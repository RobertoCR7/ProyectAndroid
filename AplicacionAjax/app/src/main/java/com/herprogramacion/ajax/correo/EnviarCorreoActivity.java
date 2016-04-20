package com.herprogramacion.ajax.correo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.herprogramacion.ajax.R;
import com.herprogramacion.ajax.ui.ActividadPrincipal;
import com.herprogramacion.ajax.ui.PrivilegiosActivity;

import java.io.File;

/**
 * Created by Rodrigo Cortes Armas on 05/04/2016.
 */
public class EnviarCorreoActivity extends Activity {
    Button btnEnviar;
    EditText txvPara;
    EditText txvTema;
    EditText txvMensaje;

    Button btnPrinciapl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout donde se ubica la vista para enviar correos
        setContentView(R.layout.correo_layout);

        btnEnviar=(Button)findViewById(R.id.btn_principal);

        btnEnviar=(Button)findViewById(R.id.btn_enviar);
        txvPara=(EditText)findViewById(R.id.edt_para);
        txvTema=(EditText)findViewById(R.id.edt_tema);
        txvMensaje=(EditText)findViewById(R.id.edt_mensaje);

        //metodo onclick al boton enviar para mas adelante escoger por donde enviar el email
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String para = txvPara.getText().toString();
                String tema = txvTema.getText().toString();
                String mensaje = txvMensaje.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                //tipo de mensaje que se enviara
                email.setType("text/plain");
                //email.putExtra(Intent.EXTRA_EMAIL, new String[]{ para});
                email.putExtra(Intent.EXTRA_SUBJECT, para);
                email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/certificado.png")));
                email.putExtra(Intent.EXTRA_TEXT,  mensaje);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Elige el email de tu preferencia :"));

            }
        });

    }

    public void irPrincipa(View view) {
        Intent intent  = new Intent(this, ActividadPrincipal.class);
        Button btnPrinciapl = (Button)findViewById(R.id.btn_principal);
        startActivity(intent);
    }
    protected void onPause(){
        super.onPause();
        finish(); //termina la actividad
    }
}
