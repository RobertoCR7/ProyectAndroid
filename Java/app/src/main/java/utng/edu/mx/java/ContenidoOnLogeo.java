package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import utng.edu.mx.java.quiz.QuizActivity;

/**
 * Created by Gustavo on 29/03/2016.
 */
public class ContenidoOnLogeo extends AppCompatActivity implements View.OnClickListener
{
    private Bundle valoresRecividosOn;
    private TextView titleWhatJava,contentWhatJava;
    private Bundle bundle;
    private ImageButton imvWatchVideo;
    private ImageView imgOnWhatJava;
    private Button btnQuiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_java_layout);
        initComponents();
    }

    private void initComponents() {

        imvWatchVideo =(ImageButton)findViewById(R.id.imv_watch_video);
        titleWhatJava=(TextView)findViewById(R.id.title_on_java);
        contentWhatJava=(TextView)findViewById(R.id.content_what_java);
        imgOnWhatJava= (ImageView) findViewById(R.id.img_on_what_java);
        btnQuiz= (Button)findViewById(R.id.img_video_whjava);

        valoresRecividosOn=getIntent().getExtras();

        titleWhatJava.setText(valoresRecividosOn.getString("elegido"));
        contentWhatJava.setText(valoresRecividosOn.getString("descripciones"));

        bundle = new Bundle();
        bundle.putInt("posicion", valoresRecividosOn.getInt("posicion"));
        switch (valoresRecividosOn.getInt("posicion")){
            case 2:
                imgOnWhatJava.setImageResource(R.drawable.que);
                break;
            default:
                break;
        }

        imvWatchVideo.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(ContenidoOnLogeo.this, VideoOnLoginActivity.class).putExtras(bundle));
    }

    public void Quiz(View view) {
        startActivity(new Intent(ContenidoOnLogeo.this, QuizActivity.class).putExtras(bundle));
    }


}
