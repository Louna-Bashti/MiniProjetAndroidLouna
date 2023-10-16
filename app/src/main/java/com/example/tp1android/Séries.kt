package com.example.tp1android

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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SeriesScreen(viewModel: MainViewModel) {

    val movies by viewModel.series.collectAsState()
    LaunchedEffect(true) {
        viewModel.getSeries()
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp), Modifier.padding(10.dp)
    ) {
        items(movies) { SeriesResult ->
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w300" + SeriesResult.backdrop_path,
                    contentDescription = "image de la série",
                )
                Text(
                    text = SeriesResult.name
                )
                Text(
                    text = SeriesResult.first_air_date
                )
            }
        }

    }
}