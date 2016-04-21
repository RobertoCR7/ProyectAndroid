package mx.edu.utng.ctutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Enrique on 03/03/2016.
 */
public class ContenidoTema extends AppCompatActivity {
    private TextView txvTituloTema;
    private TextView txvContenidoTema;
    private Bundle valoresResividosC;
    private String contenidoTemas="";
    private ImageView imvCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_tema_layout);
        initComponents();
    }
    private void initComponents(){
        txvTituloTema= (TextView) findViewById(R.id.txv_titulo_tema);
        txvContenidoTema= (TextView) findViewById(R.id.txv_contenido_tema);
        valoresResividosC=getIntent().getExtras();


        txvTituloTema.setText(valoresResividosC.getString("nombreTema"));
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.lil_contenido);
        switch (valoresResividosC.getInt("moduloElegidoPosision")){
            case 0:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:
                        contenidoTemas="";
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:

                        contenidoTemas=getString(R.string.structureOfaProgram) +
                                getString(R.string.StructureOfPprogram);
                        imvCodigo= new ImageView(this);
                        imvCodigo.setImageResource(R.drawable.codigo);
                        linearLayout.addView(imvCodigo);
                        break;
                    case 1:
                        contenidoTemas=getString(R.string.datatype) +
                                getString(R.string.dataType1) +
                                getString(R.string.dataType2);
                        imvCodigo= new ImageView(this);
                        imvCodigo.setImageResource(R.drawable.tiposdatos);
                        linearLayout.addView(imvCodigo);
                        break;
                    case 2:
                        contenidoTemas=getString(R.string.contants) +
                                getString(R.string.contants1) +
                                getString(R.string.contants2) +
                                getString(R.string.contants3) +
                                getString(R.string.contants4) +
                                getString(R.string.contants5);
                        break;
                    case 3:
                        contenidoTemas=getString(R.string.opertators) +
                                "\n" +
                                getString(R.string.operators1);
                        imvCodigo= new ImageView(this);
                        imvCodigo.setImageResource(R.drawable.operadores);
                        linearLayout.addView(imvCodigo);
                        break;
                    case 4:
                        contenidoTemas=getString(R.string.inpuot);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:
                        contenidoTemas=getString(R.string.control) +
                                "\n" +
                                getString(R.string.control1);
                        imvCodigo= new ImageView(this);
                        imvCodigo.setImageResource(R.drawable.controlestructura);
                        linearLayout.addView(imvCodigo);
                        break;
                    case 1:
                        contenidoTemas=getString(R.string.finction1) +
                                getString(R.string.function1_1) +
                                getString(R.string.function1_2) +
                                "\n" +
                                getString(R.string.function1_3) +
                                " \n" +
                                getString(R.string.function1_4) +
                                "\n" +
                                getString(R.string.functio1_5) +
                                "\n" +
                                getString(R.string.function1_6) +
                                "\n" +
                                getString(R.string.function1_7) ;
                        imvCodigo= new ImageView(this);
                        imvCodigo.setImageResource(R.drawable.funcionuno);
                        linearLayout.addView(imvCodigo);

                        break;
                    case 2:
                        contenidoTemas=getString(R.string.function2) +
                                getString(R.string.function2_1);
                        imvCodigo= new ImageView(this);
                        imvCodigo.setImageResource(R.drawable.funciondos);
                        linearLayout.addView(imvCodigo);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:
                        contenidoTemas=getString(R.string.array) +
                                getString(R.string.array1);
                        break;
                    case 1:
                        contenidoTemas="dos 3";
                        break;
                    case 2:
                        contenidoTemas="tres 3";
                        break;
                    case 3:
                        contenidoTemas="cuatro 3";
                        break;
                    case 4:
                        contenidoTemas="cinco 3";
                        break;
                    case 5:
                        contenidoTemas="seis 3";
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:
                        contenidoTemas="uno 4";
                        break;
                    case 1:
                        contenidoTemas="dos 4";
                        break;
                    case 2:
                        contenidoTemas="tres 4";
                        break;
                    case 3:
                        contenidoTemas="cuatro 4";
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:
                        contenidoTemas="uno 5";
                        break;
                    case 1:
                        contenidoTemas="dos 5";
                        break;
                    case 2:
                        contenidoTemas="tres 5";
                        break;
                    case 3:
                        contenidoTemas="cuatro 5";
                        break;
                    case 4:
                        contenidoTemas="cinco 5";
                        break;
                    default:
                        break;
                }
                break;
            case 6:
                switch (valoresResividosC.getInt("posisionTema")){
                    case 0:
                        contenidoTemas="uno 6";
                        break;
                    case 1:
                        contenidoTemas="dos 6";
                        break;
                    case 2:
                        contenidoTemas="tres 6";
                        break;
                    case 3:
                        contenidoTemas="cuatro 6";
                        break;
                    case 4:
                        contenidoTemas="cinco 6";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        txvContenidoTema.setText(contenidoTemas);
    }
}
