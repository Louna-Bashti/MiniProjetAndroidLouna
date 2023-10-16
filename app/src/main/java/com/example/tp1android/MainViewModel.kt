package com.example.tp1android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<MovieResult>>(listOf())
    val series = MutableStateFlow<List<SeriesResult>>(listOf())
    val actors = MutableStateFlow<List<ActorResult>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("6951006290ee3ea6cec168d02c857688").results
        }
    }

    fun getSeries() {
        viewModelScope.launch {
            series.value = api.lastseries("6951006290ee3ea6cec168d02c857688").results
        }
    }

    fun getActors() {
        viewModelScope.launch {
            actors.value = api.lastactors("6951006290ee3ea6cec168d02c857688").results
        }
    }

    fun searchMovies(keyword: String)
    {
        viewModelScope.launch {
            movies.value = api.searchmovies("6951006290ee3ea6cec168d02c857688", keyword).results
        }
    }

    fun searchSeries(keyword: String)
    {
        viewModelScope.launch {
            series.value = api.searchseries("6951006290ee3ea6cec168d02c857688", keyword).results
        }
    }
    fun searchActors(keyword: String)
    {
        viewModelScope.launch {
            actors.value = api.searchactors("6951006290ee3ea6cec168d02c857688", keyword).results
        }
    }

}