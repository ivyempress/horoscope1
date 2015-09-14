package com.example.tata.horoskop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.tata.horoskop.fragment.SignFragment;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

public class ChineseActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    WheelView wheelView;
    ImageView ivImage;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(),R.drawable.leo));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        wheelView = (WheelView) findViewById(R.id.wheelview);
        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                //return drawable here - the position can be seen in the gifs above
                Drawable drawable = getResources().getDrawable(R.drawable.rat);
                switch (position) {

                    case 0:
                        drawable = getResources().getDrawable(R.drawable.rat);
                        break;
                    case 1:
                        drawable = getResources().getDrawable(R.drawable.ox);
                        break;
                    case 2:
                        drawable = getResources().getDrawable(R.drawable.tiger);
                        break;
                    case 3:
                        drawable = getResources().getDrawable(R.drawable.rabbit);
                        break;
                    case 4:
                        drawable = getResources().getDrawable(R.drawable.dragon);
                        break;
                    case 5:
                        drawable = getResources().getDrawable(R.drawable.snake);
                        break;
                    case 6:
                        drawable = getResources().getDrawable(R.drawable.horse);
                        break;
                    case 7:
                        drawable = getResources().getDrawable(R.drawable.goat);
                        break;
                    case 8:
                        drawable = getResources().getDrawable(R.drawable.monkey);
                        break;
                    case 9:
                        drawable = getResources().getDrawable(R.drawable.rooster);
                        break;
                    case 10:
                        drawable = getResources().getDrawable(R.drawable.dog);
                        break;
                    case 11:
                        drawable = getResources().getDrawable(R.drawable.pig);
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
                        wheelView.setPosition(0);
                        break;
                    case 1:
                        wheelView.setPosition(1);
                        break;
                    case 2:
                        wheelView.setPosition(2);
                        break;
                    case 3:
                        wheelView.setPosition(3);
                        break;
                    case 4:
                        wheelView.setPosition(4);
                        break;
                    case 5:
                        wheelView.setPosition(5);
                        break;
                    case 6:
                        wheelView.setPosition(6);
                        break;
                    case 7:
                        wheelView.setPosition(7);
                        break;
                    case 8:
                        wheelView.setPosition(8);
                        break;
                    case 9:
                        wheelView.setPosition(9);
                        break;
                    case 10:
                        wheelView.setPosition(10);
                        break;
                    case 11:
                        wheelView.setPosition(11);
                        break;
                }
            }
        });
        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView wheelView, Drawable drawable, int i) {
                switch (i) {
                    case 0:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(),R.drawable.rat));
                        break;
                    case 1:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.ox));
                        break;
                    case 2:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.tiger));
                        break;
                    case 3:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.rabbit));
                        break;
                    case 4:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.dragon));
                        break;
                    case 5:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.snake));
                        break;
                    case 6:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.horse));
                        break;
                    case 7:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.goat));
                        break;
                    case 8:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.monkey));
                        break;
                    case 9:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.rooster));
                        break;
                    case 10:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.dog));
                        break;
                    case 11:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.pig));
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ChineseActivity.this, ZodiacSignsActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chinese, menu);
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

    private class AdapterHoroscope extends FragmentStatePagerAdapter {
        int signSrc;

        public AdapterHoroscope(FragmentManager fm, int signSrc) {
            super(fm);
            this.signSrc = signSrc;
        }

        String[] titles = {"Daily", "Monthly", "Weekly"};

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            Bundle bundle;
            switch (i) {
                case 0:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    fragment.setArguments(bundle);
                    break;
                case 1:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    fragment.setArguments(bundle);
                    break;
                case 2:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    fragment.setArguments(bundle);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
}}
