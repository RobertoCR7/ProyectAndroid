package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import utng.edu.mx.java.quiz.QuizActivity;

/**
 * Created by Gustavo on 29/03/2016.
 */
public class ContenidoOnControl extends AppCompatActivity implements View.OnClickListener
{
    private Bundle valoresRecividosOn;
    private TextView titleWhatControl,contentWhatControl;
    private ImageView imageWhatControl;
    private Intent intent;
    private Bundle bundle;
    private Button imgVideoWhcontrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_control_layout);
        initComponents();
    }

    private void initComponents() {
        bundle=new Bundle();
        titleWhatControl=(TextView)findViewById(R.id.title_on_control);
        contentWhatControl=(TextView)findViewById(R.id.content_what_control);
        imageWhatControl=(ImageView)findViewById(R.id.img_on_what_control);
        imgVideoWhcontrol=(Button)findViewById(R.id.img_video_whcontrol);
        imgVideoWhcontrol.setOnClickListener(this);

        valoresRecividosOn=getIntent().getExtras();
        titleWhatControl.setText(valoresRecividosOn.getString("elegido"));
        contentWhatControl.setText(valoresRecividosOn.getString("descripciones"));

        bundle = new Bundle();
        bundle.putInt("posicion", valoresRecividosOn.getInt("posicion"));
        bundle.putString("elegido", valoresRecividosOn.getString("elegido"));
        bundle.putString("descripciones", valoresRecividosOn.getString("descripciones"));
        switch (valoresRecividosOn.getInt("posicion")){
            case 6:
                imageWhatControl.setImageResource(R.drawable.estructura);
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(ContenidoOnControl.this, QuizActivity.class).putExtras(bundle));
    }
}
