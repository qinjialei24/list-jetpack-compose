package com.example.jetpack_compose_demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BottomBar() {
    val viewModel: SelectedModel = viewModel()
    Row(horizontalArrangement = Arrangement.Center) {
        TabItem(
            if (viewModel.selectedTabIndex === 0) Icons.Filled.Home else Icons.Outlined.Home,
            "测试",
            Modifier.weight(1f),
            tint = Color.Green,
            onClick = { viewModel.selectedTabIndex = 0 })

        TabItem(
            if (viewModel.selectedTabIndex === 1) Icons.Filled.Menu else Icons.Outlined.Menu,

            "测试",
            Modifier.weight(1f),
            tint = Color.Green,
            onClick = { viewModel.selectedTabIndex = 1 })

        TabItem(
            if (viewModel.selectedTabIndex === 2) Icons.Filled.Info else Icons.Outlined.Info,
            "测试2",
            Modifier.weight(1f),
            tint = Color.Green,
            onClick = { viewModel.selectedTabIndex = 2 })
    }
}

@Composable
fun TabItem(
    imageVector: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    tint: Color,
    onClick: () -> Unit
) {
    Column(
        modifier
            .padding(vertical = 8.dp)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(imageVector, contentDescription = null, Modifier.size(24.dp), tint = tint)
        Text(title, fontSize = 11.sp, color = tint)
    }
}
