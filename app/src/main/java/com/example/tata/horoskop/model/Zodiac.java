package com.example.tata.horoskop.model;

/**
 * Created by Ivana Lukic on 27/09/2015.
 */
public class Zodiac {
    String sign;
    String daily;
    String icon;
    String info;

    public Zodiac(String sign, String daily, String icon, String info) {
        this.sign = sign;
        this.daily = daily;
        this.icon = icon;
        this.info = info;
    }

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
}
