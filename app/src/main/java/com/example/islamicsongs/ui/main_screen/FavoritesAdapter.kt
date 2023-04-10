//package com.example.islamicsongs.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.islamicsongs.models.PLayLists
//import com.example.islamicsongs.databinding.ItemViewPlaylistsBinding
//
//class PlayListsAdapter(private val clickListener: PlayListsListener) :
//    ListAdapter<PLayLists, PlayListsAdapter.PlayListsViewHolder>(PlayListsDiffUtil()) {
//
//
//    class PlayListsViewHolder private constructor(val binding: ItemViewPlaylistsBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(
//            item: PLayLists, clickListener: PlayListsListener
//        ) {
//
//            binding.playlists = item
//            binding.clickListener = clickListener
//            binding.executePendingBindings()
//
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): PlayListsViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = ItemViewPlaylistsBinding.inflate(layoutInflater, parent, false)
//
//                return PlayListsViewHolder(binding)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
//        return PlayListsViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
//        holder.bind(getItem(position), clickListener)
//    }
//}
//
//
//class PlayListsDiffUtil() : DiffUtil.ItemCallback<PLayLists>() {
//    override fun areItemsTheSame(oldItem: PLayLists, newItem: PLayLists): Boolean {
//        return oldItem.imageOfSonger == oldItem.imageOfSonger
//    }
//
//    override fun areContentsTheSame(oldItem: PLayLists, newItem: PLayLists): Boolean {
//        return oldItem == oldItem
//    }
//
//}
//
//
//class PlayListsListener() {
//
//    fun onClick(){}
//}