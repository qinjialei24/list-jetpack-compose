package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "goodsListScreen") {
        composable("goodsListScreen") {
            GoodsListScreen(
                goodsList = testData,
                navController = navController
            )
        }

        composable("goodsDetailScreen") {
            GoodsDetailScreen(navController)
        }
    }

}


@Composable
fun GoodsDetailScreen(navController: NavController) {
    Text(text = "i am detail")

}


@Composable
fun GoodsListScreen(goodsList: List<GoodsItem>, navController: NavController) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        LazyColumn() {
            items(items = goodsList) { item ->
                GoodsListItem(item = item, navController = navController)
            }
        }
    }
}


@Composable
fun GoodsListItem(item: GoodsItem, navController: NavController) {
    val (id, name) = item
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            navController.navigate("goodsDetailScreen")
            print("111")
        }
    ) {
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