package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager


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


@OptIn(ExperimentalPagerApi::class)
@Composable
fun App() {
    JetpackcomposedemoTheme() {
        var tabPage by remember {
            mutableStateOf(TabPage.Home)
        }


        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Scaffold(bottomBar = {
                TabHome(selectedTabIndex = tabPage.ordinal, onSelectedTab = { tabPage = it })
            }) {
                Column {
                    Text(text = tabPage.name)
                }

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDemo() {
    App()
}