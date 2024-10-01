package com.example.agendaroom.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact (


    @PrimaryKey(autoGenerate = true)
    val id: Int, // Por requisito de Room

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "phone")
    val phone: String
)