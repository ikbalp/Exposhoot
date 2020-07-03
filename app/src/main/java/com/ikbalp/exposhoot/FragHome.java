package com.ikbalp.exposhoot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/*
     Jumat, 3 Juli 2020
     Ikbal Padilah
     10117143 - IF4
*/

/**
 * A simple {@link Fragment} subclass.
 */
public class FragHome extends Fragment {

    public FragHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
