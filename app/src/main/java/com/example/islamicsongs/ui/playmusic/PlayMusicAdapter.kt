package com.example.islamicsongs.ui.playmusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicsongs.data.models.PlayList
import com.example.islamicsongs.databinding.ItemViewBinding

class PlayMusicAdapter(private val clickListener: PlayMusicListener) :
    ListAdapter<PlayList, PlayMusicAdapter.PlayMusicViewHolder>(PlayMusicDiffUtil()) {


    class PlayMusicViewHolder private constructor(val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: PlayList, clickListener: PlayMusicListener
        ) {

            binding.playList = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }
        companion object {
            fun from(parent: ViewGroup): PlayMusicViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(layoutInflater, parent, false)

                return PlayMusicViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayMusicViewHolder {
        return PlayMusicViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PlayMusicViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}


class PlayMusicDiffUtil: DiffUtil.ItemCallback<PlayList>() {
    override fun areItemsTheSame(oldItem: PlayList, newItem: PlayList): Boolean {
        return oldItem.nameOfSound == oldItem.nameOfSound
    }

    override fun areContentsTheSame(oldItem: PlayList, newItem: PlayList): Boolean {
        return oldItem == oldItem
    }

}


class PlayMusicListener(private val clickListener: () -> Unit ) {

    fun onClick() = clickListener()
}