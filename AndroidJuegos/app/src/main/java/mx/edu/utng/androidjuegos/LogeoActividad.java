package mx.edu.utng.androidjuegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.androidjuegos.util.DBAdapter;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class LogeoActividad extends AppCompatActivity {
    private DBAdapter dbAdapter;
    public static int  ID_USUARIO=0;



    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logeo_layout);
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();


    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.btn_login){
            EditText a = (EditText)findViewById(R.id.edt_usuario_log);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_contrase_log);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            int[] datosLog = dbAdapter.login(str,pass);
            if (datosLog[0]==1){
                Intent i = new Intent(LogeoActividad.this, SplashScreenActivityBienbenida.class);//AccederActividad
                i.putExtra("Username",str);
                startActivity(i);
                ID_USUARIO=datosLog[1];

            }else{
                Toast temp = Toast.makeText(LogeoActividad.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
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

            Intent i = new Intent(LogeoActividad.this, RegistroActividad.class);
            startActivity(i);
        }else if(view.getId() == R.id.btn_vista){
            Intent i = new Intent(LogeoActividad.this, PrevioActivity.class);
            startActivity(i);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
