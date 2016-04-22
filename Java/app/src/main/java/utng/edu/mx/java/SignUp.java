package utng.edu.mx.java;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utng.edu.mx.java.dao.DBHelper;
import utng.edu.mx.java.dao.UsuarioDAOImpl;
import utng.edu.mx.java.Util.DBAdapter;
import utng.edu.mx.java.model.Usuario;

/**
 * Created by Gustavo on 29/02/2016.
 */
public class SignUp  extends AppCompatActivity implements View.OnClickListener {

    private DBHelper dbHelper;
    private UsuarioDAOImpl dao;
    private SQLiteDatabase db;
    private Usuario usuario;
    private DBAdapter dbAdapter;
    private Button btnRegresar;
    private MediaPlayer mpSound;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        dbHelper = new DBHelper(this, dbHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new UsuarioDAOImpl();

        initComponents();
    }
    private void initComponents() {
        btnRegresar = (Button) findViewById(R.id.Btn_regresar);
        btnRegresar.setOnClickListener(this);
        mpSound=MediaPlayer.create(this,R.raw.cli);


    }
    public void onClick(View v) {
        mpSound.start();
        if(v.getId() == R.id.Btn_regresar){
            startActivity(new Intent(SignUp.this,MainActivity.class));
        }
    }

    public void onSignUpClick(View v){
        mpSound.start();
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
                Toast pass = Toast.makeText(SignUp.this, R.string.passdifferent, Toast.LENGTH_SHORT);
                pass.show();

            }
            else {
                //insertar datos en la base de datos

                usuario = new Usuario(
                        0,
                        namestr.toString(),
                        emailstr.toString(),
                        pass1str.toString()
                );

                if (usuario.getIdUsuario() == 0) {
                    dao.agregar(usuario, db);
                } else {
                    dao.modificar(usuario, db);
                }
                int[] datosLog = dbAdapter.login(namestr, pass1str);
                Toast.makeText(SignUp.this, "0 = " + datosLog[0] + "1 =" + datosLog[1], Toast.LENGTH_SHORT).show();
                Log.e("Registro", "onSingUpClick: ");
                dbAdapter.addTopics(datosLog[1]);
                int numTemas =  dbAdapter.totalTemas();
                Log.e("Total temas", "Metodo agregar" + numTemas);

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
