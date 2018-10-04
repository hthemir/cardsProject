package com.example.rapisodo.livedataviewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.rapisodo.livedataviewmodel.di.app.DaggerAppComponent;
import com.example.rapisodo.livedataviewmodel.service.APIClient;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class LiveDataViewModelInjector implements HasActivityInjector {
    private Application mApplication;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    private static LiveDataViewModelInjector mInstance;
    private APIClient mApiClient;
    private String mBaseUrl;

    public synchronized static LiveDataViewModelInjector getInstance() {
        return mInstance;
    }

    LiveDataViewModelInjector(Application application, String baseUrl) {
        mApplication = application;
        mBaseUrl = baseUrl;
        mInstance = this;

        initInjector();
        initAPIClient();
    }

    private void initAPIClient() {
        mApiClient = new APIClient(mApplication, mBaseUrl);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    private void initInjector() {
        DaggerAppComponent.builder()
                .application(mApplication)
                .build().inject(this);
    }

    public Context getContext() {
        return mApplication;
    }

    public APIClient getApiClient() {
        return mApiClient;
    }
}
