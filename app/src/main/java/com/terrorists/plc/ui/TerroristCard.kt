package com.terrorists.plc.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terrorists.model.Terrorist
import com.terrorists.plc.ui.theme.TerroristsPLCTheme

@Composable
fun TerroristCard(terrorist: Terrorist) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {

        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = terrorist.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Row {
                    Text(
                        text = "${terrorist.placeOfBirth} - ",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )
                    Text(
                        text = terrorist.dateOfBirth,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TerroristCardDefaultPreview() {
    TerroristsPLCTheme {
        TerroristCard(
            terrorist = Terrorist(
                firstName = "First Name",
                lastName = "Last Name",
                dateOfBirth = "1950",
                placeOfBirth = "Madrid",
            )
        )
    }
}