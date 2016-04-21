package utng.edu.utng.html5apli;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import utng.edu.utng.html5apli.util.DBAdapter;

/**
 * Created by kevin on 08/02/2016.
 */
public class TemarioActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lsvTemario;
    private  String[] temas = {
            "Componentes Básicos",
            "Lista de Elementos",
            "Estructura Global",
            "Estructura del Cuerpo",
            "Dentro del Curpo",
            "Referencia Rapida",};
    private Bundle bundle;
    private String temario = "";
    private Intent intent;
    private MediaPlayer mp;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temario_layout);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        initComponents();
    }

    private void initComponents() {
        lsvTemario = (ListView)findViewById(R.id.lsv_temario);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.item_layout,
                R.id.txv_item, temas);
        lsvTemario.setAdapter(adapter);
        lsvTemario.setOnItemClickListener(this);
        bundle = new Bundle();

        mp = new MediaPlayer().create(this, R.raw.sonido);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mp.start();
        bundle.putInt("posision",position);
        boolean acti=false;
      //  int i=0;
        //Solo
        switch (position){
            case 0:
                acti=dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 1);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 1)){
                    intent=new Intent(TemarioActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TemarioActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                acti=dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 2);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 2)){
                    intent=new Intent(TemarioActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TemarioActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                acti=dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 3);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 3)){
                    intent=new Intent(TemarioActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TemarioActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                acti=dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 4);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 4)){
                    intent=new Intent(TemarioActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TemarioActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                acti=dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 5);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 5)){
                    intent=new Intent(TemarioActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TemarioActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                acti=dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 6);
                Log.e("Tema UNO", "Estatus: "+acti );
                if (dbAdapter.statusTema(LogeoActividad.ID_USUARIO_LOGEADO, 6)){
                    intent=new Intent(TemarioActivity.this,TabsActivity.class).putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TemarioActivity.this, "Tema bloqueado", Toast.LENGTH_SHORT).show();
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
