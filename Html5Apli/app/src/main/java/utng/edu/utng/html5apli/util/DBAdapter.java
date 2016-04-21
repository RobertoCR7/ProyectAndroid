package utng.edu.utng.html5apli.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import utng.edu.utng.html5apli.dao.DBHelper;
import utng.edu.utng.html5apli.model.Question;
import utng.edu.utng.html5apli.model.Tema;


/**
 * Created by Km  evin Castillo on 07/03/2016.
 */
public class DBAdapter {
    SQLiteDatabase db;
    DBHelper dbHelper;
    Context context;

    public DBAdapter(Context c){
        this.context=c;
    }
    public DBAdapter open() throws SQLException{
        dbHelper=new DBHelper(context, DBHelper.DATABASE_NAME,null, DBHelper.DATABASE_VERSION);
        db=dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    //Me comprueba si esta logeado y si me trae su ID
    public int[] login(String nomUsu,String contrUsu){
        Cursor cursor=db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME_1 + " WHERE nombre=? AND contrasena=?", new String[]{nomUsu, contrUsu});
        int[] datosLogeo=new int[2];
        datosLogeo[0]=0;
        datosLogeo[1]=0;
       if (cursor!=null){
            if (cursor.getCount()>0){
                datosLogeo[0]=1;
                cursor.moveToFirst();
                datosLogeo[1]=cursor.getInt(cursor.getColumnIndex(DBHelper.ID));
                return datosLogeo;
            }
       }
        return datosLogeo;
    }


    public boolean existUsu(){

        Cursor cursor=db.query(DBHelper.TABLE_NAME_1, new String[]{DBHelper.NAME},
                null, null, null, null, null);

        if (cursor!=null){
            if (cursor.getCount()>0){
                return true;
            }

        }
        return false;
    }
    public String[] getAllUsuDB(){
        Cursor cursor= db.query(DBHelper.TABLE_NAME_1, new String[]{DBHelper.NAME},
                null, null, null, null, null);
        String[] strUsu=new String[cursor.getCount()];
        int i=0;
        while (cursor.moveToNext()){
            strUsu[i]=cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
            i++;
        }
        return strUsu;
    }


    public String[] informacionUsuario(String nomUsu){

        Cursor cursor=db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME_1 + " WHERE _id=? ", new String[]{nomUsu});

        String[] infoUsu=new String[2];
        cursor.moveToFirst();
        infoUsu[0]=cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
        infoUsu[1]=cursor.getString(cursor.getColumnIndex(DBHelper.MAIL));
        return infoUsu;
    }


    public void addTopics(int idUsuario){
        Tema tema;

        //Inicio de insercon de los temas

        tema = new Tema("Tem_1", idUsuario, true, 0);
        this.addTopic(tema);

        tema = new Tema("Tem_2", idUsuario, false, 0);
        this.addTopic(tema);

        tema = new Tema("Tem_3", idUsuario, false, 0);
        this.addTopic(tema);

        tema = new Tema("Tem_4", idUsuario, false, 0);
        this.addTopic(tema);

        tema = new Tema("Tem_5", idUsuario, false, 0);
        this.addTopic(tema);

        tema = new Tema("Tem_6", idUsuario, false, 0);
        this.addTopic(tema);

        String idUsu=String.valueOf(idUsuario);
        int idTemaUno=idTemaUno(idUsuario,"Tem_1");
        Log.e("ID del primer tema", "addTopics: " + idTemaUno);

        //Agegamos las preguntas en la base

    }
    private void addTopic(Tema tema){

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, tema.getNombre());
        values.put(DBHelper.ACTIVO, tema.isActivo() == true ? 1 : 0);
        values.put(DBHelper.CALIFICACION, tema.getCalificacion());
        values.put(DBHelper.USER_ID, tema.getIdUsuario());

        // Inserting Row
        db.insert(DBHelper.TABLE_NAME_2, null, values);
    }

    public int idTemaUno(int idUsuario, String nombreTema){
        String idUsu= String.valueOf(idUsuario);

        Cursor cursor = db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND "
        +DBHelper.USER_ID+" = ? ", new String[]{nombreTema,idUsu});
        int idTem=0;
        if (cursor != null){
            cursor.moveToFirst();
            idTem=cursor.getInt(cursor.getColumnIndex(DBHelper.USER_ID));
            return idTem;
        }else {
            return  idTem;
        }
    }


    public List<Question> getAllQuestions( int dd) {

        List<Question> quesList = new ArrayList<Question>();
        String selectQuery="";
        Cursor cursor;
        switch (dd){
            case 0:
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" <6 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >5 OR "+DBHelper.KEY_ID+" <11 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >10 OR "+DBHelper.KEY_ID+" <16 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >15 OR "+DBHelper.KEY_ID+" <21 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >20 OR "+DBHelper.KEY_ID+" <26 ";// se crea la query
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
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >25 OR "+DBHelper.KEY_ID+" <=30 ";// se crea la query
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

    //Hace una consulta para saber cunatos Temas existen
    //sirve para comprobar si cuando se elimina el usuario se eliminan tambien sus temas correspondientes
    public int totalTemas(){
        int row=0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2, null);
        row=cursor.getCount();
        return row;
    }

    public boolean statusTema(int idUsuario, int numTema) {
        String idUsu=String.valueOf(idUsuario);
        String nomTem = "";
        boolean activo = false;

            switch (numTema){
                case 1:
                    nomTem = "Tem_1";
                    Cursor cursor = db.rawQuery(
                            "SELECT * FROM " + utng.edu.utng.html5apli.dao.DBHelper.TABLE_NAME_2 +
                                    " WHERE nombre LIKE ? AND id_usuario = ?", new String[]{nomTem, idUsu});

                    if (cursor != null) {
                        cursor.moveToFirst();
                        activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                        return activo;
                    }

                    return activo;
                case 2:
                    nomTem = "Tem_2";
                    Cursor cursor1 = db.rawQuery(
                            "SELECT * FROM " + utng.edu.utng.html5apli.dao.DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario = ?", new String[]{nomTem, idUsu});

                    if (cursor1 != null) {
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                        return activo;
                    }

                    return activo;
                case 3:
                    nomTem = "Tem_3";
                    Cursor cursor2 = db.rawQuery(
                            "SELECT * FROM " + utng.edu.utng.html5apli.dao.DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                    if (cursor2 != null) {
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                        return activo;
                    }

                    return activo;
                case 4:
                    nomTem = "Tem_4";
                    Cursor cursor3 = db.rawQuery(
                            "SELECT * FROM " + utng.edu.utng.html5apli.dao.DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                    if (cursor3 != null) {
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                        return activo;
                    }

                    return activo;
                case 5:
                    nomTem = "Tem_5";
                    Cursor cursor4 = db.rawQuery(
                            "SELECT * FROM " + utng.edu.utng.html5apli.dao.DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                    if (cursor4 != null) {
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                        return activo;
                    }

                    return activo;
                case 6:
                    nomTem = "Tem_6";
                    Cursor cursor5 = db.rawQuery(
                            "SELECT * FROM " + utng.edu.utng.html5apli.dao.DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                    if (cursor5 != null) {
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                        return activo;
                    }
                    return activo;
                default:
            }
            //Mover
                Cursor cursor = db.rawQuery(
                        "SELECT activo FROM tbl_tema "+
                                " WHERE nombre LIKE ? AND id_usuario = ?", new String[]{nomTem, idUsu});
                Log.i("Tema y Usuario:", nomTem + " , " + idUsu);
                if (cursor != null){
                    cursor.moveToFirst();

                    activo = cursor.getInt(0)== 1?true:false;
                    return activo;
                }
            return false;
        }


    //Solo m,e activa y me guarda la calificacion por tema
    public int insertarCalifTemas(int calificacion, int idUsuario, int numTema) {
        int calif = 0;
        String nombreTema = "";
        boolean isActivoTema = true;

        ContentValues values = new ContentValues();
        int totlaCal = 0;
        if (calificacion == 5) {
            totlaCal = 10;
        } else if (calificacion == 4) {
            totlaCal = 8;
        } else if (calificacion == 3){
            totlaCal = 6;
        }else if (calificacion == 2){
            totlaCal = 4;
        }else if (calificacion == 1){
            totlaCal = 2;
        }else {
            totlaCal=0;
        }


        switch (numTema){
            case 1:
                nombreTema="Tem_2";
                break;
            case 2:
                nombreTema="Tem_3";
                break;
            case 3:
                nombreTema="Tem_4";
                break;
            case 4:
                nombreTema="Tem_5";
                break;
            case 5:
                nombreTema="Tem_6";
                break;
            default:
                break;
        }

        if (totlaCal>=8){
            values.put(DBHelper.ACTIVO, isActivoTema);
        }else {
            isActivoTema=false;
            values.put(DBHelper.ACTIVO, isActivoTema);
        }

        String idUsu = String.valueOf(idUsuario);
        Log.e(" 1 de update ","Iserta Calificacion " );
        db.update(DBHelper.TABLE_NAME_2, values, DBHelper.USER_ID + " = ?  AND " + DBHelper.NAME +
                " LIKE  ? ", new String[]{idUsu, nombreTema});
        Log.e(" 2 de update ", "Iserta Calificacion ");
        return calif;
    }

    public void setCalTem(int idUsuario, int numTema, int calificacion){

        String nombre="";
        String idUsu = String.valueOf(idUsuario);

        if (calificacion == 5){
            calificacion = 10;
        }else if (calificacion == 4){
            calificacion = 8;
        }else if (calificacion == 3) {
            calificacion = 6;
        }else if (calificacion == 2) {
            calificacion = 4;
        }else if (calificacion == 1) {
            calificacion = 2;
        }else if (calificacion == 0) {
            calificacion = 0;
        }

        switch (numTema) {
            case 1:
                nombre = "Tem_1";
                break;
            case 2:
                nombre = "Tem_2";
                break;
            case 3:
                nombre = "Tem_3";
                break;
            case 4:
                nombre = "Tem_4";
                break;
            case 5:
                nombre = "Tem_5";
                break;
            case 6:
                nombre = "Tem_6";
                break;
            default:

        }
                ContentValues values = new ContentValues();
                values.put(DBHelper.CALIFICACION, calificacion);
                db.update(DBHelper.TABLE_NAME_2, values, DBHelper.USER_ID + " = ? AND " + DBHelper.NAME + " LIKE ? ",
                        new String[]{idUsu,nombre});
    }

    public int traerCalifTema(int numTema,int idUsuario){
        int calif=0;
        String nombre = "";
        String idUsu = String.valueOf(idUsuario);
        switch (numTema) {
            case 1:
                nombre = "Tem_1";
                break;
            case 2:
                nombre = "Tem_2";
                break;
            case 3:
                nombre = "Tem_3";
                break;
            case 4:
                nombre = "Tem_4";
                break;
            case 5:
                nombre = "Tem_5";
                break;
            case 6:
                nombre = "Tem_6";
                break;
        }
       // String id = String.valueOf(idUsuarios);
        Cursor cursor=db.rawQuery(
                "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE "+ DBHelper.NAME+" LIKE ? AND "+ DBHelper.USER_ID +" = ? ",new String[]{nombre,idUsu});
        cursor.moveToFirst();
        calif=cursor.getInt(cursor.getColumnIndex(DBHelper.CALIFICACION));

        return calif;
    }

    /**
     * Te trae la información del avance del curso
     *                  TxT
     * @param idUsuario
     */

    public int getProgreso(int idUsuario){
        int row=0;
        String idUsu=String.valueOf(idUsuario);
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.USER_ID+" = ?",
                new String[]{"1",idUsu});
        row=cursor.getCount();
        return row;

    }



}


