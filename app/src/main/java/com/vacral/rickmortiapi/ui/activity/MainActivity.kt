package com.vacral.rickmortiapi.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.vacral.rickmortiapi.ui.screens.characters.CharacterListScreen
import com.vacral.rickmortiapi.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            RickAndMortyTheme{
                    CharacterListScreen(modifier = Modifier.fillMaxSize())
                }
            }

        }
    }