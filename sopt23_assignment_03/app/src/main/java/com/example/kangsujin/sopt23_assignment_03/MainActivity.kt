package com.example.kangsujin.sopt23_assignment_03

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.RelativeLayout
import com.example.kangsujin.sopt23_assignment_03.Adapter.MyFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureBottomNavigation()

    }

    private fun configureBottomNavigation() {
        //탭을 세개로 고정시켜버리겠다는 의미. 세개 페이지 이상으로 넘어가면 fm 에서 빼지고 다시 그 뷰로 돌아갈때 새로 리로드 안함
        //탭 5개면 5줘서 아무리 왔다갔다해도 탭 뷰 상태 유지. 탭 개수만큼 주면 됨
        vp_main_act_frag_pager.adapter = MyFragmentStatePagerAdapter(supportFragmentManager, 3) //vp_bottom_navi_act_frag_pager.offscreenPageLimit = 3
        // ViewPager와 Tablayout을 엮어줍니다!
        tl_main_act_bottom_menu.setupWithViewPager(vp_main_act_frag_pager)
        //TabLayout에 붙일 layout을 찾아준 다음
        //inflate 가 뷰 붙여줄때 많이 씀
        val bottomNaviLayout: View = this.layoutInflater.inflate(R.layout.bottom_navigation_tab, null, false)
        //탭 하나하나 TabLayout에 연결시켜줍니다.
        tl_main_act_bottom_menu.getTabAt(0)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_main_tab) as RelativeLayout
        tl_main_act_bottom_menu.getTabAt (1)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_map_tab) as RelativeLayout
        tl_main_act_bottom_menu.getTabAt (2)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_my_page_tab) as RelativeLayout
    }

}
