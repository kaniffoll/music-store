package com.example.music_store.ui

import com.example.music_store.model.User


data class UserState (
    val login: String = "",
    val password: String = "",
    val users: List<User> = emptyList(),
)