package com.example.rapisodo.livedataviewmodel.service;

import com.example.rapisodo.livedataviewmodel.LiveDataViewModelBuilder;
import com.example.rapisodo.livedataviewmodel.di.app.AppComponent;
import com.example.rapisodo.livedataviewmodel.di.app.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AppController extends DaggerApplication {

    private String BASE_URL = "https://api.magicthegathering.io/v1/";

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new LiveDataViewModelBuilder()
                .setApplication(this)
                .setBaseUrl(BASE_URL)
                .build();
    }
}
