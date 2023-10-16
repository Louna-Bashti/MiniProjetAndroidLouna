package com.example.tp1android

import android.inputmethodservice.Keyboard.Row
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun FilmsScreen(viewModel: MainViewModel) {

    var searchMode by remember {
      mutableStateOf(false)
    }

    val movies by viewModel.movies.collectAsState()
    LaunchedEffect(true) {
        viewModel.getMovies()
    }
    if (searchMode==true) {
        SearchBarMovie(viewModel) { searchMode = false}
    }
    else
    {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 180.dp), Modifier.padding(10.dp)
        ) {
            items(movies) { MovieResult ->
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w300" + MovieResult.backdrop_path,
                        contentDescription = "image du film",
                    )
                    Text(
                        text = MovieResult.title
                    )
                    Text(
                        text = MovieResult.release_date
                    )
                }
            }

        }

        ResearchButton ( {  searchMode = !searchMode })
    }



}

@Composable
fun MovieList(viewModel: MainViewModel) {
    val movies by viewModel.movies.collectAsState()


    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp), Modifier.padding(10.dp)
    ) {
        items(movies) { MovieResult ->
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w300" + MovieResult.backdrop_path,
                    contentDescription = "image du film",
                )
                Text(
                    text = MovieResult.title
                )
                Text(
                    text = MovieResult.release_date
                )
            }
        }

    }
}



@Composable
fun ResearchButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary,
        shape = CircleShape,
    ) {
        Image(
            painterResource(id = R.drawable.baseline_search_24),
            contentDescription = "icone recherche",
            modifier = Modifier.size(30.dp)
        )
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarMovie(viewModel: MainViewModel, onClick: () -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }) {
        DockedSearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 8.dp)
                .semantics { traversalIndex = -1f },
            query = text,
            onQueryChange = { text = it },
            onSearch = {
                active = false

                onClick
                       },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text("Enter a movie keyword") },
        ) {
            val movies by viewModel.movies.collectAsState()
            viewModel.searchMovies(text)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 180.dp), Modifier.padding(10.dp)
            ) {
                items(movies) { MovieResult ->
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/w300" + MovieResult.backdrop_path,
                            contentDescription = "image du film",
                        )
                        Text(
                            text = MovieResult.title
                        )
                        Text(
                            text = MovieResult.release_date
                        )
                    }
                }

            }
        }
    }
}






