package com.example.islamicsongs.utlis.di

import android.media.MediaPlayer
import com.example.islamicsongs.data.models.PLayLists
import com.example.islamicsongs.ui.main_screen.MainScreenViewModel
import com.example.islamicsongs.ui.playmusic.PLayMusicViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val myAppModules = module {

    viewModel{
     MainScreenViewModel(get(),get())
    }

    viewModel { (playList : PLayLists) -> PLayMusicViewModel(playList ) }

    single {
        MediaPlayer()
    }

}

