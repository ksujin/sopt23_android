package com.example.kangsujin.seminar_06


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kangsujin.seminar_06.db.SharedPreferenceController
import com.example.kangsujin.seminar_06.network.ApplicationController
import com.example.kangsujin.seminar_06.network.NetworkService
import com.example.kangsujin.seminar_06.post.PostLogInResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //통신 필요한 부분에는 다 쓰기
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnBtnClickListener()
        //자동 로그인
        if (SharedPreferenceController.getAuthorization(this).isNotEmpty()) {
            startActivity<BoardActivity>()
        }
    }

    private fun setOnBtnClickListener() {

        btn_main_act_log_in.setOnClickListener {
            getLoginResponse()
        }
        btn_main_act_sign_up.setOnClickListener {
            startActivity<SignUpActivity>()
        }
    }

    private fun getLoginResponse() {
        if (et_main_act_email.text.toString().isNotEmpty() && et_main_act_pw.text.toString().isNotEmpty()) {
            val input_email = et_main_act_email.text.toString()
            val input_pw = et_main_act_pw.text.toString()
            val jsonObject: JSONObject = JSONObject()
            jsonObject.put("email", input_email)
            jsonObject.put("password", input_pw)
            val gsonObject: JsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
            val postLogInResponse = networkService.postLoginResponse("application/json", gsonObject)
            //비동기로 처리
            postLogInResponse.enqueue(object : Callback<PostLogInResponse> {
                override fun onFailure(call: Call<PostLogInResponse>, t: Throwable) {
                    Log.e("Login fail", t.toString())
                }

                override fun onResponse(call: Call<PostLogInResponse>, response: Response<PostLogInResponse>) {
                    if (response.isSuccessful) {
                        val token = response.body()!!.data.token
                        //저번 시간에 배웠던 SharedPreference에 토큰을 저장!
                        SharedPreferenceController.setAuthorization(this@MainActivity, token)
                        toast(SharedPreferenceController.getAuthorization(this@MainActivity))
                        startActivity<BoardActivity>()
                    }
                }
            })
        }
    }
}
