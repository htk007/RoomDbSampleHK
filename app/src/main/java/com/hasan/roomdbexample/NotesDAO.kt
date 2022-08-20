package com.hasan.roomdbexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hasan.roomdbexample.data.Note

@Dao
interface NotesDAO {
    @Insert
    fun insert(note: Note)

    @Query("SELECT*FROM notes")
    fun getAllNotes(): List<Note>

    @Query("DELETE FROM notes WHERE noteId =:noteId")
    fun deleteNoteById(noteId: Int)
}