package com.yah.ph3project3.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.concurrent.Flow as Flow1
import com.yah.ph3project3.data.ImageData as DataImageData

@Dao
interface ImageDao {
    @Insert
    suspend fun insertImage(dogImageData: DataImageData)
//Delete Images
    @Query("DELETE from images where id=(select max(id)-1 from images)")
    suspend fun deleteImage()
    //Select previous images in database --> return as a list
    @Query("Select * FROM images")
    fun getAllImages(): Flow1<List<DataImageData>>

    //Query recieving previous image
    @Query("SELECT * FROM images ORDER BY id DESC LIMIT 1")
    fun getNewImage() : DataImageData
}

