package com.example.materialstickersheets.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.R

// TODO: Error banner show when no @Preview is included

@Composable
fun Artboard(name: String, content: @Composable () -> Unit) {
    Surface(
        color = Color(0xfff9f9f9),
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.padding(60.dp)) {
            Text(text = "Material Design", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(text = name, style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.preferredHeight(200.dp))
            Divider(color = MaterialTheme.colors.onSurface)
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            content()
        }
    }
}

@Composable
fun MockImage(modifier: Modifier = Modifier) {
    Image(
        asset = vectorResource(id = R.drawable.ic_blank_avatar),
        modifier = modifier.background(Color(0xffe6e6e6))
    )
}

@Composable
fun MockStatusbar() {
    Row(modifier = Modifier.preferredHeight(24.dp)){

    }
}

// TODO: Need to create state overlay by hand?
@Composable
fun MockStateOverlay() {
    ConstraintLayout(modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.primary.copy(alpha = 0.08f))
    ) {
        val (icon) = createRefs()

        Icon(
            asset = Icons.Default.CheckCircle,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)
            }
        )
    }
}