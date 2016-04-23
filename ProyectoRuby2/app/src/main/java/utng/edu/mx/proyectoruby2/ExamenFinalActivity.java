package utng.edu.mx.proyectoruby2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import utng.edu.mx.proyectoruby2.util.DBAdapter;

/**
 * Created by Juan Ramon Delgado Mendoza on 07/03/2016.
 * @author Juan Ramon Delgado Mendoza
 * @email mon-ra16@hotmail.com
 *
 */
public class ExamenFinalActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvPreguntaUno,txvPreguntaDos,txvPreguntaTres, txvPreguntaCuatro,txvPreguntaCinco;
    private Button btnComprobar;
    private RadioGroup rgbGrupoUno, rgbGrupoDos;
    private CheckBox chkUno,chkDos,chkTres,chkUnoDos,chkDosDos,chkTresDos;
    private TextView txvParteUno,txvParteTres;
    private EditText edtParteDos;
    private RadioButton rbtOpcionUno,rbtOpcionDos,rbtOpcionUnoDos,rbtOpcionDosDos;
    //Timepo
    private TextView txvTiempo,txvTituloExam;

    int calificacion=0;
    private Bundle valorResividos;
    private Bundle bundle;
    //SQlite
    private DBAdapter dbAdapter;
    CounterClass timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen_final_layout);
        initComponents();
    }//nombreModulo

    private void initComponents() {
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        valorResividos =getIntent().getExtras();
        bundle=new Bundle();
        //TXV de las preguntas
        txvPreguntaUno=(TextView)findViewById(R.id.txv_pregunta_uno);
        txvPreguntaDos=(TextView)findViewById(R.id.txv_pregunta_dos);
        txvPreguntaTres=(TextView)findViewById(R.id.txv_pregunta_tres);
        txvPreguntaCuatro =(TextView)findViewById(R.id.txv_pregunta_cuatro);
        txvPreguntaCinco=(TextView)findViewById(R.id.txv_pregunta_cinco);
        //TXV extras
        txvTituloExam=(TextView)findViewById(R.id.titulo_exam);
        //BTN para comprobar
        btnComprobar=(Button)findViewById(R.id.btn_comprobar);
        //RGB de los radio
        rgbGrupoUno =(RadioGroup)findViewById(R.id.rbg_opciones_uno);
        rgbGrupoDos =(RadioGroup)findViewById(R.id.rbg_opciones_dos);
        //RBT radio
        rbtOpcionUno =(RadioButton)findViewById(R.id.rbt_repuesta_uno);
        rbtOpcionDos =(RadioButton)findViewById(R.id.rbt_repuesta_dos);
        rbtOpcionUnoDos =(RadioButton)findViewById(R.id.rbt_repuesta_uno_dos);
        rbtOpcionDosDos =(RadioButton)findViewById(R.id.rbt_repuesta_dos_dos);
        //CHK
        chkUno=(CheckBox)findViewById(R.id.chk_caja_uno);
        chkDos=(CheckBox)findViewById(R.id.chk_caja_dos);
        chkTres=(CheckBox)findViewById(R.id.chk_caja_tres);
        chkUnoDos=(CheckBox)findViewById(R.id.chk_caja_uno_dos);
        chkDosDos=(CheckBox)findViewById(R.id.chk_caja_dos_dos);
        chkTresDos=(CheckBox)findViewById(R.id.chk_caja_tres_dos);
        //Equipo
        txvParteUno=(TextView)findViewById(R.id.txv_parte_uno);
        txvParteTres=(TextView)findViewById(R.id.txv_parte_tres);
        edtParteDos=(EditText)findViewById(R.id.edt_parte_dos);

        //Tiempo
        txvTiempo=(TextView)findViewById(R.id.tiempo);
        txvTiempo.setText("00:01:00");

        timer = new CounterClass(90000, 1000);
        timer.start();

        txvTituloExam.setText(valorResividos.getString("nombreModulo"));
        switch (valorResividos.getInt("numeroExamne")){
            case 1:
                txvPreguntaUno.setText("1\n¿Que se teclea en el cmd para obtener la version de ruby instalada?");
                rbtOpcionUno.setText("ruby -v");
                rbtOpcionDos.setText("ruby -V");

                txvPreguntaDos.setText("2\n¿Cuales de estas son palabras reservada?\n(Elige dos)");
                chkUno.setText("brake");
                chkDos.setText("case");
                chkTres.setText("nil");

                txvPreguntaTres.setText("3\nDeclarar una variable de classe con el nombre de \" VAR_UNO \"" );
                txvParteUno.setText("");
                //edtParteDos
                txvParteTres.setText("");

                txvPreguntaCuatro.setText("4\nSi quiero comparar dos variables enteras ¿que tipo de operador necesito?");
                rbtOpcionUnoDos.setText("Aritmético");
                rbtOpcionDosDos.setText("Relacional");

                txvPreguntaCinco.setText("5\n¿Como se inicia un comentario en ruby?\n(Elige dos)");
                chkUnoDos.setText("=begin");
                chkDosDos.setText("//");
                chkTresDos.setText("#");
                break;
            case 2: ///////-----------------------------------------------aqui me quede
                txvPreguntaUno.setText("1\nRuby tiene soporte a los ciclos tradicionales");
                rbtOpcionUno.setText("Cierto");
                rbtOpcionDos.setText("Falso");

                txvPreguntaDos.setText("2\nQue necesita todo método");
                chkUno.setText("Parametros");
                chkDos.setText("Un objeto");
                chkTres.setText("Retornar algo");

                txvPreguntaTres.setText("3\nYiel te permite comentar mediante el signo delimitador =begin de inicio y el  ");
                txvParteUno.setText("");
                //edtParteDos
                txvParteTres.setText("de final");

                txvPreguntaCuatro.setText("4\n¿que es basicamente un mixins?");
                rbtOpcionUnoDos.setText("Un módulo");
                rbtOpcionDosDos.setText("Una clase");

                txvPreguntaCinco.setText("5\nPropiedades de los mixins.");
                chkUnoDos.setText("Manera marabillosa de agregar funcionalidades controladas a las clases");
                chkDosDos.setText("Elimina la necesidad de herencia multiple");
                chkTresDos.setText("Elimina la necesidad de métodos");
                break;
            case 3:
                txvPreguntaUno.setText("1\nPara qué sirve el método length en Ruby");
                rbtOpcionUno.setText("Para traer el numero de caracteres de una cadena");
                rbtOpcionDos.setText("Para traer el tamaño de una cadena");

                txvPreguntaDos.setText("2\nCuales son métodos que trabajan con cadenas");
                chkUno.setText("upcase");
                chkDos.setText("monocase");
                chkTres.setText("downcase");

                txvPreguntaTres.setText("3\nLos arreglos son estructuras que almacenan");
                txvParteUno.setText("");
                //edtParteDos
                txvParteTres.setText("");

                txvPreguntaCuatro.setText("3\n¿A traves de que se accede a la información de los arreglos?");
                rbtOpcionUnoDos.setText("los inedex");
                rbtOpcionDosDos.setText("Mas arrglos");

                txvPreguntaCinco.setText("3\nQué son los Hashes");
                chkUnoDos.setText("Una colección de valores pares");
                chkDosDos.setText("Es un valor que maneja las fechas");
                chkTresDos.setText("Es una matriz");
                break;
            case 4:
                txvPreguntaUno.setText("1\nLos rangos estan delimitados por un valor final");
                rbtOpcionUno.setText("Cierto");
                rbtOpcionDos.setText("Falso");

                txvPreguntaDos.setText("2\n¿Que pueden ser los iteradores?");
                chkUno.setText("Funciones");
                chkDos.setText("Métodos");
                chkTres.setText("Arreglos");

                txvPreguntaTres.setText("3\npwd da la ruta de un");
                txvParteUno.setText("");
                //edtParteDos
                txvParteTres.setText("");

                txvPreguntaCuatro.setText("4\n¿Que contiene un objeto?");
                rbtOpcionUnoDos.setText("Datos");
                rbtOpcionDosDos.setText("Clases");

                txvPreguntaCinco.setText("5\n¿Para que son utilizadas las expreciónes regulares?");
                chkUnoDos.setText("Reconocer patrones");
                chkDosDos.setText("Procesar texto");
                chkTresDos.setText("Sumar enteros");
                break;
            case 5:
                ///////////////////////////////////////////////////////////////////////////////////
                txvTituloExam.setText("Examen final");
                txvPreguntaUno.setText("1\n¿Que se teclea en el cmd para obtener la version de ruby instalada?");
                rbtOpcionUno.setText("ruby -v");
                rbtOpcionDos.setText("ruby -V");

                txvPreguntaDos.setText("2\nQue necesita todo método");
                chkUno.setText("Parametros");
                chkDos.setText("Un objeto");
                chkTres.setText("Retornar algo");

                txvPreguntaTres.setText("3\nLos arreglos son estructuras que almacenan");
                txvParteUno.setText("");
                //edtParteDos
                txvParteTres.setText("");

                txvPreguntaCuatro.setText("4\n¿Que contiene un objeto?");
                rbtOpcionUnoDos.setText("Datos");
                rbtOpcionDosDos.setText("Clases");

                txvPreguntaCinco.setText("3\nQué son los Hashes");
                chkUnoDos.setText("Una colección de valores pares");
                chkDosDos.setText("Es un valor que maneja las fechas");
                chkTresDos.setText("Es una matriz");
                break;
            default:
                Log.e("NO entro en el switch", "initComponents: ");
                break;
        }

        btnComprobar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int idModul=dbAdapter.idPrimerModuloIns(FormLoginActivity.ID_USU_LOGEADO, "Modulo 1");
        int califTraida;

        switch (valorResividos.getInt("numeroExamne")){
            case 1:
                if (rbtOpcionUno.isChecked()){
                    calificacion++;
                }
                if (chkDos.isChecked()||chkTres.isChecked()){
                    calificacion++;
                }
                if (edtParteDos.getText().toString().equals("@@VAR_UNO")){
                    calificacion++;
                }
                if (rbtOpcionDosDos.isChecked()){
                    calificacion++;
                }
                if (chkUnoDos.isChecked()||chkTresDos.isChecked()){
                    calificacion++;
                }
                dbAdapter.activarTema(idModul, 1, 8);
                califTraida=dbAdapter.traerCalificacion(1, FormLoginActivity.ID_USU_LOGEADO);
                //Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                califTraida=califTraida/2;
                Log.e("Calificacion traida", "onClick: " + califTraida + " " + calificacion);
                //El que inserta
                if (calificacion>califTraida) {
                    dbAdapter.setCalifModulo(FormLoginActivity.ID_USU_LOGEADO, 1, calificacion);
                }
                //el que trae la calif en toast
                califTraida=dbAdapter.traerCalificacion(1,FormLoginActivity.ID_USU_LOGEADO);
                Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                //--------------------------------------------
                Log.e("Calificacion incertada", "onClick: "+califTraida );
                timer.cancel();
                timer.onFinish();
                break;
            case 2:
                /////////////////////////////////////////
                if (rbtOpcionUno.isChecked()){
                    calificacion++;
                }
                if (chkDos.isChecked()){
                    calificacion++;
                }
                if (edtParteDos.getText().toString().equals("=end")){
                    calificacion++;
                }
                if (rbtOpcionUnoDos.isChecked()){
                    calificacion++;
                }
                if (chkUnoDos.isChecked()){
                    calificacion++;
                }
                dbAdapter.activarTema(idModul, 2, 6);
                califTraida=dbAdapter.traerCalificacion(2, FormLoginActivity.ID_USU_LOGEADO);
                //Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                califTraida=califTraida/2;
                Log.e("Calificacion traida", "onClick: " + califTraida + " " + calificacion);
                //El que inserta
                if (calificacion>califTraida) {
                    dbAdapter.setCalifModulo(FormLoginActivity.ID_USU_LOGEADO, 2, calificacion);
                }
                //el que trae la calif en toast
                califTraida=dbAdapter.traerCalificacion(2,FormLoginActivity.ID_USU_LOGEADO);
                Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                //--------------------------------------------
                Log.e("Calificacion incertada", "onClick: " + califTraida);
                timer.cancel();
                timer.onFinish();
                /////////////////////////////////////////
                break;
            case 3:
                if (rbtOpcionUno.isChecked()){
                    calificacion++;
                }
                if (chkUno.isChecked()||chkTres.isChecked()){
                    calificacion++;
                }
                if (edtParteDos.getText().toString().equals("elementos de diferentes tipos")){
                    calificacion++;
                }
                if (rbtOpcionUnoDos.isChecked()){
                    calificacion++;
                }
                if (chkUnoDos.isChecked()||chkDosDos.isChecked()){
                    calificacion++;
                }
                dbAdapter.activarTema(idModul, 3, 5);
                califTraida=dbAdapter.traerCalificacion(3, FormLoginActivity.ID_USU_LOGEADO);
                //Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                califTraida=califTraida/2;
                Log.e("Calificacion traida", "onClick: " + califTraida + " " + calificacion);
                //El que inserta
                if (calificacion>califTraida) {
                    dbAdapter.setCalifModulo(FormLoginActivity.ID_USU_LOGEADO, 3, calificacion);
                }
                //el que trae la calif en toast
                califTraida=dbAdapter.traerCalificacion(3,FormLoginActivity.ID_USU_LOGEADO);
                Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                //--------------------------------------------
                Log.e("Calificacion incertada", "onClick: " + califTraida);
                timer.cancel();
                timer.onFinish();
                /////////////////////////////////////////
                break;
            case 4:
                if (rbtOpcionUno.isChecked()){
                    calificacion++;
                }
                if (chkUno.isChecked()||chkDos.isChecked()){
                    calificacion++;
                }
                if (edtParteDos.getText().toString().equals("archivo")){
                    calificacion++;
                }
                if (rbtOpcionUnoDos.isChecked()){
                    calificacion++;
                }
                if (chkUnoDos.isChecked()||chkDosDos.isChecked()){
                    calificacion++;
                }
                dbAdapter.activarTema(idModul, 4, 7);
                califTraida=dbAdapter.traerCalificacion(4, FormLoginActivity.ID_USU_LOGEADO);
                //Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                califTraida=califTraida/2;
                Log.e("Calificacion traida", "onClick: " + califTraida + " " + calificacion);
                //El que inserta
                if (calificacion>califTraida) {
                    dbAdapter.setCalifModulo(FormLoginActivity.ID_USU_LOGEADO, 4, calificacion);
                }
                //el que trae la calif en toast
                califTraida=dbAdapter.traerCalificacion(4,FormLoginActivity.ID_USU_LOGEADO);
                Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                //--------------------------------------------
                Log.e("Calificacion incertada", "onClick: " + califTraida);
                timer.cancel();
                timer.onFinish();
                /////////////////////////////////////////
                break;
            case 5:
                if (rbtOpcionUno.isChecked()){
                    calificacion++;
                }
                if (chkDos.isChecked()){
                    calificacion++;
                }
                if (edtParteDos.getText().toString().equals("elementos de diferentes tipos")){
                    calificacion++;
                }
                if (rbtOpcionUnoDos.isChecked()){
                    calificacion++;
                }
                if (chkUnoDos.isChecked()||chkDosDos.isChecked()){
                    calificacion++;
                }
                califTraida=dbAdapter.traerCalificacion(5, FormLoginActivity.ID_USU_LOGEADO);
                //Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                califTraida=califTraida/2;
                Log.e("Calificacion traida", "onClick: " + califTraida + " " + calificacion);
                //El que inserta
                if (calificacion>califTraida) {
                    dbAdapter.setCalifModulo(FormLoginActivity.ID_USU_LOGEADO, 5, calificacion);
                }
                //el que trae la calif en toast
                califTraida=dbAdapter.traerCalificacion(5,FormLoginActivity.ID_USU_LOGEADO);
                Toast.makeText(ExamenFinalActivity.this, "Su calif: "+califTraida, Toast.LENGTH_SHORT).show();
                //--------------------------------------------
                Log.e("Calificacion incertada", "onClick: " + califTraida);
                //startActivity(new Intent());
                timer.cancel();
                timer.onFinish();
                startActivity(new Intent(ExamenFinalActivity.this,EjemploEmailActivity.class));
                break;
            default:
                Log.e("NO entro", "onClick:  ");
                break;
        }
        finish();
    }

    public void tiempoTerminado(int tipo){
        bundle=new Bundle();
        bundle.putString("elegido", valorResividos.getString("nombreModulo"));
        bundle.putInt("posicion", valorResividos.getInt("modulo"));
        bundle.putBoolean("logeo", valorResividos.getBoolean("logeo"));
        switch (tipo){
            case 1:
                //pantalla con la calificacion(Splash)
                //dos diferentes tipos una que aprobo y otra que no
                break;
            case 2:
                Toast.makeText(ExamenFinalActivity.this, "Tiempo terminado", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(ExamenFinalActivity.this, SeleccionTemaActivity.class).putExtras(bundle));
                finish();
                break;
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }
        @Override
        public void onFinish() {
            if (calificacion>0){
                tiempoTerminado(1);
            }else {
                txvTiempo.setText("00:00:00");
                tiempoTerminado(2);
            }
            //--------------------------------------------------------------------------------------------------------------------
        }
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            txvTiempo.setText(hms);

        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        calificacion=0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
