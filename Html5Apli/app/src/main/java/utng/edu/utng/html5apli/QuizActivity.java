package utng.edu.utng.html5apli;

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

import utng.edu.utng.html5apli.model.Question;
import utng.edu.utng.html5apli.model.Tema;
import utng.edu.utng.html5apli.util.DBAdapter;

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
       // DBHelperQuiz db=new DBHelperQuiz(this);

        db= new DBAdapter(this);
        db.open();


        //Se va a hacer una comparacion para que traiga solo 5 x temarios

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
                if(qid<5){//Numero de preguntas
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{//Si las preguntas superan el numero
                    //---------------------
                    int idTema=db.idTemaUno(LogeoActividad.ID_USUARIO_LOGEADO,"Tem_1");
                    int calif=0;

                    if (score == 5){
                        calif=10;
                    }else if (score == 4){
                        calif=8;
                    }else if (score == 3){
                        calif=6;
                    }else if (score == 2){
                        calif=4;
                    }else if (score == 1){
                        calif=2;
                    }else if (score == 0){
                        calif=0;
                    }
                    Toast.makeText(QuizActivity.this, "Tu calificacion es: " + calif, Toast.LENGTH_SHORT).show();

                    Log.e("Calif de activity", "onClick: "+score );
                    switch (valoresRecibidos.getInt("posicionTema")){
                        case 0:
                            db.insertarCalifTemas(score, LogeoActividad.ID_USUARIO_LOGEADO, 1);
                            db.setCalTem(LogeoActividad.ID_USUARIO_LOGEADO, 1, score);
                            break;
                        case 1:
                            db.insertarCalifTemas(score, LogeoActividad.ID_USUARIO_LOGEADO, 2);
                            db.setCalTem(LogeoActividad.ID_USUARIO_LOGEADO, 2, score);
                            break;
                        case 2:
                            db.insertarCalifTemas(score, LogeoActividad.ID_USUARIO_LOGEADO, 3);
                            db.setCalTem(LogeoActividad.ID_USUARIO_LOGEADO, 3, score);
                            break;
                        case 3:
                            db.insertarCalifTemas(score, LogeoActividad.ID_USUARIO_LOGEADO, 4);
                            db.setCalTem(LogeoActividad.ID_USUARIO_LOGEADO, 4, score);
                            break;
                        case 4:
                            db.insertarCalifTemas(score, LogeoActividad.ID_USUARIO_LOGEADO, 5);
                            db.setCalTem(LogeoActividad.ID_USUARIO_LOGEADO, 5, score);
                            break;
                        case 5:
                            db.insertarCalifTemas(score, LogeoActividad.ID_USUARIO_LOGEADO, 6);
                            db.setCalTem(LogeoActividad.ID_USUARIO_LOGEADO, 6, score);
                            break;
                        default:
                            break;
                    }
                    timer.cancel();

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
