
package com.example.myapplication.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated = _isAuthenticated.asStateFlow()

    fun login(email: String, password: String) {
        // TODO: Implement actual login logic
        viewModelScope.launch {
            _isAuthenticated.value = true
        }
    }

    fun signUp(name: String, email: String, password: String) {
        // TODO: Implement actual sign up logic
        viewModelScope.launch {
            _isAuthenticated.value = true
        }
    }
}
