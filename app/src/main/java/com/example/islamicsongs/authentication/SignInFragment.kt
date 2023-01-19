package com.example.islamicsongs.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.islamicsongs.R
import com.example.islamicsongs.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_in,container,false)



        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToMainScreenFragment2())

                    } else {
                        Toast.makeText(this.context, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this.context, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){

//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }
}