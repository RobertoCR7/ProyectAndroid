package com.herprogramacion.ajax.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.herprogramacion.ajax.R;
import com.herprogramacion.ajax.correo.EnviarCorreoActivity;

/**
 * Created by Rodrigo Cortes Armas on 02/03/2016.
 */
public class AyudaActivity extends Activity{
    private ImageView imvHelp;
    private TextView txvAyuda;
    private TextView txvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda_layout);
        initComponents();
    }
    private void initComponents(){

    }

    public void enviarCorreo(View view) {
        startActivity(new Intent(this, EnviarCorreoActivity.class));
    }
    protected void onPause(){
        super.onPause();
        finish(); //termina la actividad
    }
}
