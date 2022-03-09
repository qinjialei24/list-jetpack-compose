package com.example.jetpack_compose_demo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SelectedModel : ViewModel() {
    var selectedTabIndex by mutableStateOf(0)
}