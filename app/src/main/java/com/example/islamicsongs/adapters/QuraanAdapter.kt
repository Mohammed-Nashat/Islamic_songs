//package com.example.azcar.adapters
//
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.azcar.databinding.ItemViewBinding
//import com.example.azcar.model.Surah
//
//class QuraanAdapter(val clickListener: QuraanListener) :
//    ListAdapter<Surah, QuraanAdapter.QuraanViewHolder>(QraanDiffUtil()) {
//
//
//    class QuraanViewHolder private constructor(val binding: ItemViewBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(
//            item: Surah,
//            clickListener: QuraanListener
//        ) {
//
//            binding.surah = item
//            binding.clickListener = clickListener
//            binding.executePendingBindings()
//
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): QuraanViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
//
//                return QuraanViewHolder(binding)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuraanViewHolder {
//        return QuraanViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: QuraanViewHolder, position: Int) {
//        holder.bind(getItem(position), clickListener)
//    }
//}
//
//
//class QraanDiffUtil() : DiffUtil.ItemCallback<Surah>() {
//    override fun areItemsTheSame(oldItem: Surah, newItem: Surah): Boolean {
//        return oldItem.number == oldItem.number
//    }
//
//    override fun areContentsTheSame(oldItem: Surah, newItem: Surah): Boolean {
//        return oldItem == oldItem
//    }
//
//}
//
//
//class QuraanListener() {
//}