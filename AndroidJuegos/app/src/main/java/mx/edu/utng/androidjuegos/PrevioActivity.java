package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class PrevioActivity extends Activity {

    private ImageView imvPrevio;
    private TextView txvText;
    private Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.previo_layout);
        imvPrevio = (ImageView)findViewById(R.id.imv_previo);
        txvText = (TextView)findViewById(R.id.txv_texto_bie);
        btnPrev = (Button)findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrevioActivity.this, RegistroActividad.class);
                startActivity(intent);
            }
        });
    }

}
