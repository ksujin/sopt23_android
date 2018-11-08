package com.example.kangsujin.sopt23_assignment_03.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.kangsujin.sopt23_assignment_03.Data.InstagramData
import com.example.kangsujin.sopt23_assignment_03.R
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class InstagramRecyclerViewAdapter(val ctx : Context, var dataList : ArrayList<InstagramData>)
    : RecyclerView.Adapter<InstagramRecyclerViewAdapter.Holder>() {

    //뷰를 붙이는 작업
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_instagram, parent, false)
        return Holder(view)
    }

    //
    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //position 은 indexPath.row
        holder.counter.text = (position+1).toString()
        if(!dataList[position].isLike){
            holder.heartImg.visibility = View.GONE

        }
        holder.bgImg.isSelected = dataList[position].isLike

        holder.item_btn.setOnClickListener {
            //ctx.toast((position+1).toString())
            dataList[position].isLike = !dataList[position].isLike
            holder.bgImg.isSelected = dataList[position].isLike
            val idxForRow = position/3*3
            val idxForColumn = position%3
            var isYoonHappy = true
            var isYoonSad = true

            for (i in idxForColumn..dataList.size-1 step 3) {
                if (!dataList[i].isLike) {
                    isYoonHappy = false
                }
                if (dataList[i].isLike) {
                    isYoonSad = false
                }
            }

            if(dataList[idxForRow].isLike &&dataList[idxForRow+1].isLike &&dataList[idxForRow+2].isLike){
                ctx.toast("happy yoon binggo!")
            }
            else if(!dataList[idxForRow].isLike &&!dataList[idxForRow+1].isLike &&!dataList[idxForRow+2].isLike){
                ctx.toast("sad yoon binggo!")
            } else if (isYoonHappy){
                ctx.toast("happy yoon binggo!")
            }else if (isYoonSad){
                ctx.toast("sad yoon binggo!")
            }


        }
    }



    //ViewHolder는 findViewById를 통해 가져옴
    //inner 안쓰고 그냥 중첩클래스 만들면 static 으로 만들어지고 inner 붙이면 static 은 아님
    //왜 속에다 만들어 주냐면 KakaoTalkRoomRecyclerViewAdapter 안에서만 쓸 class 이기 때문
    //itemView 에서 item 들은 리사이클러 뷰 안에서 쓰이는 아이템들
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        //안썼는데 왜 보라색이냐면 안스내에서 이미 쓰인 변수들이라
        //싫으면 mTitle 이렇게 바꿔줘도됨. m 은 my 라는 뜻
        val counter : TextView = itemView.findViewById(R.id.tv_rv_item_instagram_cnt) as TextView
        val heartImg : ImageView = itemView.findViewById(R.id.iv_rv_item_heart_image) as ImageView
        val bgImg : ImageView = itemView.findViewById(R.id.iv_rv_item_instagram_image) as ImageView
        val item_btn : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_instagram) as RelativeLayout

    }
}