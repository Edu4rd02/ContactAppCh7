package com.example.contactappch7.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.contactappch7.data.Contact

@Composable
fun ContactItem(
    contact: Contact,
    onClick: () -> Unit,
    onDelete: () -> Unit
){
    var showDeleteDialog by remember { mutableStateOf(false) }
}