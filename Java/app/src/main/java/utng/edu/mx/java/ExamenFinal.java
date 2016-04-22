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
public class ExamenFinal extends AppCompatActivity
{
    private Bundle valoresRecividosOn;
    private TextView titleExamenFinal;
    private ImageView imageWhatExamenFinal;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen_final_layout);
        initComponents();
    }
    private void initComponents() {
        valoresRecividosOn=getIntent().getExtras();
        titleExamenFinal=(TextView)findViewById(R.id.title_on_examen_final);
        imageWhatExamenFinal=(ImageView)findViewById(R.id.img_on_examen_final);
        titleExamenFinal.setText(valoresRecividosOn.getString("elegido"));
        bundle = new Bundle();
        bundle.putInt("posicion", valoresRecividosOn.getInt("posicion"));

        switch (valoresRecividosOn.getInt("posicion")) {
            case 7:
                imageWhatExamenFinal.setImageResource(R.drawable.tests);
                break;
            default:
                break;
        }
    }
    public void Quiz(View view) {
        startActivity(new Intent(ExamenFinal.this, QuizActivity.class).putExtras(bundle));
    }
}
