package com.example.tata.horoskop.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivana Lukic on 16.9.15..
 */
public class Horoscope implements Parcelable {
    String sign;
    String daily;
    String weekly;
    String monthly;
    String love;
    String career;
    String wellness;
    String icon;
    String info;

    protected Horoscope(Parcel in) {
        sign = in.readString();
        daily = in.readString();
        weekly = in.readString();
        monthly = in.readString();
        love = in.readString();
        career = in.readString();
        wellness = in.readString();
        icon = in.readString();
        info = in.readString();
    }

    public static final Creator<Horoscope> CREATOR = new Creator<Horoscope>() {
        @Override
        public Horoscope createFromParcel(Parcel in) {
            return new Horoscope(in);
        }

        @Override
        public Horoscope[] newArray(int size) {
            return new Horoscope[size];
        }
    };

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getWeekly() {
        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

    public String getMonthly() {
        return monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getWellness() {
        return wellness;
    }

    public void setWellness(String wellness) {
        this.wellness = wellness;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Horoscope(String sign, String daily, String weekly, String monthly, String love, String career, String wellness, String icon, String info) {
        this.sign = sign;
        this.daily = daily;
        this.weekly = weekly;
        this.monthly = monthly;
        this.love = love;
        this.career = career;
        this.wellness = wellness;
        this.icon = icon;
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sign);
        dest.writeString(daily);
        dest.writeString(weekly);
        dest.writeString(monthly);
        dest.writeString(love);
        dest.writeString(career);
        dest.writeString(wellness);
        dest.writeString(icon);
        dest.writeString(info);
    }
}
