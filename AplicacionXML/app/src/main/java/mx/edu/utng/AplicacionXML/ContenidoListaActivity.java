package   mx.edu.utng.AplicacionXML;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Roberto on 26/01/2016.
 */
public class ContenidoListaActivity extends AppCompatActivity {

    private ImageView imvOpcionima;
    private TextView txvDescripcion;
    private Button btnlistaBoton;
    private Bundle bundleTabAct;
    private String itemMenuP= "";
    private Bundle valoresRecibidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_lista_layout);
        initComponents();
    }


    private void initComponents(){
        imvOpcionima = (ImageView)findViewById(R.id.imv_opcionima);
        txvDescripcion = (TextView)findViewById(R.id.txv_descripcion);
        btnlistaBoton = (Button)findViewById(R.id.btn_listaBoton);
        bundleTabAct = new Bundle();

        valoresRecibidos = getIntent().getExtras();
        switch (valoresRecibidos.getInt("posicion")){
            case 0:
                imvOpcionima.setImageResource(R.drawable.grandioso);
                itemMenuP = "Introduccion";
                break;
            case 1:
                imvOpcionima.setImageResource(R.drawable.grandioso);
                itemMenuP = "Tema 1";
                break;

            case 2:
                imvOpcionima.setImageResource(R.drawable.grandioso);
                itemMenuP = "Tema 2";
                break;
            case 3:
                imvOpcionima.setImageResource(R.drawable.grandioso);
                itemMenuP = "Tema 3";
                break;
            case 4:
                imvOpcionima.setImageResource(R.drawable.grandioso);
                itemMenuP = "Tema 4";
                break;
            case 5:
                imvOpcionima.setImageResource(R.drawable.grandioso);
                itemMenuP = "Tema 5";
                break;
        }

        txvDescripcion.setText("Nombre: " + valoresRecibidos.getString("elegido") + "\n\n" +
                        "Descripcion:  \n" + valoresRecibidos.getString("descripciones")
        );

        btnlistaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundleTabAct.putInt("menu_principal",valoresRecibidos.getInt("posicion"));//Posicion del item precionado
                bundleTabAct.putString("itemMenuP", itemMenuP);//Titulo del item presionado

                Intent intent   = new Intent(ContenidoListaActivity.this,
                        SegundaListaActivity.class);
                intent.putExtras(bundleTabAct);
                startActivity(intent);
            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_menu_ayuda_sugerencia:
                startActivity(new Intent(ContenidoListaActivity.this, ListaPrincipalActividad.class));
                break;
            case R.id.itm_salir:
                itmSalida();
                break;
            case R.id.itm_ayuda:
                startActivity(new Intent(ContenidoListaActivity.this, AyudaActividad.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void itmSalida(){
        finish();
        Intent intent1=new Intent(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_HOME);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }

}


