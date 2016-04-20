package com.herprogramacion.ajax.quiz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by griselda on 23/02/2016.
 * Corregir autor
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void agregar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values= new ContentValues();
        values.put(DbHelper.NAME, usuario.getNombre());
        values.put(DbHelper.PASSWORD, usuario.getContrasena());
        db.insert(DbHelper.TABLE_NAME_1, null, values);
    }
}
