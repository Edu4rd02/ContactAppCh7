package com.example.contactappch7.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contactappch7.data.Contact

@Composable
fun ContactDialog(
    contact: Contact? = null,
    onConfirm: (Contact) -> Unit,
    onDismiss: () -> Unit
){
    var name by remember { mutableStateOf(contact?.name ?: "") }
    var phoneNumber by remember { mutableStateOf(contact?.phoneNumber ?: "") }
    var email by remember { mutableStateOf(contact?.email ?: "") }

    // Determine the title based on:
    // contact = null means create mode, otherwise edit mode
    val title = if (contact == null) "Add Contact" else "Edit Contact"

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {Text(title)},
        text  = {
            Column(modifier = Modifier.padding(8.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = {Text("Name")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = {phoneNumber = it},
                    label = {Text("Phone Number")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    label = {Text("Email")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    // Create a Contact object form the inputs fields
                    // If editing, preserve the original ID;
                    // If creating, the id 0 indicates that is a new Contact and create a new id
                    val newContact = Contact(
                        id = contact?.id ?: 0,
                        name = name,
                        phoneNumber = phoneNumber,
                        email = email
                    )
                    onConfirm(newContact)
                }
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

//@Preview
//@Composable
//fun ContactDialogPreview(){
//    ContactDialog(
//        contact = null,
//        onConfirm = {},
//        onDismiss = {}
//    )
//}