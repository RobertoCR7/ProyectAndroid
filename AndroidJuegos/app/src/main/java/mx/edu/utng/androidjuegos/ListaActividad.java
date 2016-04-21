package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import mx.edu.utng.androidjuegos.util.DBAdapter;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class ListaActividad extends Activity implements AdapterView.OnItemClickListener {

    private ListView lsvOpcion;
    private String[] opciones;
    private Bundle bundle;

    private String[] descripciones;
    private DBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviews_inicio);
        initComponents();
    }

    private void initComponents(){
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        descripciones=getResources().getStringArray(R.array.descripTitulo);
        opciones=getResources().getStringArray(R.array.titulos);
        lsvOpcion =(ListView)findViewById(R.id.lsv_opcion);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.item_layout, R.id.txv_item, opciones);
        lsvOpcion.setAdapter(adapter);
        lsvOpcion.setOnItemClickListener(this);
        bundle = new Bundle();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
      // if (position==0){
        bundle.putString("elegido", opciones[position]);
        bundle.putInt("posicion", position);
        bundle.putString("descripciones", descripciones[position]);

        switch (position){
            case 0:
                boolean estat=dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,1);
                Log.e("Estatus", "Modulo 1"+estat);
                if (dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,1)){
                    Intent intent = new Intent(ListaActividad.this, SeleccionActividad.class);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }else {
                    Toast.makeText(ListaActividad.this, "Modulo 1 Bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                boolean estat1=dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,2);
                Log.e("Estatus", "Modulo 2"+estat1);
                if (dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,2)){
                    Intent intent = new Intent(ListaActividad.this, SeleccionActividad.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else {
                    Toast.makeText(ListaActividad.this, "Modulo 2 Bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                boolean estat2=dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,3);
                Log.e("Estatus", "Modulo 3"+estat2);
                if (dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,3)){
                    Intent intent = new Intent(ListaActividad.this, SeleccionActividad.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else {
                    Toast.makeText(ListaActividad.this, "Modulo 3 Bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                boolean estat3=dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,4);
                Log.e("Estatus", "Modulo 4"+estat3);
                if (dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,4)){
                    Intent intent = new Intent(ListaActividad.this, SeleccionActividad.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else {
                    Toast.makeText(ListaActividad.this, "Modulo 4 Bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                boolean estat4=dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,5);
                Log.e("Estatus", "Modulo 5"+estat4);
                if (dbAdapter.statusModulo(LogeoActividad.ID_USUARIO,5)){
                    Intent intent = new Intent(ListaActividad.this, SeleccionActividad.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else {
                    Toast.makeText(ListaActividad.this, "Modulo 5 Bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }

      //  Intent intent = new Intent(ListaActividad.this, SeleccionActividad.class);
       // intent.putExtras(bundle);
       // startActivity(intent);
    //}

           // else {
            //Toast.makeText(ListaActividad.this, "Tema Bloqueado", Toast.LENGTH_SHORT).show();

           // }
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }


}



