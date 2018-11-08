package com.example.kangsujin.seminar_03.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.kangsujin.seminar_03.MainActivity
import com.example.kangsujin.seminar_03.R
import com.example.kangsujin.seminar_03.data.KakaoTalkRoomData
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

//adapter 의 역할이 뷰랑 데이터랑 연결시켜주는것
//ArrList 는 중간에 어떤 값 변경할때 소요되는 cost 좀 큼
class KakaoTalkRoomRecyclerViewAdapter(val ctx : Context, var dataList : ArrayList<KakaoTalkRoomData>)
    : RecyclerView.Adapter<KakaoTalkRoomRecyclerViewAdapter.Holder>() {

    //뷰를 붙이는 작업
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_kakao_talk_room, parent, false)
        return Holder(view)
    }

    //
    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
      //position 은 indexPath.row
        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content
        holder.person_cnt.text = dataList[position].person_cnt.toString()
        holder.time.text = dataList[position].time

        holder.item_btn.setOnClickListener {
            ctx.toast("메인 엑티비티로~")
            ctx.startActivity<MainActivity>()
        }
    }



    //ViewHolder는 findViewById를 통해 가져옴
    //inner 안쓰고 그냥 중첩클래스 만들면 static 으로 만들어지고 inner 붙이면 static 은 아님
    //왜 속에다 만들어 주냐면 KakaoTalkRoomRecyclerViewAdapter 안에서만 쓸 class 이기 때문
    //itemView 에서 item 들은 리사이클러 뷰 안에서 쓰이는 아이템들
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        //안썼는데 왜 보라색이냐면 안스내에서 이미 쓰인 변수들이라
        //싫으면 mTitle 이렇게 바꿔줘도됨. m 은 my 라는 뜻
        val title : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_content) as TextView
        val person_cnt : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_person_cnt) as TextView
        val time : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_time) as TextView

        val item_btn : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_kakao_talk_room) as RelativeLayout

    }
}