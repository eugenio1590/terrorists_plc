package com.terrorists.plc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terrorists.domain.usecase.LoadTerrorists
import com.terrorists.domain.usecase.SearchTerrorists
import com.terrorists.model.Terrorist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TerroristsViewModel @Inject constructor(
    private val loadTerrorists: LoadTerrorists,
    private val searchTerrorists: SearchTerrorists,
) : ViewModel() {

    private val _keyword = MutableStateFlow("")
    val keyword: StateFlow<String> = _keyword.asStateFlow()

    private val _uiState = MutableStateFlow<TerroristsUiState>(TerroristsUiState.Initial)
    val uiState: StateFlow<TerroristsUiState> = _uiState.asStateFlow()

    fun updateKeyword(keyword: String) {
        _keyword.value = keyword
    }

    fun getTerrorists() {
        viewModelScope.launch {
            loadTerrorists(LoadTerrorists.Request(), object : LoadTerrorists.Callback {
                override fun load(terrorists: List<Terrorist>) {
                    _uiState.value = TerroristsUiState.Success(terrorists = terrorists)
                }
            })
        }
    }

    fun searchTerrorists(keyword: String) {
        viewModelScope.launch {
            _uiState.value = TerroristsUiState.Loading
            searchTerrorists(SearchTerrorists.Request(keyword), object : SearchTerrorists.Callback {
                override fun load(terrorists: List<Terrorist>) {
                    _uiState.value = TerroristsUiState.Success(terrorists = terrorists)
                }
            })
        }
    }
}