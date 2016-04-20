package mx.edu.utng.AplicacionXML;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * by Roberto
 */

public class Display extends AppCompatActivity implements View.OnClickListener{

    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String username= getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
        btnSiguiente =(Button)findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                startActivity(new Intent(this, ListaPrincipalActividad.class));
                break;
        }

    }
}
