package com.devtides.androidcoroutinesflow.model

import com.devtides.androidcoroutinesflow.network.PostsService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepository {
    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        private const val NEWS_DELAY = 2000L
    }
    private val postsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostsService::class.java)

    fun getPosts(): Flow<PostsModel.PostsModelItem>{
        return  flow {
            val postList = postsService.fetchPosts()
            println("PostsList is $postList")
            postList.forEach {
                emit(it)
                delay(NEWS_DELAY)
            }
        }
    }

}
//"https://raw.githubusercontent.com/DevTides/countries/master/"