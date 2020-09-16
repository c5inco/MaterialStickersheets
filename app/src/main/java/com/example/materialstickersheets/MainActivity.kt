package com.example.materialstickersheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.ui.themes.MaterialStickersheetsTheme
import com.example.materialstickersheets.ui.components.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialStickersheetsTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface {
                    ScrollableColumn {
                        Artboard(name = "Baseline components") {
                            Row(horizontalArrangement = Arrangement.spacedBy(72.dp)) {
                                BaselineComponents1()
                                BaselineComponents2()
                                BaselineComponents3()
                                BaselineComponents4()
                            }
                        }
                    }
                }
            }
        }
    }
}

// TODO: File bug about height/width not filling, maxed out by something
// TODO: fillMaxHeight fills to some arbitrary height in Preview that is not known to the user
// TODO: Zoom % popup bug on rebuild still exists
// TODO: Sometimes "preview out-of-date" banner doesn't show when it should
// TODO: Need view option to turn off bounding boxes
// TODO: Add action to have mode for showing spacing between elements on hover, a la Figma/Sketch, can be done via holding Alt also
// TODO: Interactive preview not reliable
// TODO: Interactive preview keeps bouncing up and down while active
// TODO: Preview disappears randomly sometimes
// TODO: Need to have graceful state when preview breaks (from errors/compiler/etc)
// TODO: Need MOAR docs on Modifiers - cheatsheet!
// TODO: Incorrect parameters error is very hard to parse, especially with long signatures
// TODO: Rebuild should not change zoom, and should try not to move viewport
// TODO: Need our better color picker, inline with code
// TODO: Indentation formatting is maybe too much?
// TODO: Should always show scrollbars on Preview canvas (when needed, like the Editor)
// TODO: Zoom should zoom from center, not top left
// TODO: GridLayout in Preview is slow to calculate reflow

@Preview(showBackground = true, heightDp = 2320, widthDp = 1440, name = "Typography")
@Composable
fun TypographyArtboard() {
    MaterialStickersheetsTheme {
        Artboard(name = "Typography") {
            Typography()
        }
    }
}

@Preview(showBackground = true, heightDp = 2320, widthDp = 1440, name = "Typography (Dark)")
@Composable
fun TypographyDarkArtboard() {
    MaterialStickersheetsTheme(darkTheme = true) {
        Artboard(name = "Typography (Dark)") {
            Typography()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(CircleShape)
            .preferredHeight(48.dp)
            .fillMaxSize()
    ) {
        Text(text = "hello")
    }
}