package utng.edu.mx.java;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import utng.edu.mx.java.Util.DBAdapter;

/**
 * Created by Gustavo on 23/03/2016.
 */

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    private Bundle bundle;
    private MediaPlayer mpSound;
    private DBAdapter dbAdapter;
    public static int ID_USUARIO=0;
    public static String NOMBRE="";
    public static String CORREO="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        bundle=new Bundle();
        mpSound = MediaPlayer.create(this,R.raw.cli);
    }

    public void onButtonClick(View view){
        mpSound.start();
        bundle=new Bundle();
        if(view.getId() == R.id.Blogin){

            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();


            int[] datosLog = dbAdapter.login(str, pass);
            if(datosLog[0] == 1){
                ID_USUARIO=datosLog[1];
                String id=String.valueOf(ID_USUARIO);
                String[] datos=dbAdapter.informacionUsuario(id);
                NOMBRE=datos[0];
                CORREO=datos[1];

                bundle.putBoolean("logeoU",true);
                Intent i = new Intent(MainActivity.this, Display.class).putExtras(bundle);
                i.putExtra("Username",str);
                startActivity(i);

            }else{
                Toast temp = Toast.makeText(MainActivity.this, R.string.pass_invalidates, Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if(view.getId() == R.id.Bsignup){
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }
        protected void onPause() {
        super.onPause();
        finish();
    }

}
