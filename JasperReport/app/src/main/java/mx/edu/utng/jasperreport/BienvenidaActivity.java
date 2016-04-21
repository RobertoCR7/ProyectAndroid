package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import mx.edu.utng.jasperreport.Login.MainActivity;

/**
 * Created by Erick on 03/02/2016.
 */
public class BienvenidaActivity extends Activity {

    private ImageView imvBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida_frame_layout);
        imvBienvenida = (ImageView)findViewById(R.id.imv_bienvenida);
        imvBienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BienvenidaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
