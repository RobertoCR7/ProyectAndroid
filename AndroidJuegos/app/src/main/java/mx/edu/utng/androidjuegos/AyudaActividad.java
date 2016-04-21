package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class AyudaActividad extends Activity {

    private ImageView imvHelp; //Se declaran los componentes de la vista.
    private TextView txvAyuda;
    private TextView txvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Se crea la vista con el meodo oncreate.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda_layout); //El setcontenView trae la vista que se declara.
        initComponents();
    }

    private void initComponents(){

    }
}
