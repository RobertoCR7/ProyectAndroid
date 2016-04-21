package utng.edu.utng.html5apli;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utng.edu.utng.html5apli.dao.UsuarioDAOImpl;
import utng.edu.utng.html5apli.model.Usuario;
import utng.edu.utng.html5apli.util.DBAdapter;

/**
 * Created by Kevin Castillo on 05/03/2016.
 */
public class RegistroActivity extends AppCompatActivity{

    private DBAdapter dbAdapter;
    private Button entrar;
    private Usuario usuario;
    private SQLiteDatabase db;
    private UsuarioDAOImpl dao;
    private utng.edu.utng.html5apli.dao.DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_layout);
        dbAdapter= new DBAdapter(this);
        dbAdapter.open();

        dbHelper= new utng.edu.utng.html5apli.dao.DBHelper(this, utng.edu.utng.html5apli.dao.
                DBHelper.DATABASE_NAME,null, utng.edu.utng.html5apli.dao.DBHelper.DATABASE_VERSION);
        db= dbHelper.getWritableDatabase();
        dao= new UsuarioDAOImpl();
        //

        entrar = (Button)findViewById(R.id.btn_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, LogeoActividad.class);
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

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String usuariostr = usuarioname.getText().toString();
            String pass1str = contrasenia1.getText().toString();
            String pass2str = contrasenia2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //mensage
                Toast pass = Toast.makeText(RegistroActivity.this, R.string.verif_contrasena, Toast.LENGTH_SHORT);
                pass.show();

            }
            else{
                usuario = new Usuario(
                        0,
                        namestr.toString(),
                        emailstr.toString(),
                        pass1str.toString()
                );

                if (usuario.getIdUsuario()==0){
                    dao.agregar(usuario,db);

                }else{
                    dao.modificar(usuario,db);
                }

                int[] datosLog=dbAdapter.login(namestr,pass1str);
                Toast.makeText(RegistroActivity.this, "0="+datosLog[0]+" 1="+datosLog[1], Toast.LENGTH_SHORT).show();
                Log.e("", "onSignUpClick: " + "0=" + datosLog[0] + " 1=" + datosLog[1]);
                dbAdapter.addTopics(datosLog[1]);

                int numTemas=dbAdapter.totalTemas();
                Log.e(getString(R.string.total_tem),getString(R.string.add_tem)+ numTemas);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
