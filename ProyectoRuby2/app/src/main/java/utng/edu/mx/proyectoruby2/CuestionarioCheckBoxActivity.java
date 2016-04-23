package utng.edu.mx.proyectoruby2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import utng.edu.mx.proyectoruby2.util.DBAdapter;

/**
 * Created by Juan Ramon Delgado Mendoza on 07/03/2016.
 * @author Juan Ramon Delgado Mendoza
 * @email mon-ra16@hotmail.com
 *
 */
public class CuestionarioCheckBoxActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvPreguntaCheckBox;
    private CheckBox chkCajaUno,chkCajaDos,chkCajaTres;
    private Bundle valoresResividos;
    private Button btnComprobarCheckBox;
    private DBAdapter dbAdapter;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_check_box_layout);

        initComponents();
    }

    private void initComponents() {
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        txvPreguntaCheckBox=(TextView)findViewById(R.id.txv_pregunta_ckech_box);
        chkCajaUno=(CheckBox)findViewById(R.id.chk_caja_uno);
        chkCajaDos=(CheckBox)findViewById(R.id.chk_caja_dos);
        chkCajaTres=(CheckBox)findViewById(R.id.chk_caja_tres);
        btnComprobarCheckBox=(Button)findViewById(R.id.btn_comprobar_check_box);

        valoresResividos=getIntent().getExtras();

        switch (valoresResividos.getInt("moduloS")){
            case 0://Modulo 1
                switch (valoresResividos.getInt("posicionTemaS")){
                    case 0: //Sobre ruby
                        txvPreguntaCheckBox.setText("El lenguaje de programación Ruby no fue creado por :");
                        chkCajaUno.setText(" Bjarne Stroustrup");
                        chkCajaDos.setText("Yukihiro \"Matz\" Matsumoto");
                        chkCajaTres.setText("James Gosling");
                        break;
                    case 4://Variables
                        txvPreguntaCheckBox.setText("Si deseo asignarle texto aun variable cual son los delimitadores :");
                        chkCajaUno.setText(" \" ");
                        chkCajaDos.setText(" ' ");
                        chkCajaTres.setText("END_STR");
                        break;
                    case 6://Comentarios
                        txvPreguntaCheckBox.setText("Cuantos tipos de comentarios tiene Ruby:");
                        chkCajaUno.setText(" 3 ");
                        chkCajaDos.setText(" 2 ");
                        chkCajaTres.setText(" 4 ");
                        break;
                    default:
                        break;

                }
                break;
            case 1://Modulo 2
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 0://Ciclos
                        txvPreguntaCheckBox.setText("Cuales de estos son ciclos en Ruby");
                        chkCajaUno.setText(" while ");
                        chkCajaDos.setText(" until ");
                        chkCajaTres.setText(" for ");
                        break;
                    case 4://Mixins
                        txvPreguntaCheckBox.setText("En qué se incluye un mixin");
                        chkCajaUno.setText(" En un método  ");
                        chkCajaDos.setText(" En una clase ");
                        chkCajaTres.setText(" En un mixin ");
                        break;
                    default:
                        break;
                }
                break;
            case 2://Modulo 3
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 0://Strings
                        txvPreguntaCheckBox.setText("Cales son métodos bang? :");
                        chkCajaUno.setText(" upcase! ");
                        chkCajaDos.setText(" slice ");
                        chkCajaTres.setText(" downcase! ");
                        break;
                    default:
                        break;
                }
                break;
            case 3://Modulo 4
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 0://Rangos
                        txvPreguntaCheckBox.setText("Cales son declaraciónes de rangos correctas? :");
                        chkCajaUno.setText(" nums=0..9 ");
                        chkCajaDos.setText(" escala=0..10 ");
                        chkCajaTres.setText(" colec1=0..6 ");
                        break;
                    case 4://Orientado a objetos
                        txvPreguntaCheckBox.setText("Cales son declaraciónes de correctas? :");
                        chkCajaUno.setText(" Una clase es usada para construir un objeto");
                        chkCajaDos.setText(" Una clase e como un modelo para objetos ");
                        chkCajaTres.setText(" Un objeto es la instancia de una clase ");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        btnComprobarCheckBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String respuesta = "Incorrecto";
        //String espacios="\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020";
        int idModul = dbAdapter.idPrimerModuloIns(FormLoginActivity.ID_USU_LOGEADO, "Modulo 1");
        switch (valoresResividos.getInt("moduloS")){
            case 0://Modulo 1
                switch (valoresResividos.getInt("posicionTemaS")){
                    case 0: //Sobre ruby

                        if (chkCajaUno.isChecked()&&chkCajaTres.isChecked()){
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            //Inicia lo del guardado------------------------------------------------------

                            if (valoresResividos.getBoolean("logeo")) {
                                dbAdapter.activarTema(idModul, 1, 1);
                                // boolean act=dbAdapter.temaActivo(1,2,idModul);
                                // Log.e("Tema 2 mod 1:", "onClick: "+act );
                            }else {
                                startActivity(new Intent(CuestionarioCheckBoxActivity.this,TerminoTemaOffActivity.class));
                                finish();
                                //mandarme a un pantalla que diga que Felizitaciones terinaste con extito el tema 1, para poder sergir con el curso te recomenadamos logearte
                                //dos botones uno que diga resgistrarme y otro que diga despues
                            }
                            //Termina lo del guardado------------------------------------------------------
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();

                        break;
                    case 4://Variables

                        if (chkCajaUno.isChecked()&&chkCajaDos.isChecked()){
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 1, 5);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();
                        break;
                    case 6://Comentarios

                        if (chkCajaDos.isChecked()){
                            respuesta = "Correcto; Examen del módulo desbloqueado";
                            dbAdapter.activarTema(idModul, 1, 7);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();
                        break;
                    default:
                        break;

                }
                break;
            case 1://Modulo 2
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 0://Ciclos
                        ///////////////////////////////////////
                        if (chkCajaUno.isChecked()&&chkCajaTres.isChecked()&&chkCajaDos.isChecked()){
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 2, 1);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();
                        ///////////////////////////////////////
                        break;
                    case 4://Mixins
                        if (chkCajaDos.isChecked()){
                            respuesta ="Correcto; Examen del módulo desbloqueado";
                            dbAdapter.activarTema(idModul, 2, 5);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();
                        ///////////////////////////////////////
                        break;
                    default:
                        break;
                }
                break;
            case 2://Modulo 3
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 0://Strings
                        if (chkCajaUno.isChecked()||chkCajaTres.isChecked()){
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 3, 1);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();

                        break;
                    default:
                        break;
                }
                break;
            case 3://Modulo 4
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 0://Rangos
                        if (chkCajaUno.isChecked()||chkCajaDos.isChecked()||chkCajaTres.isChecked()){
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 4, 1);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();
                        break;
                    case 4://Orientado a objetos
                        if (chkCajaUno.isChecked()||chkCajaDos.isChecked()||chkCajaTres.isChecked()){
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 4, 5);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
                        limpiar();
                        finish();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

    }

    private void limpiar(){
        chkCajaUno.setChecked(false);
        chkCajaDos.setChecked(false);
        chkCajaTres.setChecked(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        limpiar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
