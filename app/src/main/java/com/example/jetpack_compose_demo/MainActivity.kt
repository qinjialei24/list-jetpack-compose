package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposedemoTheme() {
                App()
            }
        }
    }
}


@Composable
fun MainContent() {

}


@Composable
fun App() {
    Column() {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            BottomBar()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDemo() {
    App()
}