package com.example.materialstickersheets.ui.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Preview(showBackground = true, heightDp = 2000, widthDp = 1200)
@Composable
fun Typography() {
    Column(
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        TypeRow(sample = "Headline 1", spec = "H1/Roboto/Light/96px", style = MaterialTheme.typography.h1)
        TypeRow(sample = "Headline 2", spec = "H2/Roboto/Light/60x", style = MaterialTheme.typography.h2)
        TypeRow(sample = "Headline 3", spec = "H3/Roboto/Regular/48px", style = MaterialTheme.typography.h3)
        TypeRow(sample = "Headline 4", spec = "H4/Roboto/Regular/34px", style = MaterialTheme.typography.h4)
        TypeRow(sample = "Headline 5", spec = "H5/Roboto/Regular/24px", style = MaterialTheme.typography.h5)
        TypeRow(sample = "Headline 6", spec = "H6/Roboto/Medium/20px", style = MaterialTheme.typography.h6)
        TypeRow(sample = "Subtitle 1", spec = "Subtitle 1/Roboto/Regular/16px", style = MaterialTheme.typography.subtitle1)
        TypeRow(sample = "Subtitle 2", spec = "Subtitle 2/Roboto/Medium/14px", style = MaterialTheme.typography.subtitle2)
        TypeRow(sample = "Body 1", spec = "Body 1/Roboto/Regular/16px", style = MaterialTheme.typography.body1)
        TypeRow(sample = "Body 2", spec = "Body 2/Roboto/Regular/14px", style = MaterialTheme.typography.body2)
        TypeRow(sample = "Button", spec = "Button/Roboto/Medium/14px", style = MaterialTheme.typography.button)
        TypeRow(sample = "Caption", spec = "Caption/Roboto/Regular/12px", style = MaterialTheme.typography.caption)
        TypeRow(sample = "Overline", spec = "Overline/Roboto/Regular/10px", style = MaterialTheme.typography.overline)
    }
}

@Composable
private fun TypeRow(sample: String, spec: String, style: TextStyle = MaterialTheme.typography.body1) {
    // TODO: Implemented with CL, but maybe could do with Row if verticalArrangement had baseline alignment
    // TODO: Constraints visualization would really help here
    ConstraintLayout {
        val (sampleText, specText) = createRefs()

        Text(
            text = sample,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .preferredWidth(100.dp)
                .constrainAs(sampleText) {
                    //start.linkTo(parent.start)
                    baseline.linkTo(specText.baseline)
                    //end.linkTo(specText.start, margin = 42.dp)
                }
        )
        Text(
            text = spec,
            style = style,
            modifier = Modifier.constrainAs(specText) {
                // TODO: Expected to comment this constraint out, and use just end-to-start in other Text
                start.linkTo(sampleText.end, margin = 42.dp)
            }
        )
    }
}