package mx.edu.utng.jasperreport.Login;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.jasperreport.DAO.DBHelper;
import mx.edu.utng.jasperreport.DAO.UsuarioDAOImpl;
import mx.edu.utng.jasperreport.Model.Usuario;
import mx.edu.utng.jasperreport.R;
import mx.edu.utng.jasperreport.Util.DBAdapter;

/**
 * Created by Erick on 29/02/2016.
 */
public class SignUp  extends Activity{

    private DBAdapter dbAdapter;
    private Usuario usuario;
    private SQLiteDatabase db;
    private UsuarioDAOImpl dao;
    private DBHelper dbHelper;

    DBAdapter helper = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar);
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();

        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new UsuarioDAOImpl();

    }
    public void onSignUpClick(View v){
        if(v.getId() == R.id.btn_registrar){
            EditText name =(EditText)findViewById(R.id.edt_nombre);
            EditText email =(EditText)findViewById(R.id.edt_correo);
            EditText uname =(EditText)findViewById(R.id.edt_usuario);
            EditText pass1 =(EditText)findViewById(R.id.edt_contrasenia);
            EditText pass2 =(EditText)findViewById(R.id.edt_contrasenia_confirmacion);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //mensaje
                Toast pass = Toast.makeText(SignUp.this, R.string.incorrect_pass, Toast.LENGTH_SHORT);
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

                    int[] datosLog = dbAdapter.login(namestr, pass1str);
                    Toast.makeText(SignUp.this, "0 = " + datosLog[0] + "1 = " + datosLog[1], Toast.LENGTH_SHORT).show();
                    Log.e("", "onSignUpClick: " + "0=" + datosLog[0] + " 1=" + datosLog[1]);
                    dbAdapter.addTopics(datosLog[1]);
                    int numTemas = dbAdapter.totalTemas();
                    Log.e("Total modulos", "Metodo Agregar"+ numTemas);

                /*Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
                Toast pass = Toast.makeText(SignUp.this, R.string.succeful, Toast.LENGTH_SHORT);
                pass.show();*/

                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
