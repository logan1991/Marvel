package com.oskarszymczyk.suhero.ui.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class InfiniteScrollListener(val lastItemVisible: () -> Unit) : RecyclerView.OnScrollListener() {

    var lastCompleteVisibleItem: Int? = null
    var recyclerviewLayoutManager: LinearLayoutManager? = null

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        recyclerviewLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        lastCompleteVisibleItem = recyclerviewLayoutManager?.findLastCompletelyVisibleItemPosition()?.plus(1)
        if (lastCompleteVisibleItem == recyclerView.adapter?.itemCount) {
            lastItemVisible()
        }
    }
}