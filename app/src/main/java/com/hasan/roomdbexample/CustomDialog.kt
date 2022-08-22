package com.hasan.roomdbexample

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import com.hasan.roomdbexample.data.Note
import com.hasan.roomdbexample.db.NotesDatabase

class CustomDialog(activity: Activity,var note: Note,val notesDatabase: NotesDatabase?) : Dialog(activity), View.OnClickListener {
    var btUpdate: Button? = null
    var btCancel: Button? = null
    var btDelete: Button? = null
    var etNote: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.edit_dialog)
        etNote = findViewById(R.id.txtNote)
        btUpdate = findViewById(R.id.btn_update)
        btDelete = findViewById(R.id.btn_delete)
        btCancel = findViewById(R.id.btn_cancel)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_delete ->{
                notesDatabase?.notesDao()?.deleteNoteById(note.noteId)
            }
            R.id.btn_cancel ->{
                dismiss()
            }
            R.id.btn_update ->{
                notesDatabase?.notesDao()?.updateNoteById(note.noteText,note.noteId)
            }
        }
    }


}