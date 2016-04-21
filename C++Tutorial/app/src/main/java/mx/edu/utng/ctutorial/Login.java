package mx.edu.utng.ctutorial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.ctutorial.util.DBAdapter;

/**
 * Created by Enrique on 02/03/2016.
 */


public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button aceptar;
    private Button registrarse;
    private MediaPlayer sound;
    private Button masTarde;
    private Bundle bundle;
    private DBAdapter dbAdapter;
    public  static int ID_USUARIO=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        sound = MediaPlayer.create(this,R.raw.clickboton);
        aceptar = (Button) findViewById(R.id.btn_login);
        aceptar.setOnClickListener(this);
       registrarse = (Button) findViewById(R.id.btn_signup);
        registrarse.setOnClickListener(this);
        masTarde = (Button)findViewById(R.id.btn_low);
        masTarde.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        bundle = new Bundle();
        bundle.putBoolean("logeo",false);
       switch (v.getId()){
           case R.id.btn_login:
        EditText a = (EditText)findViewById(R.id.edt_Usuario);
        String str = a.getText().toString();

        EditText b = (EditText)findViewById(R.id.edt_Clave);
        String pass = b.getText().toString();

              int[] datos= dbAdapter.login(str,pass);

               if (datos[0]==1){
                   ID_USUARIO=datos[1];
                   bundle.putBoolean("logeo", true);
                   bundle.putString("Username", str);
                   Intent i = new Intent(Login.this, Display.class).putExtras(bundle);
                   startActivity(i);

               }else {
                   Toast temp = Toast.makeText(Login.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                   temp.show();
               }

        break;
           case R.id.btn_signup:
               Intent i = new Intent(Login.this, SignUp.class);
               startActivity(i);
               break;
           case  R.id.btn_low:
               startActivity(new Intent(Login.this,Display.class).putExtras(bundle));
               break;
    }
    }
}