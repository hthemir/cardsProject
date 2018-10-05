package com.example.rapisodo.livedataviewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.media.Image;

import com.example.rapisodo.livedataviewmodel.model.Card;
import com.example.rapisodo.livedataviewmodel.repository.CardsRepository;
import com.example.rapisodo.livedataviewmodel.service.GenericResponse;

import javax.inject.Inject;

public class CardsDetailViewModel extends BaseViewModel<CardsDetailViewModel.Navigator> {
    private CardsRepository mCardsRepository;
    public Card mCard = new Card();
    public MediatorLiveData<GenericResponse<Bitmap>> mediatorLiveData = new MediatorLiveData<>();

    @Inject
    public CardsDetailViewModel(CardsRepository mCardsRepository) {
        this.mCardsRepository = mCardsRepository;
    }

    public void initScreen(Card card) {
        mCard = card;
        mediatorLiveData.addSource(getCardImage(card.getImageUrl()), input -> {
            if (input != null && input.getContent() != null) {
                mediatorLiveData.setValue(input);
            }
        });
    }

    public LiveData<GenericResponse<Bitmap>> getCardImage(String fileUrl) {
        return Transformations.map(mCardsRepository.getImage(fileUrl), input -> {
            if (input.getContent() == null) {
                GenericResponse<Bitmap> error = new GenericResponse<>();
                error.setMessage(input.getMessage());
                mediatorLiveData.setValue(error);
            }
            return input;
        });
    }

    public interface Navigator {
//        void navigateSomewhere();
    }

}
