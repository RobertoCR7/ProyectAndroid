package utng.edu.mx.java.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import utng.edu.mx.java.model.Usuario;


/**
 * Created by Gustavo on 23/02/2016.
 */
public interface UsuarioDAO {
    void agregar(Usuario usuario, SQLiteDatabase db);
    void modificar(Usuario usuario, SQLiteDatabase db);
    void eliminar(Usuario usuario, SQLiteDatabase db);
    Cursor listar(SQLiteDatabase db);
}
