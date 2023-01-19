package com.example.islamicsongs.qasayid

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamicsongs.R

class QasayidFragment : Fragment() {

    companion object {
        fun newInstance() = QasayidFragment()
    }

    private lateinit var viewModel: QasayidViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_qasayid, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QasayidViewModel::class.java)
        // TODO: Use the ViewModel
    }

}