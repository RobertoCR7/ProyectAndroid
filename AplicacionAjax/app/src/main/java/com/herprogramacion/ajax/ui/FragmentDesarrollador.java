package com.herprogramacion.ajax.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.herprogramacion.ajax.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDesarrollador extends Fragment {

     public FragmentDesarrollador() {
        // Requiere de un contructor vacio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_desarrollador, container, false);
        return view;
    }

}
