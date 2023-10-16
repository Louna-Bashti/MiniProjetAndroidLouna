package com.example.tp1android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tp1android.ui.theme.TP1AndroidTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP1AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(this)
                    val navController = rememberNavController()
                    val viewModel = MainViewModel()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    /*
                    if (currentDestination?.hierarchy?.any { it.route == "profile" } == true) {
                        NavHost(navController = navController, startDestination = "profile") {
                            composable("profile") {
                                ProfileScreen(
                                    windowSizeClass,
                                    onNavigateToMovie = { navController.navigate("films") })
                            }
                            composable("films") { FilmsScreen(viewModel)}
                            composable("séries") { SeriesScreen(viewModel) }
                            composable("acteurs") { ActorScreen(viewModel) }
                        }
                    } else {
                        */
                        Scaffold(
                            bottomBar = {
                                BottomNavigation {

                                    BottomNavigationItem(
                                        icon = {
                                            Image(
                                                painterResource(id = R.drawable.movie_icon),
                                                contentDescription = "movie icon",
                                                colorFilter = ColorFilter.tint(Color.Companion.White)
                                            )
                                        },
                                        label = { Text(text = "Films") },
                                        selected = currentDestination?.hierarchy?.any { it.route == "films" } == true,
                                        onClick =
                                        {
                                            navController.navigate("films") {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        })
                                    BottomNavigationItem(
                                        icon = {
                                            Image(
                                                painterResource(
                                                    id = R.drawable.baseline_live_tv_24
                                                ),
                                                contentDescription = "series icon",
                                                colorFilter = ColorFilter.tint(Color.Companion.White)
                                            )
                                        },
                                        label = { Text(text = "Séries") },
                                        selected = currentDestination?.hierarchy?.any { it.route == "séries" } == true,
                                        onClick =
                                        {
                                            navController.navigate("séries") {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        })
                                    BottomNavigationItem(
                                        icon = {
                                            Image(
                                                painterResource(id = R.drawable.actors_icon),
                                                contentDescription = "actor icon",
                                                colorFilter = ColorFilter.tint(Color.Companion.White)
                                            )
                                        },
                                        label = { Text(text = "Acteurs") },
                                        selected = currentDestination?.hierarchy?.any { it.route == "acteurs" } == true,
                                        onClick =
                                        {
                                            navController.navigate("acteurs") {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        })

                                }
                            }
                        )
                        { innerPadding ->
                            NavHost(
                                navController = navController,
                                startDestination = "profile",
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                composable("profile") {
                                    ProfileScreen(
                                        windowSizeClass,
                                        onNavigateToMovie = { navController.navigate("films") })
                                }
                                composable("films") { FilmsScreen(viewModel) }
                                composable("séries") { SeriesScreen(viewModel) }
                                composable("acteurs") { ActorScreen(viewModel) }
                            }



                        }
                    }


                }
            }
        }
    }
/*}

 */



