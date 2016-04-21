package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import mx.edu.utng.jasperreport.Login.MainActivity;
import mx.edu.utng.jasperreport.Util.DBAdapter;

/**
 * Created by Erick on 03/02/2016.
 */
public class CapitulosActivity extends Activity implements AdapterView.OnItemClickListener{


    //Los temas no los pasamos al archivo de cadenas porque al momento de ejecutarlo manda error
    private ListView lsvCapitulos;
    private String[] capitulos = {
            "Características De JasperReport",
            "Ciclo Vital De JasperReports",
            "Compilacion De Diseño De Reportes",
            "Exportando Reportes",
            "Parametros De Reportes",
            "Variables De Reportes",
            "Estilos De Reporte",
            "Reportes De Scriptlets",
            "Crear Subreportes",
            "Creacion De Graficos"};
    private Bundle bundle;
    private String capitulo = "";
    private Intent intent;
    private DBAdapter dbAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.captitulos_layout);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        initComponents();
    }

    private void initComponents() {
        lsvCapitulos = (ListView)findViewById(R.id.lsv_capitulos);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.item_layout,
                R.id.txv_item, capitulos);
        lsvCapitulos.setAdapter(adapter);
        lsvCapitulos.setOnItemClickListener(this);
        bundle = new Bundle();

    }


    //Checamos el estatus de cada tema para porder acceder a el
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        bundle.putInt("posision", position);
        boolean acti=false;
        //  int i=0;
        //Solo
        switch (position){
            case 0:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 1);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 1)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 2);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 2)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 3);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 3)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 4);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 4)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 5);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 5)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 6);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 6)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 6:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 7);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 7)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 7:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 8);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 8)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 8:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 9);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 9)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 9:
                acti=dbAdapter.statusTema(MainActivity.ID_USUARIO, 10);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(MainActivity.ID_USUARIO, 10)){
                    intent=new Intent(CapitulosActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(CapitulosActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
