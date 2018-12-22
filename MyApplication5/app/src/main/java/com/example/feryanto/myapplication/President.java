package com.example.feryanto.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

class President implements Parcelable {
    private String name;
    private String remarks;
    private String photo;
    private String deskripsi;
    private String lahir;

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getWafat() {
        return wafat;
    }

    public void setWafat(String wafat) {
        this.wafat = wafat;
    }

    public static Creator<President> getCREATOR() {
        return CREATOR;
    }

    private String wafat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public President() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.deskripsi);
        dest.writeString(this.lahir);
        dest.writeString(this.wafat);
    }

    protected President(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.deskripsi = in.readString();
        this.lahir = in.readString();
        this.wafat = in.readString();
    }

    public static final Creator<President> CREATOR = new Creator<President>() {
        @Override
        public President createFromParcel(Parcel source) {
            return new President(source);
        }

        @Override
        public President[] newArray(int size) {
            return new President[size];
        }
    };
}
