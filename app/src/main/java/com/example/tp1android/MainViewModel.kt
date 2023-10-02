package com.example.tp1android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val movies= MutableStateFlow<List<MovieResult>>(listOf())

    fun getMovies() {
        viewModelScope.launch{
            movies.value= api.lastmovies("6951006290ee3ea6cec168d02c857688").results
        }
    }
}