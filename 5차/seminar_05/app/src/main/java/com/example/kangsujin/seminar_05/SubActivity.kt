package com.example.kangsujin.seminar_05

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_sub.*
import org.jetbrains.anko.toast

class SubActivity : AppCompatActivity() {

    lateinit var a : String //cf. 이런식으로 초기화 나중에 시킨다고 할수도 있음

    //lazy 는 상수로만 만들 수 있음
    val bottomBarAnimation: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.example_animation)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        //애니메이션 속성 추가. 시작 / 끝 잡을수 있음
        bottomBarAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }
            override fun onAnimationEnd(p0: Animation?) {
                toast("애니메이션 끝!")
            }
            override fun onAnimationStart(p0: Animation?) {
                toast("애니메이션 시작!")
            }
        })

        btn_sub_act_show_bottom_bar.setOnClickListener {
            rl_sub_act_bottom_bar.visibility = View.VISIBLE
            rl_sub_act_bottom_bar.startAnimation(bottomBarAnimation)
        }
    }
}
