package com.example.islamicsongs.anasheed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamicsongs.R

class AnasheedFragment : Fragment() {

    companion object {
        fun newInstance() = AnasheedFragment()
    }

    private lateinit var viewModel: AnasheedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anasheed, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnasheedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}