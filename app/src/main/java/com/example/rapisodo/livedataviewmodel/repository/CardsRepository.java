package com.example.rapisodo.livedataviewmodel.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.rapisodo.livedataviewmodel.model.Cards;
import com.example.rapisodo.livedataviewmodel.service.Api;
import com.example.rapisodo.livedataviewmodel.service.BaseCallback;
import com.example.rapisodo.livedataviewmodel.service.GenericResponse;

import javax.inject.Inject;

public class CardsRepository {
    @Inject
    public Api api;

    @Inject
    public CardsRepository() {
    }

    public LiveData<GenericResponse<Cards>> getCardsTwo() {
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
}
