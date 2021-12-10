package com.yah.ph3project3

import android.util.Log
import androidx.lifecycle.*
import com.yah.ph3project3.application.AppManager
import com.yah.ph3project3.network.DogPhoto
import com.yah.ph3project3.network.DogPhotoApi
import kotlinx.coroutines.launch

class DogViewModel() : ViewModel() {

    internal val dogList : LiveData<List<DogPhoto>> = getAllPhotos()

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {
        viewModelScope.launch {
            try {
                val dog = DogPhotoApi.retrofitService.getRandomPhoto()
                AppManager.database.imageDao().insertImage(dog)
            } catch (e: Exception) {
                Log.e("DogViewModel", "Error occurred: ${e.message}")
            }
        }
    }

    private fun getAllPhotos(): LiveData<List<DogPhoto>> {
        return AppManager.database.imageDao().getAllImages()
    }

//    fun insertNewImage(imageData: ImageData)
//    {
//        viewModelScope.launch {
//            imageDao.insertImage(imageData)
//        }
//
//        fun deleteLastImage(){
//            viewModelScope.launch {
//                imageDao.deleteImage()
//            }
//        }
//        //In DogImageApp -- I am having trouble getting the flow list to work, I think its an import issue
//        fun getAllImagesList(): LiveData<List<ImageData>>{
//            return imageDao.getAllImages().asLiveData()
//        }
//    }

}

//class DogViewModelFactory(val dogImageDao: ImageDao) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        TODO("Not yet implemented")
//
//        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return DogViewModel(dogImageDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
