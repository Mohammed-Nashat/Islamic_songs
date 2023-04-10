package com.example.islamicsongs.ui.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.islamicsongs.R
import com.example.islamicsongs.adapters.PlayListAdapter
import com.example.islamicsongs.adapters.PlayListListener
import com.example.islamicsongs.databinding.FragmentMainScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment() {

    // koin Or DaggerHilt
    private val _viewModel: MainScreenViewModel by viewModel()

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)

        binding.viewModel = _viewModel

        _viewModel.controlSeeBar(binding.seekBar)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        _viewModel.seekBarVisibility.observe(viewLifecycleOwner, Observer {
            if (it) binding.seekBar.visibility = View.VISIBLE

        })
        _viewModel.seekBarMax.observe(viewLifecycleOwner, Observer {
            it?.let { binding.seekBar.max = it }
        })

        _viewModel.seekBarProgress.observe(viewLifecycleOwner, Observer {
            it?.let { binding.seekBar.progress = it }
        })

        setUpRecyclerView()

    }


    private fun setUpRecyclerView() {

        val adapterPlayLists = PlayListsAdapter(PlayListsListener {

            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragment2ToPlayMusicFragment(it))
        })

        _viewModel.playLists.observe(viewLifecycleOwner, Observer {
            adapterPlayLists.submitList(it)
        })

        binding.rcvPlayllists.adapter = adapterPlayLists

        val adapterPlayList = PlayListAdapter(PlayListListener {
            _viewModel.controlMediaPlayer(it.raw)
        })

        _viewModel.favorites.observe(viewLifecycleOwner, Observer {
            adapterPlayList.submitList(it)
        })
        binding.rcvFavorites.adapter = adapterPlayList

    }


}