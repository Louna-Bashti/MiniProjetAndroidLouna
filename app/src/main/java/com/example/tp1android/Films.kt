package com.example.tp1android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun FilmsScreen(viewModel: MainViewModel){
    val movies by viewModel.movies.collectAsState()

    LaunchedEffect(true) {
        viewModel.getMovies()
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 200.dp), Modifier.padding(vertical=50.dp)
    ) {
        items(movies) {MovieResult ->
            Column(Modifier.padding(vertical=10.dp), horizontalAlignment = Alignment.CenterHorizontally){
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w300"+MovieResult.backdrop_path,
                    contentDescription = "image du film",)
                Text(
                    text = MovieResult.title)
                Text(
                    text = MovieResult.release_date
                )
            }
}

    }

}

