package com.example.rapisodo.livedataviewmodel.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.rapisodo.livedataviewmodel.R;
import com.example.rapisodo.livedataviewmodel.databinding.ActivityCardsBinding;
import com.example.rapisodo.livedataviewmodel.model.Card;
import com.example.rapisodo.livedataviewmodel.viewmodel.CardsViewModel;

public class CardsActivity extends BaseActivity<ActivityCardsBinding, CardsViewModel> implements CardsViewModel.Navigator, CardAdapter.SelectedCard {
    private ActivityCardsBinding bind;
    private CardAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cards;
    }

    @Override
    protected Class<CardsViewModel> getViewModelClass() {
        return CardsViewModel.class;
    }

    @Override
    protected void initView() {
        bind = getBinding();
        bind.setViewModel(getViewModel());
        getViewModel().setNavigator(this);
        getSupportActionBar().setTitle(R.string.search_header_title);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getViewModel().showLoading();
        getViewModel().initScreen();
        getViewModel().mediatorLiveData.observe(this, response -> {
            getViewModel().hideLoading();
            if (response == null || response.getContent() == null) {
                Toast toast = Toast.makeText(getApplicationContext(), "erro", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                mAdapter = new CardAdapter(bind.getViewModel().mCardsList, this::setSelectedCard);
                bind.rvCards.setLayoutManager(new LinearLayoutManager(this));
                bind.rvCards.setAdapter(mAdapter);
            }
        });
    }

    @Override
    public void setSelectedCard(Card card) {
        Intent intent = new Intent(getApplicationContext(), CardsDetailActivity.class);
        intent.putExtra("card", card);
        startActivity(intent);
    }
}
