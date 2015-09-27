package com.example.tata.horoskop.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tata.horoskop.R;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

/**
 * Created by Ivana Lukic on 06-Sep-15.
 */
public class HoroscopeFragment extends Fragment {
    ImageView aries, taurus, gemini, cancer, leo, virgo, libra, scorpio, sagittaurus, capricorn, aquarius, pisces;
    WheelView wheelView;
    ImageView ivImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_horoscope, container, false);
        ivImage = (ImageView) view.findViewById(R.id.iv_image);

        wheelView = (WheelView) view.findViewById(R.id.wheelview);

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
                        Toast.makeText(getActivity(), "Stisnut prvi", Toast.LENGTH_SHORT).show();
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
        return view;
    }

}
