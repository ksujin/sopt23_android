package com.example.kangsujin.sopt23_assignment_03.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.kangsujin.sopt23_assignment_03.Fragment.MainFragment

class MyFragmentStatePagerAdapter(fm: FragmentManager, val fragmentCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MainFragment()
            1 -> {
                val mapFragment : Fragment = MainFragment()
                return mapFragment
            }
            2 -> return MainFragment()
            //항상 else 필요. default 같은 것
            else -> return null
        }
    }


    override fun getCount(): Int = fragmentCount
    //ctrl+i 누르면 무조건 오버라이드 해야하는 함수들이 뜨고, ctrl+o 누르면 오버라이드 할 수 있느 함수들이 뜸
}