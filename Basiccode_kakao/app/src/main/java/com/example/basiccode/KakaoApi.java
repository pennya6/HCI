package com.example.basiccode;

import android.content.ContentValues;

import java.net.HttpURLConnection;

//4가지의 Http 요청방식(get/post/put/delete)
//3가지 유형 - HttpURLConnection/OkHttp/Retrofit
//요청메서드 'RequestMethod' -> Http 통신에서 사용하는 요청 메서드 7개(CRUD방식 4개 + 그외에 3개)

//Retrofit2<->restAPI : Retrofit2는 안드로이드 및 자바에서 쓸 수 있는 REST 클라이언트
public class KakaoApi {
    //image content 요청 : multitage/form-data
    //image_url content 요청 : application/x-www-form-urlencoded
    String API_URL="https://dapi.kakao.com/v2/vision/multitage/generate";
    String CONTENT_TYPE="multipart/form-data"; //image 형태
    String MYAPP_KEY="342ee2207ae205492513ec8442f89419";

}
