package com.mtdata.aidev.collectingdialect.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CollectingDialectButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
) {
    Button(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .height(60.dp),
        onClick = onClick
    ) {
        Text(text = text)
    }
}