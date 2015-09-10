package com.example.tata.horoskop.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tata.horoskop.R;
import com.example.tata.horoskop.ZodiacSignsActivity;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

/**
 * Created by Ivana Lukic on 06-Sep-15.
 */
public class HoroscopeFragment extends Fragment implements View.OnClickListener {
    ImageView aries, taurus, gemini, cancer, leo, virgo, libra, scorpio, sagittaurus, capricorn, aquarius, pisces;
    WheelView wheelView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_horoscope,container,false);
//
//        aries = (ImageView) view.findViewById(R.id.iv_aries);
//        aries.setOnClickListener(this);
//
//        taurus = (ImageView) view.findViewById(R.id.iv_taurus);
//        taurus.setOnClickListener(this);
//
//        gemini = (ImageView) view.findViewById(R.id.iv_gemini);
//        gemini.setOnClickListener(this);
//
//        cancer = (ImageView) view.findViewById(R.id.iv_cancer);
//        cancer.setOnClickListener(this);
//
//        leo = (ImageView) view.findViewById(R.id.iv_leo);
//        leo.setOnClickListener(this);
//
//        virgo = (ImageView) view.findViewById(R.id.iv_virgo);
//        virgo.setOnClickListener(this);
//
//        libra = (ImageView) view.findViewById(R.id.iv_libra);
//        libra.setOnClickListener(this);
//
//        scorpio = (ImageView) view.findViewById(R.id.iv_scorpio);
//        scorpio.setOnClickListener(this);
//
//        sagittaurus = (ImageView) view.findViewById(R.id.iv_sagittarius);
//        sagittaurus.setOnClickListener(this);
//
//        capricorn = (ImageView) view.findViewById(R.id.iv_capricorn);
//        capricorn.setOnClickListener(this);
//
//        aquarius = (ImageView) view.findViewById(R.id.iv_aquaris);
//        aquarius.setOnClickListener(this);
//
//        pisces = (ImageView) view.findViewById(R.id.iv_pisces);
//        pisces.setOnClickListener(this);
        wheelView = (WheelView) view.findViewById(R.id.wheelview);

        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                //return drawable here - the position can be seen in the gifs above
                Drawable drawable = getResources().getDrawable(R.drawable.aries);
                switch (position){

                    case 0: drawable =  getResources().getDrawable(R.drawable.aries);break;
                    case 1: drawable =  getResources().getDrawable(R.drawable.taurus);break;
                    case 2: drawable =  getResources().getDrawable(R.drawable.gemini);break;
                    case 3: drawable =  getResources().getDrawable(R.drawable.cancer);break;
                    case 4: drawable =  getResources().getDrawable(R.drawable.leo);break;
                    case 5: drawable =  getResources().getDrawable(R.drawable.virgo);break;
                    case 6: drawable =  getResources().getDrawable(R.drawable.libra);break;
                    case 7: drawable =  getResources().getDrawable(R.drawable.scorpio);break;
                    case 8: drawable =  getResources().getDrawable(R.drawable.sagittarius);break;
                    case 9: drawable =  getResources().getDrawable(R.drawable.capricorn);break;
                    case 10: drawable =  getResources().getDrawable(R.drawable.aquarius);break;
                    case 11: drawable =  getResources().getDrawable(R.drawable.pisces);break;
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
                switch (position){

                    case 0:Toast.makeText(getActivity(),"Stisnut prvi",Toast.LENGTH_SHORT).show(); break;
                    case 1: break;
                    case 2: break;
                    case 3: break;
                    case 4: break;
                    case 5: break;
                    case 6: break;
                    case 7: break;
                    case 8: break;
                    case 9: break;
                    case 10: break;
                    case 11: break;

                }
            }
        });

        return view;
    }






    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),ZodiacSignsActivity.class);
        startActivity(intent);
    }
}
