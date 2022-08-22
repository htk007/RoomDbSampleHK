package com.hasan.roomdbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hasan.roomdbexample.adapter.NotesAdapter
import com.hasan.roomdbexample.data.Note
import com.hasan.roomdbexample.db.NotesDatabase

class MainActivity : AppCompatActivity() {
    private var notesDatabase:NotesDatabase? = null
    private lateinit var etNote:EditText
    private lateinit var btSave: Button
    private lateinit var btList: Button
    private lateinit var currentNote : Note
    private lateinit var rcNotes: RecyclerView
    private lateinit var adapterNotes: NotesAdapter
    private lateinit var notesList:ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initDb()
        fetchNotes()
    }

    private fun initViews(){
        println("MSSSSG init views")
        etNote = findViewById(R.id.etNote)
        btList = findViewById(R.id.btList)
        btSave = findViewById(R.id.btSave)
        rcNotes = findViewById(R.id.recyclerviewNotes)
        initClickEvents()
    }

    private fun initClickEvents(){
        btSave.setOnClickListener {
            var note = etNote.text.toString()
            if(note.isNullOrEmpty()){
                Toast.makeText(this,"Not be empty!", Toast.LENGTH_SHORT).show()
            }else{
                println("MSSSSG save start for : $note  ")
                currentNote = Note(0, note)
                // currentStudent = Student(0,name,grade)
                addNoteToDb(currentNote)
                println("MSSSSG save complete")
                etNote.text.clear()
            }
        }
        btList.setOnClickListener {
           fetchNotes()
            if(notesList.isNullOrEmpty()){

            }else{
                rcNotes.layoutManager = LinearLayoutManager(this)
                adapterNotes = NotesAdapter(notesList){
                    //delete note when clicked
                   // deleteNoteById(it.noteId)
                  //  Toast.makeText(this, "delete item successfully", Toast.LENGTH_SHORT).show()

                    var cdd = CustomDialog(this, it, notesDatabase)
                    cdd.show()
                }
                rcNotes.adapter = adapterNotes
            }
        }
    }
    
    private fun fetchNotes(){
        notesList = getAllNotes()
    }

    private fun initDb(){
        println("MSSSSG init db")
        notesDatabase = NotesDatabase.getNotesDatabase(this)
    }

    private fun addNoteToDb(note: Note){
        notesDatabase?.notesDao()?.insert(note)
    }

    private fun getAllNotes(): ArrayList<Note>{
        return notesDatabase?.notesDao()?.getAllNotes() as ArrayList<Note>
    }
    private fun deleteNoteById(noteId: Int){
        notesDatabase?.notesDao()?.deleteNoteById(noteId)
    }
}