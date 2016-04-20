package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Roberto on 28/02/2016.
 */
public class InformacionDesarrolladorActivity extends Activity {
    private TextView infoDesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infor_desarrollador_layout);
        infoDesa = (TextView)findViewById(R.id.informacion);



    }
}
