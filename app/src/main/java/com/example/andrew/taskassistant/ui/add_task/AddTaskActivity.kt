package com.example.andrew.taskassistant.ui.add_task

import android.os.Bundle
import android.os.PersistableBundle
import com.example.andrew.taskassistant.R
import com.example.andrew.taskassistant.ui.base.BaseActivity

class AddTaskActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_add_task)
    }

    override fun initViews() {

    }
}