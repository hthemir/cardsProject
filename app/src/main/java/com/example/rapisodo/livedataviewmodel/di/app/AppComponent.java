package com.example.rapisodo.livedataviewmodel.di.app;

import android.app.Application;

import com.example.rapisodo.livedataviewmodel.LiveDataViewModelInjector;
import com.example.rapisodo.livedataviewmodel.di.builder.ActivityBuilder;
import com.example.rapisodo.livedataviewmodel.di.builder.FragmentBuilder;
import com.example.rapisodo.livedataviewmodel.di.builder.ViewModelBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        FragmentBuilder.class,
        ViewModelBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(LiveDataViewModelInjector application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
