package com.example.rapisodo.livedataviewmodel.util;

import android.databinding.BindingAdapter;

import br.com.zup.multistatelayout.MultiStateLayout;

public class DataBindingUtil {
    @BindingAdapter("msl_state")
    public static void setState(MultiStateLayout multiStateLayout, MultiStateLayout.State state) {
        multiStateLayout.setState(state);
    }
}
