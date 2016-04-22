package utng.edu.mx.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gustavo on 25/03/2016.
 */
public class ContenidoOffActivity extends AppCompatActivity {
    private TextView tituloOff,contenidoOff;
    private Bundle valoresResividosC;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_off_layout);
        initComponets();
    }

    private void initComponets() {
        valoresResividosC=getIntent().getExtras();

        tituloOff=(TextView)findViewById(R.id.titulo_off);
        contenidoOff=(TextView)findViewById(R.id.id_contenido_off);
        imageView=(ImageView)findViewById(R.id.img_off_contenido);

        tituloOff.setText(valoresResividosC.getString(getString(R.string.elction)));
        contenidoOff.setText(valoresResividosC.getString(getString(R.string.description)));



        switch (valoresResividosC.getInt(getString(R.string.election))){

            case 2:
                imageView.setImageResource(R.drawable.que);
                break;
            case 3:
                imageView.setImageResource(R.drawable.objt);
                break;
            case 4:
                imageView.setImageResource(R.drawable.classi);
                break;
            case 5:
                imageView.setImageResource(R.drawable.metodoq);
                break;
            case 6:
                imageView.setImageResource(R.drawable.estructura);
                break;
            default:
                break;
        }


    }
}
