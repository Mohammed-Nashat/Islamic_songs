package com.example.islamicsongs.doaa

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamicsongs.R

class DoaaFragment : Fragment() {

    companion object {
        fun newInstance() = DoaaFragment()
    }

    private lateinit var viewModel: DoaaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doaa, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoaaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}