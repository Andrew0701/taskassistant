package com.example.andrew.taskassistant.ui.tasks

import android.content.Intent
import android.os.Bundle
import com.example.andrew.taskassistant.R
import com.example.andrew.taskassistant.ui.add_task.AddTaskActivity
import com.example.andrew.taskassistant.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_tasks.*

class TasksActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        initViews()
    }

    private fun initViews() {
        fabAddTask.setOnClickListener { openAddTaskActivity() }
    }

    private fun openAddTaskActivity() {
        startActivity(Intent(this, AddTaskActivity::class.java))
    }
}
