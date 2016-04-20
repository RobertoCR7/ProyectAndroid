package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Roberto on 26/01/2016.
 */
public class PrecentacionImagenTouchActivity extends Activity {
    private ImageView imvImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precentacion_imgen_touch);
        imvImagen=(ImageView)findViewById(R.id.imv_imagen);
        imvImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrecentacionImagenTouchActivity.this, IntroduccionActivity.class);
                startActivity(intent);
            }
        });
    }
}
