package utng.edu.utng.html5apli;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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

import utng.edu.utng.html5apli.grafica.GraphAChartEngineActivity;
import utng.edu.utng.html5apli.util.DBAdapter;

/**
 * Created by kevin on 24/03/2016.
 */
public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lsvMenu;;
    private  String[] contenido;
        private String menu = "";
    private ProgressDialog _progressDialog;
    private int _progress = 0;
    private Handler _progressHandler;
        private MediaPlayer mp;
    private DBAdapter dbAdapter;

        @Override
        protected void onCreate(Bundle  savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu_layout);
            initComponents();
        }

        private void initComponents() {
            dbAdapter=new DBAdapter(this);
            dbAdapter.open();
            contenido=getResources().getStringArray(R.array.conteniodo_lo);
            lsvMenu = (ListView)findViewById(R.id.lsv_menu);
            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.item_layout,
                 R.id.txv_item, contenido);
            lsvMenu.setAdapter(adapter);
            lsvMenu.setOnItemClickListener(this);

            mp = new MediaPlayer().create(this, R.raw.sonido);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mp.start();
            switch (position){
                case 0:
                    startActivity(new Intent(MenuActivity.this, IntroduccionActivity.class ));
                    break;
                case 1:
                    startActivity(new Intent(MenuActivity.this, TemarioActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MenuActivity.this, AprendiendoActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MenuActivity.this, DesarrolladorActivity.class));
                    break;
            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater= getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String mensajeM="";
            switch (item.getItemId()){
                case R.id.itm_actionbar_pro:
                    int elProEse=dbAdapter.getProgreso(LogeoActividad.ID_USUARIO_LOGEADO);
                    Log.e("Progreso", "onOptionsItemSelected: " + elProEse);
                    if (elProEse==6){
                        elProEse=100;
                    }else if(elProEse==5){
                        elProEse=80;
                    }else if (elProEse==4){
                        elProEse=60;
                    }else if (elProEse==3){
                        elProEse=40;
                    }else if (elProEse==2){
                        elProEse=25;
                    }else {
                        elProEse=15;
                    }
                    showDialog(1);
                    _progress = 0;
                    _progressDialog.setProgress(elProEse);
                    _progressHandler = new Handler() {
                        public void handleMessage(Message msg)
                        {
                            super.handleMessage(msg);
                            if (_progress >= 100) {
                                _progressDialog.dismiss();
                            } else {
                                _progress++;
                                _progressHandler.sendEmptyMessageDelayed(50, 100);
                            }
                        }
                    };
                    break;
                case R.id.itm_actionbar_menu_configuraciones_on:
                    startActivity(new Intent(MenuActivity.this,SettingsActivity.class));
                    break;

                case R.id.itm_actionbar_music:

                    mp = new MediaPlayer().create(this, R.raw.fondo);
                    if (mp.isPlaying()){
                        mp.pause();
                    }else
                    mp.start();
                    break;
                case R.id.itm_grafica:
                    startActivity(new Intent(MenuActivity.this,GraphAChartEngineActivity.class));
                    break;
                case R.id.itm_correo:
                    startActivity(new Intent(MenuActivity.this,GmailActivity.class));
                    break;
                case R.id.itm_actionbar_menu_salir_on:
                    finish();
                    Intent intent1=new Intent(Intent.ACTION_MAIN);
                    intent1.addCategory(Intent.CATEGORY_HOME);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent1);
                    break;
            }
            Toast.makeText(getApplicationContext(), mensajeM, Toast.LENGTH_LONG).show();
            return super.onOptionsItemSelected(item);
        }

    /*
    Nos parar la musica de fondo cuando nos vamos a otra actividad
     */
    @Override
    protected void onStop() {
        super.onStop();
        mp.pause();
    }


    @Override
    protected Dialog onCreateDialog(int i) {
        _progressDialog = new ProgressDialog(this);
        _progressDialog.setTitle("Avance del Curso");
        _progressDialog.setIcon(R.mipmap.ic_launcher);
        _progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        _progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Gracias", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        mp.start();
                    }
                });
        return _progressDialog;
    }


}
