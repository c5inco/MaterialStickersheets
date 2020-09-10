package com.example.materialstickersheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.ui.MaterialStickersheetsTheme
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialStickersheetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ScrollableColumn {
                        Artboard(name = "Baseline components")
                    }
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
                .gravity(Alignment.CenterVertically) // TODO: Doesn't work in Preview, but works on device
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
        Spacer(modifier = Modifier.preferredWidth(72.dp))
        Column(modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
        ) {
            // TODO: Error and helper text params missing from TextField components
            OutlinedTextField(
                label = { Text("Label") },
                value = TextFieldValue(),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            OutlinedTextField(
                label = { Text("Label") },
                value = TextFieldValue(text = "Input text"),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            TextField(
                label = { Text("Label") },
                leadingIcon = {
                    Icon(asset = Icons.Default.Favorite)
                },
                trailingIcon = {
                    Icon(asset = vectorResource(id = R.drawable.ic_visibility))
                },
                value = TextFieldValue(),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            TextField(
                label = { Text("Label") },
                leadingIcon = {
                    Icon(asset = Icons.Default.Favorite)
                },
                trailingIcon = {
                    Icon(asset = vectorResource(id = R.drawable.ic_visibility))
                },
                value = TextFieldValue(text = "Input text"),
                onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Row(
                verticalGravity = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(asset = Icons.Default.Favorite, tint = EmphasisAmbient.current.medium.applyEmphasis(contentColor()))
                Slider(
                    value = 0.3f,
                    onValueChange = {},
                    modifier = Modifier
                            .weight(1.0f)
                            .padding(horizontal = 16.dp)
                )
                Icon(asset = Icons.Default.Favorite, tint = EmphasisAmbient.current.medium.applyEmphasis(contentColor()))
            }
        }
        Spacer(modifier = Modifier.preferredWidth(72.dp))
        Column(modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
        ) {
            var sliderPos by remember { mutableStateOf(0.5f) }
            Slider(value = sliderPos, steps = 10, onValueChange = { sliderPos = it }, valueRange = 0f..1f)
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            FakeTabsIconAndText()
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            FakeTabsIconOnly()
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            // TODO: Three lines allowed at certain widths
            // TODO: Not clear if Action slot is using accent color by default
            Snackbar(
                text = { Text("Two lines with one action. One to two lines is preferable on mobile")},
                action = { Text(text = "Action".toUpperCase(), color = SnackbarConstants.defaultActionPrimaryColor) },
            )
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            /*
            val iconButton = @Composable {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.MoreVert)
                }
            }
            DropdownMenu(
                expanded = true,
                onDismissRequest = {},
                toggle = iconButton,
                toggleModifier = Modifier.fillMaxHeight().wrapContentSize(Alignment.TopStart)
            ) {
                DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                    Text("Refresh")
                }
                DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                    Text("Settings")
                }
                Divider()
                DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                    Text("Send Feedback")
                }
            }
            */
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(242.dp)
            ) {
                // TODO: Wonder if this Card layout should be a template?
                Card(modifier = Modifier.weight(1f)) {
                    Column {
                        Column(modifier = Modifier.background(color = Color(0x0fff00ff))) {
                            Image(
                                asset = vectorResource(id = R.drawable.ic_blank_avatar),
                                modifier = Modifier
                                        .preferredHeight(172.dp)
                                        .fillMaxWidth()
                                        .background(color = Color(0xffe6e6e6))
                            )
                        }
                        Divider(modifier = Modifier.preferredHeight(1.dp))
                        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 11.dp)) {
                            Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                            Text(text = "Body 2", style = MaterialTheme.typography.body2)
                        }
                    }
                }
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                Card(modifier = Modifier.weight(1f)) {
                    Stack {
                        Column {
                            Image(
                                asset = vectorResource(id = R.drawable.ic_blank_avatar),
                                modifier = Modifier
                                        .preferredHeight(172.dp)
                                        .fillMaxWidth()
                                        .background(color = Color(0xffe6e6e6))
                            )
                            Divider(modifier = Modifier.preferredHeight(1.dp))
                            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 11.dp)) {
                                Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                                Text(text = "Body 2", style = MaterialTheme.typography.body2)
                            }
                        }
                        FakeStateOverlay()
                    }
                }

                // TODO: Need Banner components (don't exist yet)
            }
        }
        Spacer(modifier = Modifier.preferredWidth(72.dp))
        Column(modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
        ) {
            // TODO: Button text is ALL CAPS in Figma stickersheet
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalGravity = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = {}) {
                    Text(text = "Enabled".toUpperCase())
                }
                OutlinedButton(onClick = {}) {
                    Text(text = "Enabled".toUpperCase())
                }
                Button(onClick = {}) {
                    Icon(asset = Icons.Default.Add)
                    Spacer(modifier = Modifier.preferredWidth(8.dp))
                    Text(text = "Enabled".toUpperCase())
                }
            }
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(modifier = Modifier
                        .weight(1f)
                        .preferredHeight(98.dp)
                ) {
                    emptyContent()
                }
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                Card(modifier = Modifier
                        .weight(1f)
                        .preferredHeight(98.dp)
                ) {
                    FakeStateOverlay()
                }
            }

            // TODO: Need Chip and ChipGroup components (don't exist yet)

            Spacer(modifier = Modifier.preferredHeight(72.dp))
            Surface(
                modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(247.dp),
                elevation = 4.dp
            ) {
                emptyContent()
            }
            Spacer(modifier = Modifier.preferredHeight(72.dp))
            FakeBottomNavIconAndText()
        }
    }
}

private enum class BottomNavTabs(
    val title: String = "Tab",
    val icon: VectorAsset
) {
    Favorites(title = "Favorites", icon = Icons.Default.Favorite),
    Search(title = "Search", icon = Icons.Default.Search),
    Information(title = "Information", icon = Icons.Default.Info),
    Notification(title = "Notification", icon = Icons.Default.Notifications)
}

@Composable
fun FakeBottomNavIconAndText() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(BottomNavTabs.Notification) }
    val tabs = BottomNavTabs.values()

    BottomNavigation {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(asset = tab.icon) },
                label = { Text(text = tab.title) },
                selected = tab == selectedTab,
                onSelect = { setSelectedTab(tab) })
        }
    }
}

private enum class Tabs(
        val title: String = "Tab",
        val icon: VectorAsset
) {
    Notification(icon = Icons.Default.Notifications),
    Favorites(icon = Icons.Default.Favorite),
    Settings(icon = Icons.Default.Settings),
}

@Composable
fun FakeTabsIconAndText() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(0) }
    val tabs = Tabs.values()

    TabRow(
        selectedTabIndex = selectedTab,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    icon = { Icon(asset = tab.icon )},
                    text = { Text(text = tab.title.toUpperCase()) },
                    selected = index == selectedTab,
                    onClick = { setSelectedTab(index) }
                )
            }
        }
    )
}

@Composable
fun FakeTabsIconOnly() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(0) }
    val tabs = Tabs.values()

    TabRow(
        selectedTabIndex = selectedTab,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                        icon = { Icon(asset = Tabs.Notification.icon )},
                        selected = index == selectedTab,
                        onClick = { setSelectedTab(index) }
                )
            }
        }
    )
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
                        .background(Color( 0xffe6e6e6))
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

// TODO: Need to create state overlay by hand?
@Composable
fun FakeStateOverlay() {
    ConstraintLayout(
        modifier = Modifier
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

@Composable
fun FakeStatusbar() {
    Row(modifier = Modifier.preferredHeight(24.dp)){

    }
}

// TODO: File bug about height/width not filling, maxed out by something
// TODO: fillMaxHeight fills to some arbitrary height in Preview that is not known to the user
// TODO: Zoom % popup bug on rebuild still exists
// TODO: Sometimes "preview out-of-date" banner doesn't show when it should
// TODO: Need view option to turn off bounding boxes
// TODO: Bounding box hover state only works when 2+ previews available
// TODO: Bounding box hides and shows unexpectedly
// TODO: Add action to have mode for showing spacing between elements on hover, a la Figma/Sketch, can be done via holding Alt also
// TODO: Interactive preview not reliable
// TODO: Interactive preview keeps bouncing up and down while active
// TODO: Preview disappears randomly sometimes
// TODO: Need to have graceful state when preview breaks (from errors/compiler/etc)
// TODO: Preview looks very pixelated at anything 2000x2000 and above, bounding boxes turn off also
// TODO: Need MOAR docs on Modifiers - cheatsheet!
// TODO: Incorrect parameters error is very hard to parse, especially with long signatures
// TODO: Rebuild should not change zoom, and should try not to move viewport
// TODO: Need our better color picker, inline with code
// TODO: Indentation formatting is maybe too much?
// TODO: Should always show scrollbars on Preview canvas (when needed, like the Editor)

@Preview(showBackground = true, heightDp = 2000, widthDp = 2000)
@Composable
fun DefaultPreview() {
    MaterialStickersheetsTheme {
        Artboard("Baseline components")
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun TestPreview() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(modifier = Modifier
                .weight(1f)
                .preferredHeight(98.dp)
        ) {
            emptyContent()
        }
        Spacer(modifier = Modifier.preferredWidth(16.dp))
        Card(modifier = Modifier
                .weight(1f)
                .preferredHeight(98.dp)
        ) {
            FakeStateOverlay()
        }
    }
}