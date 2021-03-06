package com.example.rapisodo.livedataviewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.rapisodo.livedataviewmodel.model.Card;
import com.example.rapisodo.livedataviewmodel.model.Cards;
import com.example.rapisodo.livedataviewmodel.repository.CardsRepository;
import com.example.rapisodo.livedataviewmodel.service.GenericResponse;

import javax.inject.Inject;

public class CardsViewModel extends BaseViewModel<CardsViewModel.Navigator> {
    private CardsRepository mCardsRepository;
    public MediatorLiveData<GenericResponse<Cards>> mediatorLiveData = new MediatorLiveData<>();
    public ObservableArrayList<Card> mCardsList = new ObservableArrayList<>();
    public Card mCard = new Card();

    @Inject
    public CardsViewModel(CardsRepository mCardsRepository) {
        this.mCardsRepository = mCardsRepository;
    }

    public void initScreen() {
        mediatorLiveData.addSource(getCardsDefault(), input -> {
            if (input != null && input.getContent() != null) {

                for (Card c : input.getContent().getCards()) {
                    mCardsList.add(c);
                }
                mediatorLiveData.setValue(input);
            }
        });
    }

    public LiveData<GenericResponse<Cards>> getCardsDefault() {
        return Transformations.map(mCardsRepository.getCards(mCard.getName(), mCard.getText()), input -> {
            if (input.getContent() == null) {
                GenericResponse<Cards> error = new GenericResponse<>();
                error.setMessage(input.getMessage());
                mediatorLiveData.setValue(error);
            }
            return input;
        });
    }

    public void onClickSearchCard() {
        showLoading();
        mCardsList.clear();
        mediatorLiveData.addSource(getCardsDefault(), input -> {
            if (input != null && input.getContent() != null) {
                for (Card c : input.getContent().getCards()) {
                    mCardsList.add(c);
                }
                mediatorLiveData.setValue(input);
            }
        });
    }

    public interface Navigator {
//        void navigateSomewhere();
    }
}
