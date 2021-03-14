package com.example.materialstickersheets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.materialstickersheets.ui.components.BaselineScreen1
import com.example.materialstickersheets.ui.themes.MaterialStickersheetsTheme

@Preview(showBackground = true)
@Composable
fun PlaygroundPreview() {
    val (scaled, setScaled) = remember { mutableStateOf(false) }
    val animSpec = tween<Dp>(durationMillis = 2000)
    val animateIconSize by animateDpAsState(targetValue = if (scaled) 64.dp else 24.dp, animationSpec = animSpec)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite icon",
                modifier = Modifier.size(animateIconSize)
            )
            Spacer(modifier = Modifier.height(24.dp))
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