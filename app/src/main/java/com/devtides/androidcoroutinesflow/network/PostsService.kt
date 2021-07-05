package com.devtides.androidcoroutinesflow.network

import com.devtides.androidcoroutinesflow.model.PostsModel
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {
    @GET("/posts")
    suspend fun  fetchPosts(): List<PostsModel.PostsModelItem>
}