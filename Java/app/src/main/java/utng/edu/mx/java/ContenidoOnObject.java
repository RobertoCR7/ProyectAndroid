package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import utng.edu.mx.java.quiz.QuizActivity;

/**
 * Created by Gustavo on 29/03/2016.
 */
public class ContenidoOnObject extends AppCompatActivity implements View.OnClickListener
{
    private Bundle valoresRecividosOn;
    private TextView titleWhatObject,contentWhatObject;
    private ImageView imageWhatObject;
    private Bundle bundle;
    private ImageButton imvWatchVideoObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_object_layout);
        initComponents();
    }

    private void initComponents() {
        valoresRecividosOn=getIntent().getExtras();

        imvWatchVideoObject =(ImageButton)findViewById(R.id.imv_watch_video_object);
        titleWhatObject=(TextView)findViewById(R.id.title_on_object);
        contentWhatObject=(TextView)findViewById(R.id.content_what_object);
        imageWhatObject=(ImageView)findViewById(R.id.img_on_what_object);


        titleWhatObject.setText(valoresRecividosOn.getString("elegido"));
        contentWhatObject.setText(valoresRecividosOn.getString("descripciones"));

        bundle = new Bundle();
        bundle.putInt("posicion", valoresRecividosOn.getInt("posicion"));

        switch (valoresRecividosOn.getInt("posicion")){
            case 3:
                imageWhatObject.setImageResource(R.drawable.objeto);
                break;
            default:
                break;
        }
        imvWatchVideoObject.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(ContenidoOnObject.this, VideoOnLoginActivity.class).putExtras(bundle));
    }
    public void Quiz(View view) {
        startActivity(new Intent(ContenidoOnObject.this, QuizActivity.class).putExtras(bundle));
    }
}
