package com.example.kangsujin.seminar_04.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.kangsujin.seminar_04.R
import com.example.kangsujin.seminar_04.data.MemoData

class MemoRecyclerViewAdapter(val ctx: Context, var dataList: ArrayList<MemoData> = ArrayList<MemoData>())
    : RecyclerView.Adapter<MemoRecyclerViewAdapter.Holder>() {

    //뷰를 붙이는 작업
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_memo, parent, false)
        return Holder(view)
    }

    //
    override fun getItemCount(): Int = dataList.size

    //이런식으로 안에 구현해도 됨
    fun addNewItem(memoData : MemoData){
        val position = dataList.size
        dataList.add(memoData)
        notifyItemInserted(position)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content
        holder.whole_box.setOnClickListener {
            //너무 빨리 누르면 터지니까 그거 방지하기 위해서 try catch
            try {
                dataList.removeAt(position)
                notifyItemRemoved(position)
                //제거되었다고 하고 전체 아이템들의 범위도 바뀌니까 두번 알려줘야함
                notifyItemRangeChanged(position, dataList.size)
            } catch (e: IndexOutOfBoundsException) {
                Log.e("Index error", e.toString())
            }
        }
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tv_rv_item_memo_title) as TextView
        val content: TextView = itemView.findViewById(R.id.tv_rv_item_memo_content) as TextView
        val whole_box: RelativeLayout = itemView.findViewById(R.id.btn_rv_item_memo_whole_box) as RelativeLayout

    }
}