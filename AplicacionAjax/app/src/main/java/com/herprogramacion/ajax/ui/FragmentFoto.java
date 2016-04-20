package com.herprogramacion.ajax.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herprogramacion.ajax.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFoto extends Fragment {


    public FragmentFoto() {
        // Requiere de un contructor vacio
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desarrollador_foto, container, false);
    }

}
