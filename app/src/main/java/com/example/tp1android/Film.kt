package com.example.tp1android

import androidx.annotation.ReturnThis
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun FilmScreen (id : Int, viewModel: MainViewModel) {

    val movie by viewModel.movie.collectAsState()
    LaunchedEffect(true) {
        viewModel.getMovie(id)
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

