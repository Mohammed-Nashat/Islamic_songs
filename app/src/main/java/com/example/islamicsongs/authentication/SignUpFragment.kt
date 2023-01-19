package com.example.islamicsongs.authentication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.islamicsongs.MainActivity
import com.example.islamicsongs.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


    binding = FragmentSignUpBinding.inflate(layoutInflater)

    firebaseAuth = FirebaseAuth.getInstance()


    binding.textView.setOnClickListener {
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
    }


    binding.button.setOnClickListener {

        val email = binding.emailEt.text.toString()
        val pass = binding.passET.text.toString()
        val confirmPass = binding.confirmPassEt.text.toString()

        if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
            if (pass == confirmPass) {

                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToMainScreenFragment2())
                    } else {
                        Toast.makeText(this.context, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this.context, "Password is not matching", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this.context, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

        }
    }
        return binding.root
}
}
