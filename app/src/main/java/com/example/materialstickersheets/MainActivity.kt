package com.example.materialstickersheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.ui.MaterialStickersheetsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialStickersheetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Artboard(name = "Baseline components")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Artboard(name: String) {
    Surface(
        color = Color(0xff00ff),
        modifier = Modifier.padding(60.dp)
    ) {
        Column {
            Text(text = "Material Design", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(text = name, style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.preferredHeight(200.dp))
            Divider(color = MaterialTheme.colors.onSurface)
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            BaselineComponents()
        }
    }
}

@Composable
fun BaselineComponents() {
    // TODO: Didn't know I had to import all of these to make this work:
    // import androidx.compose.runtime.getValue
    // import androidx.compose.runtime.savedinstancestate.savedInstanceState
    // import androidx.compose.runtime.setValue

    // var showDialog by savedInstanceState { true }

    Row {
        Column(modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
                .gravity(Alignment.CenterVertically) // TODO: Expected this to work, but isn't
        ) {
            TopAppBar(
                title = { Text(text ="Page title") },
                navigationIcon = {
                    Icon(asset = Icons.Default.Menu)
                },
                actions = {
                    Icon(asset = Icons.Default.Notifications)
                    Spacer(modifier = Modifier.preferredWidth(24.dp))
                    Icon(asset = Icons.Default.Notifications)
                    Spacer(modifier = Modifier.preferredWidth(24.dp))
                    Icon(asset = Icons.Default.Notifications)
                }
            )
            Spacer(modifier = Modifier.preferredHeight(44.dp))
            Scaffold(
                modifier = Modifier.preferredHeight(84.dp),
                bottomBar = {
                    BottomAppBar() {
                        Row {
                            // TODO: Icons are high emphasis, not medium like in Figma
                            ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                                Icon(asset = Icons.Default.Menu)
                                Spacer(modifier = Modifier.preferredWidth(24.dp))
                                Icon(asset = Icons.Default.Search)
                                Spacer(modifier = Modifier.preferredWidth(24.dp))
                                Icon(asset = Icons.Default.Notifications)
                                Spacer(modifier = Modifier.preferredWidth(24.dp))
                                Icon(asset = Icons.Default.Share)
                            }
                        }
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(asset = Icons.Default.Add)
                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                isFloatingActionButtonDocked = true
            ) {

            }
            /*
            // TODO: Removing for now - doesn't work in preview since showDialog is in savedInstanceState
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(text = "Headline 6")
                },
                text = {
                    Text(text = "Subtitle 1: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                },
                /*
                // TODO: Using this method means doing alignment manually?
                buttons = {
                    Row {
                        TextButton(onClick = {}) {
                            Text(text = "Button".toUpperCase())
                        }
                        TextButton(onClick = {}) {
                            Text(text = "Button".toUpperCase())
                        }
                    }
                },
                */
                confirmButton = {
                    TextButton(onClick = {}) {
                        Text(text = "Button".toUpperCase())
                    }
                },
                dismissButton = {
                    TextButton(onClick = {}) {
                        Text(text = "Button".toUpperCase())
                    }
                }
            )
            */
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Column {
                ListItem(
                    text = { Text(text = "Subtitle 1") },
                    secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.") },
                    trailing = { Text(text = "01") }
                )
                ListItem(
                    text = { Text(text = "Subtitle 2") },
                    secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.") },
                    trailing = { Text(text = "02") }
                )
            }
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Column {
                FakeRadioListItem(selected = true)
                FakeRadioListItem()
                FakeRadioListItem()
            }
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Column {
                FakeThreeLineListItem()
                FakeThreeLineListItem()
                FakeThreeLineListItem()
            }
        }
        Column {
            TopAppBar() {
                Text("World")
            }
        }
    }
}

@Composable
fun FakeThreeLineListItem() {
    // TODO: Expected EmphasisAmbient call to apply medium color
    // TODO: Start padding is not present in Figma stickersheet
    ListItem(
        text = { Text(text = "Three-line item") },
        icon = {
            Image(
                asset = vectorResource(id = R.drawable.ic_blank_avatar),
                modifier = Modifier
                        .background(Color(0xffe6e6e6))
                        .preferredHeight(56.dp)
                        .preferredWidth(100.dp)
            )
        },
        secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur ") },
        trailing = {
            Icon(
                asset = vectorResource(id = R.drawable.ic_bookmark),
                tint = EmphasisAmbient.current.medium.applyEmphasis(contentColor())
            )
        }
    )
}

@Composable
fun FakeRadioListItem(selected: Boolean = false) {
    // TODO: CircleShape clip not working??
    // TODO: RadioButton color is set to primary in Figma stickersheet
    ListItem(
        text = { Text(text = "Subtitle 1") },
        icon = {
            Image(
                asset = vectorResource(id = R.drawable.ic_blank_avatar),
                modifier = Modifier
                        .background(Color(0xffe6e6e6))
                        .preferredHeight(64.dp)
                        .preferredWidth(64.dp)
                        .clip(CircleShape)
            )
        },
        trailing = { RadioButton(selected = selected, onClick = {}) }
    )
}

@Composable
fun FakeStatusbar() {
    Row(modifier = Modifier.preferredHeight(24.dp)){

    }
}

// TODO: File bug about height/width not filling, maxed out by something
// TODO: Zoom % popup bug on rebuild still exists
// TODO: Sometimes "preview out-of-date" banner doesn't show when it should
// TODO: Need view option to turn of bounding boxes
// TODO: Add action to have mode for showing spacing between elements on hover, a la Figma/Sketch, can be done via holding Alt also
// TODO: Interactive preview not reliable
// TODO: Preview disappears randomly sometimes
// TODO: Need to have graceful state when preview breaks (from errors/compiler/etc)

@Preview(showBackground = true, heightDp = 2000)
@Composable
fun DefaultPreview() {
    MaterialStickersheetsTheme {
        Artboard("Baseline components")
    }
}