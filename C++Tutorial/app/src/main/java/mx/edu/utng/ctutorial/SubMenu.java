package mx.edu.utng.ctutorial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Enrique on 02/03/2016.
 */
public class SubMenu extends AppCompatActivity/* implements AdapterView.OnItemClickListener*/ {
    private TextView txvTituloListaD;
    private ListView lsvContenidoListaD;


    private String[] contenidoMenuD;
    private ArrayAdapter adapter;
    private Bundle valoresRecibidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu_activity_layout);

        initComponents();
    }

    private void initComponents() {
        txvTituloListaD = (TextView) findViewById(R.id.txv_titulo_lista_d);
        lsvContenidoListaD = (ListView) findViewById(R.id.lsv_contenido_lista_d);


        valoresRecibidos = getIntent().getExtras();
        switch (valoresRecibidos.getInt("posicionSelActP")) {
            case 0:
                txvTituloListaD.setText(getResources().getString(R.string.tm1));
                contenidoMenuD = getResources().getStringArray(R.array.introduction);
                break;
            case 1:
                txvTituloListaD.setText(getResources().getString(R.string.tem1));
                contenidoMenuD = getResources().getStringArray(R.array.number1);

                break;
            case 2:
                txvTituloListaD.setText(getResources().getString(R.string.tm2));
                contenidoMenuD = getResources().getStringArray(R.array.number2);
                break;
            case 3:
                txvTituloListaD.setText(getResources().getString(R.string.tm3));
                contenidoMenuD = getResources().getStringArray(R.array.number3);
                break;
            case 4:
                txvTituloListaD.setText(getResources().getString(R.string.tm4));
                contenidoMenuD = getResources().getStringArray(R.array.number4);
                break;
            case 5:
                txvTituloListaD.setText(getResources().getString(R.string.tm5));
                contenidoMenuD = getResources().getStringArray(R.array.number5);
                break;
        }

        adapter = new ArrayAdapter(getApplicationContext(), R.layout.submenu_activity_layout, R.id.txv_item_menu_d, contenidoMenuD);
        lsvContenidoListaD.setAdapter(adapter);
    }
}
