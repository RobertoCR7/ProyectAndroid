package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.jasperreport.Login.SignUp;

/**
 * Created by Erick on 03/02/2016.
 */
public class IntroduccionPrevioActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu_previo);
    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.btn_registrarse){
            Intent i = new Intent(IntroduccionPrevioActivity.this, SignUp.class);
            startActivity(i);
        }
    }
}
