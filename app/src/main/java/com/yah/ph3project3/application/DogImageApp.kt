package com.yah.ph3project3.application

import android.app.Application
import androidx.room.Room
import com.yah.ph3project3.data.ImageDatabase
import kotlin.reflect.KProperty

//import com.yah.ph3project3.data.ImageDatabase.getDatabase
//https://www.tutorialspoint.com/how-to-call-a-non-static-method-of-an-abstract-class-from-a-static-method-in-java
//do i use this method???

class DogImageApp : Application()  {
    // Ctrl + O to find Android Studio methods
    override fun onCreate() {
        super.onCreate()

        AppManager.initialize(this)
    }
}

object AppManager{
    private lateinit var application: Application

    // Initialize Room database
    val database by lazy {
        Room.databaseBuilder(
            this.application,
            ImageDatabase::class.java,
            "image_database"
        ).build()
    }

    // Initialize application context
    fun initialize(application: Application) {
        this.application = application
    }
}