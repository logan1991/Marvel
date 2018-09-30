package com.oskarszymczyk.suhero

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.oskarszymczyk.suhero.ui.Refreshable


@BindingAdapter("app:recyclerviewList")
fun <T> RecyclerView.recyclerviewList(list: List<T>) {
    if (this.adapter != null && this.adapter is Refreshable) {
        (adapter as Refreshable).refreshData(list)
    }
}

@BindingAdapter("app:insertImage")
fun ImageView.setImage(url: String) {
    GlideApp.with(context)
            .load(url)
            .centerCrop()
            .into(this)
}