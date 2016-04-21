package mx.edu.utng.ctutorial;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.annotation.TargetApi;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.os.Build;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import java.util.List;

import mx.edu.utng.ctutorial.model.Question;
import mx.edu.utng.ctutorial.util.DBAdapter;

/**
 * Created by Enrique on 02/03/2016.
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
    private DBAdapter db;

    private Bundle valoresRecibidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBAdapter(this);
        db.open();
        setContentView(R.layout.activity_quiz);


        //Se va a hacer una comparacion para que traiga solo 5 x temarios

        valoresRecibidos=getIntent().getExtras();

        switch (valoresRecibidos.getInt("idQuiz")){
            case 20:
                quesList=db.getAllQuestions(0);//Me trae la spreguntas
                break;
            case 21:
                quesList=db.getAllQuestions(1);//Me trae la spreguntas
                break;
            case 22:
                quesList=db.getAllQuestions(2);//Me trae la spreguntas
                break;
            case 23:
                quesList=db.getAllQuestions(3);//Me trae la spreguntas
                break;
            case 24:
                quesList=db.getAllQuestions(4);//Me trae la spreguntas
                break;
            case 25:
                quesList=db.getAllQuestions(5);//Me trae la spreguntas
                break;
        }

                currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);

        scored = (TextView) findViewById(R.id.score);
        // the timer
        times = (TextView) findViewById(R.id.timers);
        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");
        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(130000, 1000);
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
                if(qid<5){//Numero de preguntas
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{//Si las preguntas superan el numero

                    Bundle b = new Bundle();
                    b.putInt("score", score);

                    int idmod = db.idModUno(Login.ID_USUARIO,"Modulo 1");
                    Log.e("Id del modulo 1", "onClick: "+idmod );
                    int calif=0;
                    if(score==5){
                        calif=10;
                    }else if(score==4){
                        calif=8;
                    }else if(score==3){
                        calif=6;
                    }else if (score==2){
                        calif=4;
                    }else if (score==1){
                        calif=2;
                    }else {
                        calif=0;
                    }

                    Toast.makeText(QuizActivity.this,"Su calificacion es: "+calif,Toast.LENGTH_SHORT).show();
                    switch (valoresRecibidos.getInt("idQuiz")){
                        case 20:
                            db.startNextModulo(1, Login.ID_USUARIO);
                            db.setCalificacion(1, idmod, 1, score);
                            startActivity(new Intent(QuizActivity.this, ResultActivity.class).putExtras(b));
                            break;
                        case 21:
                            db.startNextModulo(2, Login.ID_USUARIO);
                            db.setCalificacion(2, idmod, 1, score);
                            startActivity(new Intent(QuizActivity.this, ResultActivity.class).putExtras(b));
                            break;
                        case 22:
                            db.startNextModulo(3,Login.ID_USUARIO);
                            db.setCalificacion(3,idmod, 1, score);
                            startActivity(new Intent(QuizActivity.this, ResultActivity.class).putExtras(b));
                            break;
                        case 23:
                            db.startNextModulo(4,Login.ID_USUARIO);
                            db.setCalificacion(4,idmod, 1, score);
                            startActivity(new Intent(QuizActivity.this, ResultActivity.class).putExtras(b));
                            break;
                        case 24:
                            db.startNextModulo(5,Login.ID_USUARIO);
                            db.setCalificacion(5,idmod, 1, score);
                            startActivity(new Intent(QuizActivity.this, ResultActivity.class).putExtras(b));
                            break;
                        case 25:
                            db.setCalificacion(6,idmod, 1, score);
                            startActivity(new Intent(QuizActivity.this, ResultActivity.class).putExtras(b));
                            break;
                    }
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
        db.close();
    }

}
