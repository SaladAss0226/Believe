package com.example.golden72.backpack

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class ItemTouchHelperCallback(var mAdapter: ITHelperInterface?): ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN          //上下滑動
//        val dragFlags = ItemTouchHelper.ACTION_STATE_IDLE
        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT       //左右滑動
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: ViewHolder,
        target: ViewHolder
    ): Boolean {
        mAdapter!!.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
        mAdapter!!.onItemDissmiss(viewHolder.adapterPosition)
    }
}
