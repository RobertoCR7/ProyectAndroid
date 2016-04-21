package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Erick on 10/04/2016.
 */
public class InstalacionActivity extends Activity implements View.OnClickListener {

    private ImageView imvVideo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instalacion_layout);
        initComponentes();
    }

    private void initComponentes(){

        imvVideo = (ImageView)findViewById(R.id.imv_video);
        imvVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imv_video:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=e-uPYpGeUHk")));
                break;
        }
    }
}
