package com.example.imagesearchapplication.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.imagesearchapplication.data.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// here also we inject the dependency repository view model (special inject viewmodelInjector)
@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {
    private val currentQuery = MutableLiveData(DEFAULT_QUERY_STRING)
    val photos = currentQuery.switchMap { queryString ->
//        query
        unsplashRepository.getSearchResult(queryString).cachedIn(viewModelScope)

    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        const val DEFAULT_QUERY_STRING = "cats"
    }
}