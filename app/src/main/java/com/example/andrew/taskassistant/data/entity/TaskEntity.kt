package com.example.andrew.taskassistant.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id : Int,
                      @ColumnInfo(name = "name") val name : String,
                      @ColumnInfo(name = "description") val description : String)