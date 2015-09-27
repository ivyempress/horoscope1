package com.example.tata.horoskop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import java.util.Calendar;

public class ChineseActivity extends AppCompatActivity {

    WheelView wheelView;
    ImageView ivImage, ivSign;
    TextView tvSign, tvDate, tvContent;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        ivSign = (ImageView) findViewById(R.id.iv_sign);
        tvSign = (TextView) findViewById(R.id.tv_sign);
        tvDate = (TextView) findViewById(R.id.tv_date);
        wheelView = (WheelView) findViewById(R.id.wheelview);
        tvContent = (TextView) findViewById(R.id.tv_content);

        // shows initial values for rat
        ivImage.setImageResource(R.drawable.rat);
        ivSign.setImageResource(R.drawable.rat);
        tvSign.setText(App.get().getListZodiac().get(0).getSign());
        tvDate.setText(App.get().getListZodiac().get(0).getInfo());
        tvContent.setText(App.get().getListZodiac().get(0).getDaily());

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
                        ivImage.setImageResource(R.drawable.rat);
                        ivSign.setImageResource(R.drawable.rat);
                        tvSign.setText(App.get().getListZodiac().get(0).getSign());
                        tvDate.setText(App.get().getListZodiac().get(0).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(0).getDaily());
                        break;
                    case 1:
                        ivImage.setImageResource(R.drawable.ox);
                        ivSign.setImageResource(R.drawable.ox);
                        tvSign.setText(App.get().getListZodiac().get(1).getSign());
                        tvDate.setText(App.get().getListZodiac().get(1).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(1).getDaily());
                        break;
                    case 2:
                        ivImage.setImageResource(R.drawable.tiger);
                        ivSign.setImageResource(R.drawable.tiger);
                        tvSign.setText(App.get().getListZodiac().get(2).getSign());
                        tvDate.setText(App.get().getListZodiac().get(2).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(2).getDaily());
                        break;
                    case 3:
                        ivImage.setImageResource(R.drawable.rabbit);
                        ivSign.setImageResource(R.drawable.rabbit);
                        tvSign.setText(App.get().getListZodiac().get(3).getSign());
                        tvDate.setText(App.get().getListZodiac().get(3).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(3).getDaily());
                        break;
                    case 4:
                        ivImage.setImageResource(R.drawable.dragon);
                        ivSign.setImageResource(R.drawable.dragon);
                        tvSign.setText(App.get().getListZodiac().get(4).getSign());
                        tvDate.setText(App.get().getListZodiac().get(4).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(4).getDaily());
                        break;
                    case 5:
                        ivImage.setImageResource(R.drawable.snake);
                        ivSign.setImageResource(R.drawable.snake);
                        tvSign.setText(App.get().getListZodiac().get(5).getSign());
                        tvDate.setText(App.get().getListZodiac().get(5).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(5).getDaily());
                        break;
                    case 6:
                        ivImage.setImageResource(R.drawable.horse);
                        ivSign.setImageResource(R.drawable.horse);
                        tvSign.setText(App.get().getListZodiac().get(6).getSign());
                        tvDate.setText(App.get().getListZodiac().get(6).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(6).getDaily());
                        break;
                    case 7:
                        ivImage.setImageResource(R.drawable.goat);
                        ivSign.setImageResource(R.drawable.goat);
                        tvSign.setText("Goat");
                        tvDate.setText(App.get().getListZodiac().get(7).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(7).getDaily());
                        break;
                    case 8:
                        ivImage.setImageResource(R.drawable.monkey);
                        ivSign.setImageResource(R.drawable.monkey);
                        tvSign.setText(App.get().getListZodiac().get(8).getSign());
                        tvDate.setText(App.get().getListZodiac().get(8).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(8).getDaily());
                        break;
                    case 9:
                        ivImage.setImageResource(R.drawable.rooster);
                        ivSign.setImageResource(R.drawable.rooster);
                        tvSign.setText(App.get().getListZodiac().get(9).getSign());
                        tvDate.setText(App.get().getListZodiac().get(9).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(9).getDaily());
                        break;
                    case 10:
                        ivImage.setImageResource(R.drawable.dog);
                        ivSign.setImageResource(R.drawable.dog);
                        tvSign.setText(App.get().getListZodiac().get(10).getSign());
                        tvDate.setText(App.get().getListZodiac().get(10).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(10).getDaily());
                        break;
                    case 11:
                        ivImage.setImageResource(R.drawable.pig);
                        ivSign.setImageResource(R.drawable.pig);
                        tvSign.setText(App.get().getListZodiac().get(11).getSign());
                        tvDate.setText(App.get().getListZodiac().get(11).getInfo());
                        tvContent.setText(App.get().getListZodiac().get(11).getDaily());
                        break;
                }
            }
        });
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
        if (id == android.R.id.home){
            super.onBackPressed();
            return true;
        }
        //noinspection SimplifiableIfStatement
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
                    calculcateSign(year);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
            return true;
        }
        if (id == R.id.notification) {
            startActivity(new Intent(this, SettingsNotificationActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculcateSign(int year) {
        if (year == 1972 || year == 1984 || year == 1996 || year == 2008) {
            wheelView.setPosition(0);
            Toast.makeText(this, "Your sign is rat", Toast.LENGTH_SHORT).show();
        } else if (year == 1973 || year == 1985 || year == 1997 || year == 2009) {
            wheelView.setPosition(1);
            Toast.makeText(this, "Your sign is ox", Toast.LENGTH_SHORT).show();
        } else if (year == 1974 || year == 1986 || year == 1998 || year == 2010) {
            wheelView.setPosition(2);
            Toast.makeText(this, "Your sign is tiger", Toast.LENGTH_SHORT).show();
        } else if (year == 1975 || year == 1987 || year == 1999 || year == 2011) {
            wheelView.setPosition(3);
            Toast.makeText(this, "Your sign is rabbit", Toast.LENGTH_SHORT).show();
        } else if (year == 1976 || year == 1988 || year == 2000 || year == 2012) {
            wheelView.setPosition(4);
            Toast.makeText(this, "Your sign is dragon", Toast.LENGTH_SHORT).show();
        } else if (year == 1977 || year == 1989 || year == 2001 || year == 2013) {
            wheelView.setPosition(5);
            Toast.makeText(this, "Your sign is snake", Toast.LENGTH_SHORT).show();
        } else if (year == 1978 || year == 1990 || year == 2002 || year == 2014) {
            wheelView.setPosition(6);
            Toast.makeText(this, "Your sign is horse", Toast.LENGTH_SHORT).show();
        } else if (year == 1979 || year == 1991 || year == 2003 || year == 2015) {
            wheelView.setPosition(7);
            Toast.makeText(this, "Your sign is goat", Toast.LENGTH_SHORT).show();
        } else if (year == 1980 || year == 1992 || year == 2004 || year == 2016) {
            wheelView.setPosition(8);
            Toast.makeText(this, "Your sign is monkey", Toast.LENGTH_SHORT).show();
        } else if (year == 1981 || year == 1993 || year == 2005 || year == 2017) {
            wheelView.setPosition(9);
            Toast.makeText(this, "Your sign is rooster", Toast.LENGTH_SHORT).show();
        } else if (year == 1982 || year == 1994 || year == 2006 || year == 2018) {
            wheelView.setPosition(10);
            Toast.makeText(this, "Your sign is dog", Toast.LENGTH_SHORT).show();
        } else if (year == 1983 || year == 1995 || year == 2007 || year == 2019) {
            wheelView.setPosition(1);
            Toast.makeText(this, "Your sign is pig", Toast.LENGTH_SHORT).show();
        }
    }
}


