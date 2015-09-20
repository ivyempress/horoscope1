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
import android.widget.TextView;
import android.widget.Toast;


import com.example.tata.horoskop.fragment.SignFragment;
import com.example.tata.horoskop.model.Horoscope;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import java.util.Calendar;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    WheelView wheelView;
    ImageView ivImage;
    Toolbar toolbar;
    List<Horoscope> lista = App.get().getLista();
    int signSrc;
    TextView tvSign,tvDate;
    TextView tvContent;
    ImageView ivSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.aries, lista.get(0)));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        tvContent = (TextView) findViewById(R.id.tv_content);
        ivSign = (ImageView) findViewById(R.id.iv_sign);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        tvSign = (TextView) findViewById(R.id.tv_sign);
        tvDate = (TextView) findViewById(R.id.tv_date);
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
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.aries, lista.get(0)));
                        ivSign.setImageResource(R.drawable.aries);
                        tvSign.setText("ARIES");
                        tvDate.setText("21. MAR - 19. APR");
                        break;
                    case 1:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.taurus, lista.get(1)));
                        ivSign.setImageResource(R.drawable.taurus);
                        tvSign.setText("TAURUS");
                        tvDate.setText("20. APR - 20. MAY");
                        break;
                    case 2:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.gemini, lista.get(2)));
                        ivSign.setImageResource(R.drawable.gemini);
                        tvSign.setText("GEMINI");
                        tvDate.setText("22. JUN - 22. JUL");
                        break;
                    case 3:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.cancer, lista.get(3)));
                        ivSign.setImageResource(R.drawable.cancer);
                        tvSign.setText("CANCER");
                        tvDate.setText("23. JUL - 22. AUG");
                        break;
                    case 4:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.leo, lista.get(4)));
                        ivSign.setImageResource(R.drawable.leo);
                        tvSign.setText("LEO");
                        tvDate.setText("23. AUG - 22. SEP");
                        break;
                    case 5:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.virgo, lista.get(5)));
                        ivSign.setImageResource(R.drawable.virgo);
                        tvSign.setText("VIRGO");
                        tvDate.setText("23. AUG - 22. SEP");

                        break;
                    case 6:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.libra, lista.get(6)));
                        ivSign.setImageResource(R.drawable.libra);
                        tvSign.setText("LIBRA");
                        tvDate.setText("23. SEP - 22. OCT");
                        break;
                    case 7:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.scorpio, lista.get(7)));
                        ivSign.setImageResource(R.drawable.scorpio);
                        tvSign.setText("SCORPIO");
                        tvDate.setText("23. OCT - 21. NOV");
                        break;
                    case 8:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.sagittarius, lista.get(8)));
                        ivSign.setImageResource(R.drawable.sagittarius);
                        tvSign.setText("SAGITTARIUS");
                        tvDate.setText("22. NOV - 21. DEC");
                        break;
                    case 9:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.capricorn, lista.get(9)));
                        ivSign.setImageResource(R.drawable.capricorn);
                        tvSign.setText("CAPRICORN");
                        tvDate.setText("22. DEC - 19. JAN");
                        break;
                    case 10:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.aquarius, lista.get(10)));
                        ivSign.setImageResource(R.drawable.aquarius);
                        tvSign.setText("AQUARIS");
                        tvDate.setText("20. JAN - 18. FEB");
                        break;
                    case 11:
                        viewPager.setAdapter(new AdapterHoroscope(getSupportFragmentManager(), R.drawable.pisces, lista.get(11)));
                        ivSign.setImageResource(R.drawable.pisces);
                        tvSign.setText("PISCES");
                        tvDate.setText("19. FEB - 20. MAR");
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
        private static final int DAILY = 0;
        private static final int MONTHLY = 1;
        private static final int WEEKLY = 2;
        private static final int LOVE = 3;
        private static final int CAREER = 4;
        private static final int WELLNESS = 5;
        int signSrc;
        Horoscope horoscope;

        public AdapterHoroscope(FragmentManager fm, int signSrc, Horoscope horoscope) {
            super(fm);
            this.signSrc = signSrc;
            this.horoscope = horoscope;
        }

        String[] titles = {"Daily", "Monthly", "Weekly", "Love", "Career", "Wellness"};

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            Bundle bundle;
            switch (i) {
                case DAILY:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    bundle.putString("horo", horoscope.getDaily());
                    fragment.setArguments(bundle);
                    break;
                case MONTHLY:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    bundle.putString("horo", horoscope.getMonthly());
                    fragment.setArguments(bundle);
                    break;
                case WEEKLY:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    bundle.putString("horo", horoscope.getWeekly());
                    fragment.setArguments(bundle);
                    break;
                case LOVE:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    bundle.putString("horo", horoscope.getLove());
                    fragment.setArguments(bundle);
                    break;
                case CAREER:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    bundle.putString("horo", horoscope.getCareer());
                    fragment.setArguments(bundle);
                    break;
                case WELLNESS:
                    fragment = new SignFragment();
                    bundle = new Bundle();
                    bundle.putInt("src", signSrc);
                    bundle.putString("horo", horoscope.getWellness());
                    fragment.setArguments(bundle);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }

    public void calculcateSign(int month, int day) {
        if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19)) {
            Toast.makeText(this, "Your sign is capricorn", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(9);
        } else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17)) {
            Toast.makeText(this, "Your sign is aquarius", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(10);
        } else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19)) {
            Toast.makeText(this, "Your sign is pisces", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(11);
        } else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19)) {
            Toast.makeText(this, "Your sign is aries", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(0);
        } else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20)) {
            Toast.makeText(this, "Your sign is taurus", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(1);
        } else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
            Toast.makeText(this, "Your sign is gemini", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(2);
        } else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22)) {
            Toast.makeText(this, "Your sign is cancer", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(3);
        } else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22)) {
            Toast.makeText(this, "Your sign is leo", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(4);
        } else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22)) {
            Toast.makeText(this, "Your sign is virgo", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(5);
        } else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)) {
            Toast.makeText(this, "Your sign is libra", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(6);
        } else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21)) {
            Toast.makeText(this, "Your sign is scorpio", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(7);
        } else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
            Toast.makeText(this, "Your sign is sagittarius", Toast.LENGTH_SHORT).show();
            wheelView.setPosition(8);
        } else
            System.out.println("Illegal date");
    }
}
