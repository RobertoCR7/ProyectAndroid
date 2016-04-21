package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.jasperreport.Quiz.QuizActivity;

/**
 * Created by Erick on 11/02/2016.
 */
public class TabsActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txvInformacion;
    private TextView txvForo;
    private TextView txvExamen;
    private ImageView imvQuiz;
    private ImageView imvVideo;
    private String informacion = "";

    private Bundle valoresRecibidosTab;
    private String urllli="";
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caracteristicas_layout);
        valoresRecibidosTab = getIntent().getExtras();
        Log.i("Tema posicion",""+ valoresRecibidosTab.getInt("posicion"));
        initComponentes();
    }

    private void initComponentes(){
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        Resources resources = getResources();

        TabHost.TabSpec spec = tabHost.newTabSpec("Información");
        spec.setContent(R.id.tab_informacion);
        spec.setIndicator("Información", resources.getDrawable(android.R.drawable.ic_menu_info_details));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Video");
        spec.setContent(R.id.tab_foro);
        spec.setIndicator("Video", resources.getDrawable(android.R.drawable.ic_media_play));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Examen");
        spec.setContent(R.id.tab_examen);
        spec.setIndicator("Examen", resources.getDrawable(android.R.drawable.ic_menu_help));
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);


        txvInformacion = (TextView)findViewById(R.id.txv_informacion);
        txvForo = (TextView)findViewById(R.id.txv_foro);
        txvExamen = (TextView)findViewById(R.id.txv_examen);
        imvQuiz = (ImageView)findViewById(R.id.imv_quiz);
        imvVideo = (ImageView)findViewById(R.id.imvVideo);


        //Pasamos la informacion conforme a la poscicion del tema
        valoresRecibidosTab=getIntent().getExtras();
        switch (valoresRecibidosTab.getInt("posision")){
            case 0:
                informacion = getString(R.string.caracteristicas);
                Log.e("Info 1", "initComponentes: " );
                urllli="https://www.youtube.com/watch?v=NVro7YFqNJU";
                break;
            case 1:
                informacion = getString(R.string.entorno);
                Log.e("Info 2", "initComponentes: " );
                break;
            case 2:
                urllli="https://www.youtube.com/watch?v=DNQs3AwlXiE";
                informacion = getString(R.string.ciclo_vital);
                Log.e("Info 3", "initComponentes: " );
                break;
            case 3:
                informacion = getString(R.string.diseños);
                urllli="https://www.youtube.com/watch?v=FsmZ4-ARfMc";
                Log.e("Info 4", "initComponentes: " );
                break;
            case 4:
                informacion = getString(R.string.compilacion);
                urllli="https://www.youtube.com/watch?v=Zxqh41bB3tY";
                Log.e("Info 5", "initComponentes: " );
                break;
            case 5:
                informacion = getString(R.string.llamado_reportes);
                urllli="https://www.youtube.com/watch?v=Bn4tiquJsSs";
                Log.e("Info 6", "initComponentes: " );
                break;
            case 6:
                informacion = getString(R.string.parametros);
                urllli="https://www.youtube.com/watch?v=yUMtCT-0nEI";
                Log.e("Info 7", "initComponentes: " );
                break;
            case 7:
                informacion = getString(R.string.fuentes_datos);
                urllli="https://www.youtube.com/watch?v=-I_XDVh5yTQ";
                Log.e("Info 8", "initComponentes: " );
                break;
            case 8:
                informacion = getString(R.string.visualizar);
                Log.e("Info 9", "initComponentes: " );
                urllli="https://www.youtube.com/watch?v=OM3XCvV5CVY";
                break;
            case 9:
                Log.e("Info 10", "initComponentes: " );
                informacion = getString(R.string.var);
                urllli="https://www.youtube.com/watch?v=jcgXnyTCgr4";
                break;
        }


        txvInformacion.setText(informacion);
        txvForo.setText(R.string.tab_foro);
        imvQuiz.setOnClickListener(this);
        imvVideo.setOnClickListener(this);


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(),
                        getString(R.string.pestaña_pulsada) + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Pasamos el video de cada tema conforme a su poscicion
    @Override
    public void onClick(View v) {
        valoresRecibidosTab=getIntent().getExtras();
        if (v.getId() == R.id.imvVideo){
            if(valoresRecibidosTab.getInt("posision")==1){
                Toast.makeText(TabsActivity.this, "Video borrado de la red", Toast.LENGTH_SHORT).show();
            }else {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urllli)));
            }
        } else if (v.getId() == R.id.imv_quiz){
            //Llenamos el quiz
            Bundle bundleQuiz = new Bundle();
            bundleQuiz.putInt("posicionTema", valoresRecibidosTab.getInt("posision"));
            startActivity(new Intent(this, QuizActivity.class).putExtras(bundleQuiz));
            finish();
        }
    }
}