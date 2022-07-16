package com.example.imagesearchapplication.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.imagesearchapplication.data.UnsplashRepository

// here also we inject the dependency repository view model (special inject viewmodelInjector)
class GalleryViewModel @ViewModelInject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {
}