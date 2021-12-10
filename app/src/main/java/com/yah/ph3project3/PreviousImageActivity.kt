package com.yah.ph3project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.yah.ph3project3.application.DogImageApp
import com.yah.ph3project3.databinding.ActivityPreviousImageBinding

class PreviousImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreviousImageBinding
    private val viewModel: DogViewModel by viewModels()
//        DogViewModelFactory((application as ImageApp).database.imageDao())
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviousImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel.getNewPhoto().observe(this) { dogImage ->
//            val prevImage = binding.previousDogImageView
//            prevImage.load(dogImage[0].imageUrl)
//            binding.currentButton.setOnClickListener { finish() }
//        }
    }
}