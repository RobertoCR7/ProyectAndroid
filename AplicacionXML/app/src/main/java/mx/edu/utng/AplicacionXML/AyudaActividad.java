package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Roberto on 29/02/2016.
 */
public class AyudaActividad extends Activity implements View.OnClickListener {

    private ImageView imvHelp;
    private TextView txvAyuda;
    private TextView txvDesc;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda_layout);
        btn1=(Button)findViewById(R.id.btn_link1);
        btn2=(Button)findViewById(R.id.btn_infor);
        btn3=(Button)findViewById(R.id.btn_conf);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AyudaActividad.this, MainActivity.class);

                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AyudaActividad.this, InformacionDesarrolladorActivity.class);

                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AyudaActividad.this, SettingsActivity.class);

                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
