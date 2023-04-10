package com.example.islamicsongs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicsongs.databinding.ItemViewPlaylistBinding
import com.example.islamicsongs.data.models.PlayList

class PlayListAdapter(private val clickListener: PlayListListener) :
    ListAdapter<PlayList, PlayListAdapter.PlayListViewHolder>(PlayListDiffUtil()) {


    class PlayListViewHolder private constructor(val binding: ItemViewPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: PlayList, clickListener: PlayListListener
        ) {

            binding.playList = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PlayListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewPlaylistBinding.inflate(layoutInflater, parent, false)

                return PlayListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}


class PlayListDiffUtil() : DiffUtil.ItemCallback<PlayList>() {
    override fun areItemsTheSame(oldItem: PlayList, newItem: PlayList): Boolean {
        return oldItem.nameOfSound == newItem.nameOfSound
    }

    override fun areContentsTheSame(oldItem: PlayList, newItem: PlayList): Boolean {
        return oldItem == newItem
    }

}


class PlayListListener(private val clickListener: (playList:PlayList) -> Unit) {

    fun onClick(playList:PlayList) = clickListener (playList)
}