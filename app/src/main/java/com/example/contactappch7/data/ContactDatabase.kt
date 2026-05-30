package com.example.contactappch7.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class],version = 1, exportSchema = false)

// This is the only way the rest of the ap accesses the database operations
// Abstract tells Rooms to generate the body of this function automatically
abstract class ContactDatabase: RoomDatabase(){
    companion object {
        // @Volatile ensures every thread always reads this value from main memory
        // Without @Volatile a thread could read a state null form its CPU Cache
        // And try to create a second database instance - breaking the Singleton
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase{
            // Nobody ever instantiates ContactDatabase directly
            // Context is needed by Room to create and locate the database file on disk
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    klass = ContactDatabase::class.java,
                    // the actual filename of the database file stored in the device
                    name = "contacts_database"
                ).build()
                INSTANCE = instance
                // Return the newly created instance
                instance
            }
        }
    }
}
