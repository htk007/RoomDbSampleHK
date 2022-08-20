package com.hasan.roomdbexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hasan.roomdbexample.NotesDAO
import com.hasan.roomdbexample.data.Note

@Database(entities = [Note::class], version = 1)
abstract class NotesDatabase : RoomDatabase(){
    abstract fun notesDao():NotesDAO

    companion object{
        private var instance: NotesDatabase?= null

        fun getNotesDatabase(context: Context): NotesDatabase?{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context,
                    NotesDatabase::class.java,
                    "notes.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}