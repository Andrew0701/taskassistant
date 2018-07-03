package com.example.andrew.taskassistant.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.andrew.taskassistant.data.dao.base.BaseDao
import com.example.andrew.taskassistant.data.entity.TaskEntity

@Dao
interface TaskDao : BaseDao<TaskEntity> {

    @Query("SELECT * FROM 'task'")
    fun getAll(): List<TaskEntity>
}