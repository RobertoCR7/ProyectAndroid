package mx.edu.utng.androidjuegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class SeleccionActividad extends AppCompatActivity {

    private ImageView imvOpcionima;
    private TextView txvDescripcion;
    private Button btnCurso;
    private Bundle bundleSelAct;
    private String itemMenuP = "";
    private Bundle valor;
    private String msj = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_layout);
        btnCurso = (Button) findViewById(R.id.btn_curso);


        initComponents();
    }


    private void initComponents() {

        btnCurso = (Button) findViewById(R.id.btn_curso);
        imvOpcionima = (ImageView) findViewById(R.id.imv_opcionima);
        txvDescripcion = (TextView) findViewById(R.id.txv_descripcion);
        bundleSelAct = new Bundle();
        Bundle valoresRecibidos = getIntent().getExtras();
        switch (valoresRecibidos.getInt("posicion")) {
            case 0:
                imvOpcionima.setImageResource(R.drawable.bien);
                itemMenuP = getResources().getString(R.string.introduccion);
                break;
            case 1:
                imvOpcionima.setImageResource(R.drawable.uno);
                itemMenuP = getResources().getString(R.string.tem1);
                break;
            case 2:
                imvOpcionima.setImageResource(R.drawable.dos);
                itemMenuP = getResources().getString(R.string.tem2);
                break;
            case 3:
                imvOpcionima.setImageResource(R.drawable.tres);
                itemMenuP = getResources().getString(R.string.tem3);
                break;
            case 4:
                imvOpcionima.setImageResource(R.drawable.cuatro);
                itemMenuP = getResources().getString(R.string.tem4);
                break;


        }

        bundleSelAct.putString("itemMenuP", itemMenuP);
        bundleSelAct.putInt("posicionSelAct", valoresRecibidos.getInt("posicion"));

        txvDescripcion.setText("Nombre: " + valoresRecibidos.getString("elegido") + "\n\n" +
                        "Descripcion:  \n" + valoresRecibidos.getString("descripciones")


        );

        btnCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionActividad.this, Indice.class);
                intent.putExtras(bundleSelAct);
                startActivity(intent);
            }
        });


    }


}

