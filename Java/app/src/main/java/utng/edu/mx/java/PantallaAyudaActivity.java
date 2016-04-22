package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Gustavo on 04/02/2016.
 */
public class PantallaAyudaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lsvIndice;
    private Intent intent;
    private String mensajeMenu = "";
    private String[] indices = {"Item1", "item2", "item3", "item4", "item5", "item6", "item7"};
    private String[] descripciones = {};
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda_layout);
        initComponents();
    }

    private void initComponents() {
        lsvIndice = (ListView) findViewById(R.id.lsv_indice);
        ArrayAdapter adapter = new ArrayAdapter(getApplication(), R.layout.item_layout, R.id.txv_item, indices);
        lsvIndice.setAdapter(adapter);
        lsvIndice.setOnItemClickListener(this);
        bundle = new Bundle();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                bundle.putString("elegido", indices[position]);
                bundle.putInt("posicion", position);
                bundle.putString("descripciones", descripciones[position]);
                intent = new Intent(PantallaAyudaActivity.this, SeleccionIndice.class);
                intent.putExtras(bundle);
                break;
            case 1:
                bundle.putString("elegido", indices[position]);
                bundle.putInt("posicion", position);
                bundle.putString("descripciones", descripciones[position]);
                intent = new Intent(PantallaAyudaActivity.this, SeleccionIndice.class);
                intent.putExtras(bundle);
                break;
            case 7:
                bundle.putString("elegido", indices[position]);
                bundle.putInt("posicion", position);
                bundle.putString("descripciones", descripciones[position]);
                intent = new Intent(PantallaAyudaActivity.this, SeleccionIndice.class);
                intent.putExtras(bundle);
                break;
            default:
                bundle.putString("elegido", indices[position]);
                bundle.putInt("posicion", position);
                bundle.putString("descripciones", descripciones[position]);
                intent.putExtras(bundle);
                break;
        }

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_off_logeo_layout, menu);
        return true;
    }
}
