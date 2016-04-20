package mx.edu.utng.AplicacionXML;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.AplicacionXML.util.DBAdapter;


/**
 * Created by Roberto on 06/02/2016.
 */

public class LoginActivity extends AppCompatActivity {
    private DBAdapter dbAdapter;
    public static int ID_USUARIO=0;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();


    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.Blogin){
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            int[] datosLog = dbAdapter.login(str,pass);
            Log.e("LOGEOe", "onButtonClick: "+datosLog[1]);
            if (datosLog[0]==1){
                Intent i = new Intent(LoginActivity.this, Display.class);//AccederActividad
                i.putExtra("Username",str);
                startActivity(i);
                ID_USUARIO=datosLog[1];

            }else{
                Toast temp = Toast.makeText(LoginActivity.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }
            /*
            if(pass.equals(password)){
                Intent i = new Intent(LogeoActividad.this, SplashScreenActivityBienbenida.class);//AccederActividad
                i.putExtra("Username",str);
                startActivity(i);

            }else{
                Toast temp = Toast.makeText(LogeoActividad.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }
   */



        }
        if(view.getId() == R.id.Bsignup){

            Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(i);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
