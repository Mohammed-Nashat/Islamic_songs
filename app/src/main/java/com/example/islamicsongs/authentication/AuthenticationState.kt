package com.example.islamicsongs.authentication

import androidx.lifecycle.map


enum class AuthenticationState {
    AUTHENTICATED, UNAUTHENTICATED
}


val authenticationStatee = FirebaseUserLiveData().map { user ->
    if (user != null) {
        AuthenticationState.AUTHENTICATED
    } else {
        AuthenticationState.UNAUTHENTICATED
    }
}
