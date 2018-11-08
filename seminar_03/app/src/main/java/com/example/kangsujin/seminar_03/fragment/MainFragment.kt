package com.example.kangsujin.seminar_03.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kangsujin.seminar_03.R
import com.example.kangsujin.seminar_03.adapter.KakaoTalkRoomRecyclerViewAdapter
import com.example.kangsujin.seminar_03.data.KakaoTalkRoomData
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(){
    //이거 안하면 초기화 선언과 동시에 해줘야함
    lateinit var kakaoTalkRoomRecyclerViewAdapter: KakaoTalkRoomRecyclerViewAdapter
    //생성주기


    //1. 이게 제일 먼저 실행
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }
    //2. 2번째 실행. 인텐트로 받을때 보통 여기서 받음
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //3.뷰를 붙이는 작업
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //뷰 붙여줌
        return inflater.inflate(R.layout.fragment_main, container, false) }

    //4.뷰 아이디로 접근해서 꾸며줌
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView() { //임시 데이터
        //생성과 동시에 초기화 시키고 싶을땐 arrayListOf("안녕", "하세요")
        var dataList: ArrayList<KakaoTalkRoomData> = ArrayList()
        dataList.add(KakaoTalkRoomData("[DoIT_SOPT] 안드로이드파트", "인터뷰 하자~~!!!", 53, "오후 6:53"))
        dataList.add(KakaoTalkRoomData("[DoIT_SOPT] iOS파트", "승수!!!", 36, "오후 4:43"))
        dataList.add(KakaoTalkRoomData("[DoIT_SOPT] 서버파트", "배다슬!!!", 55, "오후 3:03"))
        dataList.add(KakaoTalkRoomData("[DoIT_SOPT] 기획파트", "나성수!!!", 42, "오후 2:33"))
        dataList.add(KakaoTalkRoomData("[DoIT_SOPT] 디자인파트", "승미;;;", 39, "오후 1:13"))
        dataList.add(KakaoTalkRoomData("[DoIT_SOPT] 23대 운영진", "회의요!", 10, "오전 5:53"))
        dataList.add(KakaoTalkRoomData("23기 버디버디조", "코다차야?!", 10, "오전 6:53"))
        dataList.add(KakaoTalkRoomData("23기 상반기 엠티조", "디제잉 시작한다!!!", 10, "오전 7:53"))

        kakaoTalkRoomRecyclerViewAdapter = KakaoTalkRoomRecyclerViewAdapter(activity!!, dataList)
        rv_main_frag_kakao_talk_room_list.adapter = kakaoTalkRoomRecyclerViewAdapter
        rv_main_frag_kakao_talk_room_list.layoutManager = LinearLayoutManager(activity) //context 넣어도 됨
    }
}