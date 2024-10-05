package com.projects.mvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projects.mvvm.models.PostListItem
import com.projects.mvvm.retrofit.ApiInterface
import com.projects.mvvm.room.PostDatabase
import com.projects.mvvm.utils.NetworkUtils

class PostRepository(
    private val apiInterface: ApiInterface,
    private val postDatabase: PostDatabase,
    private val context: Context
) {

    var mutablePostList = MutableLiveData<List<PostListItem>>()

    val postList : LiveData<List<PostListItem>>
        get() = mutablePostList

     suspend fun getPosts() {
         if (NetworkUtils(context).isOnline()) {
             val result = apiInterface.getPosts()
             if(result?.body() != null) {
                 postDatabase.postDao().insertPosts(result.body()!!)
                 mutablePostList.postValue(result.body())
             }
         } else {
             val result = postDatabase.postDao().getPosts()
             mutablePostList.postValue(result)
         }
    }
}