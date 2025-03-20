package com.example.music_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.music_store.model.UserDatabase
import com.example.music_store.ui.UserViewModel
import com.example.music_store.ui.theme.MusicStoreTheme


class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            name = "users"
        ).build()
    }

    private val viewModel by viewModels<UserViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T{
                    return UserViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicStoreTheme {
                Surface(){
                    MusicStoreApp(viewModel = viewModel)
                }
            }
        }
    }
}


