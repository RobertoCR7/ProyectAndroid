package mx.edu.utng.AplicacionXML;


import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
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

/**
 * Created by Roberto on 15/02/2016.
 */
public class ContentTabsActividad extends AppCompatActivity implements View.OnClickListener{

    private TextView txvTema;
    private TextView txvTemaConten;
    private String modulo="";
    private String tema="";
    private TextView txvVideo;
    private VideoView vwVideo;
    private MediaController mediaController;
    private Uri uri;
    private Button btnIrExam;
    private Button btnGrafica;
    private   Bundle valoresRecibidosSec;
    private Bundle bundle;
    private Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_seleccion);
        initComponents();
    }

    private void initComponents(){
        bundle=new Bundle();
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

        btnIrExam = (Button)findViewById(R.id.btn_exa);
        btnGrafica = (Button)findViewById(R.id.btn_grafica);




        valoresRecibidosSec = getIntent().getExtras();

        final VideoView vdvVideo  = (VideoView) findViewById(R.id.video_uno);

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxx
        //Se inicializan los controles para el dieo
        mediaController = new MediaController(this);
        mediaController.setAnchorView(vdvVideo);
        vdvVideo.setMediaController(mediaController);//Se le asignan los controles



        bundle.putInt("modulo",valoresRecibidosSec.getInt("menu_principalD"));
        bundle.putInt("tema",valoresRecibidosSec.getInt("posicionTema"));

        switch (valoresRecibidosSec.getInt("menu_principalD")) {
            case 0:
                modulo = "Modulo 1";
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema =getResources().getString(R.string.subtemaUno);
                        uri = Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC2w3hVXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/C521AEB855A2C5ACFC130373DB35D1C048607273.D4A6ACAF9415990BF78B95AE89E07885212BDBF0/yt6/1/video.3gp");
                        break;
                    default:
                }

                break;

            case 1:
                modulo = "Modulo 2";
                switch (valoresRecibidosSec.getInt("posicionTema")) {
                    case 0:
                        tema =getResources().getString(R.string.subtemaDos);
                        uri = Uri.parse("rtsp://r2---sn-a5m7lner.googlevideo.com/Cj0LENy73wIaNAk0WZDgo0XCURMYDSANFC1i8hZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/4DA1A025A4839BEA32E34237529924C60844D996.8A7226479E9B20562DCCDBACA3E6CFDE9995927B/yt6/1/video.3gp");

                        break;
                    case 1:
                        tema =getResources().getString(R.string.subtemaTres);
                        uri = Uri.parse("rtsp://r2---sn-a5m7lner.googlevideo.com/Cj0LENy73wIaNAk0WZDgo0XCURMYDSANFC1i8hZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/4DA1A025A4839BEA32E34237529924C60844D996.8A7226479E9B20562DCCDBACA3E6CFDE9995927B/yt6/1/video.3gp");
                        break;
                    case 2:
                        tema =getResources().getString(R.string.subtemaCuatro);
                        uri = Uri.parse("rtsp://r2---sn-a5m7lner.googlevideo.com/Cj0LENy73wIaNAk0WZDgo0XCURMYDSANFC1i8hZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/4DA1A025A4839BEA32E34237529924C60844D996.8A7226479E9B20562DCCDBACA3E6CFDE9995927B/yt6/1/video.3gp");
                        break;
                    case 3:
                        tema =getResources().getString(R.string.subtemaCinco);
                        uri = Uri.parse("rtsp://r2---sn-a5m7lner.googlevideo.com/Cj0LENy73wIaNAk0WZDgo0XCURMYDSANFC1i8hZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/4DA1A025A4839BEA32E34237529924C60844D996.8A7226479E9B20562DCCDBACA3E6CFDE9995927B/yt6/1/video.3gp");
                        break;
                    case 4:
                        tema =getResources().getString(R.string.subtemaSeis);
                        uri = Uri.parse("rtsp://r2---sn-a5m7lner.googlevideo.com/Cj0LENy73wIaNAk0WZDgo0XCURMYDSANFC1i8hZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/4DA1A025A4839BEA32E34237529924C60844D996.8A7226479E9B20562DCCDBACA3E6CFDE9995927B/yt6/1/video.3gp");
                        break;
                    default:
                }
                break;
            case 2:
                modulo = "Modulo 3";
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema =getResources().getString(R.string.subtemaSiete);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 1:
                        tema =getResources().getString(R.string.subtemaOcho);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 2:
                        tema =getResources().getString(R.string.subtemaNueve);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 3:
                        tema =getResources().getString(R.string.subtemaDiez);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 4:
                        tema =getResources().getString(R.string.subtemaOnce);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 5:
                        tema =getResources().getString(R.string.subtemaDoce);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 6:
                        tema =getResources().getString(R.string.subtemaTrece);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 7:
                        tema =getResources().getString(R.string.subtemaCatorce);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    case 8:
                        tema =getResources().getString(R.string.subtemaQuince);
                        uri =Uri.parse("rtsp://r9---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkvQiKNNHg8lxMYDSANFC0b8xZXMOCoAUIASARgi9rmu8HO-4hXigELMEFkaXRQQU4zOTgM/77987026C60AD0632C3FD1275FCC2A7D714A45AD.614F33D0751D3626BD286309D6A1078AD3AB92E4/yt6/1/video.3gp");
                        break;
                    default:
                }
                break;



            case 3:
                modulo = "Modulo 4";
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema =getResources().getString(R.string.subtemaDieciséis);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    case 1:
                        tema =getResources().getString(R.string.subtemaDiecisiete);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    case 2:
                        tema =getResources().getString(R.string.subtemaDieciocho);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    case 3:
                        tema =getResources().getString(R.string.subtemaDiecinueve);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    case 4:
                        tema =getResources().getString(R.string.subtemaVeinte);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    case 5:
                        tema =getResources().getString(R.string.subtemaVeintiuno);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    case 6:
                        tema =getResources().getString(R.string.subtemaVeintidos);
                        uri=Uri.parse("rtsp://r18---sn-a5m7lnes.googlevideo.com/Cj0LENy73wIaNAkOAMKUrRlvOxMYDSANFC1Z9RZXMOCoAUIASARglaTdsNbUiYRXigELaGJ2RkVQc2djZHcM/36893D236B49CC5B0490BC1B67FBB3944E1F99A9.28FF83C4F083DE590F6BF3E492D57AFE1563EFE9/yt6/1/video.3gp");
                        break;
                    default:
                }
                break;
/*
* Disculpe profe los temas de abajo no los puse en los strings por que es codigo y me marcaba muchos errores
* */
            case 4:
                modulo = "Modulo 5";
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        tema = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n" +
                                "< frutas >\n" +
                                "   < fruta >\n" +
                                "      < nombre >cereza< nombre \\>\n" +
                                "   < fruta \\>\n" +
                                "   < fruta >\n" +
                                "      < nombre >naranja< nombre \\>\n" +
                                "   < fruta \\>\n" +
                                "< frutas \\>";
                        uri=Uri.parse("rtsp://r2---sn-a5m7lne6.googlevideo.com/Cj0LENy73wIaNAmZtH6r1DSQuhMYDSANFC1Z9hZXMOCoAUIASARgtqK14ceXvYtXigELN3hfWW9mSTVWc3cM/28F7B8A4C4B4B1C71BD93FFCCD774BB014517AA2.0E96A0E515F11D85E2FC4D0492C6E1CDEE996334/yt6/1/video.3gp");
                        break;
                    case 1:

                        tema = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<figuras> \n" +
                                "   <figura plana>\n" +
                                "      <nombre>cuadrado</nombre>\n" +
                                "      </lados 4>\n" +
                                "   </figura>\n" +
                                "   <figura plana>\n" +
                                "      <nombre>triángulo</nombre>\n" +
                                "      </lados 3>\n" +
                                "   </figura>\n" +
                                "   <figura tridimensional>\n" +
                                "      <nombre>cubo</nombre>\n" +
                                "      </aristas 12>\n" +
                                "      </caras 6>\n" +
                                "   </figura>\n" +
                                "</figuras>";
                        uri=Uri.parse("rtsp://r2---sn-a5m7lne6.googlevideo.com/Cj0LENy73wIaNAmZtH6r1DSQuhMYDSANFC1Z9hZXMOCoAUIASARgtqK14ceXvYtXigELN3hfWW9mSTVWc3cM/28F7B8A4C4B4B1C71BD93FFCCD774BB014517AA2.0E96A0E515F11D85E2FC4D0492C6E1CDEE996334/yt6/1/video.3gp");
                        break;
                    case 2:

                        tema = "<?Xml version=\"1,0\" encoding=\"UTF8\"?>\n" +
                                "<triangulo base=\"7\"altura=\"5\">\n" +
                                "<triangulo base=\"2\"altura=\"6\">\n" +
                                "<triangulo base=\"3\"altura=\"3\">";
                        uri=Uri.parse("rtsp://r2---sn-a5m7lne6.googlevideo.com/Cj0LENy73wIaNAmZtH6r1DSQuhMYDSANFC1Z9hZXMOCoAUIASARgtqK14ceXvYtXigELN3hfWW9mSTVWc3cM/28F7B8A4C4B4B1C71BD93FFCCD774BB014517AA2.0E96A0E515F11D85E2FC4D0492C6E1CDEE996334/yt6/1/video.3gp");
                        break;
                    case 3:

                        tema = "?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<numeros>\n" +
                                "   <1 letra=\"u\" letra=\"n\" letra=\"o\">1</>\n" +
                                "   <2 letra=\"d\" letra=\"o\" letra=\"s\">22</>\n" +
                                "   <6 letra=\"s\" letra=\"e\" letra=\"i\" letra=\"s\">666666</>\n" +
                                "</numeros>";
                        uri=Uri.parse("rtsp://r2---sn-a5m7lne6.googlevideo.com/Cj0LENy73wIaNAmZtH6r1DSQuhMYDSANFC1Z9hZXMOCoAUIASARgtqK14ceXvYtXigELN3hfWW9mSTVWc3cM/28F7B8A4C4B4B1C71BD93FFCCD774BB014517AA2.0E96A0E515F11D85E2FC4D0492C6E1CDEE996334/yt6/1/video.3gp");
                        break;
                    case 4:

                        tema = "<?xml version=\"1.0\"?>\n" +
                                "<CAT>\n" +
                                "  <NAME>Izzy</NAME>\n" +
                                "  <BREED>Siamese</BREED>\n" +
                                "  <AGE>6</AGE>\n" +
                                "  <ALTERED>yes</ALTERED>\n" +
                                "  <DECLAWED>no</DECLAWED>\n" +
                                "  <LICENSE>Izz138bod</LICENSE>\n" +
                                "  <OWNER>Colin Wilcox</OWNER>\n" +
                                "</CAT>";
                        uri=Uri.parse("rtsp://r2---sn-a5m7lne6.googlevideo.com/Cj0LENy73wIaNAmZtH6r1DSQuhMYDSANFC1Z9hZXMOCoAUIASARgtqK14ceXvYtXigELN3hfWW9mSTVWc3cM/28F7B8A4C4B4B1C71BD93FFCCD774BB014517AA2.0E96A0E515F11D85E2FC4D0492C6E1CDEE996334/yt6/1/video.3gp");
                        break;
                    case 5:
                        tema =getResources().getString(R.string.subtemaVeintitres);
                        uri=Uri.parse("rtsp://r2---sn-a5m7lne6.googlevideo.com/Cj0LENy73wIaNAmZtH6r1DSQuhMYDSANFC1Z9hZXMOCoAUIASARgtqK14ceXvYtXigELN3hfWW9mSTVWc3cM/28F7B8A4C4B4B1C71BD93FFCCD774BB014517AA2.0E96A0E515F11D85E2FC4D0492C6E1CDEE996334/yt6/1/video.3gp");
                        break;
                    default:
                }
                break;

        }

        txvTema.setText(modulo);
        txvTemaConten.setText(tema);


        txvTema.setText(modulo);
        txvTemaConten.setText(tema);

        btnIrExam.setOnClickListener(this);
        btnGrafica.setOnClickListener(this);
        vdvVideo.setVideoURI(uri);
        vdvVideo.requestFocus();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_segundo, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itm_salir:
                itmSalida();
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_exa:
                startActivity(new Intent(this, QuizActivity.class).putExtras(bundle));
                break;
            case R.id.btn_grafica:
                startActivity(new Intent(this, GraficoActivityDos.class).putExtras(bundle));
                break;
            default:
                break;

        }


    }


}
