package com.example.islamicsongs.ui.playmusic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.islamicsongs.data.models.PLayLists
import com.example.islamicsongs.data.models.PlayList

class PLayMusicViewModel ( playLists: PLayLists): ViewModel() {


    private val _playLists = MutableLiveData<PLayLists>()
    val playLists:LiveData<PLayLists>
        get() = _playLists

    private val _playList = MutableLiveData<List<PlayList>?>()
    val playList:LiveData<List<PlayList>?>
    get() = _playList



    init {
        _playList.value = playLists.listOfSinger
        _playLists.value = playLists

    }



}