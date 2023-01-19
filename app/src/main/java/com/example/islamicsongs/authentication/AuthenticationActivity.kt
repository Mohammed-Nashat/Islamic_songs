package com.example.islamicsongs.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.islamicsongs.R
import com.example.islamicsongs.databinding.ActivityAuthenticationBinding
import androidx.lifecycle.Observer
import com.example.islamicsongs.MainActivity

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeAuthenticationState()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_authentication)

    }

    private fun observeAuthenticationState() {

        authenticationStatee.observe(this, Observer { authenticationState ->

            when (authenticationState) {

                AuthenticationState.AUTHENTICATED -> sendUserToRemindersActivity()

                else -> Log.e("yut", " ....... ")
            }
        })
    }


    private fun sendUserToRemindersActivity (){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

