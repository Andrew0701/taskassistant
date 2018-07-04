package com.example.andrew.taskassistant.ui.add_task

import android.os.Bundle
import com.example.andrew.taskassistant.R
import com.example.andrew.taskassistant.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        initViews()
    }

    private fun initViews() {
        fabAddTask.setOnClickListener {  }
    }
}