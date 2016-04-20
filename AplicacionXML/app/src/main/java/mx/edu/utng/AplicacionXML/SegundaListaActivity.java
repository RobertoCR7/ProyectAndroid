package mx.edu.utng.AplicacionXML;

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

import mx.edu.utng.AplicacionXML.util.DBAdapter;

/**
 * Created by Roberto on 15/02/2016.
 */
public class SegundaListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TextView txvTituloListaD;
    private ListView lsvContenidoListaD;

    private String[] contenidoMenuD;
    private ArrayAdapter  adapter;
    private Bundle bundleLisDosAct;
    private Intent intent;
    private Bundle valoresRecibidosLisDosAct;
    
    private DBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_lista_layut);
        initComponents();
    }

    private void initComponents(){
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();

        txvTituloListaD = (TextView)findViewById(R.id.txv_titulo_lista_d);//titulo de la lista
        lsvContenidoListaD = (ListView)findViewById(R.id.lsv_contenido_lista_d);//lista

        valoresRecibidosLisDosAct = getIntent().getExtras();

        switch (valoresRecibidosLisDosAct.getInt("menu_principal")){//Posicion de item en la lista principal
            case 0:
                txvTituloListaD.setText(getResources().getString(R.string.intro));
                contenidoMenuD=getResources().getStringArray(R.array.DesgloseIntro);
                break;
            case 1:
                txvTituloListaD.setText(getResources().getString(R.string.uno));
                contenidoMenuD=getResources().getStringArray(R.array.TemaUno);

                break;
            case 2:
                txvTituloListaD.setText(getResources().getString(R.string.dos));
                contenidoMenuD=getResources().getStringArray(R.array.TemaDos);
                break;
            case 3:
                txvTituloListaD.setText(getResources().getString(R.string.cuatro));
                contenidoMenuD=getResources().getStringArray(R.array.TemaCuatro);
                break;
            case 4:
                txvTituloListaD.setText(getResources().getString(R.string.Cinco));
                contenidoMenuD=getResources().getStringArray(R.array.TemaCinco);
                break;

        }

        adapter = new ArrayAdapter(getApplicationContext(),R.layout.menu_layout,R.id.txv_item_menu_d, contenidoMenuD);
        lsvContenidoListaD.setAdapter(adapter);
        lsvContenidoListaD.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            bundleLisDosAct = new Bundle();
            bundleLisDosAct.putInt("menu_principalD", valoresRecibidosLisDosAct.getInt("menu_principal"));//Posicion de  item de la lista principal
            bundleLisDosAct.putInt("posicionTema", position);//Posicion de  item de la lista secundaria
        /**
         * intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class);
         *intent.putExtras(bundleLisDosAct);
         *startActivity(intent);
         */

        int idModul=dbAdapter.idModulo1(LoginActivity.ID_USUARIO, "Modulo_1");
        boolean activo;

        switch (valoresRecibidosLisDosAct.getInt("menu_principal")){//para colocar la lista de los temas del modulo
            case 0://Tema uno
                switch (position){
                    case 0:
                        activo=dbAdapter.statusTema(1,1,idModul);
                        Log.e("mod 1 tem 1", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

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
                        Log.e("mod 2 tem 1", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 1:
                        activo=dbAdapter.statusTema(2,2,idModul);
                        Log.e("mod 2 tem 2", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(2,3,idModul);
                        Log.e("mod 2 tem 3", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(2,4,idModul);
                        Log.e("mod 2 tem 4", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(2,5,idModul);
                        Log.e("mod 2 tem 5", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

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
                        Log.e("mod 3 tem 1", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 1:
                        activo=dbAdapter.statusTema(3,2,idModul);
                        Log.e("mod 3 tem 2", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(3,3,idModul);
                        Log.e("mod 3 tem 3", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(3,4,idModul);
                        Log.e("mod 3 tem 4", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(3,5,idModul);
                        Log.e("mod 3 tem 5", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(3,6,idModul);
                        Log.e("mod 3 tem 6", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 6:
                        activo=dbAdapter.statusTema(3,7,idModul);
                        Log.e("mod 3 tem 7", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 7:
                        activo=dbAdapter.statusTema(3,8,idModul);
                        Log.e("mod 3 tem 8", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

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
                        Log.e("mod 4 tem 1", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 1:
                        activo=dbAdapter.statusTema(4,2,idModul);
                        Log.e("mod 4 tem 2", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(4,3,idModul);
                        Log.e("mod 4 tem 3", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(4,4,idModul);
                        Log.e("mod 4 tem 4", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(4,5,idModul);
                        Log.e("mod 4 tem 5", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(4,6,idModul);
                        Log.e("mod 4 tem 6", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 6:
                        activo=dbAdapter.statusTema(4,7,idModul);
                        Log.e("mod 4 tem 7", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

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
                        Log.e("mod 5 tem 1", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 1:
                        activo=dbAdapter.statusTema(5,2,idModul);
                        Log.e("mod 5 tem 2", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        activo=dbAdapter.statusTema(5,3,idModul);
                        Log.e("mod 5 tem 3", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 3:
                        activo=dbAdapter.statusTema(5,4,idModul);
                        Log.e("mod 5 tem 4", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 4:
                        activo=dbAdapter.statusTema(5,5,idModul);
                        Log.e("mod 5 tem 5", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case 5:
                        activo=dbAdapter.statusTema(5,6,idModul);
                        Log.e("mod 5 tem 6", "onItemClick:"+activo);
                        if (activo){
                            intent = new Intent(SegundaListaActivity.this, ContentTabsActividad.class).putExtras(bundleLisDosAct);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SegundaListaActivity.this, "Subtema bloqueado", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    default:
                        break;


                }
                break;
        }
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
                startActivity(new Intent(SegundaListaActivity.this, ListaPrincipalActividad.class));
                break;
            case R.id.itm_salir:
                itmSalida();
                break;
            case R.id.itm_ayuda:
                startActivity(new Intent(SegundaListaActivity.this, AyudaActividad.class));
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
