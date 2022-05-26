package com.seiko.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.seiko.material3.ui.theme.ComposeMaterial3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = { }) {
                            Icon(Icons.Filled.Add, null)
                        }
                    },
                    topBar = {
                        SmallTopAppBar(
                            title = {
                                Text("Material 3")
                            }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                icon = {
                                    Icon(Icons.Filled.Home, null)
                                },
                                label = {
                                    Text("Home")
                                }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = {
                                    Icon(Icons.Filled.Search, null)
                                },
                                label = {
                                    Text("Search")
                                }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = {
                                    Icon(Icons.Filled.VerifiedUser, null)
                                },
                                label = {
                                    Text("User")
                                }
                            )
                        }
                    }
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMaterial3Theme {
        Greeting("Android")
    }
}