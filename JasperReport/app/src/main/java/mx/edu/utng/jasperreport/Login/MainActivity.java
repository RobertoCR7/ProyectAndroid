package mx.edu.utng.jasperreport.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.jasperreport.BienvenidaActivity;
import mx.edu.utng.jasperreport.IntroduccionPrevioActivity;
import mx.edu.utng.jasperreport.R;
import mx.edu.utng.jasperreport.Util.DBAdapter;

public class MainActivity extends Activity {

    private DBAdapter dbAdapter;
    public static int ID_USUARIO=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();

    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.btn_acceder){
            EditText a = (EditText)findViewById(R.id.edt_usuario);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_contrasenia);
            String pass = b.getText().toString();
            int[] datosLog=dbAdapter.login(str,pass);
            if (datosLog[0]==1){
                ID_USUARIO=datosLog[1];
                Intent i = new Intent(MainActivity.this, Display.class);//AccederActividad
                i.putExtra("Username", str);
                startActivity(i);
            }else {
                Toast temp = Toast.makeText(MainActivity.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }
        }

        if(view.getId() == R.id.btn_nuevo_usuario){
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        } else if (view.getId() == R.id.btn_cancelar){
            Intent i = new Intent(MainActivity.this, BienvenidaActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.btn_previo){
            Intent i = new Intent(MainActivity.this, IntroduccionPrevioActivity.class);
            startActivity(i);
        }
    }
}