package com.example.islamicsongs.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class PLayLists(
    val imageOfSinger: Int, val listOfSinger: List<PlayList>
) : Parcelable


@Parcelize

data class PlayList(
    val nameOfSound: String,
    val nameOfSinger: String?,
    val raw: Int,
    val duration: Double,
) : Parcelable
