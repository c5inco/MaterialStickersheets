package com.example.materialstickersheets.ui.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.R
import com.example.materialstickersheets.ui.MaterialStickersheetsTheme
import com.example.materialstickersheets.ui.components.*

@Composable
fun MockImage(modifier: Modifier = Modifier) {
    Image(
        asset = vectorResource(id = R.drawable.ic_blank_avatar),
        modifier = modifier.background(Color(0xffe6e6e6))
    )
}

@Composable
fun FakeStatusbar() {
    Row(modifier = Modifier.preferredHeight(24.dp)){

    }
}

// TODO: Need to create state overlay by hand?
@Composable
fun FakeStateOverlay() {
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