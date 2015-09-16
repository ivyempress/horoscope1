package com.example.tata.horoskop;

import android.app.Application;



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
