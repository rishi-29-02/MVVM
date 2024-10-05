package com.projects.mvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.projects.mvvm.models.PostListItem

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    suspend fun getPosts() : List<PostListItem>

    @Insert
    suspend fun insertPosts(posts: List<PostListItem>)
}