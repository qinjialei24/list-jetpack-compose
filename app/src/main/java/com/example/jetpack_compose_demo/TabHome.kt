package com.example.jetpack_compose_demo

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


enum class TabPage(val icon: ImageVector) {
    Home(icon = Icons.Default.Home),
    Favorite(Icons.Default.Favorite),
    Message(Icons.Default.Email)
}

@Composable
fun TabHome(selectedTabIndex: Int, onSelectedTab: (TabPage) -> Unit) {
    TabRow(selectedTabIndex = selectedTabIndex, indicator = {
        TabIndicator(tabPosition = it, index = selectedTabIndex)
    }) {
        TabPage.values()
            .forEachIndexed { index, tabPage ->
                Tab(
                    selected = index === selectedTabIndex,
                    selectedContentColor = Color.Green,
                    unselectedContentColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.disabled),
                    text = { Text(text = tabPage.name) },
                    icon = { Icon(imageVector = tabPage.icon, contentDescription = null) },
                    onClick = {
                        onSelectedTab(tabPage)
                    })
            }
    }
}