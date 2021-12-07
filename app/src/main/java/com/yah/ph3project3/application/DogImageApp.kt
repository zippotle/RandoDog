package com.yah.ph3project3.application

import android.app.Application
import com.yah.ph3project3.data.ImageData
//Why isnt this import working???
import com.yah.ph3project3.data.ImageDatabase
import kotlin.reflect.KProperty

//import com.yah.ph3project3.data.ImageDatabase.getDatabase
//https://www.tutorialspoint.com/how-to-call-a-non-static-method-of-an-abstract-class-from-a-static-method-in-java
//do i use this method???

class ImageApp : Application()  {
    val database: ImageDatabase by lazy {
        ImageDatabase.getDatabase(this)
    }
}

//Was suggestes by Android Studio
private operator fun <T> Lazy<T>.getValue(
    imageApp: ImageApp,
    property: KProperty<T?>
): ImageDatabase {
    TODO("Not yet implemented")
}
