package com.example.pertemuan11;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {

    private String title, desc, released_date, review;
    private int poster;


    public Movies() {
    }

    public Movies(Parcel parcel) {
        title = parcel.readString();
        desc = parcel.readString();
        released_date = parcel.readString();
        review = parcel.readString();
        poster = parcel.readInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReleased_date() {
        return released_date;
    }

    public void setReleased_date(String released_date) {
        this.released_date = released_date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeString(released_date);
        parcel.writeString(review);
        parcel.writeInt(poster);
    }

    public static final Creator<Movies> CREATOR = new ClassLoaderCreator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new Movies(parcel);
        }

        @Override
        public Movies createFromParcel(Parcel parcel) {
            return new Movies(parcel);
        }

        @Override
        public Movies[] newArray(int i) {
            return new Movies[i];
        }
    };


}
