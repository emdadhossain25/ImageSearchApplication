package com.example.imagesearchapplication.data

import com.example.imagesearchapplication.api.UnsplashApi
import javax.inject.Inject

//we use inject for our own classes like this repository
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
}