package com.example.kangsujin.seminar_04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kangsujin.seminar_04.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setOnClickListener()

        //userId가 있으면 바로 넘어가는 형태
        if (SharedPreferenceController.getUserId(this).isNotBlank()){
            startActivity<MemoActivity>()
        }
    }

    private fun setOnClickListener(){
        btn_login_act_sign_in.setOnClickListener {
            val input_id = et_login_act_id.text.toString()
            val input_pw = et_login_act_pw.text.toString()

            if (input_id.isNotEmpty() && input_pw.isNotEmpty()){
                SharedPreferenceController.setUserId(this,input_id)
                SharedPreferenceController.setUserPw(this, input_pw)
                startActivity<MemoActivity>()
                //loginAcvivity닫음
                finish()
            }
        }
    }
}
