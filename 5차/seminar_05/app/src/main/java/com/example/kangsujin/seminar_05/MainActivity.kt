package com.example.kangsujin.seminar_05

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val motocycleAnimation : LottieAnimationView = findViewById(R.id.lottie_main_act_motocycle)

        //클릭시 한번 더 재생되는 코드
        lottie_main_act_motocycle.setOnClickListener {
            //motocycleAnimation.playAnimation()
            lottie_main_act_motocycle.playAnimation()
        }

        //시작될때 끝날때 시점 캐치 리스너
        lottie_main_act_motocycle.addAnimatorListener(object : Animator.AnimatorListener{

            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
               startActivity<SubActivity>()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }
        })
    }



}
