package mx.edu.utng.androidjuegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.androidjuegos.util.DBAdapter;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class ListaDosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView txvTituloListaD;
    private ListView lsvContenidoListaD;


    private String[] contenidoMenuD;
    private ArrayAdapter adapter;
    private Bundle bundle;
    private Intent intent;
    private Bundle valoresRecibidos;
    private String msj = "";

    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_dos_layut);

        initComponents();
    }

    private void initComponents() {

        dbAdapter=new DBAdapter(this);
        dbAdapter.open();

        txvTituloListaD = (TextView) findViewById(R.id.txv_titulo_lista_d);
        lsvContenidoListaD = (ListView) findViewById(R.id.lsv_contenido_lista_d);


        valoresRecibidos = getIntent().getExtras();

        switch (valoresRecibidos.getInt("posicionSelActP")) {
            case 0:
                txvTituloListaD.setText(getResources().getString(R.string.temIntro));
                contenidoMenuD = getResources().getStringArray(R.array.introducción);
                break;
            case 1:
                txvTituloListaD.setText(getResources().getString(R.string.tm1));
                contenidoMenuD = getResources().getStringArray(R.array.number1);

                break;
            case 2:
                txvTituloListaD.setText(getResources().getString(R.string.tm2));
                contenidoMenuD =getResources().getStringArray(R.array.number2);
                break;
            case 3:
                txvTituloListaD.setText(getResources().getString(R.string.tm3));
                contenidoMenuD = getResources().getStringArray(R.array.number3);
                break;
            case 4:
                txvTituloListaD.setText(getResources().getString(R.string.tm4));
                contenidoMenuD = getResources().getStringArray(R.array.number4);
                break;

        }

        adapter = new ArrayAdapter(getApplicationContext(), R.layout.item_layout_menu_d, R.id.txv_item_menu_d, contenidoMenuD);
        lsvContenidoListaD.setAdapter(adapter);
        lsvContenidoListaD.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        bundle = new Bundle();
        bundle.putInt("moduloMenuDos", valoresRecibidos.getInt("posicionSelActP"));
        bundle.putInt("posicionTema", position);

        int idModul=dbAdapter.idModulo1(LogeoActividad.ID_USUARIO,"Modulo_1");
        boolean activo;

        switch (valoresRecibidos.getInt("posicionSelActP")) {
            case 0://tema1
                switch (position){
                    case 0:
                        activo=dbAdapter.statusTema(1,1,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (position){
                    case 0:
                        activo=dbAdapter.statusTema(2,1,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        activo=dbAdapter.statusTema(2,2,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(2,3,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(2,4,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(2,5,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(2,6,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;

                }
                break;
            case 2:
                switch (position){
                    case 0:
                        activo=dbAdapter.statusTema(3,1,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        activo=dbAdapter.statusTema(3,2,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(3,3,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(3,4,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(3,5,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(3,6,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 6:
                        activo=dbAdapter.statusTema(3,7,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 7:
                        activo=dbAdapter.statusTema(3,8,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 8:
                        activo=dbAdapter.statusTema(3,9,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;

                }
                break;
            case 3:
               switch (position){
                    case 0:
                        activo=dbAdapter.statusTema(4,1,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        activo=dbAdapter.statusTema(4,2,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(4,3,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(4,4,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(4,5,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(4,6,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 6:
                        activo=dbAdapter.statusTema(4,7,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;

                }

                break;
            case 4:
               switch (position){
                    case 0:
                        activo=dbAdapter.statusTema(5,1,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        activo=dbAdapter.statusTema(5,2,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(5,3,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(5,4,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(5,5,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(5,6,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 6:
                        activo=dbAdapter.statusTema(5,7,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 7:
                        activo=dbAdapter.statusTema(5,8,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 8:
                        activo=dbAdapter.statusTema(5,9,idModul);
                        Log.e("Temas activos", "onItemclick: "+activo);
                        if (activo){
                            intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class).putExtras(bundle);
                            startActivity(intent);
                        }else {
                            Toast.makeText(ListaDosActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;

                }

                break;
        }

       /*intent = new Intent(ListaDosActivity.this, SeleccionSegundaActividad.class);
        //intent = new Intent(ListaDosActivity.this, QuizActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_menu_ayuda_sugerencia:
                startActivity(new Intent(ListaDosActivity.this, ListaActividad.class));
                break;
            case R.id.itm_salir:
                itmSalida();
                break;
            case R.id.itm_ayuda:
                startActivity(new Intent(ListaDosActivity.this, AyudaActividad.class));
                break;
            case R.id.itm_desar:
                startActivity(new Intent(ListaDosActivity.this, DeveloperActivity.class));
                break;
            case R.id.itm_conf:
                startActivity(new Intent(ListaDosActivity.this, SettingsActivity.class));
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
