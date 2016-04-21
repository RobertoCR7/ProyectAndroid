package mx.edu.utng.ctutorial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Enrique on 02/03/2016.
 */
public class Home extends AppCompatActivity {
    ImageButton imvHome;
    private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);
        initContents();
    }

    private void initContents(){
        sound = new MediaPlayer().create(this,R.raw.clickboton);
        imvHome = (ImageButton) findViewById(R.id.imv_home);
        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
                startActivity(new Intent(Home.this, Login.class));
            }
        });
    }

}
