package com.example.music_store.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    val password: String,
    @PrimaryKey
    val login: String
)
