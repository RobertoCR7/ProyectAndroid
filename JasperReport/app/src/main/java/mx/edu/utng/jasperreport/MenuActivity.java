package mx.edu.utng.jasperreport;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


import mx.edu.utng.jasperreport.Login.MainActivity;
import mx.edu.utng.jasperreport.Util.DBAdapter;
import mx.edu.utng.jasperreport.grafica.GraphAChartEngineActivity;

/**
*
 */
public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MediaPlayer mpMusica;
    private  String[] contenido;
    private String menu = "";
    private ProgressDialog _progressDialog;
    private int _progress = 0;
    private Handler _progressHandler;
    private MediaPlayer mp;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.replace, Snackbar.LENGTH_LONG)
                        .setAction(R.string.action, null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mpMusica = new MediaPlayer().create(this, R.raw.audio);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.action_configuracion:
                startActivity(new Intent(MenuActivity.this, SettingsActivity.class));
                break;
            case R.id.menu_principal:
                startActivity(new Intent(MenuActivity.this, MenuActivity.class));
                break;
            case R.id.logout:
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
                break;
            case R.id.salir:
                itmSalida();
                break;
            case R.id.ayuda:

                int elProEse=dbAdapter.getProgreso(1);
                Log.e("Numero de temas", "onOptionsItemSelected: "+elProEse );
                //elProEse=elProEse/100;
                Log.e("Progreso", "onOptionsItemSelected: " + elProEse);
                if (elProEse==10){
                    elProEse=100;
                }else if(elProEse==9){
                    elProEse=90;
                }else if (elProEse==8){
                    elProEse=80;
                }else if (elProEse==7){
                    elProEse=70;
                }else if (elProEse==6){
                    elProEse=60;
                }else if (elProEse==5){
                    elProEse=50;
                } else if (elProEse==4){
                    elProEse=40;
                } else if (elProEse==3){
                    elProEse=30;
                } else if (elProEse==2){
                    elProEse=20;
                } else {
                    elProEse=10;
                }
                showDialog(1);
                _progress = 0;
                _progressDialog.setProgress(elProEse);
                //_progressHandler.sendEmptyMessage(0);
                _progressHandler = new Handler(){
                    public void handleMessage(Message msg)
                    {
                        super.handleMessage(msg);
                        if (_progress >= 100) {
                            _progressDialog.dismiss();
                        } else {
                            _progress++;
                            //_progressDialog.incrementProgressBy(1);
                            _progressHandler.sendEmptyMessageDelayed(50, 100);
                        }
                    }
                };

                break;
            case R.id.promocionar:
                startActivity(new Intent(MenuActivity.this, UTNGActivity.class));
                break;
            case R.id.itm_musica_fondo:
                mpMusica.start();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected Dialog onCreateDialog(int i) {
        _progressDialog = new ProgressDialog(this);
        _progressDialog.setTitle("Tu Progreso Del Curso");
        _progressDialog.setIcon(R.mipmap.ic_launcher);
        _progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        _progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //mp.start();
                    }
                });
        return _progressDialog;
    }

    private void itmSalida(){
        finish();
        Intent intent1 = new Intent(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_HOME);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_historia) {
            startActivity(new Intent(MenuActivity.this, HistoriaActivity.class));
        } else if (id == R.id.nav_captitulos) {
            startActivity(new Intent(MenuActivity.this, CapitulosActivity.class));
        } else if (id == R.id.nav_instalacion) {
            startActivity(new Intent(MenuActivity.this, InstalacionActivity.class));
        } else if (id == R.id.nav_agradecimientos) {
            startActivity(new Intent(MenuActivity.this, AgradecimientosActivity.class));
        } else if(id == R.id.nav_material){
            startActivity(new Intent(MenuActivity.this, MaterialDinamicoActivity.class));
        } else if(id == R.id.nav_graficas){
            startActivity(new Intent(MenuActivity.this, GraphAChartEngineActivity.class));
        } else if(id == R.id.nav_email){
            startActivity(new Intent(MenuActivity.this, EjemploEmailActivity.class));
        } else if (id == R.id.nav_desarrollador) {
            startActivity(new Intent(MenuActivity.this, DesarrolladorActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mpMusica.pause();
    }
}
