package com.terrorists.plc.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@SuppressLint("PrivateResource")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeywordSearch(
    modifier: Modifier = Modifier,
    keyword: String,
    onChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val search = stringResource(androidx.compose.material3.R.string.search)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp, start = 5.dp, end = 5.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedTextField(
            value = keyword,
            placeholder = { Text(search) },
            onValueChange = onChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onSearch() }
            )
        )
        IconButton(
            onClick = onSearch,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = search,
                tint = MaterialTheme.colorScheme.inversePrimary
            )
        }
    }
}