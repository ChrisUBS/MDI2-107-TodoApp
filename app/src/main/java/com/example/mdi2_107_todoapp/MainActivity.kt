package com.example.mdi2_107_todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mdi2_107_todoapp.ui.screens.TodoScreen
import com.example.mdi2_107_todoapp.ui.theme.MDI2107TodoAppTheme

class MainActivity : ComponentActivity() {
    // viewModels(), it creates the viewModel and keeps it alive during the configuration changes
    private val viewModel: TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MDI2107TodoAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoScreen(viewModel = viewModel)
                }
            }
        }
    }
}