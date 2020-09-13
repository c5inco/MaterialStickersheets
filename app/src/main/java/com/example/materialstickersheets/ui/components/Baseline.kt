package com.example.materialstickersheets.ui.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.weight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.materialstickersheets.Artboard
import com.example.materialstickersheets.R
import com.example.materialstickersheets.ui.MaterialStickersheetsTheme

@Composable
fun BaselineComponents() {
    // TODO: Didn't know I had to import all of these to make this work:
    // import androidx.compose.runtime.getValue
    // import androidx.compose.runtime.savedinstancestate.savedInstanceState
    // import androidx.compose.runtime.setValue

    // var showDialog by savedInstanceState { true }

    Row(horizontalArrangement = Arrangement.spacedBy(72.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(72.dp),
            modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
                //.gravity(Alignment.CenterVertically) // TODO: Doesn't work in Preview, but works on device
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

            // TODO: Replace with real AlertDialog is easier to show without savedInstantState
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                FakeAlertDialog()
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

            Column {
                // TODO: Had to manually draw Dividers and bottom spacing
                ListItem(
                        text = { Text(text = "Subtitle 1") },
                        secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.") },
                        trailing = { Text(text = "01") }
                )
                Spacer(modifier = Modifier.preferredHeight(12.dp))
                Divider()
                ListItem(
                        text = { Text(text = "Subtitle 2") },
                        secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.") },
                        trailing = { Text(text = "02") }
                )
                Spacer(modifier = Modifier.preferredHeight(12.dp))
                Divider()
            }

            Column {
                FakeRadioListItem(selected = true)
                FakeRadioListItem()
                FakeRadioListItem()
            }

            Column {
                FakeThreeLineListItem()
                FakeThreeLineListItem()
                FakeThreeLineListItem()
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(72.dp),
            modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
        ) {
            FakeBottomSheet()

            // TODO: Error and helper text params missing from TextField components
            OutlinedTextField(
                    label = { Text("Label") },
                    value = TextFieldValue(),
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                    label = { Text("Label") },
                    value = TextFieldValue(text = "Input text"),
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
            )

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
        Column(
            verticalArrangement = Arrangement.spacedBy(72.dp),
            modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
        ) {
            var sliderPos by remember { mutableStateOf(0.5f) }
            Slider(value = sliderPos, steps = 10, onValueChange = { sliderPos = it }, valueRange = 0f..1f)
            FakeTabsIconAndText()
            FakeTabsIconOnly()

            // TODO: Three lines allowed at certain widths
            // TODO: Not clear if Action slot is using accent color by default
            Snackbar(
                text = { Text("Two lines with one action. One to two lines is preferable on mobile") },
                action = { Text(text = "Action".toUpperCase(), color = SnackbarConstants.defaultActionPrimaryColor) },
            )
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
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                FakeMenu()
            }
            Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(242.dp)
            ) {
                // TODO: Wonder if this Card layout should be a template?
                Card(modifier = Modifier.weight(1f)) {
                    Column {
                        Column(modifier = Modifier.background(color = Color(0x0fff00ff))) {
                            MockImage(modifier = Modifier
                                    .preferredHeight(172.dp)
                                    .fillMaxWidth()
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
                            MockImage(modifier = Modifier
                                    .preferredHeight(172.dp)
                                    .fillMaxWidth()
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
            }

            // TODO: Replace with Banner components (don't exist yet)
            FakeSimpleBanner()
            FakeFullBanner()
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(72.dp),
            modifier = Modifier
                .preferredWidth(360.dp)
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(190.dp)
            ) {
                ConversionCard()
                Spacer(modifier = Modifier.preferredWidth(24.dp))
                ConversionCard(active = true)
            }

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

            Row(modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                ImageListItem()
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                ImageListItem(active = true)
            }

            // TODO: Replace with real Chip and ChipGroup when components exist
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FakeChip(selected = true) {
                        Spacer(modifier = Modifier.preferredWidth(6.dp))
                        MockImage(modifier = Modifier
                                .clip(CircleShape)
                                .preferredSize(18.dp)
                        )
                        Spacer(modifier = Modifier.preferredWidth(8.dp))
                        Text(text = "Enabled")
                    }
                    FakeChip {
                        Spacer(modifier = Modifier.preferredWidth(6.dp))
                        Icon(asset = Icons.Default.Favorite, modifier = Modifier.preferredSize(18.dp))
                        Spacer(modifier = Modifier.preferredWidth(8.dp))
                        Text(text = "Enabled")
                    }
                    FakeChip {
                        Spacer(modifier = Modifier.preferredWidth(6.dp))
                        MockImage(modifier = Modifier
                                .clip(CircleShape)
                                .preferredSize(18.dp)
                        )
                        Spacer(modifier = Modifier.preferredWidth(8.dp))
                        Text(text = "Enabled")
                    }
                }
                Spacer(modifier = Modifier.preferredHeight(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FakeChip(selected = true) {
                        Spacer(modifier = Modifier.preferredWidth(6.dp))
                        MockImage(modifier = Modifier
                                .clip(CircleShape)
                                .preferredSize(18.dp)
                        )
                        Spacer(modifier = Modifier.preferredWidth(8.dp))
                        Text(text = "Enabled")
                    }
                    FakeChip {
                        Spacer(modifier = Modifier.preferredWidth(6.dp))
                        Icon(asset = Icons.Default.Favorite, modifier = Modifier.preferredSize(18.dp))
                        Spacer(modifier = Modifier.preferredWidth(8.dp))
                        Text(text = "Enabled")
                    }
                    FakeChip {
                        Spacer(modifier = Modifier.preferredWidth(6.dp))
                        MockImage(modifier = Modifier
                                .clip(CircleShape)
                                .preferredSize(18.dp)
                        )
                        Spacer(modifier = Modifier.preferredWidth(8.dp))
                        Text(text = "Enabled")
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalGravity = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // TODO: Button text is ALL CAPS in Figma stickersheet
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

            Surface(
                modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(247.dp),
                elevation = 4.dp
            ) {
                emptyContent()
            }

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
                            icon = { Icon(asset = tab.icon ) },
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
                            icon = { Icon(asset = Tabs.Notification.icon ) },
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
    // TODO: Have to draw Dividers manually, might be better to include in component
    //      for content sizing reasons relative to startIndent
    Column {
        ListItem(
                text = { Text(text = "Three-line item") },
                icon = {
                    MockImage(modifier = Modifier
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
        Divider(startIndent = (100+20+12).dp)
    }
}

@Composable
fun FakeRadioListItem(selected: Boolean = false) {
    // TODO: RadioButton color is set to primary in Figma stickersheet
    Column {
        ListItem(
            text = { Text(text = "Subtitle 1") },
            icon = {
                MockImage(modifier = Modifier
                        .clip(CircleShape)
                        .preferredSize(40.dp)
                )
            },
            trailing = { RadioButton(selected = selected, onClick = {}) }
        )
        Divider(startIndent = (40+16+16).dp)
    }
}

// TODO: Quick re-implementation of Chip

@Composable
fun FakeChip(
    selected: Boolean = false,
    content: @Composable () -> Unit
) {
    Surface(
        color = Color(0xff232f34).copy(alpha = 0.12f),
        elevation = 0.dp,
        modifier = Modifier
                .clip(RoundedCornerShape(percent = 50))
                .preferredHeight(32.dp)
                .wrapContentWidth()
    ) {
        Row(verticalGravity = Alignment.CenterVertically) {
            Row(verticalGravity = Alignment.CenterVertically) {
                content()
                Spacer(modifier = if (selected) Modifier.preferredWidth(8.dp) else Modifier.preferredWidth(12.dp))
            }
            if (selected) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_cancel),
                    modifier = Modifier.preferredSize(18.dp),
                    tint = EmphasisAmbient.current.medium.applyEmphasis(contentColor())
                )
                Spacer(modifier = Modifier.preferredWidth(8.dp))
            }
        }
    }
}

@Composable
fun ConversionCard(active: Boolean = false) {
    Card(modifier = Modifier
            .weight(1f)
    ) {
        Stack {
            Column(modifier = Modifier.padding(16.dp)) {
                ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                    Text(text = "Conversion")
                }
                Spacer(modifier = Modifier.preferredHeightIn(12.dp))
                Text(text = "537", style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.preferredHeightIn(6.dp))
                ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                    Text(text = "+22% of target", style = MaterialTheme.typography.body2)
                }
                Spacer(modifier = Modifier.preferredHeightIn(8.dp))

                val barValues = floatArrayOf(0.2f, 0.3f, 0.4f, 0.5f, 1f, 0.8f, 0.5f)
                val maxBarHeight = 44f

                Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalGravity = Alignment.Bottom
                ) {
                    barValues.forEach { value ->
                        // TODO: Expected clip mo  difier to go after background
                        Column(modifier = Modifier
                                .clip(RoundedCornerShape(topLeft = 2.dp, topRight = 2.dp))
                                .background(MaterialTheme.colors.primary)
                                .preferredHeight((maxBarHeight * value).dp)
                                .weight(1f)
                        ) {}
                    }
                }
            }
            if (active) {
                FakeStateOverlay()
            }
        }
    }
}

// TODO: Quick re-implementation of BottomSheet component
@Composable
fun FakeBottomSheet() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
                .preferredHeight(644.dp)
                .fillMaxSize()
                .background(color = Color(0x52000000))
    ) {
        Surface(modifier = Modifier.fillMaxWidth(), elevation = 16.dp) {
            Column {
                Row(
                    verticalGravity = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                ) {
                    MockImage(modifier = Modifier
                            .preferredSize(40.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.preferredWidth(16.dp))
                    Column {
                        Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                        Text(text = "Body 2", style = MaterialTheme.typography.body2)
                    }
                }
                Divider()
                Column {
                    FakeBottomSheetItem()
                    FakeBottomSheetItem()
                    FakeBottomSheetItem(active = true)
                    FakeBottomSheetItem()
                    FakeBottomSheetItem()
                }
            }
        }
    }
}

@Composable
private fun FakeBottomSheetItem(active: Boolean = false) {
    val currentTint = if(active) MaterialTheme.colors.primary else EmphasisAmbient.current.medium.applyEmphasis(contentColor())
    val currentModifier = if (active) Modifier.background(color = MaterialTheme.colors.primary.copy(alpha = 0.08f)) else Modifier

    Row(
        verticalGravity = Alignment.CenterVertically,
        modifier = currentModifier
                .padding(horizontal = 16.dp)
                .preferredHeight(48.dp)
                .fillMaxWidth()
    ) {
        Icon(asset = Icons.Default.Favorite, tint = currentTint)
        Spacer(modifier = Modifier.preferredWidth(32.dp))
        Text(text = "Subtitle 2", style = MaterialTheme.typography.subtitle2, color = currentTint)
    }
}

// TODO: Quick re-implementation of Menu component
@Composable
fun FakeMenu() {
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp,
        modifier = Modifier.preferredWidth(280.dp)
    ) {
        Column(modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
        ) {
            FakeMenuItem()
            FakeMenuItem()
            FakeMenuItem()
        }
    }
}

@Composable
private fun FakeMenuItem() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically,
        modifier = Modifier
                .padding(horizontal = 16.dp)
                .preferredHeight(48.dp)
                .fillMaxWidth()
    ) {
        Text(
            text = "Subtitle 2",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                    .weight(1f)
                    .padding(end = 32.dp)
        )
        Icon(asset = Icons.Default.Favorite)
    }
}

// TODO: Quick re-implementation of AlertDialog to display freely

@Composable
fun FakeAlertDialog() {
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 24.dp,
        modifier = Modifier.preferredWidth(280.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 20.dp)
                        .fillMaxWidth()
            ){
                Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.preferredHeight(16.dp))
                ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                    Text(
                        text = "Subtitle 1: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            Spacer(modifier = Modifier.preferredHeight(28.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
                        .fillMaxWidth()
            )
            {
                TextButton(onClick = {}) {
                    Text(text = "Button".toUpperCase())
                }
                TextButton(onClick = {}) {
                    Text(text = "Button".toUpperCase())
                }
            }
        }
    }
}

// TODO: Quick re-implementation of Banner component

@Composable
fun FakeSimpleBanner() {
    Surface(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalGravity = Alignment.CenterVertically,
                modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                        .fillMaxWidth()
            ) {
                ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                    Text(
                            text = "One line text string with one action",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.preferredWidth(36.dp))
                TextButton(onClick = {}) {
                    Text(text = "Action".toUpperCase())
                }
            }
            Divider()
        }
    }
}

@Composable
fun FakeFullBanner() {
    // TODO: No linting or build error for passing more than one child to Surface, results in runtime-error
    // TODO: Surface error above results in broken preview
    Surface(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                    verticalGravity = Alignment.CenterVertically,
                    modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp, bottom = 12.dp, end = 16.dp)
                            .fillMaxWidth()
            ){
                MockImage(modifier = Modifier.clip(CircleShape).preferredSize(40.dp))
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                    Text(
                            text = "Two line text string with two actions. One to two lines is preferable on mobile",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.body2
                    )
                }
            }
            Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                            .padding(bottom = 8.dp, end = 8.dp)
                            .fillMaxWidth()
            )
            {
                TextButton(onClick = {}) {
                    Text(text = "Action".toUpperCase())
                }
                TextButton(onClick = {}) {
                    Text(text = "Action".toUpperCase())
                }
            }
            Divider()
        }
    }
}

// TODO: Quick re-implementation of ImageListItem
@Composable
fun ImageListItem(active: Boolean = false) {
    Stack(modifier = Modifier
            .preferredHeight(207.dp)
            .weight(1f)
    ) {
        MockImage(modifier = Modifier.fillMaxSize())

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                        .background(color = Color.Black.copy(alpha = 0.38f))
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .fillMaxWidth()
            ) {
                Text(text = "Subtitle 1", style = MaterialTheme.typography.subtitle1)
                Icon(asset = Icons.Default.Favorite)
            }
        }
        if (active) {
            FakeStateOverlay()
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun PrototypingPreview() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        FakeChip(selected = true) {
            Spacer(modifier = Modifier.preferredWidth(6.dp))
            MockImage(modifier = Modifier
                .clip(CircleShape)
                .preferredSize(18.dp)
            )
            Spacer(modifier = Modifier.preferredWidth(8.dp))
            Text(text = "Enabled")
        }
        FakeChip {
            Spacer(modifier = Modifier.preferredWidth(6.dp))
            Icon(asset = vectorResource(id = R.drawable.ic_directions_bike), modifier = Modifier.preferredSize(18.dp))
            Spacer(modifier = Modifier.preferredWidth(8.dp))
            Text(text = "Enabled")
        }
        FakeChip {
            Spacer(modifier = Modifier.preferredWidth(6.dp))
            MockImage(modifier = Modifier
                    .clip(CircleShape)
                    .preferredSize(18.dp)
            )
            Spacer(modifier = Modifier.preferredWidth(8.dp))
            Text(text = "Enabled")
        }
    }
}

@Preview(showBackground = true, heightDp = 2800, widthDp = 1782, name = "Material Theme")
@Composable
fun BaselineStandalone() {
    MaterialStickersheetsTheme {
        Artboard(name = "Baseline components") {
            BaselineComponents()
        }
    }
}