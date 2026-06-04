package com.example.contactappch7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactappch7.data.Contact
import com.example.contactappch7.ui.ContactViewModel
import com.example.contactappch7.ui.screens.ContactDetailScreen
import com.example.contactappch7.ui.screens.ContactListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: ContactViewModel = viewModel()
            val selectedContact = remember { mutableStateOf<Contact?>(null) }
            MaterialTheme {
                if (selectedContact.value == null){
                    ContactListScreen(
                        viewModel = viewModel,
                        onContactClick = { contact ->
                            selectedContact.value = contact
                        }
                    )
                } else {
                    ContactDetailScreen(
                        contactId = selectedContact.value!!.id,
                        viewModel = viewModel,
                        onBackClick = {
                            selectedContact.value = null
                        }
                    )
                }
            }
        }
    }
}
