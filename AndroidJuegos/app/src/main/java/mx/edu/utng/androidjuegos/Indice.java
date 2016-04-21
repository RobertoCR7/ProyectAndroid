package mx.edu.utng.androidjuegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class Indice extends AppCompatActivity {
    private Bundle bundleIndice; // se declaran los elementos de la vista
    private ImageView imvStart;
    private Intent intent;
    private Bundle valoresRecibidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indice_layout); //Trae todos los elementos de layout
        initComponents();
    }

    private  void initComponents(){
        imvStart= (ImageView) findViewById(R.id.imv_start); //Declaramos nuestra imagen.
        valoresRecibidos = getIntent().getExtras();

        bundleIndice = new Bundle(); // Se crea un bundle con ese nombre.

        imvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // se crea el metodo onclick para al dar clic sobre un elemento se vaya a otra vista
                bundleIndice.putString("itemMenuPP", valoresRecibidos.getString("itemMenuP")); //se trae todos los elementos de la primer lista
                bundleIndice.putInt("posicionSelActP", valoresRecibidos.getInt("posicionSelAct")); // se trae la posicion del que haya elegio
                intent = new Intent(Indice.this, ListaDosActivity.class); //se crea un nuevo intento que se ira de la imagen a la segunda lista
                intent.putExtras(bundleIndice); // con el putExtras se trae el contenido.
                startActivity(intent);
            }
        });


    }
}
