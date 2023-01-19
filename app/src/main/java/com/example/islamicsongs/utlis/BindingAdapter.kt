//package com.example.azcar.utlis
//
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.databinding.BindingAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.azcar.R
//import com.example.azcar.adapters.QuraanAdapter
//import com.example.azcar.model.Surah
//import com.example.azcar.screens.main.QuraanApiStatus
//
//
//@BindingAdapter("arabicNameS")
//fun TextView.arabicName(surah: Surah?){
//    surah?.let {
//        text= it.englishName
//    }
//}
//
//
//@BindingAdapter("englishbicNameS")
//fun TextView.englishbicName(surah: Surah?){
//    surah?.let {
//        text= it.name
//    }
//}
//
//@BindingAdapter("numberS")
//fun TextView.number(surah: Surah?){
//    surah?.let {
//        text= it.number.toString()
//    }
//}
//
//@BindingAdapter("revelationTypeS")
//fun TextView.revelationTypeS(surah: Surah?){
//    surah?.let {
//        text= it.revelationType
//    }
//}
//
//
//@BindingAdapter("listData")
//
//fun bindRecyclerView(recyclerView: RecyclerView, data: List<Surah>?) {
//    val adapter = recyclerView.adapter as QuraanAdapter
//    adapter.submitList(data)
//}
//
//
//
//@BindingAdapter("quraanApiStatus")
//fun bindStatus(statusImageView: ImageView, status: QuraanApiStatus?) {
//    when (status) {
//        QuraanApiStatus.LOADING -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.loading_animation)
//        }
//        QuraanApiStatus.ERROR -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.ic_connection_error)
//        }
//        QuraanApiStatus.DONE -> {
//            statusImageView.visibility = View.GONE
//        }
//        else -> {}
//    }
//}
//
//
