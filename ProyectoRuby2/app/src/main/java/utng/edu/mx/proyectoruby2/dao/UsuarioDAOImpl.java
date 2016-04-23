package utng.edu.mx.proyectoruby2.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import utng.edu.mx.proyectoruby2.model.Usuario;
import utng.edu.mx.proyectoruby2.util.DBAdapter;

/**
 * Created by Juan Ramon Delgado Mendoza on 07/03/2016.
 * @author Juan Ramon Delgado Mendoza
 * @email mon-ra16@hotmail.com
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void agregar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values= new ContentValues();
        values.put(DBHelper.NAME, usuario.getNombre());
        values.put(DBHelper.MAIL, usuario.getCorreo());
        values.put(DBHelper.PASSWORD, usuario.getContrasena());
        db.insert(DBHelper.TABLE_NAME_1, null, values);
    }

    @Override
    public void modificar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values= new ContentValues();
        values.put(DBHelper.NAME, usuario.getNombre());
        values.put(DBHelper.MAIL, usuario.getCorreo());
        values.put(DBHelper.PASSWORD, usuario.getContrasena());
        db.update(DBHelper.TABLE_NAME_1, values, DBHelper.ID + "=" + usuario.getIdUsuario(), null);
    }

    @Override
    public void eliminar(Usuario usuario, SQLiteDatabase db) {
        db.delete(DBHelper.TABLE_NAME_1, DBHelper.ID + " = " + usuario.getIdUsuario(), null);
        db.delete(DBHelper.TABLE_NAME_3,DBHelper.USER_ID + " = " + usuario.getIdUsuario(),null);

        try {
            //DBAdapter dbAdapter = new DBAdapter();
            //dbAdapter.eliminarModulosTemas(usuario.getIdUsuario());
        }catch (Error e){
            Log.e("UsuarioDaoImpl", "eliminar: "+e.toString());
        }

    }

    @Override
    public Cursor listar(SQLiteDatabase db) {
        return db.query(DBHelper.TABLE_NAME_1,null,null,null,null,null,null);
    }

}
