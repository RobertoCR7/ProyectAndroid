package utng.edu.mx.java;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Gustavo on 22/03/2016.
 */

public class SplashScreenActivity extends Activity {

    private static final long SPLASH_SCREEN_DELAY=2000;//Duracion

    //metodo onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_secreen_layout);

        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent=new Intent().setClass(SplashScreenActivity.this,OpcionesLogeoActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer=new Timer();
        timer.schedule(task,SPLASH_SCREEN_DELAY);
    }

        protected void onPause(){
        super.onPause();
        finish();
}
}
