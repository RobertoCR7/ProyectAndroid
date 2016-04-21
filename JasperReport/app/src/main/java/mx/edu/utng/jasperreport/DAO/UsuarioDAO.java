package mx.edu.utng.jasperreport.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mx.edu.utng.jasperreport.Model.Usuario;


/**
 * Created by Erick on 23/02/2016.
 * Faltan comentarios en la clase y los metodos
 */
public interface UsuarioDAO {
    void agregar(Usuario usuario, SQLiteDatabase db);// Agregamos el usuario a la bd
    void modificar(Usuario usuario, SQLiteDatabase db); // Modificamos el usuario a la bd
    void eliminar(Usuario usuario, SQLiteDatabase db); // Eliminamos el usuario a la bd
    Cursor listar(SQLiteDatabase db); // Agregamos el usuario a la bd
}
