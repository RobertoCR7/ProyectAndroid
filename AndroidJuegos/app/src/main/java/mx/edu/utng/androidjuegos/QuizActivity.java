package mx.edu.utng.androidjuegos;

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

import mx.edu.utng.androidjuegos.util.DBAdapter;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    int position;
    Question currentQ;
    TextView txtQuestion, times, scored;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private DBAdapter dbAdapter;

    private Bundle valoresRecibidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        dbAdapter = new DBAdapter(this);
        dbAdapter.open();


        valoresRecibidos=getIntent().getExtras();

        switch (valoresRecibidos.getInt("moduloT")){
            case 0:
                switch (valoresRecibidos.getInt("temaT")){
                    case 0:
                        quesList=dbAdapter.getAllQuestions(0);//Me trae la spreguntas
                        break;
                    default:
                        break;
                }
                break;//Fin modulo 1
            case 1:
                switch (valoresRecibidos.getInt("temaT")){
                    case 0:
                        quesList=dbAdapter.getAllQuestions(1);//Me trae la spreguntas
                        break;
                    case 1:
                        quesList=dbAdapter.getAllQuestions(2);//Me trae la spreguntas

                        break;
                    case 2:
                        quesList=dbAdapter.getAllQuestions(3);//Me trae la spreguntas

                        break;
                    case 3:
                        quesList=dbAdapter.getAllQuestions(4);//Me trae la spreguntas

                        break;
                    case 4:
                        quesList=dbAdapter.getAllQuestions(5);//Me trae la spreguntas
                        break;
                    case 5:
                        quesList=dbAdapter.getAllQuestions(6);//Me trae la spreguntas
                        break;
                    default:
                        break;
                }

                break;//Fin modulo 2
            case 2:
                switch (valoresRecibidos.getInt("temaT")){
                    case 0:
                        quesList=dbAdapter.getAllQuestions(7);//Me trae la spreguntas
                        break;
                    case 1:
                        quesList=dbAdapter.getAllQuestions(8);//Me trae la spreguntas

                        break;
                    case 2:
                        quesList=dbAdapter.getAllQuestions(9);//Me trae la spreguntas

                        break;
                    case 3:
                        quesList=dbAdapter.getAllQuestions(10);//Me trae la spreguntas

                        break;
                    case 4:
                        quesList=dbAdapter.getAllQuestions(11);//Me trae la spreguntas
                        break;
                    case 5:
                        quesList=dbAdapter.getAllQuestions(12);//Me trae la spreguntas
                        break;
                    case 6:
                        quesList=dbAdapter.getAllQuestions(13);//Me trae la spreguntas
                        break;
                    case 7:
                        quesList=dbAdapter.getAllQuestions(14);//Me trae la spreguntas
                        break;
                    case 8:
                        quesList=dbAdapter.getAllQuestions(15);//Me trae la spreguntas
                        break;
                    default:
                        break;
                }

                break; //fin modulo 3
            case 3:
                switch (valoresRecibidos.getInt("temaT")){
                    case 0:
                        quesList=dbAdapter.getAllQuestions(16);//Me trae la spreguntas
                        break;
                    case 1:
                        quesList=dbAdapter.getAllQuestions(17);//Me trae la spreguntas

                        break;
                    case 2:
                        quesList=dbAdapter.getAllQuestions(18);//Me trae la spreguntas

                        break;
                    case 3:
                        quesList=dbAdapter.getAllQuestions(19);//Me trae la spreguntas

                        break;
                    case 4:
                        quesList=dbAdapter.getAllQuestions(20);//Me trae la spreguntas
                        break;
                    case 5:
                        quesList=dbAdapter.getAllQuestions(21);//Me trae la spreguntas
                        break;
                    case 6:
                        quesList=dbAdapter.getAllQuestions(22);//Me trae la spreguntas
                        break;
                    default:
                        break;
                }

                break; //FIN MODULO 4
            case 4:
                switch (valoresRecibidos.getInt("temaT")){
                    case 0:
                        quesList=dbAdapter.getAllQuestions(23);//Me trae la spreguntas
                        break;
                    case 1:
                        quesList=dbAdapter.getAllQuestions(24);//Me trae la spreguntas

                        break;
                    case 2:
                        quesList=dbAdapter.getAllQuestions(25);//Me trae la spreguntas

                        break;
                    case 3:
                        quesList=dbAdapter.getAllQuestions(26);//Me trae la spreguntas

                        break;
                    case 4:
                        quesList=dbAdapter.getAllQuestions(27);//Me trae la spreguntas
                        break;
                    case 5:
                        quesList=dbAdapter.getAllQuestions(28);//Me trae la spreguntas
                        break;
                    case 6:
                        quesList=dbAdapter.getAllQuestions(29);//Me trae la spreguntas
                        break;
                    case 7:
                        quesList=dbAdapter.getAllQuestions(30);//Me trae la spreguntas
                        break;
                    case 8:
                        quesList=dbAdapter.getAllQuestions(31);//Me trae la spreguntas
                        break;
                    default:
                        break;
                }

                break; //fin modulo 5
            default:
                break;



        }


                currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);

       //scored = (TextView) findViewById(R.id.score);
        // the timer
        times = (TextView) findViewById(R.id.timers);
        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");
        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        final CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        //setQuestionView();//Rellena la informacion de cada pregunta

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);

                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                switch (valoresRecibidos.getInt("posicionTema")){

                }
                if(qid<2){//Numero de preguntas
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{//Si las preguntas superan el numero

                    //Aqui empieza para las calificaciones.

                    //_______==========================================================================================================================================

                    int idModul =dbAdapter.idModulo1(LogeoActividad.ID_USUARIO, "Modulo_1");

                    int calif = 0;
                    if (score==2){
                        calif = 10;
                    }else if (score==1){
                        calif=5;

                    }
                    Toast.makeText(QuizActivity.this, "Su calificación es: "+calif, Toast.LENGTH_SHORT).show();
                    switch (valoresRecibidos.getInt("moduloT")){
                        case 0:
                            switch (valoresRecibidos.getInt("temaT")){
                                case 0:

                                    dbAdapter.addCalifTemas(idModul, 1, 1, score);
                                    break;
                                default:
                                    break;
                            }
                            break;//Fin modulo 1
                        case 1:
                            switch (valoresRecibidos.getInt("temaT")){
                                case 0:
                                    dbAdapter.addCalifTemas(idModul, 2, 1, score);
                                    break;
                                case 1:
                                    dbAdapter.addCalifTemas(idModul, 2, 2, score);
                                    break;
                                case 2:
                                    dbAdapter.addCalifTemas(idModul, 2, 3, score);
                                    break;
                                case 3:
                                    dbAdapter.addCalifTemas(idModul, 2, 4, score);
                                    break;
                                case 4:
                                    dbAdapter.addCalifTemas(idModul, 2, 5, score);
                                    break;
                                case 5:
                                    dbAdapter.addCalifTemas(idModul, 2, 6, score);
                                    break;
                                default:
                                    break;
                            }

                            break;//Fin modulo 2
                        case 2:
                            switch (valoresRecibidos.getInt("temaT")){
                                case 0:
                                    dbAdapter.addCalifTemas(idModul, 3, 1, score);
                                    break;
                                case 1:
                                    dbAdapter.addCalifTemas(idModul, 3, 2, score);
                                    break;
                                case 2:
                                    dbAdapter.addCalifTemas(idModul, 3, 3, score);
                                    break;
                                case 3:
                                    dbAdapter.addCalifTemas(idModul, 3, 4, score);
                                    break;
                                case 4:
                                    dbAdapter.addCalifTemas(idModul, 3, 5, score);
                                    break;
                                case 5:
                                    dbAdapter.addCalifTemas(idModul, 3, 6, score);
                                    break;
                                case 6:
                                    dbAdapter.addCalifTemas(idModul, 3, 7, score);
                                    break;
                                case 7:
                                    dbAdapter.addCalifTemas(idModul, 3, 8, score);
                                    break;
                                case 8:
                                    dbAdapter.addCalifTemas(idModul, 3, 9, score);
                                    break;
                                default:
                                    break;
                            }

                            break; //fin modulo 3
                        case 3:
                            switch (valoresRecibidos.getInt("temaT")){
                                case 0:
                                    dbAdapter.addCalifTemas(idModul, 4, 1, score);
                                    break;
                                case 1:
                                    dbAdapter.addCalifTemas(idModul, 4, 2, score);
                                    break;
                                case 2:
                                    dbAdapter.addCalifTemas(idModul, 4, 3, score);
                                    break;
                                case 3:
                                    dbAdapter.addCalifTemas(idModul, 4, 4, score);
                                    break;
                                case 4:
                                    dbAdapter.addCalifTemas(idModul, 4, 5, score);
                                    break;
                                case 5:
                                    dbAdapter.addCalifTemas(idModul, 4, 6, score);
                                    break;
                                case 6:
                                    dbAdapter.addCalifTemas(idModul, 4, 7, score);
                                    break;
                                default:
                                    break;
                            }

                            break; //FIN MODULO 4
                        case 4:
                            switch (valoresRecibidos.getInt("temaT")){
                                case 0:
                                    dbAdapter.addCalifTemas(idModul, 5, 1, score);
                                    break;
                                case 1:
                                    dbAdapter.addCalifTemas(idModul, 5, 2, score);
                                    break;
                                case 2:
                                    dbAdapter.addCalifTemas(idModul, 5, 3, score);
                                    break;
                                case 3:
                                    dbAdapter.addCalifTemas(idModul, 5, 4, score);
                                    break;
                                case 4:
                                    dbAdapter.addCalifTemas(idModul, 5, 5, score);
                                    break;
                                case 5:
                                    dbAdapter.addCalifTemas(idModul, 5, 6, score);
                                    break;
                                case 6:
                                    dbAdapter.addCalifTemas(idModul, 5, 7, score);
                                    break;
                                case 7:
                                    dbAdapter.addCalifTemas(idModul, 5, 8, score);
                                    break;
                                case 8:
                                    dbAdapter.addCalifTemas(idModul, 5, 9, score);

                                    break;
                                default:
                                    break;
                            }

                            break; //fin modulo 5
                        default:
                            break;


                    }
                    timer.cancel();

                    //_______==========================================================================================================================================

                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("temaT", valoresRecibidos.getInt("temaT")); //Your score
                    b.putInt("moduloT", valoresRecibidos.getInt("moduloT")); //Your score
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
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
            times.setText("El tiempo acabo");
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
            times.setText(hms);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
