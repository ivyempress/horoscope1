package com.example.tata.horoskop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tata.horoskop.R;
import com.example.tata.horoskop.model.Horoscope;


/**
 * Created by bataemperor on 12.9.15..
 */
public class SignFragment extends Fragment {
    int signSrc;
    String horo;
    TextView tvContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_sign, container, false);
        ImageView ivSign = (ImageView) view.findViewById(R.id.iv_sign);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        Bundle bundle = this.getArguments();
        horo = bundle.getString("horo");
        signSrc = bundle.getInt("src", 0);
        ivSign.setImageResource(signSrc);
        tvContent.setText(horo);
        return view;
    }
}
