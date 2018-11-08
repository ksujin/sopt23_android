package com.example.kangsujin.seminar_03.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.kangsujin.seminar_03.fragment.MainFragment
import com.example.kangsujin.seminar_03.fragment.MapFragment
import com.example.kangsujin.seminar_03.fragment.MypageFragment

//ctr+space 누르면 파일 명대로 바로 띄워짐
//opt+cmd+l 하면 예쁘게 정렬
//우리가 액션 슬라이드를 줬을때 프래그먼트가 어떤 프래그먼트가 붙을지 리턴해주는것.
//어댑터라는게 중간 매체
//매개변수 자리에 val 붙여주면 바로 instance 변수로 사용 가능
//매개 변수에 뭐넣어야하는지 모르겠다 싶으면 cmd+p
class MyFragmentStatePagerAdapter(fm: FragmentManager, val fragmentCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MainFragment()
            1 -> {
                val mapFragment : Fragment = MapFragment()
                return mapFragment
            }
            2 -> return MypageFragment()
            //항상 else 필요. default 같은 것
            else -> return null
        }
    }


    override fun getCount(): Int = fragmentCount
   //ctrl+i 누르면 무조건 오버라이드 해야하는 함수들이 뜨고, ctrl+o 누르면 오버라이드 할 수 있느 함수들이 뜸
}