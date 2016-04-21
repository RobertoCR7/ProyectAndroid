package mx.edu.utng.ctutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Enrique on 02/03/2016.
 */
public class Display extends AppCompatActivity implements View.OnClickListener{

    Button btnSiguiente;
    Bundle bundleD;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_layout);
        String username= getIntent().getStringExtra("Username");
        bundleD = getIntent().getExtras();
        bundle = new Bundle();
        bundle.putBoolean("loginD",bundleD.getBoolean("logeo"));
        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
        btnSiguiente =(Button)findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                startActivity(new Intent(this, Menu.class).putExtras(bundle));
        }

    }
}
