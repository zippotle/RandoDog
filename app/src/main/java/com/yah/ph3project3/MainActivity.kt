package com.yah.ph3project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.net.toUri
import coil.load
import com.yah.ph3project3.application.ImageApp
import com.yah.ph3project3.data.ImageData
import com.yah.ph3project3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels{
        DogViewModelFactory((application as ImageApp).database.imageDao())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomDogPhoto()

    }

    fun getRandomDogPhoto () {
        viewModel.dogPhoto.observe(this, {val imgUri = it.imageUrl!!.toUri().buildUpon().scheme("https").build()
            binding.imageView.load(imgUri)})


        val randomPhotoButton = binding.button


        randomPhotoButton.setOnClickListener {

            val currentImage = viewModel.dogPhoto.value!!.imageUrl
            val previousImage = currentImage?.let {
                    dogImage -> ImageData(imageUrl = dogImage)
            }
            viewModel.getNewPhoto()

//
//            if(previousImage != null){
//                viewModel.insertNewImage(previousImage)
//            }
//            viewModel.deleteLastImage()
        }


    }
}
