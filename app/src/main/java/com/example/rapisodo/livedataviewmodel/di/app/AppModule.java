package com.example.rapisodo.livedataviewmodel.di.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.rapisodo.livedataviewmodel.LiveDataViewModelInjector;
import com.example.rapisodo.livedataviewmodel.service.APIClient;
import com.example.rapisodo.livedataviewmodel.service.Api;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application app) {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    LiveDataViewModelInjector provideAccountOpeningInjector() {
        return LiveDataViewModelInjector.getInstance();
    }

    @Provides
    @Singleton
    APIClient provideApiClient(LiveDataViewModelInjector injector) {
        return injector.getApiClient();
    }


    @Provides
    @Singleton
    Api provideApiService(APIClient apiClient) {
        return apiClient.getRetrofit().create(Api.class);
    }
}
