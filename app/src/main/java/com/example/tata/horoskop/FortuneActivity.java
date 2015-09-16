package com.example.tata.horoskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.json.JSONException;
import org.json.JSONObject;


public class FortuneActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView, tv2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);
        imageView = (ImageView) findViewById(R.id.iv_imagefortune1);
        textView = (TextView) findViewById(R.id.tv_scrooltext);
        tv2 = (TextView) findViewById(R.id.tv_headtext1);
        button = (Button) findViewById(R.id.buttonShare);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fortune, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void fortuneClick(View view) {
        imageView.setImageResource(R.drawable.fortune2);

        tv2.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);
        String url = "http://www.yerkee.com//api/fortune/cookie";

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            String fortune = jsonObject.getString("fortune");
                            textView.setVisibility(View.VISIBLE);
                            YoYo.with(Techniques.Tada)
                                    .duration(700)
                                    .playOn(textView);
                            textView.setText(fortune);

                        } catch (JSONException e) {
                            Toast.makeText(FortuneActivity.this,"Neuspesna konekcija",Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FortuneActivity.this,"Neuspesna konekcija",Toast.LENGTH_SHORT).show();

            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void shareClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "I find my fortune on Horoscope APP http://www.google.com/");
        startActivity(Intent.createChooser(intent, "Share with"));
    }
}
