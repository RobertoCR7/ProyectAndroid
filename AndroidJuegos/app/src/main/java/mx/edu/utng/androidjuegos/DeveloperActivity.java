package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class DeveloperActivity extends Activity {

    private ImageView imvUni; //Se declaran los elementos de la vista.
    private ImageView imvDvelop;
    private TextView txvDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_layout); //con esta funcion se trae los elementos de la vista
        initComponents();
    }

    private void initComponents(){

    }
}
