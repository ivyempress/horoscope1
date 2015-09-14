package com.example.tata.horoskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tata.horoskop.utility.DisplayManager;
import com.example.tata.horoskop.view.FixedPageTransformer;
import com.example.tata.horoskop.view.InfoViewPager;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private static final float PAGE_WIDTH = 0.8f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final InfoViewPager pager = (InfoViewPager) findViewById(R.id.viewPager);
        pager.setOverriderDrawingOrder(true);
        DisplayManager dm = new DisplayManager();
        int screenWidth = dm.screenWidth;
        int screenHeight = dm.screenHeight;
        final float padding = (screenWidth * (1 - PAGE_WIDTH)) * 0.5f;
        pager.setPadding((int) padding, pager.getPaddingTop(), (int) padding, pager.getPaddingBottom());

        ViewGroup.LayoutParams params = pager.getLayoutParams();
        params.height = (int) (screenHeight * 0.6f);
        pager.setLayoutParams(params);

        PagerAdapter adapter = new PagerAdapter(dummyList());
        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new FixedPageTransformer(pager) {
            private static final float MIN_SCALE = 0.80f;
            private static final float MIN_ALPHA = 0.5f;

            @Override
            public void fixedTransformPage(View view, float position) {
                float scaleFactor = 1 - ((1 - MIN_SCALE) * Math.abs(position));

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                if (position < 0) {
                    view.setTranslationX(view.getWidth() * (1 - scaleFactor));
                } else {
                    view.setTranslationX(-(view.getWidth() * (1 - scaleFactor)));
                }

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
            }
        });
    }

    private List<Item> dummyList() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Item());
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void openChineseHoroscope(View view) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void openZodiacHoroscope(View view) {
        Intent intent = new Intent(MainActivity.this, ChineseActivity.class);
        startActivity(intent);
    }

    public void openFortuneCookie(View view) {
        Intent intent = new Intent(MainActivity.this, FortuneActivity.class);
        startActivity(intent);
    }


    class PagerAdapter extends android.support.v4.view.PagerAdapter {
        List<Item> items;

        public PagerAdapter(List<Item> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            CardView view = (CardView) LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_slider_item, container, false);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            int width;
            params.width = width = (int) (new DisplayManager().screenWidth * PAGE_WIDTH);
            view.setLayoutParams(params);
            ImageView ivImage = (ImageView) view.findViewById(R.id.ivHoroscope);
            TextView tvText = (TextView) view.findViewById(R.id.tv_text);
            params = ivImage.getLayoutParams();
            //noinspection SuspiciousNameCombination
            params.height = (int) (width * (3f / 4f));
            ivImage.setLayoutParams(params);
            switch (position) {
                case 0:
                    ivImage.setImageResource(R.drawable.h1);
                    tvText.setText("Horoscope");
                    break;
                case 1:
                    ivImage.setImageResource(R.drawable.h2);
                    tvText.setText("Chinese Horoscope");
                    break;
                case 2:
                    ivImage.setImageResource(R.drawable.h3);
                    tvText.setText("Fortune Cookie");
                    break;
            }
            container.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, ChineseActivity.class));
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this, FortuneActivity.class));
                            break;

                    }
                }
            });
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    public static class Item {

    }
}
