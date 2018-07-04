package com.example.andrew.taskassistant.di.module

import android.app.Application
import androidx.room.Room
import com.example.andrew.taskassistant.data.AppDatabase
import com.example.andrew.taskassistant.di.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideAppDatabase(context: Application): AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database").build()
    }
}