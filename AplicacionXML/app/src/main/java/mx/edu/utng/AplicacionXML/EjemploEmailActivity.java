package mx.edu.utng.AplicacionXML;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

/**
 * Created by Roberto on 19/04/2016.
 */
public class EjemploEmailActivity extends AppCompatActivity  implements View.OnClickListener {

    private  Button btnEnviarEmailHaora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grafic_layout);
        initComponets();
    }

    private void initComponets() {

        btnEnviarEmailHaora=(Button)findViewById(R.id.btn_email_email_haora);

        btnEnviarEmailHaora.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case 0:

                break;
            case R.id.btn_email_email_haora:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                email.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://"+ getPackageName()+ "/" + R.drawable.certificado));
                email.putExtra(Intent.EXTRA_SUBJECT, "CURSO DE XML");
                email.putExtra(Intent.EXTRA_TEXT , "Gracias por finalizar el curso de XML");
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, ""));


        }
    }
}
