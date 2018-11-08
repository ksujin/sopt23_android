package com.example.kangsujin.seminar_03.data

//val 이나 var 붙이면 바로 인스턴스 상수로 쓸 수 있음. java로 따지면 getter, setter 설정해야하는거 줄여줌
data class KakaoTalkRoomData(var title : String,
                             var content : String,
                             var person_cnt : Int,
                             var time : String)