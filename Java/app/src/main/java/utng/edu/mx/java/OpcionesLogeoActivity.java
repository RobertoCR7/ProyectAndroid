package utng.edu.mx.java;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gustavo on 25/03/2016.
 */
public class OpcionesLogeoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIngresarLogin,btnPreview;
    private MediaPlayer mpSound;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcion_logeo_layout);
        initComponets();
    }

    private void initComponets() {
        btnIngresarLogin=(Button)findViewById(R.id.btn_ingresar_login);
        btnPreview=(Button)findViewById(R.id.btn_preview);
        bundle=new Bundle();
        mpSound=MediaPlayer.create(this,R.raw.cli);

        btnIngresarLogin.setOnClickListener(this);
        btnPreview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mpSound.start();
        switch (v.getId()) {
            case R.id.btn_ingresar_login:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btn_preview:
                bundle.putBoolean("logeo",false);
                startActivity(new Intent(this,ExampleIndiceActivity.class).putExtras(bundle));
                break;
            default:
                break;
        }
    }

}
