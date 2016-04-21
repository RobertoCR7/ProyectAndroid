package utng.edu.utng.html5apli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import utng.edu.utng.html5apli.util.DBAdapter;

public class LogeoActividad extends AppCompatActivity {
    private DBAdapter dbAdapter;
    public static int ID_USUARIO_LOGEADO =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logeo_layout);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();

    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.btn_login){
            EditText a = (EditText)findViewById(R.id.edt_usuario_log);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_contrase_log);
            String pass = b.getText().toString();
            int[] datosLog=dbAdapter.login(str,pass);
            if (datosLog[0]==1){
                ID_USUARIO_LOGEADO=datosLog[1];
                //dbAdapter.addTopics(datosLog[1]);
                ID_USUARIO_LOGEADO =datosLog[1];
                Intent i = new Intent(LogeoActividad.this, SplashScreenActivityBienbenida.class);//AccederActividad
                i.putExtra("Username", str);
                startActivity(i);
            }else {
                Toast temp = Toast.makeText(LogeoActividad.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if(view.getId() == R.id.Bsignup){

            Intent i = new Intent(LogeoActividad.this, RegistroActivity.class);
            startActivity(i);
        }else if (view.getId() == R.id.btn_visita){
            Intent i = new Intent(LogeoActividad.this, VisitaActivity.class);
            startActivity(i);
        }
    }
}
