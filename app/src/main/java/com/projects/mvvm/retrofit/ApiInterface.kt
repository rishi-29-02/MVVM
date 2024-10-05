package com.projects.mvvm.retrofit

import com.projects.mvvm.models.PostListItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun getPosts() : Response<List<PostListItem>>


}