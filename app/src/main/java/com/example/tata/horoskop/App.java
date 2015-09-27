package com.example.tata.horoskop;

import android.app.Application;

import com.example.tata.horoskop.model.Horoscope;
import com.example.tata.horoskop.model.Zodiac;

import java.util.ArrayList;
import java.util.List;


public class App extends Application {

    public List<Horoscope> listHoroscope = new ArrayList<>();
    public List<Zodiac> listZodiac = new ArrayList<>();

    public List<Zodiac> getListZodiac() {
        return listZodiac;
    }

    public void setListZodiac(List<Zodiac> listZodiac) {
        this.listZodiac = listZodiac;
    }

    public List<Horoscope> getListHoroscope() {
        return listHoroscope;
    }

    public void setListHoroscope(List<Horoscope> listHoroscope) {
        this.listHoroscope = listHoroscope;
    }

    private static App app = null;

    public static App get() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

    }

}
