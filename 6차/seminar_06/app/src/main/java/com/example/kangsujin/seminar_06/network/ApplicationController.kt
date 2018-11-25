package com.example.kangsujin.seminar_06.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : Application() {
    private val baseURL = "http://bghgu.tk:8080/"
    lateinit var networkService: NetworkService
    //싱글톤 패턴 만들때 하나만 이 인스턴스 생성하겠다는 의미로 companion object 사용
    companion object {
        lateinit var instance: ApplicationController
    }
    //액티비티 생명주기랑 똑같이 onCreate() 에서 가장 먼저 실행 되는 곳
    override fun onCreate() {
        super.onCreate()
        //앱 키자마자 자기 자신을 instance 에 넣어줌. 그리고 싱글톤으로 사용
        instance = this
        buildNetWork()
    }

    //네트워크 빌드해주는 코드
    fun buildNetWork() {
        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkService = retrofit.create(NetworkService::class.java)
    }

}
