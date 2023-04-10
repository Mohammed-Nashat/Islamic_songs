package com.example.islamicsongs.ui.main_screen

import android.app.Application
import android.media.MediaPlayer
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.islamicsongs.data.localy.listOfPlayList
import com.example.islamicsongs.data.localy.listOfPlayLists
import com.example.islamicsongs.data.models.PLayLists
import com.example.islamicsongs.data.models.PlayList

class MainScreenViewModel(
    private val context: Application,
    private var mediaPlayer: MediaPlayer

) : AndroidViewModel(context) {

    private var _raw = 0

    private val _playLists = MutableLiveData<List<PLayLists>?>()
    val playLists: LiveData<List<PLayLists>?>
        get() = _playLists

    private val _seekBarVisibility = MutableLiveData<Boolean>()
    val seekBarVisibility: LiveData<Boolean>
        get() = _seekBarVisibility

    private val _seekBarMax = MutableLiveData<Int>()
    val seekBarMax: LiveData<Int>
        get() = _seekBarMax

    private val _seekBarProgress = MutableLiveData<Int>()
    val seekBarProgress: LiveData<Int>
        get() = _seekBarProgress

    private val _favorites = MutableLiveData<List<PlayList>?>()
    val favorites: LiveData<List<PlayList>?>
        get() = _favorites

    init {
        _playLists.value = listOfPlayLists()
        _favorites.value = listOfPlayList()

    }

     fun controlSeeBar(seekBar: SeekBar) {

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }



    fun controlMediaPlayer(raw: Int) {

        if (_raw == raw) {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                Log.e("Tag", "pause")

            } else {
                mediaPlayer.start()
                Log.e("Tag", "start")

            }

        } else {
            _raw = raw
            _seekBarVisibility.value = true
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()
                mediaPlayer = MediaPlayer.create(context, raw)
                mediaPlayer.start()
                Log.e("Tag", "stop")

                initializeSeekBar()
            } else {
                mediaPlayer = MediaPlayer.create(context, raw)
                mediaPlayer.start()
                initializeSeekBar()
                Log.e("Tag", "start")

            }
        }
    }


    private fun initializeSeekBar() {

        _seekBarMax.value = mediaPlayer.duration
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    _seekBarProgress.value = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    _seekBarProgress.value = 0
                }
            }
        }, 0)
    }



}