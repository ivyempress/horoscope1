package com.example.tata.horoskop;

import android.app.Application;
import android.util.Log;

import java.io.IOException;

import horoscopeapi.HoroscopeAPI;
import horoscopeapi.HoroscopeReading;
import horoscopeapi.HoroscopeSign;
import horoscopeapi.SQLExcpetion;


public class App extends Application {

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
