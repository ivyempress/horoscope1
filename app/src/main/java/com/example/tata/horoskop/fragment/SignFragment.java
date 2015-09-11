package com.example.tata.horoskop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tata.horoskop.R;

/**
 * Created by bataemperor on 12.9.15..
 */
public class SignFragment extends Fragment {
    int signSrc;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_sign, container, false);
        ImageView ivSign = (ImageView) view.findViewById(R.id.iv_sign);
        Bundle bundle = this.getArguments();
        signSrc = bundle.getInt("src", 0);
        ivSign.setImageResource(signSrc);
        return view;
    }
}
