package com.example.tata.horoskop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    WheelView wheelView;
    ImageView ivImage;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment_horoscope);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        wheelView = (WheelView) findViewById(R.id.wheelview);
        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                //return drawable here - the position can be seen in the gifs above
                Drawable drawable = getResources().getDrawable(R.drawable.aries);
                switch (position) {

                    case 0:
                        drawable = getResources().getDrawable(R.drawable.aries);
                        break;
                    case 1:
                        drawable = getResources().getDrawable(R.drawable.taurus);
                        break;
                    case 2:
                        drawable = getResources().getDrawable(R.drawable.gemini);
                        break;
                    case 3:
                        drawable = getResources().getDrawable(R.drawable.cancer);
                        break;
                    case 4:
                        drawable = getResources().getDrawable(R.drawable.leo);
                        break;
                    case 5:
                        drawable = getResources().getDrawable(R.drawable.virgo);
                        break;
                    case 6:
                        drawable = getResources().getDrawable(R.drawable.libra);
                        break;
                    case 7:
                        drawable = getResources().getDrawable(R.drawable.scorpio);
                        break;
                    case 8:
                        drawable = getResources().getDrawable(R.drawable.sagittarius);
                        break;
                    case 9:
                        drawable = getResources().getDrawable(R.drawable.capricorn);
                        break;
                    case 10:
                        drawable = getResources().getDrawable(R.drawable.aquarius);
                        break;
                    case 11:
                        drawable = getResources().getDrawable(R.drawable.pisces);
                        break;
                }
                return drawable;
            }

            @Override
            public int getCount() {
                //return the count
                return 12;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }
        });
        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                //the position in the adapter and whether it is closest to the selection angle
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                }
            }
        });
        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView wheelView, Drawable drawable, int i) {
                switch (i) {
                    case 0:
                        ivImage.setImageResource(R.drawable.aries);
                        break;
                    case 1:
                        ivImage.setImageResource(R.drawable.taurus);
                        break;
                    case 2:
                        ivImage.setImageResource(R.drawable.gemini);
                        break;
                    case 3:
                        ivImage.setImageResource(R.drawable.cancer);
                        break;
                    case 4:
                        ivImage.setImageResource(R.drawable.leo);
                        break;
                    case 5:
                        ivImage.setImageResource(R.drawable.virgo);
                        break;
                    case 6:
                        ivImage.setImageResource(R.drawable.libra);
                        break;
                    case 7:
                        ivImage.setImageResource(R.drawable.scorpio);
                        break;
                    case 8:
                        ivImage.setImageResource(R.drawable.sagittarius);
                        break;
                    case 9:
                        ivImage.setImageResource(R.drawable.capricorn);
                        break;
                    case 10:
                        ivImage.setImageResource(R.drawable.aquarius);
                        break;
                    case 11:
                        ivImage.setImageResource(R.drawable.pisces);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this, ZodiacSignsActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.contact) {
            startActivity(new Intent(this,ContactUsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
