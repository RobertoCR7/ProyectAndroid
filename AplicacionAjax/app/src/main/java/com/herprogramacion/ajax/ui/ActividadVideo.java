package com.herprogramacion.ajax.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.herprogramacion.ajax.R;

/**
 * Created by Rodrigo Cortes Armas on 24/03/2016.
 */
public class ActividadVideo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fila_lista_videos);
        registrarEventos();
    }

    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.miLista);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> aprent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://youtu.be/iG1QjiRQ3F4")));
                        break;
                    case 1 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=6ACF27H23n8")));
                        break;
                    case 2 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=-1RLW7a8Gr4&index=2&list=PL6gx4Cwl9DGDiJSXfsJTASx9eMq_HlenQ")));
                        break;
                    case 3 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=Sz2_B4ezDW8&list=PL6gx4Cwl9DGDiJSXfsJTASx9eMq_HlenQ&index=21")));
                        break;
                    case 4 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=xnWtGNiG2lg")));
                        break;
                    default:
                }

            }
        });

    }



}
