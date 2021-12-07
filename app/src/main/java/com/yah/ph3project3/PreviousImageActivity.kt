package com.yah.ph3project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yah.ph3project3.application.ImageApp

class PreviousImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllImagesList().observe(this) { dogImage ->
            val prevImage = binding.previousDogImageView
            prevImage.load(dogImage[0].imageUrl)
            binding.currentButton.setOnClickListener { finish() }
        }
    }

    private lateinit var binding: ActivityLastImageBinding
    private val viewModel: DogViewModel by viewModels{
        DogViewModelFactory((application as ImageApp).database.imageDao())
    }

}