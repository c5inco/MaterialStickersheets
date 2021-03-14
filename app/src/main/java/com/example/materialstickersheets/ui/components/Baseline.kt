package com.example.materialstickersheets.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialstickersheets.R
import com.example.materialstickersheets.ui.themes.MaterialStickersheetsTheme
import java.util.Locale

@ExperimentalMaterialApi
@Composable
fun BaselineComponents1() {
    // var showDialog by savedInstanceState { true }

    Column(
        verticalArrangement = Arrangement.spacedBy(72.dp),
        modifier = Modifier
            .width(360.dp)
            .fillMaxHeight()
            //.gravity(Alignment.CenterVertically) // TODO: Doesn't work in Preview, but works on device
    ) {
        BaselineScreen1()
        Spacer(modifier = Modifier.height(72.dp))
        Column {
            MockStatusbar(
                backgroundColor = MaterialTheme.colors.primary,
                iconTint = MaterialTheme.colors.onPrimary
            )
            TopAppBar(
                title = { Text(text ="Page title") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu icon",
                        modifier = Modifier.padding(start = 12.dp)
                    )
                },
                actions = {
                    Row(modifier = Modifier.padding(end = 12.dp)) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications icon")
                        Spacer(modifier = Modifier.width(24.dp))
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications icon")
                        Spacer(modifier = Modifier.width(24.dp))
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications icon")
                    }
                }
            )
        }

        Scaffold(
            bottomBar = {
                BottomAppBar {
                    Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                        // TODO: Icons are high emphasis, not medium like in Figma
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon")
                            Spacer(modifier = Modifier.width(24.dp))
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Icon")
                            Spacer(modifier = Modifier.width(24.dp))
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = "Icon")
                            Spacer(modifier = Modifier.width(24.dp))
                            Icon(imageVector = Icons.Default.Share, contentDescription = "Icon")
                        }
                    }
                }
            },
                floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = true,
            backgroundColor = Color.Transparent,
            modifier = Modifier.height(84.dp)
        ) {

        }

        // TODO: Replace with real AlertDialog is easier to show without savedInstantState
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            MockAlertDialog()
        }

        /*
        // TODO: Removing for now - doesn't work in preview since showDialog is in savedInstanceState
        Spacer(modifier = Modifier.height(72.dp))
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
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            ListItem(
                text = { Text(text = "Subtitle 2") },
                secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.") },
                trailing = { Text(text = "02") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
        }

        Column {
            val (selectedItem, setSelectedItem) = remember { mutableStateOf(0) }
            val items = 0..2
            items.forEach { item ->
                RadioListItem(
                    selected = item == selectedItem,
                    onSelect = {
                        setSelectedItem(item)
                    }
                )
            }
        }

        Column {
            MockThreeLineListItem()
            MockThreeLineListItem()
            MockThreeLineListItem()
        }
    }
}

@Composable
fun BaselineComponents2() {
    Column(
        verticalArrangement = Arrangement.spacedBy(72.dp),
        modifier = Modifier
            .width(360.dp)
            .fillMaxHeight()
    ) {
        MockBottomSheet()

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
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Icon")
            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_visibility), contentDescription = "Icon")
            },
            value = TextFieldValue(),
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            label = { Text("Label") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Icon")
            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_visibility), contentDescription = "Icon")
            },
            value = TextFieldValue(text = "Input text"),
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            var sliderPos by remember { mutableStateOf(0.3f) }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Icon")
            }
            Slider(
                    value = sliderPos,
                    onValueChange = { sliderPos = it },
                    modifier = Modifier
                        .weight(1.0f)
                        .padding(horizontal = 16.dp)
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Icon")
            }
        }
    }
}

@Composable
fun BaselineComponents3() {
    Column(
        verticalArrangement = Arrangement.spacedBy(72.dp),
        modifier = Modifier
            .width(360.dp)
            .fillMaxHeight()
    ) {
        var sliderPos by remember { mutableStateOf(0.5f) }
        Slider(value = sliderPos, steps = 10, onValueChange = { sliderPos = it }, valueRange = 0f..1f)
        TabsIconAndText()
        TabsIconOnly()

        // TODO: Three lines allowed at certain widths
        // TODO: Not clear if Action slot is using accent color by default
        Snackbar(
            action = { Text(text = "Action".toUpperCase(Locale.ROOT), color = MaterialTheme.colors.primary) },
        ) {
            Text("Two lines with one action. One to two lines is preferable on mobile")
        }
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
            MockMenu()
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(242.dp)
        ) {
            // TODO: Wonder if this Card layout should be a template?
            Card(modifier = Modifier.weight(1f)) {
                Column {
                    Column(modifier = Modifier.background(color = Color(0x0fff00ff))) {
                        MockImage(modifier = Modifier
                                .height(172.dp)
                                .fillMaxWidth()
                        )
                    }
                    Divider(modifier = Modifier.height(1.dp))
                    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 11.dp)) {
                        Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                        Text(text = "Body 2", style = MaterialTheme.typography.body2)
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Card(modifier = Modifier.weight(1f)) {
                Box {
                    Column {
                        MockImage(modifier = Modifier
                                .height(172.dp)
                                .fillMaxWidth()
                        )
                        Divider(modifier = Modifier.height(1.dp))
                        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 11.dp)) {
                            Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                            Text(text = "Body 2", style = MaterialTheme.typography.body2)
                        }
                    }
                    MockStateOverlay()
                }
            }
        }

        // TODO: Replace with Banner components (don't exist yet)
        MockSimpleBanner()
        MockFullBanner()
    }
}

@Composable
fun BaselineComponents4() {
    Column(
        verticalArrangement = Arrangement.spacedBy(72.dp),
        modifier = Modifier
                .width(360.dp)
                .fillMaxHeight()
    ) {
        Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
        ) {
            ConversionCard(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(24.dp))
            ConversionCard(modifier = Modifier.weight(1f), active = true)
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Card(modifier = Modifier
                    .weight(1f)
                    .height(98.dp)
            ) {
            }
            Spacer(modifier = Modifier.width(16.dp))
            Card(modifier = Modifier
                    .weight(1f)
                    .height(98.dp)
            ) {
                MockStateOverlay()
            }
        }

        Row(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            MockImageListItem(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            MockImageListItem(modifier = Modifier.weight(1f), active = true)
        }

        // TODO: Replace with real Chip and ChipGroup when components exist
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                MockChip(selected = true) {
                    Spacer(modifier = Modifier.width(6.dp))
                    MockImage(modifier = Modifier
                            .clip(CircleShape)
                            .size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enabled")
                }
                MockChip {
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorites icon", modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enabled")
                }
                MockChip {
                    Spacer(modifier = Modifier.width(6.dp))
                    MockImage(modifier = Modifier
                            .clip(CircleShape)
                            .size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enabled")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                MockChip(selected = true) {
                    Spacer(modifier = Modifier.width(6.dp))
                    MockImage(modifier = Modifier
                            .clip(CircleShape)
                            .size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enabled")
                }
                MockChip {
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite icon", modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enabled")
                }
                MockChip {
                    Spacer(modifier = Modifier.width(6.dp))
                    MockImage(modifier = Modifier
                            .clip(CircleShape)
                            .size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enabled")
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // TODO: Button text is ALL CAPS in Figma stickersheet
            TextButton(onClick = {}) {
                Text(text = "Enabled".toUpperCase(Locale.ROOT))
            }
            OutlinedButton(onClick = {}) {
                Text(text = "Enabled".toUpperCase(Locale.ROOT))
            }
            Button(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Enabled".toUpperCase(Locale.ROOT))
            }
        }

        Surface(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(247.dp),
            elevation = 4.dp
        ) {
        }

        BottomNavIconAndText()
    }
}

private enum class BottomNavTabs(
        val title: String = "Tab",
        val icon: ImageVector
) {
    Favorites(title = "Favorites", icon = Icons.Default.Favorite),
    Search(title = "Search", icon = Icons.Default.Search),
    Information(title = "Information", icon = Icons.Default.Info),
    Notification(title = "Notification", icon = Icons.Default.Notifications)
}

@Composable
fun BottomNavIconAndText() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(BottomNavTabs.Notification) }
    val tabs = BottomNavTabs.values()

    BottomNavigation {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(imageVector = tab.icon, contentDescription = "Tab") },
                label = { Text(text = tab.title) },
                selected = tab == selectedTab,
                onClick = { setSelectedTab(tab) }
            )
        }
    }
}

private enum class Tabs(
        val title: String = "Tab",
        val icon: ImageVector
) {
    Notification(icon = Icons.Default.Notifications),
    Favorites(icon = Icons.Default.Favorite),
    Settings(icon = Icons.Default.Settings),
}

@Composable
fun TabsIconAndText() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(0) }
    val tabs = Tabs.values()

    TabRow(
        selectedTabIndex = selectedTab,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    icon = { Icon(imageVector = tab.icon, contentDescription = "Tab" ) },
                    text = { Text(text = tab.title.toUpperCase(Locale.ROOT)) },
                    selected = index == selectedTab,
                    onClick = { setSelectedTab(index) }
                )
            }
        }
    )
}

@Composable
fun TabsIconOnly() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(0) }
    val tabs = Tabs.values()

    TabRow(
        selectedTabIndex = selectedTab,
        tabs = {
            tabs.forEachIndexed { index, _ ->
                Tab(
                    icon = { Icon(imageVector = Tabs.Notification.icon, contentDescription = "Tab" ) },
                    selected = index == selectedTab,
                    onClick = { setSelectedTab(index) }
                )
            }
        }
    )
}


@ExperimentalMaterialApi
@Composable
fun MockThreeLineListItem() {
    // TODO: Expected AmbientEmphasisLevels call to apply medium color
    // TODO: Start padding is not present in Figma stickersheet
    // TODO: Have to draw Dividers manually, might be better to include in component
    //      for content sizing reasons relative to startIndent
    Column {
        ListItem(
            text = { Text(text = "Three-line item") },
            icon = {
                MockImage(modifier = Modifier
                    .height(56.dp)
                    .width(100.dp)
                )
            },
            secondaryText = { Text(text = "Lorem ipsum dolor sit amet, consectetur ") },
            trailing = {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bookmark),
                        contentDescription = "Bookmark icon",
                    )
                }
            }
        )
        Divider(startIndent = (100+20+12).dp)
    }
}

@ExperimentalMaterialApi
@Composable
fun RadioListItem(selected: Boolean = false, onSelect: () -> Unit) {
    // TODO: RadioButton color is set to primary in Figma stickersheet
    Column {
        ListItem(
            text = { Text(text = "Subtitle 1") },
            icon = {
                MockImage(modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                )
            },
            trailing = { RadioButton(selected = selected, onClick = onSelect) }
        )
        Divider(startIndent = (40+16+16).dp)
    }
}

// TODO: Quick re-implementation of Chip

@Composable
fun MockChip(
    selected: Boolean = false,
    content: @Composable () -> Unit
) {
    Surface(
        color = Color(0xff232f34).copy(alpha = 0.12f),
        elevation = 0.dp,
        modifier = Modifier
                .clip(RoundedCornerShape(percent = 50))
                .height(32.dp)
                .wrapContentWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            content()
            Spacer(modifier = if (selected) Modifier.width(8.dp) else Modifier.width(12.dp))

            if (selected) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cancel),
                        contentDescription = "Cancel icon",
                        modifier = Modifier.size(18.dp),
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun ConversionCard(modifier: Modifier = Modifier, active: Boolean = false) {
    Card(modifier = modifier) {
        Box {
            Column(modifier = Modifier.padding(16.dp)) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = "Conversion")
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "537", style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.height(6.dp))
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = "+22% of target", style = MaterialTheme.typography.body2)
                }
                Spacer(modifier = Modifier.height(8.dp))

                val barValues = floatArrayOf(0.2f, 0.3f, 0.4f, 0.5f, 1f, 0.8f, 0.5f)
                val maxBarHeight = 44f

                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    barValues.forEach { value ->
                        // TODO: Expected clip modifier to go after background
                        Column(modifier = Modifier
                                .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                                .background(MaterialTheme.colors.primary)
                                .height((maxBarHeight * value).dp)
                                .weight(1f)
                        ) {}
                    }
                }
            }
            if (active) {
                MockStateOverlay()
            }
        }
    }
}

@Composable
fun CardTwoElementsTemplate() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        MockImage(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Headline 6", style = MaterialTheme.typography.h6)
            Text(text = "Body 2", style = MaterialTheme.typography.body2)
        }
    }
}

// TODO: Quick re-implementation of BottomSheet component
@Composable
fun MockBottomSheet() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
                .height(644.dp)
                .fillMaxSize()
                .background(color = Color(0x52000000))
    ) {
        Surface(modifier = Modifier.fillMaxWidth(), elevation = 16.dp) {
            Column {
                CardTwoElementsTemplate()
                Divider()
                Column {
                    MockBottomSheetItem()
                    MockBottomSheetItem()
                    MockBottomSheetItem(active = true)
                    MockBottomSheetItem()
                    MockBottomSheetItem()
                }
            }
        }
    }
}

@Composable
private fun MockBottomSheetItem(active: Boolean = false) {
    val currentTint = if(active) MaterialTheme.colors.primary else contentColorFor(backgroundColor = MaterialTheme.colors.surface)
    val currentModifier = if (active) Modifier.background(color = MaterialTheme.colors.primary.copy(alpha = 0.08f)) else Modifier

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = currentModifier
                .padding(horizontal = 16.dp)
                .height(48.dp)
                .fillMaxWidth()
    ) {
        CompositionLocalProvider(LocalContentAlpha provides (if (active) 1.00f else ContentAlpha.medium)) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite icon",
                tint = currentTint
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = "Subtitle 2",
                style = MaterialTheme.typography.subtitle2,
                color = currentTint
            )
        }
    }
}

// TODO: Quick re-implementation of Menu component
@Composable
fun MockMenu() {
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp,
        modifier = Modifier.width(280.dp)
    ) {
        Column(modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
        ) {
            MockMenuItem()
            MockMenuItem()
            MockMenuItem()
        }
    }
}

@Composable
private fun MockMenuItem() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(48.dp)
                .fillMaxWidth()
    ) {
        Text(
            text = "Subtitle 2",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                    .weight(1f)
                    .padding(end = 32.dp)
        )
        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite icon")
    }
}

// TODO: Quick re-implementation of AlertDialog to display freely

@Composable
fun MockAlertDialog() {
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 24.dp,
        modifier = Modifier.width(280.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 20.dp)
                        .fillMaxWidth()
            ){
                Text(text = "Headline 6", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(16.dp))
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "Subtitle 1: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
                        .fillMaxWidth()
            )
            {
                TextButton(onClick = {}) {
                    Text(text = "Button".toUpperCase(Locale.ROOT))
                }
                TextButton(onClick = {}) {
                    Text(text = "Button".toUpperCase(Locale.ROOT))
                }
            }
        }
    }
}

// TODO: Quick re-implementation of Banner component

@Composable
fun MockSimpleBanner() {
    Surface(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                        .fillMaxWidth()
            ) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "One line text string with one action",
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.width(36.dp))
                TextButton(onClick = {}) {
                    Text(text = "Action".toUpperCase(Locale.ROOT))
                }
            }
            Divider()
        }
    }
}

@Composable
fun MockFullBanner() {
    // TODO: No linting or build error for passing more than one child to Surface, results in runtime-error
    // TODO: Surface error above results in broken preview
    Surface(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, bottom = 12.dp, end = 16.dp)
                        .fillMaxWidth()
            ){
                MockImage(modifier = Modifier.clip(CircleShape).size(40.dp))
                Spacer(modifier = Modifier.width(16.dp))
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
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
                    Text(text = "Action".toUpperCase(Locale.ROOT))
                }
                TextButton(onClick = {}) {
                    Text(text = "Action".toUpperCase(Locale.ROOT))
                }
            }
            Divider()
        }
    }
}

// TODO: Quick re-implementation of ImageListItem
@Composable
fun MockImageListItem(modifier: Modifier = Modifier, active: Boolean = false) {
    Box(modifier = modifier
            .height(207.dp)
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
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite icon")
            }
        }
        if (active) {
            MockStateOverlay ()
        }
    }
}

@Composable
fun BaselineScreen1() {
    Column(modifier = Modifier
        .height(640.dp)
        .width(360.dp)
    ) {
        MockStatusbar()
        Scaffold(
            bottomBar = {
                BottomAppBar {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth()
                    ) {
                        // TODO: Icons are high emphasis, not medium like in Figma
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu icon")
                            Row {
                                Icon(imageVector = Icons.Default.Share, contentDescription = "Icon")
                                Spacer(modifier = Modifier.width(24.dp))
                                Icon(imageVector = Icons.Default.Search, contentDescription = "Icon")
                            }
                        }
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Icon")
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)
            ){
                for (x in 0..1) {
                    Card(
                        elevation = 1.dp
                    ) {
                        Column {
                            CardTwoElementsTemplate()
                            Column(modifier = Modifier.padding(horizontal = 4.dp)) {
                                MockImage(modifier = Modifier
                                    .height(168.dp)
                                    .fillMaxWidth()
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    for (y in 0..2) {
                                        MockImage(modifier = Modifier
                                            .height(112.dp)
                                            .weight(1f)
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                                style = MaterialTheme.typography.body2,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(modifier = Modifier.padding(8.dp)) {
                                TextButton(onClick = {}) {
                                    Text(text = "Button".toUpperCase(Locale.ROOT))
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                TextButton(onClick = {}) {
                                    Text(text = "Button".toUpperCase(Locale.ROOT))
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}


@Preview(showBackground = true, heightDp = 2000)
@ExperimentalMaterialApi
@Composable
fun Baseline1() {
    MaterialStickersheetsTheme() {
        Column(modifier = Modifier.padding(36.dp)) {
            BaselineComponents1()
        }
    }
}

@Preview(showBackground = true, heightDp = 2000)
@Composable
fun Baseline2() {
    MaterialStickersheetsTheme {
        Column(modifier = Modifier.padding(36.dp)) {
            BaselineComponents2()
        }
    }
}

@Preview(showBackground = true, heightDp = 2000)
@Composable
fun Baseline3() {
    MaterialStickersheetsTheme {
        Column(modifier = Modifier.padding(36.dp)) {
            BaselineComponents3()
        }
    }
}

@Preview(showBackground = true, heightDp = 2000)
@Composable
fun Baseline4() {
    MaterialStickersheetsTheme {
        Column(modifier = Modifier.padding(36.dp)) {
            BaselineComponents4()
        }
    }
}