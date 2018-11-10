package com.example.kangsujin.seminar_04.db

import android.content.Context
import android.content.SharedPreferences

//companion object 는 일부분만 빼서 싱글턴으로 하고싶을때
//object 는 안에있는 전체. 자바로 치면 static
object SharedPreferenceController {
    private val user_name : String = "user_name"
    private val user_id : String = "user_id"
    private val user_pw : String = "user_pw"

    //context 매개변수에는 보통 호출하는 액티비티를 this 로 넣어주면 됨
    //우리가 보는 화면에 대한 가장 뿌리에 있는..어떤것..?
    fun setUserId(ctx : Context, input_id : String){
        //SharedPreferences를 다른 앱에서도 참조할수 있게 열어둘수 있는데 modePrivate 하면 해당 앱에서만 열어볼 수 있도록 함
        val preference : SharedPreferences = ctx.getSharedPreferences(user_name, Context.MODE_PRIVATE)

        //SharedPreferences 를 조작해서 뭔가를 하겠다할 때 쓰는 것
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString(user_id, input_id)
        editor.commit()
    }

    fun getUserId(ctx: Context) : String {
        val preferences : SharedPreferences = ctx.getSharedPreferences(user_name, Context.MODE_PRIVATE)
        return preferences.getString(user_id, "")
    }
    fun setUserPw(ctx : Context, input_pw : String){
        //SharedPreferences를 다른 앱에서도 참조할수 있게 열어둘수 있는데 modePrivate 하면 해당 앱에서만 열어볼 수 있도록 함
        val preference : SharedPreferences = ctx.getSharedPreferences(user_name, Context.MODE_PRIVATE)
        //SharedPreferences 를 조작해서 뭔가를 하겠다할 때 쓰는 것
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString(user_pw, input_pw)
        editor.commit()
    }

    fun getUserPw(ctx: Context) : String {
        val preferences : SharedPreferences = ctx.getSharedPreferences(user_name, Context.MODE_PRIVATE)
        return preferences.getString(user_pw, "")
    }

    fun clearUserSharedPreferences(ctx : Context){
        val preferences : SharedPreferences = ctx.getSharedPreferences(user_name, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.commit()
    }
}