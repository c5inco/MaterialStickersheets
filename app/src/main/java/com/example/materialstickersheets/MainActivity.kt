package com.example.materialstickersheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Devices
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
    Row {
        Column(modifier = Modifier
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
        }
        Column {
            TopAppBar() {
                Text("World")
            }
        }
    }
}

@Composable
fun FakeStatusbar() {
    Row(modifier = Modifier.preferredHeight(24.dp)){

    }
}

// TODO: File bug about height not filling, maxed out by something

@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun DefaultPreview() {
    MaterialStickersheetsTheme {
        Artboard("Baseline components")
    }
}