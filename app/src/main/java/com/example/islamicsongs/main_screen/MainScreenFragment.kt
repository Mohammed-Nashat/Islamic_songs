package com.example.islamicsongs.main_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.islamicsongs.R
import com.example.islamicsongs.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {


    private lateinit var viewModel: MainScreenViewModel
    private lateinit var binding:FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

    binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_screen,container,false)

        return binding.root

    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}