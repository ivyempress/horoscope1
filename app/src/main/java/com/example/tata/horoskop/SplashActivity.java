package com.example.tata.horoskop;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.tata.horoskop.model.Horoscope;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    List<Horoscope> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        String url = "http://www.api.littleastro.com/restserver/index.php/api/horoscope/readings/format/json";
        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray= new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {  // **line 2**
                                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                                String sign = childJSONObject.getString("Sign");
                                String daily = childJSONObject.getString("Daily_Horoscope");
                                String weekly = childJSONObject.getString("Weekly_Horoscope");
                                String monthly = childJSONObject.getString("Monthly_Horoscope");
                                String love = childJSONObject.getString("Love");
                                String career = childJSONObject.getString("Career");
                                String wellness = childJSONObject.getString("Wellness");
                                String icon = childJSONObject.getString("Icon");
                                String info = childJSONObject.getString("Info");
                                Horoscope horoscope = new Horoscope(sign,daily,weekly,monthly,love,career,wellness,icon,info);
                                lista.add(horoscope);
                                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                                SplashActivity.this.startActivity(intent);
                                SplashActivity.this.finish();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(SplashActivity.this, "Neuspesna konekcija", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("greska", error.networkResponse + "");
                Toast.makeText(SplashActivity.this,"Neuspesna konekcija",Toast.LENGTH_SHORT).show();

            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        App.get().setLista(lista);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 7000);

    }
}
