package mx.edu.utng.jasperreport.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mx.edu.utng.jasperreport.MenuActivity;
import mx.edu.utng.jasperreport.R;


public class Display extends AppCompatActivity implements View.OnClickListener{

    ImageView imvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_display);
        String username= getIntent().getStringExtra(getString(R.string.username)); //Traemos el nombre del usuario registrado

        TextView tv = (TextView)findViewById(R.id.txv_usuario);
        tv.setText(username);
        imvNext =(ImageView)findViewById(R.id.imv_next);
        imvNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imv_next:
                startActivity(new Intent(this, MenuActivity.class));
        }

    }
}
