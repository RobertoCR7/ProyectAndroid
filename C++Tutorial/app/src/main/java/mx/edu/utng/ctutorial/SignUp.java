package mx.edu.utng.ctutorial;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.ctutorial.dao.DBHelper;
import mx.edu.utng.ctutorial.dao.UsuarioDAOImpl;
import mx.edu.utng.ctutorial.model.Usuario;
import mx.edu.utng.ctutorial.util.DBAdapter;
/**
 * Created by Enrique on 02/03/2016.
 */
public class SignUp extends Activity{

    private DBAdapter dbAdapter;
    private Usuario usuario;
    private UsuarioDAOImpl dao;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity_layout);
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();

        dbHelper= new DBHelper(this, DBHelper.DATABASE_NAME,null, DBHelper.DATABASE_VERSION);
        db= dbHelper.getWritableDatabase();
        dao= new UsuarioDAOImpl();

    }
    public void onSignUpClick(View v){
        if(v.getId() == R.id.Bsignupbutton){
            EditText name =(EditText)findViewById(R.id.TFname);
            EditText email =(EditText)findViewById(R.id.TFemail);
            EditText uname =(EditText)findViewById(R.id.TFuname);
            EditText pass1 =(EditText)findViewById(R.id.TFpass1);
            EditText pass2 =(EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //mensage
                Toast pass = Toast.makeText(SignUp.this,"Las Contrasenias No Coinciden", Toast.LENGTH_SHORT);
                pass.show();

            }
            else{
                //insertar datos en la base de datos
                usuario = new Usuario(
                        0,
                        namestr.toString(),
                        emailstr.toString(),
                        pass1str.toString()
                );


                if (usuario.getIdUsuario()==0){
                    dao.agregar(usuario,db);
                }

                int[] datosLog= dbAdapter.login(namestr,pass1str);
                Toast.makeText(SignUp.this, "0="+datosLog[0]+" 1="+datosLog[1], Toast.LENGTH_SHORT).show();
                dbAdapter.addModulos(datosLog[1]);
                int totalModulos=dbAdapter.totalModulos();
                Log.e("total Modulos", "onSignUpClick: " + totalModulos);
                int totalTemas=dbAdapter.totalTemas();
                Log.e("total Temas", "onSignUpClick: "+ totalTemas);

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
