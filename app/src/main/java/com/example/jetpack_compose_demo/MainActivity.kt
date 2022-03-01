package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}


@Composable
fun App() {
    TodoList(mutableListOf("摸鱼", "打游戏"))
}

@Composable
fun TodoList(lists: MutableList<String>) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            for (list in lists) {
                TodoListItem(text = list)
            }
        }
    }
}

@Composable
fun TodoListItem(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        val done = remember { mutableStateOf(false) }
        Text(text = if (done.value) "$text completed!" else text, Modifier.padding(5.dp))
        OutlinedButton(onClick = { done.value = !done.value }) {
            Text(text = "completed!")
        }
    }
}

@Preview
@Composable
fun PreviewDemo() {
    App()
}