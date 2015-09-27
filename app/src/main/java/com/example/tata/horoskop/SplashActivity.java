package com.example.tata.horoskop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tata.horoskop.model.Horoscope;
import com.example.tata.horoskop.model.Zodiac;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    MaterialDialog progressDialog;
    List<Horoscope> listHoroscope = new ArrayList<>();
    List<Zodiac> listZodiac = new ArrayList<>();
    private static final String URL_ZODIAC = "http://www.api.littleastro.com/restserver/index.php/api/zodiac/readings/format/json";
    private static final String URL_HOROSCOPE = "http://www.api.littleastro.com/restserver/index.php/api/horoscope/readings/format/json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        StringRequest stringRequestZodiac = new StringRequest(Request.Method.GET, URL_ZODIAC,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {  // **line 2**
                                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                                String sign = childJSONObject.getString("Sign");
                                String daily = childJSONObject.getString("Daily_Zodiac");
                                String icon = childJSONObject.getString("Icon");
                                String info = childJSONObject.getString("Info");
                                Zodiac zodiac = new Zodiac(sign, daily, icon, info);
                                listZodiac.add(zodiac);
                                App.get().setListZodiac(listZodiac);

                            }

                        } catch (JSONException e) {
                            Toast.makeText(SplashActivity.this, "Neuspesna konekcija", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Log.d("greska", error.networkResponse + "");
                Toast.makeText(SplashActivity.this, "Neuspesna konekcija", Toast.LENGTH_SHORT).show();

            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequestZodiac);
        progressDialog = new MaterialDialog.Builder(this).title("Horoscope")
                .content("Loading horoscope...").backgroundColor(Color.parseColor("#000000")).titleColor(Color.parseColor("#ffffff")).progress(true,0).show();
        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_HOROSCOPE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
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
                                Horoscope horoscope = new Horoscope(sign, daily, weekly, monthly, love, career, wellness, icon, info);
                                listHoroscope.add(horoscope);
                                App.get().setListHoroscope(listHoroscope);
                                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                                SplashActivity.this.startActivity(intent);
                                progressDialog.dismiss();
                                SplashActivity.this.finish();

                            }

                        } catch (JSONException e) {
                            Toast.makeText(SplashActivity.this, "Neuspesna konekcija", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Log.d("greska", error.networkResponse + "");
                Toast.makeText(SplashActivity.this, "Neuspesna konekcija", Toast.LENGTH_SHORT).show();

            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);

    }
}
