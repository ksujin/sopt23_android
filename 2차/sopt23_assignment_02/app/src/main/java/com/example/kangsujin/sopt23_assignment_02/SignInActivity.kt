package com.example.kangsujin.sopt23_assignment_02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager!!.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0)
    }

    fun setupUI(view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    hideSoftKeyboard(this@SignInActivity)
                    return false
                }
            })
        }

        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until (view as ViewGroup).childCount) {
                val innerView = (view as ViewGroup).getChildAt(i)
                setupUI(innerView)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        et_sign_in_act_id.setText(intent.getStringExtra("id"))
        et_sign_in_act_pw.setText(intent.getStringExtra("pw"))
        setupUI(findViewById(R.id.view_sign_in_act_parent))
        btn_sign_in_act_complete.setOnClickListener{
            (it as Button).text = "complete"
            val intent : Intent = Intent()
            intent.putExtra("editedId", et_sign_in_act_id.text.toString())
            intent.putExtra("editedPw", et_sign_in_act_pw.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


}
