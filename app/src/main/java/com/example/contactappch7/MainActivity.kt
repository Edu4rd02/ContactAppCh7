package com.example.contactappch7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactappch7.ui.ContactViewModel
import com.example.contactappch7.ui.screens.ContactListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: ContactViewModel = viewModel()
            MaterialTheme {
                ContactListScreen(
                    viewModel = viewModel
                ) { }
            }
        }
    }
}
