package com.example.tata.horoskop;

import android.app.Application;

import com.example.tata.horoskop.model.Horoscope;

import java.util.ArrayList;
import java.util.List;


public class App extends Application {
    public List<Horoscope> getLista() {
        return lista;
    }

    public void setLista(List<Horoscope> lista) {
        this.lista = lista;
    }

    public List<Horoscope> lista = new ArrayList<>();

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
