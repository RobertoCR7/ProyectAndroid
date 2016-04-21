package mx.edu.utng.jasperreport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Erick on 19/04/2016.
 */
public class EjemploEmailActivity extends AppCompatActivity  implements View.OnClickListener {

    private ImageView imvEnviarEmailAhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.example_email_layout);
        initComponets();
    }

    private void initComponets() {
        imvEnviarEmailAhora=(ImageView)findViewById(R.id.imv_email_email_haora);
        imvEnviarEmailAhora.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.imv_email_email_haora:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/certificado.png")));//Traemos la imagen
                email.putExtra(Intent.EXTRA_SUBJECT, "Curso De JasperReport certificado");//Pasamos el titulos del correo
                email.putExtra(Intent.EXTRA_TEXT , "Estimado usuario nos es grato comunicarle que a concluido de manera satisfactoria el curso de JasperReport.");//Contenido del mail
                email.setType("plain/text");

                startActivity(Intent.createChooser(email, ""));


        }
    }
}
