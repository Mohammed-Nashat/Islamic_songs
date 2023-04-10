package com.example.islamicsongs.utlis

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicsongs.adapters.PlayListAdapter
import com.example.islamicsongs.ui.main_screen.PlayListsAdapter
import com.example.islamicsongs.data.models.PLayLists
import com.example.islamicsongs.data.models.PlayList


// Bind Image for Play_Music_Fragment & Images for RecyclerView PlayLists
@BindingAdapter("sourceImage")
fun ImageView.setImage(pLayLists: PLayLists?){
    pLayLists?.let {
        setImageResource(it.imageOfSinger)
    }
}

@BindingAdapter("listOfData")
fun bindRecyclerViewPlayLists(recyclerView: RecyclerView, data: List<PLayLists>?) {
    val adapter = recyclerView.adapter as PlayListsAdapter
    adapter.submitList(data)
}

@BindingAdapter("listOfData")
fun bindRecyclerViewPlayList(recyclerView: RecyclerView, data: List<PlayList>) {
    val adapter = recyclerView.adapter as PlayListAdapter
    adapter.submitList(data)
}


@BindingAdapter("nameOfSinger")
fun TextView.setNameOfSinger(playList: PlayList){
        text= playList.nameOfSinger
    }

@BindingAdapter("nameOfSound")
fun TextView.setNameOfSound2(playList: PlayList){
    text= playList.nameOfSound
}

@BindingAdapter("duration")
fun TextView.setDuration2(playList: PlayList){
        text= playList.duration.toString()
    }



