package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import utng.edu.mx.java.quiz.QuizActivity;

/**
 * Created by Gustavo on 29/03/2016.
 */
public class ContenidoOnClass extends AppCompatActivity implements VideoView.OnClickListener
{
    private Bundle valoresRecividosOn;
    private TextView titleWhatClass,contentWhatClass;
    private ImageView imageWhatClass;
    private ImageButton imvWatchVideo;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_class_layout);
        initComponents();
    }

    private void initComponents() {
        valoresRecividosOn=getIntent().getExtras();
        imvWatchVideo=(ImageButton)findViewById(R.id.imv_watch_video_class);
        titleWhatClass=(TextView)findViewById(R.id.title_on_class);
        contentWhatClass=(TextView)findViewById(R.id.content_what_class);
        imageWhatClass=(ImageView)findViewById(R.id.img_on_what_class);



        titleWhatClass.setText(valoresRecividosOn.getString("elegido"));
        contentWhatClass.setText(valoresRecividosOn.getString("descripciones"));


        bundle = new Bundle();
        bundle.putInt("posicion", valoresRecividosOn.getInt("posicion"));

        switch (valoresRecividosOn.getInt("posicion")){
            case 4:
                imageWhatClass.setImageResource(R.drawable.classi);
                break;
            default:
                break;
        }
        imvWatchVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(ContenidoOnClass.this, VideoOnLoginActivity.class).putExtras(bundle));
    }
    public void Quiz(View view) {
        startActivity(new Intent(ContenidoOnClass.this, QuizActivity.class).putExtras(bundle));
    }
}
