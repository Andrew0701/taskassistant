package com.example.andrew.taskassistant.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.andrew.taskassistant.data.dao.TaskDao
import com.example.andrew.taskassistant.data.entity.TaskEntity

@Database(entities = [(TaskEntity::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}