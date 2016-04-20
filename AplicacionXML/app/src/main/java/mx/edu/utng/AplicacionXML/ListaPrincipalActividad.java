package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import mx.edu.utng.AplicacionXML.util.DBAdapter;

/**
 * Created by Roberto on 06/02/2016.
 */
public class ListaPrincipalActividad extends Activity implements AdapterView.OnItemClickListener {

    private ListView lsvOpcion;
    private String[] opciones;
    private DBAdapter dbAdapter;
    private Bundle bundle;
    private String[] descripciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temas_lista_principal);
        initComponents();
    }

    private void initComponents(){
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        opciones = getResources().getStringArray(R.array.TemarioList);
        descripciones = getResources().getStringArray(R.array.DesgloseTemarioList);

        lsvOpcion =(ListView)findViewById(R.id.lsv_opcion);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),
                R.layout.lista_principal_layout,R.id.txv_item, opciones);
        lsvOpcion.setAdapter(adapter);
        lsvOpcion.setOnItemClickListener(this);
        bundle = new Bundle();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            bundle.putString("elegido", opciones[position]);
            bundle.putInt("posicion", position);
            bundle.putString("descripciones", descripciones[position]);

        switch (position){
            case 0:
                boolean estat=dbAdapter.statusModulo(LoginActivity.ID_USUARIO,1);
                Log.e("Estatus", "Modulos 1: "+estat );
                if (dbAdapter.statusModulo(LoginActivity.ID_USUARIO,1)){
                    startActivity(new Intent(ListaPrincipalActividad.this, ContenidoListaActivity.class).putExtras(bundle));

                }else {
                    Toast.makeText(ListaPrincipalActividad.this, "Modulo 1 bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                boolean estat1=dbAdapter.statusModulo(LoginActivity.ID_USUARIO,2);
                Log.e("Estatus", "Modulos 2: "+estat1 );
                if (dbAdapter.statusModulo(LoginActivity.ID_USUARIO,2)){
                    startActivity(new Intent(ListaPrincipalActividad.this, ContenidoListaActivity.class).putExtras(bundle));

                }else {
                    Toast.makeText(ListaPrincipalActividad.this, "Modulo 2 bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                boolean estat2=dbAdapter.statusModulo(LoginActivity.ID_USUARIO,3);
                Log.e("Estatus", "Modulos 3: "+estat2 );
                if (dbAdapter.statusModulo(LoginActivity.ID_USUARIO,3)){
                    startActivity(new Intent(ListaPrincipalActividad.this, ContenidoListaActivity.class).putExtras(bundle));

                }else {
                    Toast.makeText(ListaPrincipalActividad.this, "Modulo 3 bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                boolean estat3=dbAdapter.statusModulo(LoginActivity.ID_USUARIO,4);
                Log.e("Estatus", "Modulos 4: "+estat3 );
                if (dbAdapter.statusModulo(LoginActivity.ID_USUARIO,4)){
                    startActivity(new Intent(ListaPrincipalActividad.this, ContenidoListaActivity.class).putExtras(bundle));

                }else {
                    Toast.makeText(ListaPrincipalActividad.this, "Modulo 4 bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                boolean estat4=dbAdapter.statusModulo(LoginActivity.ID_USUARIO,5);
                Log.e("Estatus", "Modulos 5: "+estat4 );
                if (dbAdapter.statusModulo(LoginActivity.ID_USUARIO,5)){
                    startActivity(new Intent(ListaPrincipalActividad.this, ContenidoListaActivity.class).putExtras(bundle));

                }else {
                    Toast.makeText(ListaPrincipalActividad.this, "Modulo 5 bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
      //  startActivity(new Intent(ListaPrincipalActividad.this, ContenidoListaActivity.class).putExtras(bundle));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_menu_ayuda_sugerencia:
                startActivity(new Intent(ListaPrincipalActividad.this, ListaPrincipalActividad.class));
                break;
            case R.id.itm_salir:
                itmSalida();
                break;

            case R.id.itm_ayuda:
                startActivity(new Intent(ListaPrincipalActividad.this, AyudaActividad.class));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
