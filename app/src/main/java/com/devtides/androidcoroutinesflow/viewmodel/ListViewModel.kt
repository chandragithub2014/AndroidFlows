package com.devtides.androidcoroutinesflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.devtides.androidcoroutinesflow.model.PostRepository

class ListViewModel: ViewModel() {

    val posts = PostRepository().getPosts().asLiveData()

}