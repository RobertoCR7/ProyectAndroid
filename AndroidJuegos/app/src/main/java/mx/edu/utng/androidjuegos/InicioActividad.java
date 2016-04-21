package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class InicioActividad extends Activity {

    private ImageView imv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);
        imv_img=(ImageView)findViewById(R.id.imv_img);
        imv_img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActividad.this,
                        LogeoActividad.class);
                startActivity(intent);
            }
        });





    }
    private void initComponents(){

    }
}
