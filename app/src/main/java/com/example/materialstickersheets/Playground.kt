package com.example.materialstickersheets

import androidx.compose.animation.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.ui.components.BaselineScreen1
import com.example.materialstickersheets.ui.themes.MaterialStickersheetsTheme

@Preview(showBackground = true)
@Composable
fun PlaygroundPreview() {
    val (scaled, setScaled) = remember { mutableStateOf(false) }
    val iconSize = if (scaled) 64.dp else 24.dp
    val animSpec = tween<Dp>(durationMillis = 2000)

    Box(
        alignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
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

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PlaygroundPreview2() {
    MaterialStickersheetsTheme() {
        BaselineScreen1()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PlaygroundPreview3() {
    MaterialStickersheetsTheme(darkTheme = true) {
        BaselineScreen1()
    }
}