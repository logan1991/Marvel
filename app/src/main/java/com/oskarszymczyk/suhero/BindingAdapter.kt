package com.oskarszymczyk.suhero

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.oskarszymczyk.suhero.ui.Refreshable


@BindingAdapter("app:recyclerviewList")
fun <T> RecyclerView.recyclerviewList(list: List<T>) {
    (adapter as? Refreshable)?.refreshData(list)
}

@BindingAdapter("app:insertImage")
fun ImageView.setImage(url: String) {
    GlideApp.with(context)
            .load(url)
            .centerCrop()
            .into(this)
}

@BindingAdapter("android:visibility")
fun View.setVisibility(isVisible: Boolean){
    this.visibility = if(isVisible) View.VISIBLE else View.GONE
}
