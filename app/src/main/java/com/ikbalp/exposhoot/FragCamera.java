package com.ikbalp.exposhoot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


/*
     Minggu, 10 Mei 2020
     Ikbal Padilah
     10117143 - IF4
*/


/**
 * A simple {@link Fragment} subclass.
 */
public class FragCamera extends Fragment {

    public FragCamera() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }
}