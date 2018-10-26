package com.example.kangsujin.sopt23_assignment_02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_SIGN_IN_ACTIVITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_act_sign_in.setOnClickListener {
            startActivityForResult<SignInActivity>(REQUEST_CODE_SIGN_IN_ACTIVITY, "id" to tv_main_act_id.text)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SIGN_IN_ACTIVITY){
            //result ok 인지 체크
            if (resultCode == Activity.RESULT_OK){
                data?.getStringExtra("editedId").let {
                    et_main_act_id.setText(it)
                }
            }
        }
    }

}
