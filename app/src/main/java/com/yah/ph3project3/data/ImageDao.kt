package com.yah.ph3project3.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yah.ph3project3.network.DogPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Insert
    suspend fun insertImage(dogImageData: DogPhoto)
//Delete Images
    @Query("DELETE from images where id=(select max(id)-1 from images)")
    suspend fun deleteImage()
    //Select previous images in database --> return as a list
    @Query("Select * FROM images")
    fun getAllImages(): LiveData<List<DogPhoto>>

    //Query recieving previous image
    @Query("SELECT * FROM images ORDER BY id DESC LIMIT 1")
    fun getNewImage(): DogPhoto
}

