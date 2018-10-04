package com.example.rapisodo.livedataviewmodel.di.builder;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.rapisodo.livedataviewmodel.di.ViewModelKey;
import com.example.rapisodo.livedataviewmodel.viewmodel.CardsViewModel;
import com.example.rapisodo.livedataviewmodel.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(CardsViewModel.class)
    abstract ViewModel bindCardsViewModel(CardsViewModel cardsViewModel);

    // ViewModel Factory
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
