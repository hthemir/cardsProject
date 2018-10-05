package com.example.rapisodo.livedataviewmodel.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.rapisodo.livedataviewmodel.R;
import com.example.rapisodo.livedataviewmodel.databinding.ActivityCardsDetailBinding;
import com.example.rapisodo.livedataviewmodel.model.Card;
import com.example.rapisodo.livedataviewmodel.viewmodel.CardsDetailViewModel;

import java.nio.ByteBuffer;

public class CardsDetailActivity extends BaseActivity<ActivityCardsDetailBinding, CardsDetailViewModel> implements CardsDetailViewModel.Navigator {
    private ActivityCardsDetailBinding bind;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cards_detail;
    }

    @Override
    protected Class<CardsDetailViewModel> getViewModelClass() {
        return CardsDetailViewModel.class;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void initView() {
        bind = getBinding();
        bind.setViewModel(getViewModel());
        getViewModel().setNavigator(this);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Card card = getIntent().getParcelableExtra("card");

            getSupportActionBar().setTitle(card.getName()); //todo

            getViewModel().showLoading();
            getViewModel().initScreen(card);
            getViewModel().mediatorLiveData.observe(this, response -> {
                getViewModel().hideLoading();
                if (response == null || response.getContent() == null) {
                    bind.ivCard.setImageResource(R.drawable.default_card);
                } else {
                    bind.ivCard.setImageBitmap(response.getContent());
//                    bind.tvName.setText(card.getName());
//                    bind.tvText.setText(card.getText());
//                    bind.tvType.setText(card.getType());
                }
            });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private Bitmap convertImageToBitmap(Image image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bytes = new byte[buffer.capacity()];
        buffer.get(bytes);
        Bitmap bitmapImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, null);
        return bitmapImage;
    }
}
