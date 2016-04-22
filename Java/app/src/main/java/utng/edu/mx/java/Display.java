package utng.edu.mx.java;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Gustavo on 15/02/2016.
 */

public class Display extends AppCompatActivity implements View.OnClickListener{

    private Button btnSiguiente;
    private MediaPlayer mpSound;
    private Bundle valoresResividosD;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        valoresResividosD=getIntent().getExtras();
        bundle=new Bundle();
        mpSound=MediaPlayer.create(this,R.raw.cli);



        String username= valoresResividosD.getString("Username");//getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
        btnSiguiente =(Button)findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mpSound.start();
        switch (v.getId()){
            case R.id.btnSiguiente:
                bundle.putBoolean(getString(R.string.logeo),valoresResividosD.getBoolean(getString(R.string.logeOff)));
                startActivity(new Intent(this, ExampleIndiceActivity.class).putExtras(bundle));
        }

    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
