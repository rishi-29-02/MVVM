package com.projects.mvvm

import android.app.Application
import com.projects.mvvm.retrofit.ApiInterface
import com.projects.mvvm.retrofit.RetrofitHelper
import com.projects.mvvm.room.PostDatabase

class PostApplication : Application() {

    lateinit var postRepository: PostRepository

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        val api = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val database = PostDatabase.getDatabase(applicationContext)
        postRepository = PostRepository(api, database, applicationContext)
    }
}