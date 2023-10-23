package com.example.tp1android

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage

@Composable
fun SerieScreen (id : Int, viewModel: MainViewModel) {

    val movie by viewModel.movie.collectAsState()
    LaunchedEffect(true) {
        viewModel.getSerie(id)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = movie.title)

        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780" + movie.backdrop_path,
            contentDescription = "image du film",
        )
        Text(
            text = movie.release_date
        )

    }

}