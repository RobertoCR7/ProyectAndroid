package mx.edu.utng.jasperreport.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mx.edu.utng.jasperreport.Model.Usuario;

/**
 * Created by Erick on 23/02/2016.
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    //Pasamos los datos del usuario para añadirlos a la bd
    @Override
    public void agregar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values= new ContentValues();
        values.put(DBHelper.NAME, usuario.getNombre());
        values.put(DBHelper.MAIL, usuario.getCorreo());
        values.put(DBHelper.PASSWORD, usuario.getContrasena());
        db.insert(DBHelper.TABLE_NAME_1, null, values);
    }

    //Pasamos los datos del usuario para modificarlos a la bd
    @Override
    public void modificar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values= new ContentValues();
        values.put(DBHelper.NAME, usuario.getNombre());
        values.put(DBHelper.MAIL, usuario.getCorreo());
        values.put(DBHelper.PASSWORD, usuario.getContrasena());
        db.update(DBHelper.TABLE_NAME_1, values, DBHelper.ID + "=" + usuario.getIdUsuario(), null);
    }

    //Eliminamos el registro del usuario
    @Override
    public void eliminar(Usuario usuario, SQLiteDatabase db) {
    db.delete(DBHelper.TABLE_NAME_1, DBHelper.ID + " = " + usuario.getIdUsuario(), null);
    }

    //Listamos los usuarios
    @Override
    public Cursor listar(SQLiteDatabase db) {
        return db.query(DBHelper.TABLE_NAME_1,null,null,null,null,null,null);
    }

}
