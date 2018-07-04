package com.example.andrew.taskassistant.di

import android.app.Application
import com.example.andrew.taskassistant.App
import com.example.andrew.taskassistant.di.module.ApplicationModule
import com.example.andrew.taskassistant.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component

@PerApplication
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: App)
}