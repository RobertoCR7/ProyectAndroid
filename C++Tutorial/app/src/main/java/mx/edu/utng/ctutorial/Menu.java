package mx.edu.utng.ctutorial;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import mx.edu.utng.ctutorial.util.DBAdapter;

/**
 * Created by Enrique on 09/02/2016.
 */
public class Menu extends AppCompatActivity implements AdapterView.OnItemClickListener  {
    private ListView lsvTema;
    private MediaPlayer sound;
    private String[] temas;
    private Bundle bundle;
    private Bundle valoresRecividos;
    private DBAdapter dbAdapter;
    private Button btnEnviarCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_layout);
        initComponents();
    }

    private void initComponents(){
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        temas = getResources().getStringArray(R.array.menu);
        sound = new MediaPlayer().create(this, R.raw.clickboton);
        lsvTema=(ListView)findViewById(R.id.lsv_temas);

        btnEnviarCorreo = (Button)findViewById(R.id.btn_enviar_correo);
        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, EnviarCorreoActivity.class));
            }
        });
        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.selection_menu_layout,
                R.id.txv_selection,
                temas);
        lsvTema.setAdapter(adapter);
        lsvTema.setOnItemClickListener(this);
        bundle = new Bundle();
        valoresRecividos = getIntent().getExtras();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        sound.start();
        bundle.putString("elegido", temas[position]);
        bundle.putInt("posicion", position);
        boolean estart=false;

        switch (position){
            case 0:
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                break;
            case 1:
                estart=dbAdapter.statusModulo(Login.ID_USUARIO,1);
                Log.e("Estatus","Modulo 2"+ estart);
                if(estart){
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                }else{
                    Toast.makeText(Menu.this, "Modulo 2 Bloqueado",Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                estart=dbAdapter.statusModulo(Login.ID_USUARIO,2);
                Log.e("Estatus","Modulo 2"+ estart);
                if(estart){
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                }else{
                    Toast.makeText(Menu.this, "Modulo 3 Bloqueado",Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                estart =dbAdapter.statusModulo(Login.ID_USUARIO,3);
                Log.e("Estatus","Modulo 3"+ estart);
                if(estart){
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                }else{
                    Toast.makeText(Menu.this, "Modulo 4 Bloqueado",Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                estart=dbAdapter.statusModulo(Login.ID_USUARIO,4);
                Log.e("Estatus","Modulo 4"+ estart);
                if(estart){
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                }else{
                    Toast.makeText(Menu.this, "Modulo 5 Bloqueado",Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                estart=dbAdapter.statusModulo(Login.ID_USUARIO,5);
                Log.e("Estatus","Modulo 5"+ estart);
                if(estart){
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                }else{
                    Toast.makeText(Menu.this, "Modulo 6 Bloqueado",Toast.LENGTH_SHORT).show();
                }
                break;
            case 6:
                estart=dbAdapter.statusModulo(Login.ID_USUARIO,6);
                Log.e("Estatus","Modulo 6"+ estart);
                if(estart){
                    startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
                }else{
                    Toast.makeText(Menu.this, "Modulo 7 Bloqueado",Toast.LENGTH_SHORT).show();
                }
                break;
        }

       // startActivity(new Intent(this, Seleccion.class).putExtras(bundle));
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();

        if (valoresRecividos.getBoolean("loginD")){
            inflater.inflate(R.menu.menu_layouts, menu);
            return true;
        }else {
                inflater.inflate(R.menu.menu,menu);
            return true;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensage = "";
        if (valoresRecividos.getBoolean("loginD")){
            switch (item.getItemId()){
                case R.id.itm_Avanses:
                    startActivity(new Intent(Menu.this,GraficaMenuActiviry.class));
                    mensage = "Grafica";
                    break;
                case R.id.itm_video:
                    mensage = "video";
                    startActivity(new Intent(Menu.this,VideoActiviti.class));
                    break;
                case R.id.itm_desarrollador:
                    mensage = "Desarrollador kike";
                    startActivity(new Intent(Menu.this, DesarrolladorActivity.class));
                    break;
                case R.id.itm_salir:
                    itmSalir();
                    break;
                case R.id.itm_seting:
                    mensage = "Configuracion";
                    startActivity(new Intent(Menu.this, SettingsActivity.class));
                    break;
                case R.id.itm_dinamic:
                    mensage = "Dinamico";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://codepad.remoteinterview.io/ActiveLoftyEternalFamily")));
                    break;
                case R.id.itm_diviertete:
                    mensage = "Diviertete";
                    startActivity(new Intent(Menu.this, BuscaminasActivity.class));
                    break;

            }
        }else {
            if( item.getItemId()==R.id.itm_desarrollador_out)
                    mensage = "Desarrollador kike";

        }

        Toast.makeText(getApplicationContext(), mensage, Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    private void itmSalir(){
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
