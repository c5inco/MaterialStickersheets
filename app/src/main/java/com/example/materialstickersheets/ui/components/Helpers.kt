package com.example.materialstickersheets.ui.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Divider
import androidx.compose.material.EmphasisAmbient
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
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
        color = MaterialTheme.colors.background,
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
fun MockStatusbar(
        backgroundColor: Color = Color.Black.copy(alpha = 0.08f),
        iconTint: Color = MaterialTheme.colors.onSurface
) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .background(color = backgroundColor)
            .preferredHeight(24.dp)
            .fillMaxWidth()
    ){
        Icon(
            asset = vectorResource(id = R.drawable.ic_status_icons),
            tint = EmphasisAmbient.current.disabled.applyEmphasis(iconTint)
        )
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

@Preview(showBackground = true, widthDp = 360)
@Composable
fun HelpersPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        MockStatusbar()
        MockStatusbar(backgroundColor = MaterialTheme.colors.primary, iconTint = MaterialTheme.colors.onPrimary)
    }
}