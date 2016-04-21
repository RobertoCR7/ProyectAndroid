package utng.edu.utng.html5apli.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import utng.edu.utng.html5apli.model.Usuario;

/**
 * Created by kevin Castillo  on 09/04/2016..
 */
public interface UsuarioDAO {
    void agregar(Usuario usuario, SQLiteDatabase db);
    void modificar(Usuario usuario, SQLiteDatabase db);
    void eliminar(Usuario usuario, SQLiteDatabase db);
    Cursor listar(SQLiteDatabase db);
}
