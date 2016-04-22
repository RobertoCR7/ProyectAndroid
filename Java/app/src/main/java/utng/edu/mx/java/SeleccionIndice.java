package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gustavo on 04/02/2016.
 */
public class SeleccionIndice extends AppCompatActivity {

    private ImageView imvIndice;
    private TextView txvDescripcion,txvTituloIndice;
    private String indice= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indice_seleccion);
        initComponents();
    }
    private void initComponents(){
        imvIndice = (ImageView)findViewById(R.id.imv_java);
        txvDescripcion = (TextView)findViewById(R.id.txv_descripcion);
        txvTituloIndice = (TextView)findViewById(R.id.titulo_on);
        Bundle valoresRecividos = getIntent().getExtras();

        switch (valoresRecividos.getInt("posicion")){
            case 0:
                indice = getString(R.string.obj);
                imvIndice.setImageResource(R.drawable.objuno);
                break;
            case 1:
                indice = getString(R.string.addressee);
                imvIndice.setImageResource(R.drawable.des);
                break;
            case 7:
                indice = getString(R.string.exam_final);
                imvIndice.setImageResource(R.drawable.tests);
                break;
            default:
        }
        txvTituloIndice.setText(indice);
        txvDescripcion.setText(valoresRecividos.getString("descripciones"));
    }
}
