package utng.edu.mx.java;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

import utng.edu.mx.java.Util.DBAdapter;
import utng.edu.mx.java.grafica.GraphAChartEngineActivity;

/**
 * Created by Gustavo on 04/02/2016.
 */
public class ExampleIndiceActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Bundle valoresResividos;
    private ListView lsvIndice;
    private Intent intent;
    private String[] indices;
    private String[] descripciones;
    private Bundle bundle;
    private MediaPlayer mpSound;
    private ProgressDialog _progressDialog;
    private int _progress = 0;
    private Handler _progressHandler;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_indice_layout);
        initComponents();
    }

    private void initComponents() {
        mpSound = MediaPlayer.create(this, R.raw.cli);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        valoresResividos = getIntent().getExtras();

        lsvIndice = (ListView) findViewById(R.id.lsv_indice);

        if (valoresResividos.getBoolean("logeo")) {
            indices = getResources().getStringArray(R.array.indices_temas);
        } else {
            indices = getResources().getStringArray(R.array.indices_temas_off);
        }
        lsvIndice = (ListView) findViewById(R.id.lsv_indice);

        if (valoresResividos.getBoolean(getString(R.string.logeou))) {
            indices = getResources().getStringArray(R.array.indices_temas);
        } else {
            indices = getResources().getStringArray(R.array.indices_temas_off);
        }


        descripciones = getResources().getStringArray(R.array.descripciones_contenido);
        ArrayAdapter adapter = new ArrayAdapter(getApplication(), R.layout.item_layout, R.id.txv_item, indices);
        lsvIndice.setAdapter(adapter);
        lsvIndice.setOnItemClickListener(this);
        bundle = new Bundle();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mpSound.start();

        bundle.putString("elegido", indices[position]);
        bundle.putInt("posicion", position);
        bundle.putString("descripciones", descripciones[position]);
        bundle.putBoolean(getString(R.string.log),valoresResividos.getBoolean(getString(R.string.log)));

        if ( valoresResividos.getBoolean(getString(R.string.log))) {

            switch (position) {
                case 2:
                    if (dbAdapter.statusTema(MainActivity.ID_USUARIO,1)){
                        startActivity(new Intent(ExampleIndiceActivity.this, ContenidoOnLogeo.class).putExtras(bundle));
                    }else {
                        Toast.makeText(ExampleIndiceActivity.this, "Modulo 1 bloqueado", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3:
                    if (dbAdapter.statusTema(MainActivity.ID_USUARIO,2)) {
                        intent = new Intent(ExampleIndiceActivity.this, ContenidoOnObject.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ExampleIndiceActivity.this, "Modulo 2 bloqueado", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 4:
                    if (dbAdapter.statusTema(MainActivity.ID_USUARIO,3)) {
                        intent = new Intent(ExampleIndiceActivity.this, ContenidoOnClass.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ExampleIndiceActivity.this, "Modulo 3 bloqueado", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 5:
                    if (dbAdapter.statusTema(MainActivity.ID_USUARIO,4)) {
                        intent = new Intent(ExampleIndiceActivity.this, ContenidoOnMethod.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ExampleIndiceActivity.this, "Modulo 4 bloqueado", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 6:
                    if (dbAdapter.statusTema(MainActivity.ID_USUARIO,5)) {
                        intent = new Intent(ExampleIndiceActivity.this, ContenidoOnControl.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ExampleIndiceActivity.this, "Modulo 5 bloqueado", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 7:
                    if (dbAdapter.statusTema(MainActivity.ID_USUARIO,6)) {
                        intent = new Intent(ExampleIndiceActivity.this, ExamenFinal.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ExampleIndiceActivity.this, "Examen Final Bloqueado", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        } else {
            switch (position) {
                case 2:
                    intent = new Intent(ExampleIndiceActivity.this, ContenidoOffActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(ExampleIndiceActivity.this, ContenidoOffActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case 4:
                        intent = new Intent(ExampleIndiceActivity.this, ContenidoOffActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(ExampleIndiceActivity.this, ContenidoOffActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(ExampleIndiceActivity.this, ContenidoOffActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
            }

        }
        switch (position) {
            case 0:
                intent = new Intent(ExampleIndiceActivity.this, SeleccionIndice.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(ExampleIndiceActivity.this, SeleccionIndice.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mpSound.start();
        MenuInflater inflater = getMenuInflater();
        if (valoresResividos.getBoolean("logeo")) {
            inflater.inflate(R.menu.menu_on_logeo_layout, menu);
        } else {
            inflater.inflate(R.menu.menu_off_logeo_layout, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mpSound.start();
        if (valoresResividos.getBoolean("logeo")) {
            switch (item.getItemId()) {
                case R.id.itm_actionbar_menu_progreso_on:
                    ///////ProgresBar Inicio
                    int avances=dbAdapter.getProgreso(MainActivity.ID_USUARIO);
                    Log.e("Total avances", "onOptionsItemSelected: "+avances );
                    //avances=avances-1;
                    if (avances==6){
                        avances=100;
                    }else if (avances==5){
                        avances=84;
                    }else if (avances==4){
                        avances=68;
                    }else if (avances==3){
                        avances=50;
                    }else if (avances==2){
                        avances=33;
                    }else if (avances==1){
                        avances=16;
                    }else {
                        avances=0;
                    }
                    Log.e("Total avances", "onOptionsItemSelected: "+avances );
                    showDialog(1);
                    _progress = 0;
                    _progressDialog.setProgress(avances);
                    _progressHandler = new Handler() {
                        public void handleMessage(Message msg) {
                            super.handleMessage(msg);
                            if (_progress >= 100) {
                                _progressDialog.dismiss();
                            } else {
                                _progress++;
                                _progressHandler.sendEmptyMessageDelayed(50, 100);
                            }
                        }
                    };
                    ///////ProgresBar fin
                    break;
                case R.id.itm_actionbar_menu_juego_on:
                    //JuegoDinamico
                startActivity(new Intent(ExampleIndiceActivity.this,ListaGameActivity.class));
                    break;
                case R.id.itm_actionbar_menu_grafica_on:
                    //Usuario
                   startActivity(new Intent(ExampleIndiceActivity.this, GraphAChartEngineActivity.class));
                    break;
                case R.id.itm_actionbar_menu_configuraciones_on:
                    //Configuración
                    startActivity(new Intent(ExampleIndiceActivity.this, SettingsActivity.class));
                    break;
                case R.id.itm_actionbar_menu_correo_app:
                    //Correo

                    String para = MainActivity.CORREO;
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.setType("text/plain");
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{para});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Certificacion de tu curso en JAVA");
                    email.putExtra(Intent.EXTRA_TEXT,"Felicidades has culminado exitosamente el curso de JAVA, te mandamos tu certificado");
                    email.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File("/sdcard/certificado.jpg")));
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Elige el email de tu preferencia :"));
                    break;
                case R.id.itm_actionbar_menu_desarrollador_on:
                    //Desarrollador
                    startActivity(new Intent(ExampleIndiceActivity.this, DesarrolladorActivity.class));
                    break;
                case R.id.itm_actionbar_menu_salir_on:
                    //Salir
                    itmSalir();
                    break;
            }
        } else {
            switch (item.getItemId()) {
                case R.id.itm_actionbar_menu_desarrollador_off:
                    desarrollador();
                    break;
                case R.id.itm_actionbar_menu_video_off:
                    startActivity(new Intent(ExampleIndiceActivity.this, AudioActividad.class));
                    break;
                case R.id.itm_actionbar_menu_salir_off:
                    itmSalir();
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected Dialog onCreateDialog(int i) {
        _progressDialog = new ProgressDialog(this);
        _progressDialog.setTitle("Avance");
        _progressDialog.setIcon(R.drawable.logavance);
        _progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        _progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        mpSound.start();
                    }
                });
        return _progressDialog;
    }
    private void itmSalir() {
        finish();
        Intent intent1 = new Intent(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_HOME);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }
    private void desarrollador() {
        intent = new Intent(ExampleIndiceActivity.this, DesarrolladorActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    private void ayuda() {
        intent = new Intent(ExampleIndiceActivity.this, PantallaAyudaActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }



}