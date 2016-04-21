package mx.edu.utng.ctutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Enrique on 06/04/2016.
 */
public class DesarrolladorActivity extends Activity {
    TextView textView ;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desarrollador_activity_layout);
        textView = (TextView)findViewById(R.id.txt_desarrollador);
        imageView = (ImageView)findViewById(R.id.imv_desarrollador);
    }
}
