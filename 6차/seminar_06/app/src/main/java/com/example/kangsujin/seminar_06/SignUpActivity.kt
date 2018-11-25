package com.example.kangsujin.seminar_06

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kangsujin.seminar_06.network.ApplicationController
import com.example.kangsujin.seminar_06.network.NetworkService
import com.example.kangsujin.seminar_06.post.PostSignUpResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
        }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setOnBtnClickListener()
    }
    private fun setOnBtnClickListener() {
        btn_sign_up_act_complete.setOnClickListener {
        getSignUpResponseData()
    }
        btn_sign_up_act_close.setOnClickListener {
            finish()
        }
    }

    private fun getSignUpResponseData(){
        val inputName = et_sign_up_act_name.text.toString()
        val inputPw = et_sign_up_act_pw.text.toString()
        val inputPart = et_sign_up_act_part.text.toString()
        val inputEmail = et_sign_up_act_email.text.toString()

        var jsonObject = JSONObject()
        jsonObject.put("name", inputName)
        jsonObject.put("email", inputEmail)
        jsonObject.put("password", inputPw)
        jsonObject.put("part", inputPart)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        //Call 은 여러가지 call 이 있는데 retrofit2에 대한 call이어야함
        val postSignUpResponse: Call<PostSignUpResponse> =
                networkService.postSignUpResponse("application/json", gsonObject)
        postSignUpResponse.enqueue(object : Callback<PostSignUpResponse> {

            //태그로 sign up fail 입력후 에러가 담기는 매개변수로 t이용해서  toString 통해서 우리가 볼수 있게 로그로 찍어주는 것
            override fun onFailure(call: Call<PostSignUpResponse>, t: Throwable) {
                Log.e("sign up fail", t.toString())
            }

            override fun onResponse(call: Call<PostSignUpResponse>, response: Response<PostSignUpResponse>) {
                //성공시 수행
                if(response.isSuccessful){
                    toast(response.body()!!.message)
                    Log.e("sign up success", response.toString())
                    finish()
                }
            }

        })

    }

}
