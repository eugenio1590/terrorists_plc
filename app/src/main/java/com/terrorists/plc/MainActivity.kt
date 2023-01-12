package com.terrorists.plc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.terrorists.plc.ui.KeywordSearch
import com.terrorists.plc.ui.Loading
import com.terrorists.plc.ui.Splash
import com.terrorists.plc.ui.TerroristList
import com.terrorists.plc.ui.theme.TerroristsPLCTheme
import com.terrorists.plc.viewmodel.TerroristsUiState
import com.terrorists.plc.viewmodel.TerroristsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val terroristsViewModel: TerroristsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerroristsPLCTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TerroristsScreen(terroristsViewModel = terroristsViewModel)
                }
            }
        }

        terroristsViewModel.getTerrorists()
    }
}

@Composable
fun TerroristsScreen(terroristsViewModel: TerroristsViewModel) {
    val uiState by terroristsViewModel.uiState.collectAsState()
    Column {
        when (uiState) {
            is TerroristsUiState.Initial -> Splash()
            is TerroristsUiState.Loading -> Loading()
            is TerroristsUiState.Success -> Column {
                val keyword by terroristsViewModel.keyword.collectAsState()
                KeywordSearch(
                    keyword = keyword,
                    onChange = {
                        terroristsViewModel.updateKeyword(it)
                    },
                    onSearch = {
                        terroristsViewModel.searchTerrorists(keyword)
                    }
                )
                TerroristList(
                    terrorists = (uiState as TerroristsUiState.Success).terrorists
                )
            }
        }
    }
}