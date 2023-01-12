package com.terrorists.plc.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.terrorists.model.Terrorist
import com.terrorists.plc.ui.theme.TerroristsPLCTheme

@Composable
fun TerroristList(terrorists: List<Terrorist>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(terrorists) {
            TerroristCard(terrorist = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TerroristListDefaultPreview() {
    TerroristsPLCTheme {
        TerroristList(
            terrorists = listOf(
                Terrorist(
                    firstName = "First",
                    lastName = ""
                ),
                Terrorist(
                    firstName = "Second",
                    lastName = ""
                )
            )
        )
    }
}