package com.example.rapisodo.livedataviewmodel.service;

import com.example.rapisodo.livedataviewmodel.model.Cards;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("cards")
    Call<Cards> getCards();

//    @GET("accounts-opening/v2/configurator/agencies/{codeOffer}")
//    Call<AgenciesResponse> fetchAgencies(@Path("codeOffer") String codeOffer, @Query("latitude") String lat, @Query("longitude")  String lng);

}
