package com.example.kangsujin.sopt23_assignment_02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        et_sign_in_act_id.setText(intent.getStringExtra("id"))
        btn_sign_in_act_complete.setOnClickListener{
            (it as Button).text = "complete"
            val intent : Intent = Intent()
            intent.putExtra("editedId", et_sign_in_act_id.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


}
