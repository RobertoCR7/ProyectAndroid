package com.herprogramacion.ajax.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.herprogramacion.ajax.R;
import com.herprogramacion.ajax.ui.ActividadPrincipal;

/**
 * Created by Rodrigo Cortes Armas on 27/03/2016.
 */
public class ReadComments extends Activity  {

    Button btnCursoStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // cuenta que el uso read_comments.xml en lugar de nuestra single_post.xml
        //layout de la vista
        setContentView(R.layout.read_comments);
        btnCursoStar = (Button) findViewById(R.id.btn_inicio);


    }

    //onClick declarado en el boton inicio.
    public void inicio(View view) {
        Intent intent = new Intent(this, ActividadPrincipal.class);
        Button button = (Button) findViewById(R.id.btn_inicio);
        startActivity(intent);
    }

    //metodo para finalizar la ventana y no aparezca al momento de retroceder en la aplicacion.
    protected void onPause(){
        super.onPause();
        finish(); //termina la actividad
    }

}
