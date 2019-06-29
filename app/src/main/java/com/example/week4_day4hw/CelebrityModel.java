package com.example.week4_day4hw;

import android.os.Parcel;
import android.os.Parcelable;

public class CelebrityModel implements Parcelable {

    private String name;
    private String age;
    private String profession;
    private int picture;

    public CelebrityModel(String name, String age, String profession, int picture) {
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.picture = picture;
    }

    protected CelebrityModel(Parcel in) {
        name = in.readString();
        age = in.readString();
        profession = in.readString();
        picture = in.readInt();
    }


    public static final Creator<CelebrityModel> CREATOR = new Creator<CelebrityModel>() {
        @Override
        public CelebrityModel createFromParcel(Parcel in) {
            return new CelebrityModel(in);
        }

        @Override
        public CelebrityModel[] newArray(int size) {
            return new CelebrityModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(profession);
        parcel.writeInt(picture);
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public int getPicture(){
        return picture;
    }
}
