package mx.edu.utng.androidjuegos;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.VideoView;

import mx.edu.utng.androidjuegos.util.DBAdapter;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class SeleccionSegundaActividad extends AppCompatActivity implements View.OnClickListener{

    private TextView txvTema;
    private TextView txvTemaConten;
    private String modulo="";
    private String tema="";
    private MediaController mediaController;
    private Uri uri;
    private Button btnExa;
    private Bundle valoresRecibidosSec;
    private Button btnOtroBoton;
    private ProgressDialog _progressDialog;
    private int _progress = 0;
    private Handler _progressHandler;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_seleccion);
        initComponents();
    }

    private void initComponents(){
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        Resources resources = getResources();

        TabHost.TabSpec spec= tabHost.newTabSpec(getString(R.string.tab_info));
        spec.setContent(R.id.tab_info);
        spec.setIndicator(getString(R.string.tab_info), resources.getDrawable(android.R.drawable.ic_input_get));
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec(getString(R.string.tab_video));
        spec.setContent(R.id.tab_video);
        spec.setIndicator(getString(R.string.tab_video), resources.getDrawable(android.R.drawable.presence_video_online));
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec(getString(R.string.tab_examen));
        spec.setContent(R.id.tab_examen);
        spec.setIndicator(getString(R.string.tab_examen), resources.getDrawable(android.R.drawable.ic_lock_idle_lock));
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        txvTema= (TextView) findViewById(R.id.txv_tema);
        txvTemaConten= (TextView) findViewById(R.id.txv_tema_contenido);
       btnOtroBoton = (Button) findViewById(R.id.btn_otro_boton);


        btnExa = (Button)findViewById(R.id.btn_exa);



        valoresRecibidosSec = getIntent().getExtras();

        final VideoView vdvVideo  = (VideoView) findViewById(R.id.video_uno);

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxx
        //Se inicializan los controles para el dieo
        mediaController = new MediaController(this);
        mediaController.setAnchorView(vdvVideo);
        vdvVideo.setMediaController(mediaController);//Se le asignan los controles


        switch (valoresRecibidosSec.getInt("moduloMenuDos")) {
            case 0:
                        modulo = getResources().getString(R.string.modulo1);
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema = getResources().getString(R.string.modtema1);
                       uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");
                        break;
                }
                break;
            case 1:
                modulo = getResources().getString(R.string.modulo2);
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema = getResources().getString(R.string.mod2tm1);
                        uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");

                        break;
                    case 1:
                        tema = getResources().getString(R.string.mod2tm2);
                        uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");

                        break;
                    case 2:
                        tema = getResources().getString(R.string.mod2tm3);
                        uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");

                        break;
                    case 3:
                        tema = getResources().getString(R.string.mod2tm4);
                        uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");

                        break;
                    case 4:
                        tema = getResources().getString(R.string.mod2tm5);
                        uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");

                        break;
                    case 5:
                        tema = getResources().getString(R.string.mod2tm6);
                        uri = Uri.parse("rtsp://r5---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAnzSBFUvwmc_hMYDSANFC2ZTQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/2357620B968AFE3DB48472B021DBCA4344EF1E3C.BA451F8198DD6953E44DB32D20BF2B962C40C9AC/yt6/1/video.3gp");

                        break;
                }
                break;
            case 2:
                modulo = getResources().getString(R.string.modulo3);
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema = getResources().getString(R.string.mod3tm1);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 1:
                        tema = getResources().getString(R.string.mod3tm2);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 2:
                        tema = getResources().getString(R.string.mod3tm3);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 3:
                        tema = getResources().getString(R.string.mod3tm4);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 4:
                        tema = getResources().getString(R.string.mod3tm5);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 5:
                        tema = getResources().getString(R.string.mod3tm6);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 6:
                        tema = getResources().getString(R.string.mod3tm7);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 7:
                        tema = getResources().getString(R.string.mod3tm8);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                    case 8:
                        tema = getResources().getString(R.string.mod3tm9);
                        uri = Uri.parse("rtsp://r9---sn-a5m7ln7s.googlevideo.com/Cj0LENy73wIaNAlHpML7r7oYjBMYDSANFC1EUANXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/449A7A6A3EBAF98D179651FECE4480622329CF43.ABD772085C5470868889284F575C2162499C9E1C/yt6/1/video.3gp");

                        break;
                }
                break;
            case 3:
                modulo = getResources().getString(R.string.modulo4);
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema = getResources().getString(R.string.mod4tm1);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                    case 1:
                        tema = getResources().getString(R.string.mod4tm2);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                    case 2:
                        tema = getResources().getString(R.string.mod4tm3);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                    case 3:
                        tema = getResources().getString(R.string.mod4tm4);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                    case 4:
                        tema = getResources().getString(R.string.mod4tm5);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                    case 5:
                        tema = getResources().getString(R.string.mod4tm6);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                    case 6:
                        tema = getResources().getString(R.string.mod4tm7);
                        uri = Uri.parse("rtsp://r11---sn-a5m7ln7z.googlevideo.com/Cj0LENy73wIaNAlNB9bn0JVJ8RMYDSANFC3TUQNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/B4DE22B09FB8F677D699E79034D42ACC037750A6.36EFDEE359C2C0D42B64DAB050D409C9F5D51C91/yt6/1/video.3gp");

                        break;
                }
                break;
            case 4:
                modulo = getResources().getString(R.string.modulo5);
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema = getResources().getString(R.string.mod5tm1);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 1:
                        tema = getResources().getString(R.string.mod5tm2);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 2:
                        tema = getResources().getString(R.string.mod5tm3);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 3:
                        tema = getResources().getString(R.string.mod5tm4);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 4:
                        tema = getResources().getString(R.string.mod5tm5);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 5:
                        tema = getResources().getString(R.string.mod5tm6);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 6:
                        tema = getResources().getString(R.string.mod5tm7);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 7:
                        tema = getResources().getString(R.string.mod5tm8);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                    case 8:
                        tema = getResources().getString(R.string.mod5tm9);
                        uri = Uri.parse("rtsp://r5---sn-a5mekne7.googlevideo.com/Cj0LENy73wIaNAl7GJJtf5ww6hMYDSANFC1YUgNXMOCoAUIASARgxJ2s74G9vf9WigELcUpvUV9BZjJRcXMM/468982DE687F918C4674E4D2458944F13614A855.D9F2CD22F85BE1143B65C38D73D0C679C063C1/yt6/1/video.3gp");

                        break;
                }
                break;


        }

        vdvVideo.setVideoURI(uri);
        vdvVideo.requestFocus();


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mediaController.hide();
                if (vdvVideo.isPlaying()) {
                    vdvVideo.pause();
                }
            }
        });

        txvTema.setText(modulo);
        txvTemaConten.setText(tema);

        btnExa.setOnClickListener(this);
       btnOtroBoton.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_segundo, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_salir:
                itmSalida();
                break;
            case R.id.itm_grafic:
                startActivity(new Intent(SeleccionSegundaActividad.this, GraficoActivityDos.class));
                break;
        }

    //    Toast.makeText(getApplicationContext(), mensajeM, Toast.LENGTH_LONG).show();
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
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putInt("moduloT", valoresRecibidosSec.getInt("moduloMenuDos"));
        bundle.putInt("temaT", valoresRecibidosSec.getInt("posicionTema"));

        switch (v.getId()){
            case R.id.btn_otro_boton:
                startActivity(new Intent(this, InformacionActivity.class).putExtras(bundle));
                break;
            case R.id.btn_exa:
                startActivity(new Intent(this, QuizActivity.class).putExtras(bundle));
                break;

        }
    }


    @Override
    protected Dialog onCreateDialog(int i) {
        _progressDialog = new ProgressDialog(this);
        _progressDialog.setTitle("El pro");
        _progressDialog.setIcon(R.mipmap.ic_launcher);
        _progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        _progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Gracias ese", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        return _progressDialog;
    }



}
