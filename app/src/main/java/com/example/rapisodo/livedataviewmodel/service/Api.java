package com.example.rapisodo.livedataviewmodel.service;

import android.graphics.Bitmap;
import android.media.Image;

import com.example.rapisodo.livedataviewmodel.model.Cards;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    @GET("cards")
    Call<Cards> getCards();
//
//    @GET
//    Call<Response<ResponseBody>> getCardImage(@Url String fileUrl);

    @GET
    Call<ResponseBody> getCardImage(@Url String fileUrl);



//    @GET("accounts-opening/v2/configurator/agencies/{codeOffer}")
//    Call<AgenciesResponse> fetchAgencies(@Path("codeOffer") String codeOffer, @Query("latitude") String lat, @Query("longitude")  String lng);

}
