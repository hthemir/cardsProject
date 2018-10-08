package com.example.rapisodo.livedataviewmodel.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

public class ForeignNames extends BaseObservable implements Parcelable {
    private String name;
    private String imageUrl;
    private String language;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ForeignNames(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        language = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeString(language);
    }

    public static final Parcelable.Creator<ForeignNames> CREATOR = new Parcelable.Creator<ForeignNames>() {
        public ForeignNames createFromParcel(Parcel in) {
            return new ForeignNames(in);
        }

        public ForeignNames[] newArray(int size) {
            return new ForeignNames[size];
        }
    };
}
