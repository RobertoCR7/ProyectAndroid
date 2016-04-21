package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Erick on 03/02/2016.
 */
public class DesarrolladorActivity extends Activity {

    private ImageView imvDesarrollador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desarrollador_layout);
        initComponents();
    }

    private void  initComponents(){
        imvDesarrollador = (ImageView)findViewById(R.id.imv_erick);
    }
}
