package com.example.kangsujin.seminar_06.network

import com.example.kangsujin.seminar_06.get.GetBoardResponse
import com.example.kangsujin.seminar_06.post.PostLogInResponse
import com.example.kangsujin.seminar_06.post.PostSignUpResponse
import com.example.kangsujin.seminar_06.post.PostWriteBoardResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    //회원가입
    //Delete면 @Delete라고 달아주면 됨
    //이거는 폼데이터 형식 - 그래서 바디에 한개 제이슨 오브젝트만 넣으면 되는데 파람방식이면 하나씩 키값 넣어서 보내줘야함
    @POST("/users")
    fun postSignUpResponse(
            @Header("Content-Type") content_type : String,
            @Body() body : JsonObject
    ) : Call<PostSignUpResponse>

    //로그인
    //폼형식
    @POST("/login")
    fun postLoginResponse(
            @Header("Content-Type") content_type : String,
            @Body() body : JsonObject
    ) : Call<PostLogInResponse>

    //파라미터 형식
    @Multipart
    @POST("/contents")
    //멀티파트의 @Part 에서 RequestBody 로 안하고 String 으로 보내면 "" 이 붙어 가기 때문에 RequestBody로 함. Int 는 상관 없음
    fun postWriteBoardResponse(
            @Header("Authorization") token : String,
            @Part("title") title : RequestBody,
            @Part("contents") contents : RequestBody,
            @Part photo: MultipartBody.Part?
    ) : Call<PostWriteBoardResponse>

    //offset and limit 이용해서 페이징 하는 것
    @GET("/contents")
    fun getBoardListResponse(
            @Header("Content-Type") content_type : String, @Query("offset") offset : Int,
            @Query("limit") limit : Int
    ) : Call<GetBoardResponse>
}