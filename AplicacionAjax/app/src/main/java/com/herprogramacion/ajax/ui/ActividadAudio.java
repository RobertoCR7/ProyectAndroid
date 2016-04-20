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
 * Created by Rodrigo Cortes Armas on 05/04/2016.
 */
public class ActividadAudio extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fila_lista_audios);
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
                                Uri.parse("https://soundcloud.com/rodrigo-cortes-blue-sens/introduccion-ajax1")));
                        break;
                    case 1 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://soundcloud.com/rodrigo-cortes-blue-sens/primeros-pasos-en-ajax1")));
                        break;
                    case 2 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://soundcloud.com/rodrigo-cortes-blue-sens/tecnicas-basicas-con-ajax1")));
                        break;
                    case 3 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://soundcloud.com/rodrigo-cortes-blue-sens/tecnicas-avanzadas-en-ajax1")));
                        break;
                    case 4 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://soundcloud.com/rodrigo-cortes-blue-sens/javascript-basico1")));
                        break;
                    default:
                }

            }
        });

    }
}
