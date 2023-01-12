package com.terrorists.plc.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terrorists.plc.R

@Composable
fun Splash(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val appName = stringResource(R.string.app_name)
        Image(painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = appName,
            contentScale = ContentScale.FillHeight,
            modifier = modifier
                .padding(8.dp)
                .size(110.dp)
                .clip(CircleShape)
        )
        Text(
            modifier = modifier.padding(10.dp),
            text = appName,
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 22.sp,
            ),
        )
        Spinner(modifier.padding(top = 20.dp))
    }
}