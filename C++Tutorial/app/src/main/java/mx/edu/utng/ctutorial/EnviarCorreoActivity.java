package mx.edu.utng.ctutorial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.io.File;


public class EnviarCorreoActivity extends Activity {
    Button btnEnviar;
    EditText txvPara;
    EditText txvTema;
    EditText txvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correo_layout);

        btnEnviar=(Button)findViewById(R.id.btn_principal);

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
                email.putExtra(Intent.EXTRA_SUBJECT, para);
                email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/certificado1.png" )));
                email.putExtra(Intent.EXTRA_TEXT,  mensaje);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Elige el email de tu preferencia :"));

            }
        });

    }

    public void irPrincipa(View view) {
        Intent intent  = new Intent(this, Home.class);
        Button btnPrinciapl = (Button)findViewById(R.id.btn_principal);
        startActivity(intent);
    }
    protected void onPause(){
        super.onPause();
        finish(); //termina la actividad
    }
}
