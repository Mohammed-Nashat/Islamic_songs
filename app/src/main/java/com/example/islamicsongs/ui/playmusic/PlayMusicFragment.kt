package com.example.islamicsongs.ui.playmusic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.islamicsongs.R
import com.example.islamicsongs.databinding.FragmentPlayMusicBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class PlayMusicFragment : Fragment() {

    private lateinit var binding: FragmentPlayMusicBinding

    val _viewModel: PLayMusicViewModel by viewModel {
        parametersOf(PlayMusicFragmentArgs.fromBundle(requireArguments()).playList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_play_music, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {

        val adapterPlayLists = PlayMusicAdapter(PlayMusicListener {
        })

        _viewModel.playList.observe(viewLifecycleOwner, Observer {
            adapterPlayLists.submitList(it)
        })

        binding.rcvPlayListOfSinger.adapter = adapterPlayLists


    }

}