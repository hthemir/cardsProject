package com.example.rapisodo.livedataviewmodel.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.rapisodo.livedataviewmodel.model.Cards;
import com.example.rapisodo.livedataviewmodel.service.Api;
import com.example.rapisodo.livedataviewmodel.service.BaseCallback;
import com.example.rapisodo.livedataviewmodel.service.GenericResponse;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class CardsRepository {
    @Inject
    public Api api;

    @Inject
    public CardsRepository() {
    }

    public LiveData<GenericResponse<Cards>> getCards() {
        final MutableLiveData<GenericResponse<Cards>> data = new MutableLiveData<>();

        api.getCards().enqueue(new BaseCallback<Cards>() {
            @Override
            public void onSuccess(Cards response) {
                GenericResponse<Cards> ret = new GenericResponse<>();
                ret.setContent(response);
                data.setValue(ret);
            }

            @Override
            public void onError(GenericResponse error) {
                data.setValue(error);
            }
        });
        return data;
    }
//
//    public LiveData<GenericResponse<Bitmap>> getImage(String fileUrl) {
//        final MutableLiveData<GenericResponse<Bitmap>> data = new MutableLiveData<>();
//
//        api.getCardImage(fileUrl).enqueue(new BaseCallback<Response<ResponseBody>>() {
//            @Override
//            public void onSuccess(Response<ResponseBody> response) {
//                GenericResponse<Bitmap> ret = new GenericResponse<>();
//                ret.setContent(BitmapFactory.decodeStream(response.body().byteStream()));
//                data.setValue(ret);
//            }
//
//            @Override
//            public void onError(GenericResponse error) {
//                data.setValue(error);
//            }
//        });
//        return data;
//    }


    public LiveData<GenericResponse<Bitmap>> getImage(String fileUrl) {
        final MutableLiveData<GenericResponse<Bitmap>> data = new MutableLiveData<>();

        api.getCardImage(fileUrl).enqueue(new BaseCallback<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody response) {
                GenericResponse<Bitmap> ret = new GenericResponse<>();
                ret.setContent(BitmapFactory.decodeStream(response.byteStream()));
                data.setValue(ret);
            }

            @Override
            public void onError(GenericResponse error) {
                data.setValue(error);
            }
        });
        return data;
    }
}
