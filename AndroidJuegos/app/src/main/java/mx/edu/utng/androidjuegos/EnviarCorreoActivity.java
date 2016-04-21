package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class EnviarCorreoActivity extends Activity {  //Se declaran los componentes del layout
    Button btnEnviar;
    EditText txvPara;
    EditText txvTema;
    EditText txvMensaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) { // se hace el oncreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correo_layout);



        btnEnviar=(Button)findViewById(R.id.btn_enviar);
        txvPara=(EditText)findViewById(R.id.edt_para);
        txvTema=(EditText)findViewById(R.id.edt_tema);
        txvMensaje=(EditText)findViewById(R.id.edt_mensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String para = txvPara.getText().toString();
                String tema = txvTema.getText().toString();
                String mensaje = txvMensaje.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                //email.putExtra(Intent.EXTRA_EMAIL, new String[]{ para});
                email.putExtra(Intent.EXTRA_SUBJECT, para); //se pone quien envia el correo
                email.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.cer));
                email.putExtra(Intent.EXTRA_TEXT,  mensaje); //se pone el mensaje

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Elige el email de tu preferencia :"));

            }
        });

    }


    protected void onPause(){
        super.onPause();
        finish(); //termina la actividad
    }
}
