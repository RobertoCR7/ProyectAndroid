package com.herprogramacion.ajax.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.herprogramacion.ajax.R;


/**
 * Created by Rodrigo Cortes Armas on 04/04/2016.
 */
public class SplashActivity extends Activity{
    protected boolean active= true;
    protected int splashTime  = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);

        Thread splahsThread = new Thread(){
            @Override
            public void run(){
                try{
                    int waited = 0;
                    while (active && (waited < splashTime)){
                        sleep(100);
                        if (active){
                            waited += 100;
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    openApp();

                }

            }

        };
        splahsThread.start();
    }
    private void openApp(){
        finish();
        startActivity(new Intent(this,PrivilegiosActivity.class));
    }

}
