package utng.edu.mx.proyectoruby2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Juan Ramon Delgado Mendoza on 07/03/2016.
 * @author Juan Ramon Delgado Mendoza
 * @email mon-ra16@hotmail.com
 *
 */
public class SeleccionTabActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvTema;
    private TextView txvTemaContenido;
    private String contDelTem="";
    private MediaController mediaController;
    private Uri uri;
    private Bundle valoresRecibidosSec;
    private Bundle bundle;
    private Button btnTabInfoEvaluacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_tab_tema_layout);
        initComponents();
    }
    private void initComponents(){
        final TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        //Para el tab de informacion
        TabHost.TabSpec spec=tabHost.newTabSpec(getString(R.string.tab_informacon));
        spec.setContent(R.id.tab_informacion);
        spec.setIndicator(getString(R.string.tab_informacon), getResources().getDrawable(R.drawable.ic_info));
        tabHost.addTab(spec);
        //Para el tab de Video
        spec=tabHost.newTabSpec(getString(R.string.tab_video));
        spec.setContent(R.id.tab_video);
        spec.setIndicator(getString(R.string.tab_video), getResources().getDrawable(R.drawable.ic_video));
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);

        txvTema= (TextView) findViewById(R.id.txv_tema);
        txvTemaContenido= (TextView) findViewById(R.id.txv_tema_contenido);
        btnTabInfoEvaluacion=(Button)findViewById(R.id.btn_tab_info_evaluacion);

        btnTabInfoEvaluacion.setOnClickListener(this);

        valoresRecibidosSec = getIntent().getExtras();
        //txvTema.setText(valoresRecibidosSec.getString("temaElegido"));
        bundle=new Bundle();

        //Se almacenan los datos utilizables a un bundel
        bundle.putInt("moduloS",valoresRecibidosSec.getInt("modulo"));
        bundle.putInt("posicionTemaS",valoresRecibidosSec.getInt("posicionTema"));
        bundle.putString("temaElegidoS",valoresRecibidosSec.getString("temaElegido"));

        //Se Vincula el video
        final Button vdvVideo  = (Button) findViewById(R.id.vdv_video);

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxx
        //Se inicializan los controles para el dieo
        mediaController = new MediaController(this);
        mediaController.setAnchorView(vdvVideo);

        switch (valoresRecibidosSec.getInt("modulo")){
            case 0:
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0://Sobre ruby
                        contDelTem=getResources().getString(R.string.html_uno_sobre_ruby);
                        uri = Uri.parse("https://www.youtube.com/watch?v=R3MhA8vWGsg");
                        break;
                    case 1://Medio ambiente de configuración
                        contDelTem=getResources().getString(R.string.html_uno_medio_ambiente_configuracion);
                        uri = Uri.parse("https://www.youtube.com/watch?v=o0vQ0Jfq5ls&list=PLvimn1Ins-41I74OfEUG_RTIX7wXl19E8");
                        break;
                    case 2://Sintaxis
                        contDelTem=getResources().getString(R.string.html_uno_sintaxis);
                        uri = Uri.parse("https://www.youtube.com/watch?v=u5wVtsjsSY4");
                        break;
                    case 3://Palabras reservadas
                        contDelTem=getResources().getString(R.string.html_uno_palabras_reservadas);
                        uri = Uri.parse("https://www.youtube.com/watch?v=ECFMXgq95VQ");
                        break;
                    case 4://Variables
                        contDelTem=getResources().getString(R.string.html_uno_variables);
                        uri = Uri.parse("https://www.youtube.com/watch?v=R9u32kMdslE");
                        break;
                    case 5://Operadores
                        contDelTem=getResources().getString(R.string.html_uno_operadores);
                        uri = Uri.parse("https://www.youtube.com/watch?v=UDA-Obk1JKU");
                        break;
                    case 6://Comentarios
                        contDelTem=getResources().getString(R.string.html_uno_comentarios);
                        uri = Uri.parse("https://www.youtube.com/watch?v=zyFoG48fU60");
                        break;
                    default:

                        break;
                }
                break;
            case 1:

                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        contDelTem=getResources().getString(R.string.html_dos_ciclos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=v-fwa6VcIKk");
                        break;
                    case 1:
                        contDelTem=getResources().getString(R.string.html_dos_metodos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=2A2RrMdXEpI");
                        break;
                    case 2:
                        contDelTem=getResources().getString(R.string.html_dos_bloques);
                        uri = Uri.parse("https://www.youtube.com/watch?v=tiorImN-0Ak");
                        break;
                    case 3:
                        contDelTem=getResources().getString(R.string.html_dos_modulos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=cEaYmci1nks");
                        break;
                    case 4:
                        contDelTem=getResources().getString(R.string.html_dos_mix);
                        uri = Uri.parse("https://www.youtube.com/watch?v=azb7NxHsZkI");
                        break;
                    default:
                        break;
                }
                break;
            case 2:

                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        contDelTem=getResources().getString(R.string.html_tres_strings);
                        uri = Uri.parse("https://www.youtube.com/watch?v=BDHOkQiWAv0");
                        break;
                    case 1:
                        contDelTem=getResources().getString(R.string.html_tres_arreglos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=F9WRA0cDOZ4");
                        break;
                    case 2:
                        contDelTem=getResources().getString(R.string.html_tres_hashes);
                        uri = Uri.parse("https://www.youtube.com/watch?v=_3khk6o2We4");
                        break;
                    case 3:
                        contDelTem=getResources().getString(R.string.html_tres_fecha_hora);
                        uri = Uri.parse("https://www.youtube.com/watch?v=AeZGmXP0Vq8");
                        break;
                    default:

                        break;
                }
                break;
            case 3:

                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        contDelTem=getResources().getString(R.string.html_cuatro_rangos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=n1pTgBuq3uQ");
                        break;
                    case 1:
                        contDelTem=getResources().getString(R.string.html_cuatro_iteradores);
                        uri = Uri.parse("https://www.youtube.com/watch?v=n1pTgBuq3uQ");
                        break;
                    case 2:
                        contDelTem=getResources().getString(R.string.html_cuatro_directorios);
                        uri = Uri.parse("https://www.youtube.com/watch?v=8zepv7QqXEc");
                        break;
                    case 3:
                        contDelTem=getResources().getString(R.string.html_cuatro_excepciones);
                        uri = Uri.parse("https://www.youtube.com/watch?v=p7o9vrd8qe8");
                        break;
                    case 4:
                        contDelTem=getResources().getString(R.string.html_cuatro_orientado_objetos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=63ql0nDPVU0");
                        break;
                    case 5:
                        contDelTem=getResources().getString(R.string.html_cuatro_expreciones_regulares);
                        uri = Uri.parse("https://www.youtube.com/watch?v=yzhIF68VG5g");
                        break;
                    default:

                        break;
                }
                break;
            default:

                break;
        }

        vdvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        txvTema.setText(valoresRecibidosSec.getString("nombreModulo")+": "+valoresRecibidosSec.getString("temaElegido"));
        CharSequence textoInterpretado = Html.fromHtml(contDelTem);
        txvTemaContenido.setText(textoInterpretado);

        //menda el mensaje de que pestaña fue oprimid
    }

    @Override
    public void onClick(View v) {

        byte posicionTmea= (byte) (valoresRecibidosSec.getInt("posicionTema")+1);//Se le aumenta uno ya que la posicion empiesa desde 0.
        byte pares= (byte) (posicionTmea%2);
        bundle.putBoolean("logeo",valoresRecibidosSec.getBoolean("logeo"));
        if (posicionTmea==3|posicionTmea==6){//EditText
            //3,6 ---> se le va arestar uno cunado se pase en el suich de los cuises
            startActivity(new Intent(this, CuestionarioEditTextActivity.class).putExtras(bundle));

        }else if (pares==0){//RadioButton

            startActivity(new Intent(this, CuestionarioRadioButtonActivity.class).putExtras(bundle));
            //2,4  ---> se le va arestar uno cunado se pase en el suich de los cuises

        }else {//Checkbox

            startActivity(new Intent(this, CuestionarioCheckBoxActivity.class).putExtras(bundle));
            //1,5,7 ---> se le va arestar uno cunado se pase en el suich de los cuises
        }
        finish();
    }
}