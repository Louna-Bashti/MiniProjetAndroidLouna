package com.example.tp1android

import android.graphics.Movie
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(classes: WindowSizeClass, onNavigateToMovie: () -> Unit,) {
    val classeHauteur = classes.heightSizeClass
    val classeLargeur = classes.widthSizeClass
    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp)
            ) {
                Greeting("Louna")
                ImageChat()
                Présentation()
                Démarrer(onNavigateToMovie)
            };
        }

        else -> {
            Row(
                Modifier.fillMaxSize().padding(horizontal = 50.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                ) {
                    Greeting("Louna")
                    ImageChat()
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                )
                {
                    Présentation()
                    Démarrer(onNavigateToMovie)
                }
            }

        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ImageChat() {
    Image(
        painterResource(id = R.drawable.suna),
        contentDescription = "chat",
        Modifier
            .clip(RoundedCornerShape(200.dp))
            .size(300.dp)
    )
}

@Composable
fun Présentation() {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Suna Bashti"
        )
        Text(text = "Chat professionnel")
    }
    Column (modifier = Modifier.padding(40.dp)){
        Row {
            Image(
                painterResource(id = R.drawable.baseline_location_on_24),
                contentDescription = "location"
            )
            Text(text = "Sur le canapé")
        }
        Row {
            Image(
                painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "add"
            )
            Text(text = "Ajouter en ami")
        }
    }

}

@Composable
fun Démarrer(onNavigateToMovie: () -> Unit) {
    Button(onClick = onNavigateToMovie , modifier = Modifier.clip(RoundedCornerShape(2.dp)),) {
        Text(text = "Accéder aux films")

    }
}