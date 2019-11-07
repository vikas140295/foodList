package com.demo.food;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name, url, keywords, email, date;
    private Integer imageId, rating;

    public Food(String name, String url, String keywords, String email, String date, int rating, int imageId) {
        this.name = name;
        this.url = url;
        this.keywords = keywords;
        this.email = email;
        this.date = date;
        this.rating = rating;
        this.imageId = imageId;
    }

    protected Food(Parcel in) {
        name = in.readString();
        url = in.readString();
        keywords = in.readString();
        email = in.readString();
        date = in.readString();
        rating = in.readInt();
        imageId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(keywords);
        dest.writeString(email);
        dest.writeString(date);
        dest.writeInt(rating);
        dest.writeInt(imageId);
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public static Creator<Food> getCREATOR() {
        return CREATOR;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setName (String name)
    {
        this.name = name;
    }
    public void setUrl (String url)
    {
        this.url = url;
    } public void setKeywords (String keywords)
    {
        this.keywords = keywords;
    } public void setEmail (String email)
    {
        this.email = email;
    }
    public void setRating (Integer rating)
    {
        this.rating = rating;
    }



}