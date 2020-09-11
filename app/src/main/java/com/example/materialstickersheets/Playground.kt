package com.example.materialstickersheets

import androidx.compose.animation.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PlaygroundPreview() {
    val (scaled, setScaled) = remember { mutableStateOf(false) }
    val iconSize = if (scaled) 64.dp else 24.dp
    val animSpec = tween<Dp>(durationMillis = 2000)

    Box(
        gravity = ContentGravity.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalGravity = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                asset = Icons.Default.Favorite,
                modifier = Modifier.preferredSize(animate(target = iconSize, animSpec = animSpec))
            )
            Spacer(modifier = Modifier.preferredHeight(24.dp))
            Button(onClick = { setScaled(!scaled) }) {
                Text(text = if (scaled) "Shrink!" else "Grow")
            }
        }
    }
}