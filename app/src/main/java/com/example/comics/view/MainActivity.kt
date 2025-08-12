package com.example.comics.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.comics.designsystem.themes.apptheme.AppTheme
import com.example.comics.di.setupKoinApplication
import com.example.comics.navigation.AppNavGraph
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            KoinApplication(
                application = setupKoinApplication(),
            ) {
                AppTheme(
                    isDarkTheme = false
                ) {
                    AppNavGraph()
                }
            }
        }
    }
}
