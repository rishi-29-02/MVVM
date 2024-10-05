package com.projects.mvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostListItem(

    @PrimaryKey(autoGenerate = true)
    var postId: Int,
    var body: String,
    var id: Int,
    var title: String,
    var userId: Int
)