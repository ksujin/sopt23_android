package com.example.kangsujin.sopt23_assignment_03.Fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kangsujin.sopt23_assignment_03.Adapter.InstagramRecyclerViewAdapter
import com.example.kangsujin.sopt23_assignment_03.Data.InstagramData
import com.example.kangsujin.sopt23_assignment_03.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(){
    //이거 안하면 초기화 선언과 동시에 해줘야함
    lateinit var instagramRecyclerViewAdapter: InstagramRecyclerViewAdapter
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
        var dataList: ArrayList<InstagramData> = ArrayList()
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))
        dataList.add(InstagramData( 1, true))




        instagramRecyclerViewAdapter = InstagramRecyclerViewAdapter(activity!!, dataList)
        rv_main_frag_insagram_list.adapter = instagramRecyclerViewAdapter
        rv_main_frag_insagram_list.layoutManager = GridLayoutManager(activity, 3) //context 넣어도 됨
    }
}