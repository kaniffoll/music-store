package com.example.music_store.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.music_store.model.User
import com.example.music_store.model.UserDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val dao: UserDao
): ViewModel() {
    private val _uiState = MutableStateFlow(UserState())
    val uiState: StateFlow<UserState> = _uiState.asStateFlow()

    init{
        getUsers()
    }

    fun checkUser(): Boolean{
        val user = User(uiState.value.password, uiState.value.login)
        return uiState.value.users.any { it.login == user.login && it.password == user.password }
    }

    fun checkUserLogin():Boolean{
        val user = User(uiState.value.password, uiState.value.login)
        return uiState.value.users.any { it.login == user.login }
    }

    private fun getUsers() {
        viewModelScope.launch {
            val users = dao.getUsers()
            _uiState.value = _uiState.value.copy(
                users = users
            )
        }
    }

    fun regUser(){
        val user = User(uiState.value.password, uiState.value.login)
        viewModelScope.launch {
            dao.upsertUser(user)
            _uiState.value = _uiState.value.copy(
                login = user.login,
                password = user.password
            )
        }
    }

    fun deleteUser(){
        val user = User(uiState.value.password, uiState.value.login)
        viewModelScope.launch {
            dao.deleteUser(user)
            getUsers()
            _uiState.value = _uiState.value.copy(
                login = "",
                password = ""
            )
        }
    }

    fun updateLogin(newText: String){
        _uiState.value = _uiState.value.copy(
            login = newText
        )
    }

    fun updatePassword(newText: String){
        _uiState.value = _uiState.value.copy(
            password = newText
        )
    }
}