package utng.edu.utng.html5apli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by kevin on 03/02/2016.
 */
public class InicioActivity extends AppCompatActivity {

    private ImageView imvInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida_layout);
        imvInicio =(ImageView)findViewById(R.id.imv_bien);
        imvInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, LogeoActividad.class);
                startActivity(intent);
            }
        });
    }

    private void initConponents() {

    }
}
