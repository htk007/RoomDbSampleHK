package com.hasan.roomdbexample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
    var noteId: Int = 0,

    @ColumnInfo(name = "noteText")
    var noteText: String,
)