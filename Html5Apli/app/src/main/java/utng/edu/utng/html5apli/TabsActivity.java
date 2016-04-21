package utng.edu.utng.html5apli;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by kevin on 11/02/2016.
 */
public class TabsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvInformacion;
    private String informacionTemas = "";
    private ImageView imvIrQuiz;
    private Bundle getValoresRecibidotes;
    private ImageView imgIrVideo;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_layout);
        initComponents();
    }

    private void initComponents() {

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        Resources resources = getResources();

        TabHost.TabSpec spec = tabHost.newTabSpec("Información");
        spec.setContent(R.id.tab_videos);
        spec.setIndicator("Informacion", resources.getDrawable(android.R.drawable.ic_dialog_info));

        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Videos");
        spec.setContent(R.id.tab_audio);
        spec.setIndicator("Videos", resources.getDrawable(android.R.drawable.ic_media_play));

        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Quiz");
        spec.setContent(R.id.tab_examen);
        spec.setIndicator("Quiz", resources.getDrawable(android.R.drawable.ic_dialog_info));

        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);

        txvInformacion = (TextView) findViewById(R.id.txv_info_tab);
        imvIrQuiz = (ImageView) findViewById(R.id.imv_quiz);

        getValoresRecibidotes=getIntent().getExtras();



        imgIrVideo=(ImageView) findViewById(R.id.imv_video);
        imgIrVideo.setOnClickListener(this);

        switch (getValoresRecibidotes.getInt("posision")){
            case 0:
                informacionTemas=getResources().getString(R.string.info_componentes_basicos) + "\n\n "+
                getResources().getString(R.string.info_componentes_basicos_Dos)+ "\n\n "+
                getResources().getString(R.string.info_componentes_basicos_Tres)+ "\n\n "+
                getResources().getString(R.string.info_componentes_basicos_Cuatro);

                break;
            case 1:
                informacionTemas=getResources().getString(R.string.info_lista_elementos);
                break;
            case 2:
                informacionTemas=getResources().getString(R.string.info_estructura_global);

                break;
            case 3:
                informacionTemas=getResources().getString(R.string.estructura) + "\n\n "+
                        getResources().getString(R.string.estructuraUno)+ "\n\n "+
                        getResources().getString(R.string.estructuraOrg)+ "\n\n "+
                        getResources().getString(R.string.estructura4);

                break;
            case 4:
                informacionTemas=getResources().getString(R.string.dentro_cuerpo);
                break;
            case 5:
                informacionTemas=getResources().getString(R.string.info_referencias_rapidas);
                break;
        }

        txvInformacion.setText(informacionTemas);
        imvIrQuiz.setOnClickListener(this);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(), "Pestaña pulsada: "+tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imv_video) {

            switch (getValoresRecibidotes.getInt("posision")){
                case 0:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1hqTCYFKNVE")));
                    break;
                case 1:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=F-cDjBkSRT4")));

                    break;
                case 2:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qCSskjd1Mxs")));
                    break;
                case 3:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Wjgv2GJUe2I&list=PLU8oAlHdN5BnX63lyAeV0LzLnpGudgRrK&index=4")));
                    break;
                case 4:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EX0peVQn-xI")));
                    break;
                case 5:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CKnJQInkmLM")));
                    break;
            }

        }else {
            Bundle bundleOPPs = new Bundle();
            bundleOPPs.putInt("posicionTema", getValoresRecibidotes.getInt("posision"));
            startActivity(new Intent(this, QuizActivity.class).putExtras(bundleOPPs));
        }
    }
}
