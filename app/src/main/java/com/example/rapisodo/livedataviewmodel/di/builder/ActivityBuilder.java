package com.example.rapisodo.livedataviewmodel.di.builder;

import com.example.rapisodo.livedataviewmodel.di.Activity;
import com.example.rapisodo.livedataviewmodel.view.CardsActivity;
import com.example.rapisodo.livedataviewmodel.view.CardsDetailActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @Activity
    @ContributesAndroidInjector
    abstract CardsActivity bindCardsActivity();

    @Activity
    @ContributesAndroidInjector
    abstract CardsDetailActivity bindCardsDetailActivity();
}
