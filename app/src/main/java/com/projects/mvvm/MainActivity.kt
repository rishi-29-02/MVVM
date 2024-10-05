package com.projects.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.projects.mvvm.retrofit.ApiInterface
import com.projects.mvvm.databinding.ActivityMainBinding
import com.projects.mvvm.retrofit.RetrofitHelper
import com.projects.mvvm.viewModels.MainViewModel
import com.projects.mvvm.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postRepository = (application as PostApplication).postRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(postRepository))[MainViewModel::class.java]

        mainViewModel.posts.observe(this, Observer {
            Toast.makeText(this, it.size.toString(), Toast.LENGTH_LONG).show()
            binding.tvText.text = it.toString()
        })
    }
}