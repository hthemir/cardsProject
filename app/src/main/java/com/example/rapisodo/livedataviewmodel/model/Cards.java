package com.example.rapisodo.livedataviewmodel.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;

public class Cards extends BaseObservable {

    private ArrayList<Card> cards;

    @Bindable
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
