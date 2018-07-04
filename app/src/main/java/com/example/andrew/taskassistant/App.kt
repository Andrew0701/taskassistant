package com.example.andrew.taskassistant

import android.app.Application
import com.example.andrew.taskassistant.di.DaggerApplicationComponent
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initDagger()
        setupTimber()
    }

    private fun initDagger() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}