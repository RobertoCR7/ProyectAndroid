package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.AplicacionXML.dao.DBHelper;
import mx.edu.utng.AplicacionXML.dao.UsuarioDAOImpl;
import mx.edu.utng.AplicacionXML.model.Usuario;
import mx.edu.utng.AplicacionXML.util.DBAdapter;

/**
 * Created by Roberto on 29/02/2016.
 */
public class RegistroActivity extends Activity{

    private Button btnGo;
    private DBAdapter dbAdapter;
    private DBHelper dbHelper;
    private Usuario usuario;
    private SQLiteDatabase db;
    private UsuarioDAOImpl dao;


    EditText name,email,uname,pass1,pass2;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        dbHelper = new DBHelper(this, dbHelper.DATABASE_NAME, null, dbHelper.DATABASE_VERSION);
        db=dbHelper.getWritableDatabase();
        dao = new UsuarioDAOImpl();

        btnGo = (Button)findViewById(R.id.btn_login);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onSignUpClick(View v){
        if (v.getId() == R.id.Bsignupbutton) {
            name = (EditText) findViewById(R.id.TFname);
            email = (EditText) findViewById(R.id.TFemail);
            uname = (EditText) findViewById(R.id.TFuname);
            pass1 = (EditText) findViewById(R.id.TFpass1);
            pass2 = (EditText) findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (!pass1str.equals(pass2str)) {
                //mensage
                Toast pass = Toast.makeText(RegistroActivity.this, "Las Contrasenias No Coinciden", Toast.LENGTH_SHORT);
                pass.show();

            }
            else {
                if(namestr.length()>3&pass1str.length()>3) {

                    usuario = new Usuario(
                            0,
                            name.getText().toString(),
                            email.getText().toString(),
                            pass1str.toString()
                    );

                    if (usuario.getIdUsuario() == 0) {
                        dao.agregar(usuario, db);
                    } else {

                        dao.modificar(usuario, db);
                    }

                    int[] datosLog = dbAdapter.login(namestr, pass1str);
                    Toast.makeText(RegistroActivity.this, "0=" + datosLog[0] + " 1=" + datosLog[1], Toast.LENGTH_SHORT).show();
                    Log.e("", " onSignUpClick: " + "0=" + datosLog[0] + " 1=" + datosLog[1]);
                    dbAdapter.addModulos(datosLog[1]);
                    int totalModulos=dbAdapter.totalModulos();
                    Log.e("Total Modulos", "onSignUpClick: " + totalModulos);
                    int totalTems=dbAdapter.totalTemas();
                    Log.e("Total Temas", "onSignUpClick: "+totalTems );

                    name.setText("");email.setText("");uname.setText("");pass1.setText("");pass2.setText("");

               /*og.e("numeroModulos", "="+numero);
                //insertar datos en la base de datos
                /*
                DatosActividad c = new DatosActividad();
                c.setName(nametext);
                c.setEmail(emailtext);
                c.setUname(usuariotext);
                c.setPass(pass1text);

                helper.insertContact(c);
                Toast pass = Toast.makeText(RegistroActividad.this,"Datos Guardados", Toast.LENGTH_SHORT);
                pass.show();*/
                }else {
                    Toast.makeText(RegistroActivity.this, "Solo acepta minimo 4 caracteres ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
