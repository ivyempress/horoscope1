package com.example.tata.horoskop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.tata.horoskop.fragment.SignFragment;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    WheelView wheelView;
    ImageView ivImage;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.leo));
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
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.aries));
                        break;
                    case 1:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.taurus));
                        break;
                    case 2:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.gemini));
                        break;
                    case 3:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.cancer));
                        break;
                    case 4:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.leo));
                        break;
                    case 5:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.virgo));
                        break;
                    case 6:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.libra));
                        break;
                    case 7:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.scorpio));
                        break;
                    case 8:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.sagittarius));
                        break;
                    case 9:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.capricorn));
                        break;
                    case 10:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.aquarius));
                        break;
                    case 11:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.pisces));
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
        Calendar calendar = Calendar.getInstance();
        //noinspection SimplifiableIfStatement
        if (id == R.id.contact) {
            startActivity(new Intent(this, ContactUsActivity.class));
            return true;
        }
        if (id == R.id.calculate) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    calculcateSign(monthOfYear + 1, dayOfMonth);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
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
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }

    public void calculcateSign(int month, int day) {
        if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19)){
            Toast.makeText(this, "Your sign is capricorn", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(9);
        } else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17)) {
            Toast.makeText(this, "Your sign is aquarius", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(10);
        } else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19)){
            Toast.makeText(this, "Your sign is pisces", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(11);
        } else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19)){
            Toast.makeText(this, "Your sign is aries", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(0);
        } else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20)){
            Toast.makeText(this, "Your sign is taurus", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(1);
        } else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20)){
            Toast.makeText(this, "Your sign is gemini", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(2);
        } else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22)){
            Toast.makeText(this, "Your sign is cancer", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(3);
        }        else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22)){
            Toast.makeText(this, "Your sign is leo", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(4);
        }        else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22)){
            Toast.makeText(this, "Your sign is virgo", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(5);
        }        else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)){
            Toast.makeText(this, "Your sign is libra", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(6);
        }        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21)){
            Toast.makeText(this, "Your sign is scorpio", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(7);
        }else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)){
            Toast.makeText(this, "Your sign is sagittarius", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(8);
        } else
            System.out.println("Illegal date");
    }
}
