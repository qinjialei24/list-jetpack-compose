package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


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

        val pagerState = rememberPagerState(initialPage = TabPage.values().size)
        var scope = rememberCoroutineScope()

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Scaffold(bottomBar = {
                TabHome(selectedTabIndex = 1, onSelectedTab = {
                    scope.launch {
                        pagerState.animateScrollToPage(it.ordinal)
                    }
                })
            }) {
                HorizontalPager(state = pagerState, count = 4) { index ->
                    Column(Modifier.fillMaxSize()) {
                        when (index) {
                            0 -> Text(text = "0")
                            1 -> Text(text = "1")
                            2 -> Text(text = "2")
                        }
                    }
                }

            }

        }
    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabIndicator(tabPosition: List<TabPosition>, index: Int) {
    val width = tabPosition[index].width
    val offsetX = tabPosition[index].left



    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = offsetX)
            .width(width)
            .padding(4.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, Color.Green)
            )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDemo() {
    App()
}