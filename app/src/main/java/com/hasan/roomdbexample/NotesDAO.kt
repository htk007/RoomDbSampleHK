package com.hasan.roomdbexample

import android.widget.EditText
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

    @Query("UPDATE notes SET noteText= :noteText WHERE noteId =:noteId")
    fun updateNoteById(noteText: String, noteId: Int)
}