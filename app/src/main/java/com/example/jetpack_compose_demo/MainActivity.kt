package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class GoodsItem(
    val id: String,
    val name: String,
    val imgUrl: String
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

val testData: List<GoodsItem> = listOf(
    GoodsItem(name = "phone", imgUrl = "", id = "1"),
    GoodsItem(name = "basketball", imgUrl = "", id = "2"),
)


@Composable
fun App() {
    GoodsList(testData)
}


@Composable
fun GoodsList(goodsList: List<GoodsItem>) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        LazyColumn() {
            items(items = goodsList) { item ->
                GoodsListItem(item = item)
            }
        }
    }
}


@Composable
fun GoodsListItem(item: GoodsItem) {
    val (id, name) = item
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(
                id = R.drawable.goods1
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(50)),
        )
        Text(name)
    }
}


@Preview
@Composable
fun PreviewDemo() {
    App()
}