package com.example.contactappch7.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao{

    // Retrieves all contacts ordered alphabetically by name
    @Query("SELECT * FROM contacts ORDER by name ASC")
    fun getAllContacts(): Flow<List<Contact>>

    // onConflictsStrategy.Replace means if a contact with the same ID exist then ROOM deletes
    // The old row and insert the new one
    // Suspend runs this disk operations off the main thread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact)

    // Updates an existing contact in the database
    // @Update tells Room to generate a SQL UPDATE statement
    @Update
    suspend fun updateContact(contact: Contact)

    // @Delete tells Room to generate a SQL DELETE statement
    // Room matches the contact by its ID and removes the entire row
    @Delete
    suspend fun deleteContact(contact: Contact)
}