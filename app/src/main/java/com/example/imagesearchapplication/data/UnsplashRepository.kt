package com.example.imagesearchapplication.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imagesearchapplication.api.UnsplashApi
import javax.inject.Inject

//we use inject for our own classes like this repository
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResult(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UnsplashPagingSource(unsplashApi, query)
            }
        ).liveData
}