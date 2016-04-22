package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import utng.edu.mx.java.quiz.QuizActivity;

/**
 * Created by Gustavo on 29/03/2016.
 */
public class ContenidoOnMethod extends AppCompatActivity implements View.OnClickListener
{
    private Bundle valoresRecividosOn;
    private TextView titleWhatMethod,contentWhatMethod;
    private ImageView imageWhatMethod;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_method_layout);
        initComponents();
    }

    private void initComponents() {
        valoresRecividosOn=getIntent().getExtras();

        titleWhatMethod=(TextView)findViewById(R.id.title_on_method);
        contentWhatMethod=(TextView)findViewById(R.id.content_what_method);
        imageWhatMethod=(ImageView)findViewById(R.id.img_on_what_method);


        titleWhatMethod.setText(valoresRecividosOn.getString("elegido"));
        contentWhatMethod.setText(valoresRecividosOn.getString("descripciones"));



        bundle = new Bundle();
        bundle.putInt("posicion", valoresRecividosOn.getInt("posicion"));

        switch (valoresRecividosOn.getInt("posicion")){
            case 5:
                imageWhatMethod.setImageResource(R.drawable.metodoq);
                break;
            default:
                break;
        }
        imageWhatMethod.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(ContenidoOnMethod.this, VideoOnLoginActivity.class).putExtras(bundle));
    }
    public void Quiz(View view) {
        startActivity(new Intent(ContenidoOnMethod.this, QuizActivity.class).putExtras(bundle));
    }
}
