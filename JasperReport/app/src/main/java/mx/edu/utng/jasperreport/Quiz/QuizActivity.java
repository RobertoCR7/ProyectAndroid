package mx.edu.utng.jasperreport.Quiz;

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

import mx.edu.utng.jasperreport.DAO.DBHelper;
import mx.edu.utng.jasperreport.Login.MainActivity;
import mx.edu.utng.jasperreport.Login.SignUp;
import mx.edu.utng.jasperreport.Model.Question;
import mx.edu.utng.jasperreport.R;
import mx.edu.utng.jasperreport.Util.DBAdapter;

public class QuizActivity extends AppCompatActivity {

    private DBAdapter db;

    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion, times;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private Bundle valoresRecibidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        db= new DBAdapter(this);
        db.open();

        //Se va a hacer una comparacion para que traiga solo 5 x temarios

        //Traemos las preguntas y las ponemos conforme a su poscision
        valoresRecibidos=getIntent().getExtras();
        switch (valoresRecibidos.getInt("posicionTema")){
            case 0:
                quesList=db.getAllQuestions(0);//Me trae la spreguntas

                break;
            case 1:
                quesList=db.getAllQuestions(1);//Me trae la spreguntas

                break;
            case 2:
                quesList=db.getAllQuestions(2);//Me trae la spreguntas

                break;
            case 3:
                quesList=db.getAllQuestions(3);//Me trae la spreguntas

                break;
            case 4:
                quesList=db.getAllQuestions(4);//Me trae la spreguntas

                break;
            case 5:
                quesList=db.getAllQuestions(5);//Me trae la spreguntas

                break;
            case 6:
                quesList=db.getAllQuestions(6);//Me trae la spreguntas

                break;
            case 7:
                quesList=db.getAllQuestions(7);//Me trae la spreguntas

                break;
            case 8:
                quesList=db.getAllQuestions(8);//Me trae la spreguntas

                break;
            case 9:
                quesList=db.getAllQuestions(9);//Me trae la spreguntas
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

        times = (TextView)findViewById(R.id.timers);

        setQuestionView();//Rellena la informacion de cada pregunta

        times.setText("00:01:00");
        //Se le cambia el tiempo que se le da para realizar el QUIZ
        final CounterClass timer = new CounterClass(90000, 1000);
        timer.start();

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
                if(qid<4){//Numero de preguntas
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{//Si las preguntas superan el numero
                    //--------------------------------------------------------------------------------------
                    int idTema=db.idTemaUno(MainActivity.ID_USUARIO,"Tem_1");

                    int calif = 0;
                    if (score == 4){
                        calif = 10;
                    } else if (score == 3){
                        calif = 8;
                    } else if (score == 2){
                        calif = 6;
                    } else if (score == 1){
                        calif = 4;
                    }

                    Toast.makeText(QuizActivity.this, "Calificación: " + calif, Toast.LENGTH_SHORT).show();

                    switch (valoresRecibidos.getInt("posicionTema")){
                        case 0:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 1);
                            db.setCalifTema(MainActivity.ID_USUARIO, 1, score);
                            break;
                        case 1:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 2);
                            db.setCalifTema(MainActivity.ID_USUARIO, 2, score);
                            break;
                        case 2:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 3);
                            db.setCalifTema(MainActivity.ID_USUARIO, 3, score);
                            break;
                        case 3:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 4);
                            db.setCalifTema(MainActivity.ID_USUARIO, 4, score);
                            break;
                        case 4:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 5);
                            db.setCalifTema(MainActivity.ID_USUARIO, 5, score);
                            break;
                        case 5:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 6);
                            db.setCalifTema(MainActivity.ID_USUARIO, 6, score);
                            break;
                        case 6:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 7);
                            db.setCalifTema(MainActivity.ID_USUARIO, 7, score);
                            break;
                        case 7:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 8);
                            db.setCalifTema(MainActivity.ID_USUARIO, 8, score);
                            break;
                        case 8:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 9);
                            db.setCalifTema(MainActivity.ID_USUARIO, 9, score);
                            break;
                        case 9:
                            db.insertaCalifTemas(score, MainActivity.ID_USUARIO, 10);
                            db.setCalifTema(MainActivity.ID_USUARIO, 10, score);
                            break;
                        default:
                            break;

                    }

                    timer.cancel();

                    //-----------------

                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
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
}
