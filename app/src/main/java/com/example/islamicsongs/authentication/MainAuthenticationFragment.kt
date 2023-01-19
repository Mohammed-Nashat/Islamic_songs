package com.example.islamicsongs.authentication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.islamicsongs.R
import com.example.islamicsongs.databinding.FragmentMainAuthenticationBinding

class MainAuthenticationFragment : Fragment() {

    private lateinit var binding: FragmentMainAuthenticationBinding
    private val TAG = MainAuthenticationFragment::class.java.name
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main_authentication,
            container,
            false
        )


        binding.btnSignIn.setOnClickListener {
         findNavController().navigate(MainAuthenticationFragmentDirections.actionMainAuthenticationFragmentToSignInFragment())
      Log.e(TAG,"btnSignIn")
        }

        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(MainAuthenticationFragmentDirections.actionMainAuthenticationFragmentToSignUpFragment())
            Log.e(TAG,"btnSignUp")

        }

        return binding.root
    }

}