package utng.edu.mx.java.quiz;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.concurrent.TimeUnit;
import utng.edu.mx.java.ExampleIndiceActivity;
import utng.edu.mx.java.MainActivity;
import utng.edu.mx.java.R;
import utng.edu.mx.java.Util.DBAdapter;
import utng.edu.mx.java.model.Question;


/**
 * Created by Gustavo on 26/03/2016.
 */

public class QuizActivity extends AppCompatActivity{

    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion, txvTiempo;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private Bundle valoresRecibidos;
    private Bundle enviados;
    private DBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();


        //Se va a hacer una comparacion para que traiga solo 5 x temarios

        valoresRecibidos=getIntent().getExtras();

        switch (valoresRecibidos.getInt("posicion")){
            case 2:
                quesList=dbAdapter.getAllQuestions(0);//Me trae las preguntas
                break;
            case 3:
                quesList=dbAdapter.getAllQuestions(1);//Me trae la spreguntas
                break;
            case 4:
                quesList=dbAdapter.getAllQuestions(2);//Me trae la spreguntas
                break;
            case 5:
                quesList=dbAdapter.getAllQuestions(3);//Me trae la spreguntas
                break;
            case 6:
                quesList=dbAdapter.getAllQuestions(4);//Me trae la spreguntas
                break;
            case 7:
                quesList=dbAdapter.getAllQuestions(5);//Me trae la spreguntas

                break;
            default:
                break;

        }

        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);

        txvTiempo = (TextView)findViewById(R.id.timers);

        setQuestionView();//Rellena la informacion de cada pregunta

        txvTiempo.setText("00:01:00");

        //Se le cambia el tiempo que se le da para realizar el QUIZ
        final CounterClass timer = new CounterClass(90000, 1000);
        timer.start();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);

                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText())){
                    score++;
                }
                if(qid<5){//Numero de preguntas
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{//Si las preguntas superan el numero
                    //--------------------------------------------------------------------------------------
                    Log.e("ID del usuario", "onClick: "+ MainActivity.ID_USUARIO);
                    switch (valoresRecibidos.getInt("posicion")){
                        case 2:
                            Log.e("Calificacion", "onClick: "+score );
                            dbAdapter.desbloquearTemas(1,  MainActivity.ID_USUARIO,score);
                            dbAdapter.ingresarCalificacion(score,1, MainActivity.ID_USUARIO);
                            break;
                        case 3:
                            dbAdapter.desbloquearTemas(2,  MainActivity.ID_USUARIO,score);
                            dbAdapter.ingresarCalificacion(score,2, MainActivity.ID_USUARIO);
                            break;
                        case 4:
                            dbAdapter.desbloquearTemas(3,  MainActivity.ID_USUARIO,score);
                            dbAdapter.ingresarCalificacion(score,3, MainActivity.ID_USUARIO);
                            break;
                        case 5:
                            dbAdapter.desbloquearTemas(4,  MainActivity.ID_USUARIO,score);
                            dbAdapter.ingresarCalificacion(score,4, MainActivity.ID_USUARIO);
                            break;
                        case 6:
                            dbAdapter.desbloquearTemas(5,  MainActivity.ID_USUARIO,score);
                            dbAdapter.ingresarCalificacion(score,5, MainActivity.ID_USUARIO);
                            break;
                        case 7:
                            dbAdapter.desbloquearTemas(6,  MainActivity.ID_USUARIO,score);
                            dbAdapter.ingresarCalificacion(score,6, MainActivity.ID_USUARIO);
                            break;
                        default:
                            break;
                    }
                    timer.cancel();
                    //--------------------------------------------------------------------------------------
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    b.putInt("posicion", valoresRecibidos.getInt("posicion")); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }//Termino del if de preguntas
            }
        });

    }
    public void tiempoTerminado(){
        enviados=new Bundle();
        enviados.putInt("posicion", valoresRecibidos.getInt("posicion"));
        enviados.putString("elegido", valoresRecibidos.getString("elegido"));
        enviados.putString("descripciones", valoresRecibidos.getString("descripciones"));
        enviados.putBoolean("logeo",true);
            Toast.makeText(QuizActivity.this, "Tiempo terminado", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(QuizActivity.this, ExampleIndiceActivity.class).putExtras(enviados));

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
            txvTiempo.setText("El tiempo acabo");
            tiempoTerminado();
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
            if (hms.equals("00:00:10")
                    ||hms.equals("00:00:09")
                    ||hms.equals("00:00:08")
                    ||hms.equals("00:00:07")
                    ||hms.equals("00:00:06")
                    ||hms.equals("00:00:05")
                    ||hms.equals("00:00:04")
                    ||hms.equals("00:00:03")
                    ||hms.equals("00:00:02")
                    ||hms.equals("00:00:01")
                    ||hms.equals("00:00:01")
                    ||hms.equals("00:00:00")
                    ) {
                System.out.println(hms);
            }
            txvTiempo.setText(hms);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }

}
