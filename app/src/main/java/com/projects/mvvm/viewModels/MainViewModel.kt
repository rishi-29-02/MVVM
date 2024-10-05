package com.projects.mvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.mvvm.PostRepository
import com.projects.mvvm.models.PostListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val postRepository: PostRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            postRepository.getPosts()
        }
    }

    val posts : LiveData<List<PostListItem>>
    get() = postRepository.postList


}