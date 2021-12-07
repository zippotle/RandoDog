package com.yah.ph3project3

import androidx.lifecycle.*
import com.yah.ph3project3.data.ImageDao
import com.yah.ph3project3.data.ImageData
import com.yah.ph3project3.network.DogPhoto
import kotlinx.coroutines.launch

class DogViewModel(private val imageDao: ImageDao) : ViewModel() {

    private val _dogPhoto = MutableLiveData<DogPhoto>()
    val dogPhoto: LiveData<DogPhoto> = _dogPhoto

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {
        viewModelScope.launch {
            fun insertNewImage(imageData: ImageData {
                viewModelScope.launch {
                    imageDao.insertImage(imageData)
                }

                fun deleteLastImage(){
                    viewModelScope.launch {
                        imageDao.deleteImage()
                    }
                }
//In DogImageApp -- I am having trouble getting the flow list to work, I think its an import issue
                fun getAllImagesList(): LiveData<List<ImageData>>{
                    return imageDao.getAllImages().asLiveData()
                }
            }

        }
    }

}

class DogViewModelFactory(val dogImageDao: ImageDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")

        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DogViewModel(dogImageDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

