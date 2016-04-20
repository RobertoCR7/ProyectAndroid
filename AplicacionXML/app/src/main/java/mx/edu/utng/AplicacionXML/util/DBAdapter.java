package mx.edu.utng.AplicacionXML.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.AplicacionXML.LoginActivity;
import mx.edu.utng.AplicacionXML.dao.DBHelper;
import mx.edu.utng.AplicacionXML.model.Modulo;
import mx.edu.utng.AplicacionXML.model.Question;
import mx.edu.utng.AplicacionXML.model.Tema;


/**
 * Created by Roberto on 07/03/2016.
 */
public class DBAdapter {
    SQLiteDatabase db;
    DBHelper dbHelper;
    Context context;


    public DBAdapter(Context c) {
        this.context = c;
    }

    public DBAdapter open() throws SQLException {
        dbHelper = new DBHelper(context, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    //Me comprueba si esta logeado y si me trae su ID
    public int[] login(String nomUsu, String contrUsu) {
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME_1 + " WHERE nombre=? AND contrasena=?", new String[]{nomUsu, contrUsu});
        int[] datosLogeo = new int[2];
        datosLogeo[0] = 0;
        datosLogeo[1] = 0;
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                datosLogeo[0] = 1;
                cursor.moveToFirst();
                datosLogeo[1] = cursor.getInt(cursor.getColumnIndex(DBHelper.ID));
                return datosLogeo;
            }

        }
        return datosLogeo;
    }


    public boolean existUsu() {

        Cursor cursor = db.query(DBHelper.TABLE_NAME_1, new String[]{DBHelper.NAME}, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                return true;
            }

        }
        return false;
    }

    public String[] getAllUsuDB() {
        Cursor cursor = db.query(DBHelper.TABLE_NAME_1, new String[]{DBHelper.NAME}, null, null, null, null, null);
        String[] strUsu = new String[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext()) {
            strUsu[i] = cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
            i++;
        }
        return strUsu;
    }


    public String[] informacionUsuario(String nomUsu) {

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME_1 + " WHERE _id=? ", new String[]{nomUsu});

        String[] infoUsu = new String[2];
        cursor.moveToFirst();
        infoUsu[0] = cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
        infoUsu[1] = cursor.getString(cursor.getColumnIndex(DBHelper.MAIL));
        return infoUsu;
    }

    // ese es el metodo que inserta los valores ala base mediante la utilizacion  del metodo put
    private void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_QUES, quest.getQUESTION());
        values.put(DBHelper.KEY_ANSWER, quest.getANSWER());
        values.put(DBHelper.KEY_OPTA, quest.getOPTA());
        values.put(DBHelper.KEY_OPTB, quest.getOPTB());
        values.put(DBHelper.KEY_OPTC, quest.getOPTC());
        // Inserting Row
        db.insert(DBHelper.TABLE_NAME_3, null, values);
    }

    public void addTopics(int idModulo, int numeroModulo) {
        Tema tema;
        switch (numeroModulo) {
            case 1:
                tema = new Tema("mod_1_tem_1", idModulo, true, 0);
                this.addTopic(tema);
                break;
            case 2:
                idModulo++;
                tema = new Tema("mod_2_tem_1", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_2_tem_2", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_2_tem_3", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_2_tem_4", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_2_tem_5", idModulo, false, 0);
                this.addTopic(tema);
                break;
            case 3:
                idModulo =idModulo+ 2;
                tema = new Tema("mod_3_tem_1", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_2", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_3", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_4", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_5", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_6", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_7", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_3_tem_8", idModulo, false, 0);
                this.addTopic(tema);

                break;
            case 4:
                idModulo =idModulo+ 3;
                tema = new Tema("mod_4_tem_1", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_4_tem_2", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_4_tem_3", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_4_tem_4", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_4_tem_5", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_4_tem_6", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_4_tem_7", idModulo, false, 0);
                this.addTopic(tema);
                break;
            case 5:
                idModulo =idModulo+ 4;
                tema = new Tema("mod_5_tem_1", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_2", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_3", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_4", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_5", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_6", idModulo, true, 0);
                this.addTopic(tema);
                break;
            default:
                break;
        }


    }

    private void addTopic(Tema tema) {

        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, tema.getNombre());
        values.put(DBHelper.ACTIVO, tema.isActivo() == true ? 1 : 0);
        values.put(DBHelper.CALIFICACION, tema.getCalificacion());
        values.put(DBHelper.MOD_ID, tema.getIdModulo());
        // Inserting Row
        db.insert(DBHelper.TABLE_NAME_2, null, values);

    }

    public int idModulo1(int idUsuario, String nombreModulo) {
        String idUsu =
                String.valueOf(idUsuario);
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND " + DBHelper.USER_ID + " " + " = ?  ",
                new String[]{nombreModulo, idUsu});

        int idModulo = 1;
        if (cursor != null) {
            cursor.moveToFirst();
            idModulo = cursor.getInt(cursor.getColumnIndex(DBHelper.ID));
            return idModulo;
        }
        return idModulo;
    }

    public void addModulos(int idUsuario) {
        Modulo modulo;
        modulo = new Modulo(idUsuario, "Modulo_1", true);
        this.addModulo(modulo);
        modulo = new Modulo(idUsuario, "Modulo_2", false);
        this.addModulo(modulo);
        modulo = new Modulo(idUsuario, "Modulo_3", false);
        this.addModulo(modulo);
        modulo = new Modulo(idUsuario, "Modulo_4", false);
        this.addModulo(modulo);
        modulo = new Modulo(idUsuario, "Modulo_5", false);
        this.addModulo(modulo);


        int idModUno = idModulo1(idUsuario, "Modulo_1");

        addTopics(idModUno, 1);
        addTopics(idModUno, 2);
        addTopics(idModUno, 3);
        addTopics(idModUno, 4);
        addTopics(idModUno, 5);


        addQuestions();


    }

    private void addModulo(Modulo modulo) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, modulo.getNombre());
        values.put(DBHelper.USER_ID, modulo.getIdUsiario());
        values.put(DBHelper.ACTIVO, modulo.isActivo() == true ? 1 : 0);
        // Inserting Row
        db.insert(DBHelper.TABLE_NAME_4, null, values);

    }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_4;
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }

    //Hace una consulta para saber cunatos Modulos existen
    //sirve para comprobar si cuando se elimina el usuario se eliminan tambien sus modulos correspondientes
    public int totalModulos() {
        int row = 0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4, null);
        row = cursor.getCount();
        return row;
    }

    //Hace una consulta para saber cunatos Temas existen
    //sirve para comprobar si cuando se elimina el usuario se eliminan tambien sus temas correspondientes
    public int totalTemas() {
        int row = 0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2, null);
        row = cursor.getCount();
        return row;
    }

    // este metodo no s alluda ver si el kuis esta inactivo o activo
    public boolean statusModulo(int idUsuario, int numModulo) {
        String idUsu = String.valueOf(idUsuario);
        String nomMod = "";
        boolean activo = false;


        switch (numModulo) {
            case 1:
                nomMod = "Modulo_1";
                Cursor cursor = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomMod, idUsu});
                if (cursor != null) {
                    cursor.moveToFirst();
                    activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 2:
                nomMod = "Modulo_2";
                Cursor cursor1 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor1 != null) {
                    cursor1.moveToFirst();
                    activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 3:
                nomMod = "Modulo_3";
                Cursor cursor2 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor2 != null) {
                    cursor2.moveToFirst();
                    activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 4:
                nomMod = "Modulo_4";
                Cursor cursor3 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor3 != null) {
                    cursor3.moveToFirst();
                    activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 5:
                nomMod = "Modulo_5";
                Cursor cursor4 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor4 != null) {
                    cursor4.moveToFirst();
                    activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;


        }
        return false;
    }

    public boolean statusTema(int numMod, int numeroCap, int idModulo) {
        String idMod = String.valueOf(idModulo);
        String nomTema;
        boolean activo = false;


        switch (numMod) {
            case 1:
                switch (numeroCap) {
                    //Subtema 1 del Modulo 1
                    case 1:
                        nomTema = "mod_1_tem_1";
                        Cursor cursor = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor.moveToFirst();
                        activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                break;
            case 2:
                idModulo++;
                idMod = String.valueOf(idModulo);//se vuelbe asignar la variable de cadesnas
                switch (numeroCap) {
                    //Subtema 1 del Modulo 1
                    case 1:
                        nomTema = "mod_2_tem_1";
                        Cursor cursor = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor.moveToFirst();
                        activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2:
                        nomTema = "mod_2_tem_2";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3:
                        nomTema = "mod_2_tem_3";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4:
                        nomTema = "mod_2_tem_4";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5:
                        nomTema = "mod_2_tem_5";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                return activo;
            case 3:
                idModulo = idModulo + 2;
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    //Subtema 3 del Modulo 3
                    case 1:
                        nomTema = "mod_3_tem_1";
                        Cursor cursor = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor.moveToFirst();
                        activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2:
                        nomTema = "mod_3_tem_2";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3:
                        nomTema = "mod_3_tem_3";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4:
                        nomTema = "mod_3_tem_4";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5:
                        nomTema = "mod_3_tem_5";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6:
                        nomTema = "mod_3_tem_6";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 7:
                        nomTema = "mod_3_tem_7";
                        Cursor cursor6 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor6.moveToFirst();
                        activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 8:
                        nomTema = "mod_3_tem_8";
                        Cursor cursor8 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor8.moveToFirst();
                        activo = cursor8.getInt(cursor8.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                return activo;
            case 4:
                idModulo = idModulo + 3;
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    //Subtema 3 del Modulo 3
                    case 1:
                        nomTema = "mod_4_tem_1";
                        Cursor cursor = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor.moveToFirst();
                        activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2:
                        nomTema = "mod_4_tem_2";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3:
                        nomTema = "mod_4_tem_3";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4:
                        nomTema = "mod_4_tem_4";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5:
                        nomTema = "mod_4_tem_5";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6:
                        nomTema = "mod_4_tem_6";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 7:
                        nomTema = "mod_4_tem_7";
                        Cursor cursor6 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor6.moveToFirst();
                        activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                return activo;
            case 5:
                idModulo = idModulo + 4;
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    //Subtema 3 del Modulo 3
                    case 1:
                        nomTema = "mod_5_tem_1";
                        Cursor cursor = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor.moveToFirst();
                        activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2:
                        nomTema = "mod_5_tem_2";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3:
                        nomTema = "mod_5_tem_3";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4:
                        nomTema = "mod_5_tem_4";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5:
                        nomTema = "mod_5_tem_5";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6:
                        nomTema = "mod_5_tem_6";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " =?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                return activo;

        }
        return activo;

    }

    // Activa temas
    public void addCalifTemas(int idmodulo, int numModulo, int numTema, int calificacion) {

        ContentValues values = new ContentValues();
        String idUsu = String.valueOf(LoginActivity.ID_USUARIO);
        String nombreSubTemas = "";
        int calif = 0;

        int totalCal = 0;
        if (calificacion == 2) {
            totalCal = 10;
        } else if (calificacion == 1) {
            totalCal = 5;
        } else {
            totalCal = 0;
        }
        boolean isTopic = true;


        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        addCalifMdodulo(idUsu, 1);
                        isTopic = false;
                        break;
                }
                break;
            case 2:
                idmodulo++;
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_2_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_2_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_2_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_2_tem_5";
                        break;
                    case 5:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        addCalifMdodulo(idUsu, 2);
                        isTopic = false;
                        break;
                }
                break;
            case 3:
                idmodulo = idmodulo + 2;
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_3_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_3_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_3_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_3_tem_5";
                        break;
                    case 5:
                        nombreSubTemas = "mod_3_tem_6";
                        break;
                    case 6:
                        nombreSubTemas = "mod_3_tem_7";
                        break;
                    case 7:
                        nombreSubTemas = "mod_3_tem_8";
                        break;
                    case 8:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        addCalifMdodulo(idUsu, 3);
                        isTopic = false;
                        break;
                }
                break;
            case 4:
                idmodulo = idmodulo + 3;
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_4_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_4_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_4_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_4_tem_5";
                        break;
                    case 5:
                        nombreSubTemas = "mod_4_tem_6";
                        break;
                    case 6:
                        nombreSubTemas = "mod_4_tem_7";
                        break;
                    case 7:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        addCalifMdodulo(idUsu, 4);
                        isTopic = false;
                        break;
                }
                break;
            case 5:
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_5_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_5_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_5_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_5_tem_5";
                        break;
                    case 5:
                        nombreSubTemas = "mod_5_tem_6";
                        break;
                    case 6:
                        nombreSubTemas = "mod_5_tem_7";
                        break;
                }
                break;
        }
        if (isTopic) {
            if (totalCal == 10) {

                values.put(DBHelper.ACTIVO, true);
            } else {
                values.put(DBHelper.ACTIVO, false);
            }

            String idMos = String.valueOf(idmodulo);
            db.update(DBHelper.TABLE_NAME_2, values, DBHelper.MOD_ID + " = ? AND " + DBHelper.NAME + " LIKE ?", new String[]{idMos, nombreSubTemas});
        }
    }

    //Inserta calificacion
    public void insertarCalificacion(int idmodulo, int numModulo, int numTema) {
        String nombreSubTemas = "";
        ContentValues values = new ContentValues();

        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        nombreSubTemas = "mod_1_tem_1";
                        break;
                }
                break;
            case 2:
                idmodulo++;
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_2_tem_2";
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        break;
                    case 2:
                        nombreSubTemas = "mod_2_tem_3";
                        Log.e("Pepa:", "addCalifTemas: " + "Si entro");
                        // Este debe acativar el siguiente modulo
                        break;
                    case 3:
                        nombreSubTemas = "mod_2_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_2_tem_5";
                        break;
                    case 5:
                        // Este debe acativar el siguiente modulo  y ba  guardar la calificacion
                        break;
                }
                break;
            case 3:
                idmodulo = idmodulo + 2;
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_3_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_3_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_3_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_3_tem_5";
                        break;
                    case 5:
                        nombreSubTemas = "mod_3_tem_6";
                        break;
                    case 6:
                        nombreSubTemas = "mod_3_tem_7";
                        break;
                    case 7:
                        nombreSubTemas = "mod_3_tem_8";
                        break;
                    case 8:
                   //     nombreSubTemas = "mod_3_tem_9";
                        break;



                }

                break;
            case 4:
                idmodulo = idmodulo + 3;
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_4_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_4_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_4_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_4_tem_5";
                        break;
                    case 5:
                        nombreSubTemas = "mod_4_tem_6";
                        break;
                    case 6:
                        nombreSubTemas = "mod_4_tem_7";
                        break;
                    case 7:
                        // nombreSubTemas="mod_4_tem_7";
                        break;


                }
                break;
            case 5:
                switch (numTema) {
                    case 1:
                        nombreSubTemas = "mod_5_tem_2";
                        break;
                    case 2:
                        nombreSubTemas = "mod_5_tem_3";
                        break;
                    case 3:
                        nombreSubTemas = "mod_5_tem_4";
                        break;
                    case 4:
                        nombreSubTemas = "mod_5_tem_5";
                        break;
                    case 5:
                        nombreSubTemas = "mod_5_tem_6";
                        break;
                    case 6:
                        nombreSubTemas = "mod_5_tem_7";
                        break;

                }
                break;
        }


        values.put(DBHelper.ACTIVO, true);

        String idMos = String.valueOf(idmodulo);
        db.update(DBHelper.TABLE_NAME_2, values, DBHelper.MOD_ID + " = ? AND " + DBHelper.NAME + " LIKE ?", new String[]{idMos, nombreSubTemas});

    }

    private void addQuestions() {

        //================Introduccion XML============================================
        Question q1;
        //PAK Cero  -->Introducción --1(Intro)
        //Se crean las preguntas con sus posibles resultado y su resultado correcto
        q1 = new Question("¿Significaco de XML?", "extensible Markup language", "Ninguno", "Desarrollador de aplicaciones", "extensible Markup language");
        this.addQuestion(q1);
        q1 = new Question("Por que usar XML?", "Poque es dificil de manipular", "puede ser fácilmente\n" +
                "procesado y sus datos manipulados", "Ninguna", "puede ser fácilmente\n" +
                "procesado y sus datos manipulados");
        this.addQuestion(q1);
        //================Introduccion============================================


        //---------------ESTUDIANDO XML------------------
        //////////================XML METALENGUAJE=============================

        q1 = new Question("XML es un metalenguage?", "Ninguno", "NO", "SI", "NO");
        this.addQuestion(q1);
        q1 = new Question("Por que XML es un conjunto de Reglas?", "para definir\n" +
                "lenguajes de etiquetas (como XHTML)", "Por que lo pudes utilizar con todo", "ninguno", "para definir\n" +
                "lenguajes de etiquetas (como XHTML)");
        this.addQuestion(q1);

        //PAK dos  -->------------XML en el mundo rel-----------------
        q1 = new Question("En que trabaja XML?", "inversiones", "Comprecion", "Struts, Spring etc", "Struts, Spring etc");
        this.addQuestion(q1);
        q1 = new Question("En donde se aplica XML en el mundo real ?", "Base de datos, Servicios web, interfaces graficas", "al hacer un analisis ", "Ninguna", "Base de datos, Servicios web, interfaces graficas");
        this.addQuestion(q1);

        //PAK tres -->Terminos en xml-----------------------------
        q1 = new Question("Cuantas reglas sintaticas son?>", "6", "4", "2", "6");
        this.addQuestion(q1);
        q1 = new Question("cuales son unas de las  reglas sintaticas?", "Una raiz, Anidación de las etiquetas", "Configuracion, Administracion", "Ninguna", "Una raiz, Anidación de las etiquetas");
        this.addQuestion(q1);

        //PAK cuatro--> Difer
        // encias entre una BBDD y XML.
        q1 = new Question("Cual es la diferencia en una BBDD Y XML? ", "Que BBDD  no es dependiente de la SGBD Y XML NO", "Ninguno", "Una BBDD es binaria, XML es texto plano", "Una BBDD es binaria, XML es texto plano");
        this.addQuestion(q1);
        q1 = new Question("En una tabla importa el orden en XML? tema 4", "SI", "NO", "Ninguno", "SI");
        this.addQuestion(q1);


        //PAK cinco--> Caracteres NO PERMITE XML-------------------

        q1 = new Question("Completa siguiente codigo  <!_________ pizzas SYSTEM \"pizzas.dtd\">", "DOCTYPE", "hmtl,", "php", "DOCTYPE");
        this.addQuestion(q1);
        q1 = new Question("Cres que XML  sirve mucho para la programacion?", "SI", "NO", "Varias veces", "SI");
        this.addQuestion(q1);


        //=============================== TEMA///Manipulacion XML=============================


        //===========================SubTema///Tecnologias Para trabajar XML===============================0

        q1 = new Question("Escoje algunas de las tecnologias que sepueden utilizar con XML", "xml version=>, XHTML", "Ninguna", "API SAX, XQuery, XPath", "API SAX, XQuery, XPath");
        this.addQuestion(q1);
        q1 = new Question("Almenos una ventaja de XML?", "Ninguna", " Es un formato estructurado", "No se pude utilizar en todo", " Es un formato estructurado");
        this.addQuestion(q1);

        //--------------------- Simple API for XML------------------------
        q1 = new Question("Que significa API for XML?", "Orientado a eventos, Muy detallado,No construye nada en memoria, En tiempo real, Sin estado."
                , "Siglas para saber identificarlas", "Ninguna", "Orientado a eventos, Muy detallado,No construye nada en memoria, En tiempo real, Sin estado.");
        this.addQuestion(q1);
        q1 = new Question("Dime una buenas utilidades de XML", "Buena produccion", "Ofrece una interfaz para recorrer el árbol", "HTML", "Ofrece una interfaz para recorrer el árbol");
        this.addQuestion(q1);

        //-----------------------Simple API for XML Inconvenientes---------
        q1 = new Question("cuales son unos de los inconvenites de API for XML?", "Complejo para documentos complejos, mas lento", "Mala administracion", "Ninguna de las anteriores", "Complejo para documentos complejos, mas lento");
        this.addQuestion(q1);
        q1 = new Question("Que es un documento de Model", "Realiza modificaciones", "Contruye arboles de memoria entre otras cosas", "Ninguna", "Contruye arboles de memoria entre otras cosas");
        this.addQuestion(q1);

        //-------------------------XML Binding------------------------------
        q1 = new Question("Ques es XML Binding?", "Vincular un conjunto de clases con un\n" +
                "conjunto de estructuras XML.", "UN forma de porgramas facil mente", "Ninguna", "Vincular un conjunto de clases con un\n" +
                "conjunto de estructuras XML.");
        this.addQuestion(q1);
        q1 = new Question("Dime unas de las herramientas de java en XML Binding?", "JAXB, Castor, XMLBeans", "BIOS, JavaScript, C#", "Ninguna", "JAXB, Castor, XMLBeans");
        this.addQuestion(q1);


        //-------------------(Serializadores de Binding XML - JAXB)----------------
        q1 = new Question("Cuales son esas dos caracteristicas que proporcionaJAXB ", "la capacidad de serializar las referencias de objetos Java a XML y la inversa, es decir, deserializar XML en objetos Java", "Ninguna", "Escribir un documento XML para recoger la siguiente información sobre árboles", "la capacidad de serializar las referencias de objetos Java a XML y la inversa, es decir, deserializar XML en objetos Java");
        this.addQuestion(q1);
        q1 = new Question("Para que es JAXB?", "permite almacenar y recuperar datos en memoria en cualquier formato XML", "Metodo de programacion mejorado", "Ninguno", "permite almacenar y recuperar datos en memoria en cualquier formato XML");
        this.addQuestion(q1);


        //------------------eXtensible Stylesheet Language Transformations---------------------------
        q1 = new Question("Que es eXtensible Stylesheet Language Transformations?", "estilos de lenguaje para programacion", "Ninguno", "transformaciones y presentaciones de documentos XML", "transformaciones y presentaciones de documentos XML");
        this.addQuestion(q1);
        q1 = new Question("En que se Utiliza Que es eXtensible Stylesheet Language?", "Crear PDFs, Crear código, Generar páginas web.", "Metodo para analizar codigo", "Ninguno", "Crear PDFs, Crear código, Generar páginas web.");
        this.addQuestion(q1);


        //-----------------XPath--------------------------------------------------------------------
        q1 = new Question("Para que se utiliza XPath?", "Es el metodo mas facil y exelente para la realizacion de codigo", "Ninguna", "Lenguaje de expresión utilizado para referenciar nodos de información en un conjunto de datos XML", "Lenguaje de expresión utilizado para referenciar nodos de información en un conjunto de datos XML");
        this.addQuestion(q1);
        q1 = new Question("cres que XPath es muy eficiente para la programacion?", "SI", "NO", "Ninguno", "SI");
        this.addQuestion(q1);


        //----------------XQuery-------------------------------------------------------------------------
        q1 = new Question("Que es XQuery?", "metodologia de programacion", "Una evolución de XPath.", "Ninguno", "Una evolución de XPath.");
        this.addQuestion(q1);
        q1 = new Question("Como se utiliza XQuery?", "XQuery como el SQL para XML", "Metodo para analizar codigo", "Ninguno", "XQuery como el SQL para XML");
        this.addQuestion(q1);


        //===========================00Esquemas XML===============================0

        //===========================
        q1 = new Question("Dime un problema de DTNs?", "Difíciles de manipular no son XML", "Realizan combinación de HTML", "Ninguna", "Difíciles de manipular no son XML");
        this.addQuestion(q1);
        q1 = new Question("Que permite XML Schema?", "Definir la estructura de datos", "Permite definir esquemas de documentos", "Documentación", "Permite definir esquemas de documentos");
        this.addQuestion(q1);
//-----------------------------------------------
        q1 = new Question("Que es esquema?", "definición de estructura de un conjunto de documentos XML", "Realizan combinación de HTML", "Ninguna", "definición de estructura de un conjunto de documentos XML");
        this.addQuestion(q1);
        q1 = new Question("Que es Validad?", "Comprobar que un documento sigue un esquema", "Permite definir esquemas de documentos", "Ninguno", "Comprobar que un documento sigue un esquema");
        this.addQuestion(q1);


        //------------------------------sub tema 3
        q1 = new Question("XML tiene sintaxis de programacion", "NO", "SI", "Ninguno", "SI");
        this.addQuestion(q1);
        q1 = new Question("Dos tipos de Sintaxis de XML", "Restricciones numéricas, Herencia de tipos de datos", "Convinacion y relacion", "reportes , Comprovacion", "Restricciones numéricas, Herencia de tipos de datos");
        this.addQuestion(q1);

        //-----------------------------subtema 4
        q1 = new Question("Que perminten XML Schemas", "Cocordancia en la relacion", "Implementacion", "Describir estructura, Multiplicidad", "Describir estructura, Multiplicidad");
        this.addQuestion(q1);
        q1 = new Question(" cuantas se mencionan?", "10", "6", "11", "11");
        this.addQuestion(q1);

        //---------------------------------subtema 5
        q1 = new Question("Que hace el mecanismo que permite a los documentos XML", "contener instrucciones específicas para las aplicaciones", "Ejecutar las aplicaciones de xml", "Analizar lo que se pide ", "contener instrucciones específicas para las aplicaciones");
        this.addQuestion(q1);
        q1 = new Question("Que codigo falta en la siguiente linea de codigo <?____ version=’1.0’ ?>", "xml", "php", "html", "xml");
        this.addQuestion(q1);

        //---------------------------------subtema 6
        q1 = new Question("Que es lo que contiene un elemento simple", "Contiene elementos y atributos", "texto (cualquier tipo de dato) pero no otros elementos ni atributos", "Contiene mucha informacion", "texto (cualquier tipo de dato) pero no otros elementos ni atributos");
        this.addQuestion(q1);
        q1 = new Question("como se define el elemento siemple en codigo completa la siguiente lienea de codigo <xs:________ name=\"nombre\" type=\"tipo\" />", "result", "element", "html", "element");
        this.addQuestion(q1);

        //---------------------------------subtema 7
        q1 = new Question("Que es un atributo", "Es para reconocer una cosa o persona", "Es al realizar un acto", "Es cuando ejecutas un programa", "Es para reconocer una cosa o persona");
        this.addQuestion(q1);
        q1 = new Question("Copleta lasiguente linea de cosdigo donde se declara un atributo <xs:_________ name=\"nombre\" type=\"tipo\" />", "SuSe", "BIOS", "attribute", "attribute");
        this.addQuestion(q1);


        //===========================Tema Codigo===============================0
        //------------- Subtema uno
        q1 = new Question("Completa la Siguiente linea de codigo " +
                "            <usuarios>   \n" +
                "           <usuario>Jacinto</usuario>    \n" +
                "            <usuario>Ana</usuario> \n" +
                "            </__________>", "usuarios", "Ana", "Jacinto", "usuarios");
        this.addQuestion(q1);
        q1 = new Question("Completa la Siguiente linea de codigo " +
                "<!_______________ pizzas SYSTEM \"pizzas.dtd\">\n" +
                "<pizzas>\n" +
                "<pizza nombre=\"Barbacoa\" precio=\"8\">\n" +
                "<ingrediente nombre=\"Salsa Barbacoa\" />\n" +
                "<ingrediente nombre=”Mozzarella\" />\n" +
                "<ingrediente nombre=”Pollo\" />\n" +
                "<ingrediente nombre=\"Bacon\" />\n" +
                "<ingrediente nombre=\"Ternera\" />\n" +
                "</pizza>", "DOCTYPE", "HTML", "PHP", "DOCTYPE");
        this.addQuestion(q1);

        //----------------------------
        q1 = new Question("Completa la Siguiente linea de codigo\n" +
                " <?xml version=\"1.0\" ?>\n" +
                "<!DOCTYPE poema SYSTEM \"poema.dtd\">\n" +
                "<poema fecha=\"Abril 1915\" lugar=\"Granada\">\n" +
                "<titulo>Alba</titulo>\n" +
                "<verso>Mi corazón oprimido</verso>\n" +
                "<verso>siente junto a la alborada</verso>\n" +
                "<verso>el dolor de sus amores...</verso>\n" +
                "</______>", "titulo", "poema", "verso", "poema");
        this.addQuestion(q1);
        q1 = new Question("Completa la Siguiente linea de codigo  \n" +
                "<verso>siente junto a la alborada</verso>", "php", "xml", "verso", "verso");
        this.addQuestion(q1);


        //------------------------------
        q1 = new Question("Completa la Siguiente linea de codigo\n" +
                "<__________>\n" +
                "<head>\n" +
                "<title>Hello John</title>\n" +
                "</head>\n" +
                "<body bgcolor=\"#FFFFFF\"\n" +
                "text=\"#000000\">\n" +
                "<p> Hello John. </P>\n" +
                "</body>\n" +
                "</html>"
                , "html", "xml", "php", "html");
        this.addQuestion(q1);
        q1 = new Question("Completa la Siguiente linea de codigo" +
                "<head>\n" +
                "<_____>Hello John</title>\n" +
                "</head>"
                , "text", "head", "title", "title");
        this.addQuestion(q1);

        //-----------------------------
        q1 = new Question("Completa la Siguiente linea de codigo" +
                "<?____ version=\"1.0\"?>\n" +
                "<X> Hola Mundo! </X>\n" +
                "<X> Hola Mundo! </X>",
                "xml", "html", "java", "xml");
        this.addQuestion(q1);
        q1 = new Question("Con que codigo declaras un atributo?",
                "<attribute name=\"sexo\" type=\"string\"/>",
                "<element name=\"apellido2\" type=\"string\"/>",
                "<?xml version=\"1.0\"?>",
                "<attribute name=\"sexo\" type=\"string\"/>");
        this.addQuestion(q1);

        //---------------------------------
        q1 = new Question("Con que codigo declaras un elemento?",
                "<attribute name=\"sexo\" type=\"string\"/>",
                "<element name=\"apellido2\" type=\"string\"/>",
                "<?xml version=\"1.0\"?>",
                "<element name=\"apellido2\" type=\"string\"/>");
        this.addQuestion(q1);
        q1 = new Question("Con que codigo declaras un Namespace del Schema.?"
                , "<attribute name=\"sexo\" type=\"string\"/>",
                "<?xml version=\"1.0\"?>",
                "<schema xmlns=\"http://www.w3.org/2001/XMLSchema\"",
                "<schema xmlns=\"http://www.w3.org/2001/XMLSchema\"");
        this.addQuestion(q1);


        //---------------------------------
        q1 = new Question("De que fue el curso", "XML", "HTML", "PHP", "XML");
        this.addQuestion(q1);
        q1 = new Question("Cres que es importante XML en la progrmacion", "SI", "NO", "Ninguno", "SI");
        this.addQuestion(q1);

//64  164

    }

    public List<Question> getAllQuestions(int dd) {

        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "";
        Cursor cursor;
        switch (dd) {
            case 0:
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " <3 ";// se crea la query 1,2
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 1:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >2 OR " + DBHelper.KEY_ID + " <5 ";// se crea la query 3, 4
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 2:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >4 OR " + DBHelper.KEY_ID + " <7 ";// se crea la query 5,6
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 3:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >6 OR " + DBHelper.KEY_ID + " <9 ";// se crea la query 7,8
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 4:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >8 OR " + DBHelper.KEY_ID + " <11 ";// se crea la query 9,10
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 5:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >10 OR " + DBHelper.KEY_ID + " <13 ";// se crea la query 11,12
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 6:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >12 OR " + DBHelper.KEY_ID + " <15 ";// se crea la query 13,14
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 7:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >14 OR " + DBHelper.KEY_ID + " <17 "; //15, 16 1
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 8:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >16 OR " + DBHelper.KEY_ID + " <19 "; //17, 18 2
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 9:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >18 OR " + DBHelper.KEY_ID + " <21 "; //19, 20 empiezan 3
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 10:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >20 OR " + DBHelper.KEY_ID + " <23 "; //21, 22 empiezan 4
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 11:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >22 OR " + DBHelper.KEY_ID + " <25 "; //23, 24 empiezan 5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 12:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 + " where " + DBHelper.KEY_ID + " >24 OR " + DBHelper.KEY_ID + " <27 "; //25, 26 empiezan 6
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

            case 13:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >26 OR "+DBHelper.KEY_ID+" <29 "; //27, 28 empiezan 7
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 14:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >28 OR "+DBHelper.KEY_ID+" <31 "; //29, 30 empiezan 8
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 15:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >30 OR "+DBHelper.KEY_ID+" <33 "; //31, 32 empiezan 9
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 16:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >32 OR "+DBHelper.KEY_ID+" <35 "; //33, 34 tema 4INICIA 1
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 17:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >34 OR "+DBHelper.KEY_ID+" <37 "; //35, 36 tema 4INICIA 2
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 18:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >36 OR "+DBHelper.KEY_ID+" <39 "; //37, 38 tema 4INICIA 3
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 19:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >38 OR "+DBHelper.KEY_ID+" <41 "; //39, 40 tema 4INICIA 4
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 20:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >40 OR "+DBHelper.KEY_ID+" <43 "; //41, 42 tema 4INICIA 5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 21:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >42 OR "+DBHelper.KEY_ID+" <45 "; //43, 44 tema 4INICIA 6
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 22:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >44 OR "+DBHelper.KEY_ID+" <47 "; //45, 46 tema 4INICIA 7 ter4
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 23: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >46 OR "+DBHelper.KEY_ID+" <49 "; //47, 48 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 24: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >48 OR "+DBHelper.KEY_ID+" <51 "; //49, 50 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 25: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >50 OR "+DBHelper.KEY_ID+" <53 "; //51, 52 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 26: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >52 OR "+DBHelper.KEY_ID+" <55 "; //53, 54 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 27: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >54 OR "+DBHelper.KEY_ID+" <57 "; //55, 56 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 28: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >56 OR "+DBHelper.KEY_ID+" <59 "; //57, 58 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 29: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >58 OR "+DBHelper.KEY_ID+" <61 "; //59, 60 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 30: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >60 OR "+DBHelper.KEY_ID+" <63 "; //61, 62 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            case 31: //Empieza el ultimo tema son 9 subtemas este es el uno de 9 ...

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >62 OR "+DBHelper.KEY_ID+" <65 "; //63, 64 empieza el mod5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Question quest = new Question();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            default:
                break;
        }

        // return quest list
        return quesList;
    }

    public void addCalifMdodulo(String idUsuario, int numModulo) {
        String nombreModulo = "";
        switch (numModulo) {
            case 1:
                nombreModulo = "Modulo_2";
                break;
            case 2:
                nombreModulo = "Modulo_3";
                break;
            case 3:
                nombreModulo = "Modulo_4";
                break;
            case 4:
                nombreModulo = "Modulo_5";
                break;
            case 5:
                Log.e("default sw", "aggCalifModulo: No entro  ninguno");
                break;


        }
        ContentValues values = new ContentValues();
        values.put(DBHelper.ACTIVO, 1);
        db.update(DBHelper.TABLE_NAME_4, values, DBHelper.USER_ID + " = ? AND " + DBHelper.NAME + " LIKE ?",
                new String[]{idUsuario, nombreModulo});
    }

    public void setCalifTema(int idmodulo, int numTema, int numModulo, int calificacion) {

        int totalCal = 0;
        if (calificacion == 2) {
            totalCal = 10;
        } else if (calificacion == 1) {
            totalCal = 5;
        } else {
            totalCal = 0;
        }


        String nombre = "";
        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:

                        nombre = "mod_1_tem_1";
                        break;
                }
                break;
            case 2:
                idmodulo++;
                switch (numTema) {
                    case 1:
                        nombre = "mod_2_tem_1";
                        break;
                    case 2:
                        nombre = "mod_2_tem_2";
                        break;
                    case 3:
                        nombre = "mod_2_tem_3";
                        break;
                    case 4:
                        nombre = "mod_2_tem_4";
                        break;
                    case 5:
                        nombre = "mod_2_tem_5";
                        break;
                }
                break;
            case 3:
                idmodulo=idmodulo+2;
                switch (numTema) {
                    case 1:
                        nombre = "mod_3_tem_1";
                        break;
                    case 2:
                        nombre = "mod_3_tem_2";
                        break;
                    case 3:
                        nombre = "mod_3_tem_3";
                        break;
                    case 4:
                        nombre = "mod_3_tem_4";
                        break;
                    case 5:
                        nombre = "mod_3_tem_5";
                        break;
                    case 6:
                        nombre = "mod_3_tem_6";
                        break;
                    case 7:
                        nombre = "mod_3_tem_7";
                        break;
                    case 8:
                        nombre = "mod_3_tem_8";
                        break;

                }

                break;
            case 4:
                idmodulo=idmodulo+3;
                switch (numTema) {
                    case 1:
                        nombre = "mod_4_tem_1";
                        break;
                    case 2:
                        nombre = "mod_4_tem_2";
                        break;
                    case 3:
                        nombre = "mod_4_tem_3";
                        break;
                    case 4:
                        nombre = "mod_4_tem_4";
                        break;
                    case 5:
                        nombre = "mod_4_tem_5";
                        break;
                    case 6:
                        nombre = "mod_4_tem_6";
                        break;
                    case 7:
                        nombre = "mod_3_tem_7";
                        break;


                }
                break;
            case 5:
                idmodulo=idmodulo+4;
                switch (numTema) {
                    case 1:
                        nombre = "mod_5_tem_1";
                        break;
                    case 2:
                        nombre = "mod_5_tem_2";
                        break;
                    case 3:
                        nombre = "mod_5_tem_3";
                        break;
                    case 4:
                        nombre = "mod_5_tem_4";
                        break;
                    case 5:
                        nombre = "mod_5_tem_5";
                        break;
                    case 6:
                        nombre = "mod_5_tem_6";
                        break;
                }
                break;
        }

            if (totalCal == 10) {
                String idMod=String.valueOf(idmodulo);

                ContentValues values = new ContentValues();
                values.put(DBHelper.CALIFICACION, totalCal);
                db.update(DBHelper.TABLE_NAME_2, values, DBHelper.MOD_ID + " = ? AND " + DBHelper.NAME + " LIKE ?", new String[]{idMod, nombre});

            }

    }

    public int traerCalificacion(int idmodulo, int numTema, int numModulo, int calificacion){
        int calif=0;

        String nombre = "";
        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:

                        nombre = "mod_1_tem_1";
                        break;
                }
                break;
            case 2:
                idmodulo++;
                switch (numTema) {
                    case 1:
                        nombre = "mod_2_tem_1";
                        break;
                    case 2:
                        nombre = "mod_2_tem_2";
                        break;
                    case 3:
                        nombre = "mod_2_tem_3";
                        break;
                    case 4:
                        nombre = "mod_2_tem_4";
                        break;
                    case 5:
                        nombre = "mod_2_tem_5";
                        break;
                }
                break;
            case 3:
                idmodulo = idmodulo + 2;
                switch (numTema) {
                    case 1:
                        nombre = "mod_3_tem_1";
                        break;
                    case 2:
                        nombre = "mod_3_tem_2";
                        break;
                    case 3:
                        nombre = "mod_3_tem_3";
                        break;
                    case 4:
                        nombre = "mod_3_tem_4";
                        break;
                    case 5:
                        nombre = "mod_3_tem_5";
                        break;
                    case 6:
                        nombre = "mod_3_tem_6";
                        break;
                    case 7:
                        nombre = "mod_3_tem_7";
                        break;
                    case 8:
                        nombre = "mod_3_tem_8";
                        break;

                }

                break;
            case 4:
                idmodulo = idmodulo + 3;
                switch (numTema) {
                    case 1:
                        nombre = "mod_4_tem_1";
                        break;
                    case 2:
                        nombre = "mod_4_tem_2";
                        break;
                    case 3:
                        nombre = "mod_4_tem_3";
                        break;
                    case 4:
                        nombre = "mod_4_tem_4";
                        break;
                    case 5:
                        nombre = "mod_4_tem_5";
                        break;
                    case 6:
                        nombre = "mod_4_tem_6";
                        break;
                    case 7:
                        nombre = "mod_3_tem_7";
                        break;


                }
                break;
            case 5:
                idmodulo = idmodulo + 4;
                switch (numTema) {
                    case 1:
                        nombre = "mod_5_tem_1";
                        break;
                    case 2:
                        nombre = "mod_5_tem_2";
                        break;
                    case 3:
                        nombre = "mod_5_tem_3";
                        break;
                    case 4:
                        nombre = "mod_5_tem_4";
                        break;
                    case 5:
                        nombre = "mod_5_tem_5";
                        break;
                    case 6:
                        nombre = "mod_5_tem_6";
                        break;
                }
                break;
        }
            String idMod=String.valueOf(idmodulo);
        Cursor cursor8=db.rawQuery(
                "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND  "+DBHelper.MOD_ID+" = ?",new String[]{ idMod, nombre});
        cursor8.moveToFirst();


        return calif;
    }




}