package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.androidjuegos.dao.DBHelper;
import mx.edu.utng.androidjuegos.dao.UsuarioDAOImpl;
import mx.edu.utng.androidjuegos.model.Usuario;
import mx.edu.utng.androidjuegos.util.DBAdapter;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class RegistroActividad extends Activity{

    private Button btnGo;
    private DBAdapter dbAdapter;
    private DBHelper dbHelper;
    private Usuario usuario;
    private SQLiteDatabase db;
    private UsuarioDAOImpl dao;




    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_layout);

        dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        dbHelper = new DBHelper(this, dbHelper.DATABASE_NAME, null, dbHelper.DATABASE_VERSION);
        db=dbHelper.getWritableDatabase();
        dao = new UsuarioDAOImpl();

        btnGo = (Button)findViewById(R.id.btn_go);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActividad.this, LogeoActividad.class);
                startActivity(intent);
            }
        });
    }
    public void onSignUpClick(View v){
        if(v.getId() == R.id.Bsignupbutton){
            EditText name =(EditText)findViewById(R.id.edt_nombre_registro);
            EditText email =(EditText)findViewById(R.id.edt_email_reg);
            EditText usuarioname =(EditText)findViewById(R.id.edt_usuario_reg);
            EditText contrasenia1 =(EditText)findViewById(R.id.edt_contrasenia);
            EditText contrasenia2 =(EditText)findViewById(R.id.edt_confirm_contrasenia);

            String nametext = name.getText().toString();
            String emailtext = email.getText().toString();
            String usuariotext = usuarioname.getText().toString();
            String pass1text = contrasenia1.getText().toString();
            String pass2text = contrasenia2.getText().toString();

            if(!pass1text.equals(pass2text)){
                //mensage
                Toast pass = Toast.makeText(RegistroActividad.this,"Las Contrasenias No Coinciden", Toast.LENGTH_SHORT);
                pass.show();

            }
            else {
                    if(nametext.length()>3&pass1text.length()>3) {


                        usuario = new Usuario(
                                0,
                                name.getText().toString(),
                                email.getText().toString(),
                                pass1text.toString()
                        );

                        if (usuario.getIdUsuario() == 0) {
                            dao.agregar(usuario, db);
                        } else {

                            dao.modificar(usuario, db);

                        }

                        int[] datosLog = dbAdapter.login(nametext, pass1text);
                        Toast.makeText(RegistroActividad.this, "0=" + datosLog[0] + " 1=" + datosLog[1], Toast.LENGTH_SHORT).show();
                        Log.e("", " onSignUpClick: " + "0=" + datosLog[0] + " 1=" + datosLog[1]);

                        dbAdapter.addModulos(datosLog[1]);
                        int  totalModulos=dbAdapter.totalModulos();
                        Log.e("Total Modulos", "onSignUpClick: " + totalModulos);

                        int  totalTemas=dbAdapter.totalTemas();
                        Log.e("Total Temas", "onSignUpClick: "+totalTemas);

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
                        Toast.makeText(RegistroActividad.this, "Minimo 4 caracteres en los campos", Toast.LENGTH_SHORT).show();
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
