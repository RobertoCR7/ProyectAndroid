package mx.edu.utng.ctutorial.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import mx.edu.utng.ctutorial.Login;
import mx.edu.utng.ctutorial.dao.DBHelper;
import mx.edu.utng.ctutorial.model.Modulo;
import mx.edu.utng.ctutorial.model.Question;
import mx.edu.utng.ctutorial.model.Tema;

/**
 * Created by Enrique on 02/03/2016.
 */
public class DBAdapter {
    SQLiteDatabase db;
    DBHelper dbHelper;
    Context context;
    boolean isActivoT= true;


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
        Cursor cursor=db.query(DBHelper.TABLE_NAME_1, new String[]{DBHelper.NAME}, null, null, null, null, null);
        if (cursor!=null){
            if (cursor.getCount()>0){
                return true;
            }
        }
        return false;
    }

    public String[] getAllUsuDB(){
        Cursor cursor= db.query(DBHelper.TABLE_NAME_1, new String[]{DBHelper.NAME}, null, null, null, null, null);
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



    public List<Question> getAllQuestions( int dd) {

        List<Question> quesList = new ArrayList<Question>();
        String selectQuery="";
        Cursor cursor;
        switch (dd){
            case 0:
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" <6 ";// se crea la query 1,5
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >6 OR "+DBHelper.KEY_ID+" <11 ";// se crea la query 3, 4
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

                selectQuery = "SELECT  * FROM " +DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >9 OR "+DBHelper.KEY_ID+" <16 ";// se crea la query 5,6
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >15 OR "+DBHelper.KEY_ID+" <21 ";// se crea la query 7,8
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >20 OR "+DBHelper.KEY_ID+" <26 ";// se crea la query 9,10
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >25 OR "+DBHelper.KEY_ID+" <31 ";// se crea la query 11,12
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

    public void     addTopics(int idModulo,int numeroModulo){
        Tema tema;
        switch (numeroModulo){
            case 1:
                tema=new Tema("Mod_1_Tem_1",idModulo,true,0);
                this.addTopic(tema);
                tema=new Tema("Mod_1_Tem_2",idModulo,true,0);
                this.addTopic(tema);
                tema=new Tema("Mod_1_Tem_3",idModulo,true,0);
                this.addTopic(tema);
                tema=new Tema("Mod_1_Tem_4",idModulo,true,0);
                this.addTopic(tema);
                tema=new Tema("Mod_1_Tem_5",idModulo,true,0);
                this.addTopic(tema);
                tema=new Tema("Mod_1_Tem_6",idModulo,true,0);
                this.addTopic(tema);

                break;
            case 2:
                idModulo++;

                tema=new Tema("Mod_2_Tem_1",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_2_Tem_2",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_2_Tem_3",idModulo,false,0);
                this.addTopic(tema);

                break;
            case 3:
                idModulo+=2;

                tema=new Tema("Mod_3_Tem_1",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_3_Tem_2",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_3_Tem_3",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_3_Tem_4",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_3_Tem_5",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_3_Tem_6",idModulo,false,0);
                this.addTopic(tema);


                break;
            case 4:
                idModulo+=3;

                tema=new Tema("Mod_4_Tem_1",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_4_Tem_2",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_4_Tem_3",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_4_Tem_4",idModulo,false,0);
                this.addTopic(tema);
                break;
            case 5:
                idModulo+=4;

                tema=new Tema("Mod_5_Tem_1",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_5_Tem_2",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_5_Tem_3",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_5_Tem_4",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_5_Tem_5",idModulo,false,0);
                this.addTopic(tema);
                break;
            case 6:
                idModulo+=5;

                tema=new Tema("Mod_6_Tem_1",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_6_Tem_2",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_6_Tem_3",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_6_Tem_4",idModulo,false,0);
                this.addTopic(tema);
                tema=new Tema("Mod_6_Tem_5",idModulo,false,0);
                this.addTopic(tema);
                break;
        }


    }

    private void addTopic(Tema tema){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBHelper.NAME, tema.getNombre());
        values.put(DBHelper.ACTIVO, tema.isActivo()==true?1:0);
        values.put(DBHelper.CALIFICACION, tema.getCalificacion());
        values.put(DBHelper.MOD_ID, tema.getIdModulo());
        // Inserting Row
        db.insert(DBHelper.TABLE_NAME_2, null, values);
    }


    public void addModulos(int idUsuario) {
        Modulo modulo;

        modulo = new Modulo( idUsuario,"Modulo 1", true);
        this.addModulo(modulo);
        modulo = new Modulo( idUsuario,"Modulo 2", false);
        this.addModulo(modulo);
        modulo = new Modulo( idUsuario,"Modulo 3", false);
        this.addModulo(modulo);
        modulo = new Modulo( idUsuario,"Modulo 4", false);
        this.addModulo(modulo);
        modulo = new Modulo( idUsuario,"Modulo 5", false);
        this.addModulo(modulo);
        modulo = new Modulo( idUsuario,"Modulo 6", false);
        this.addModulo(modulo);


        int idmodUno= idModUno(idUsuario, "Modulo 1");
        addTopics(idmodUno,1);
        addTopics(idmodUno,2);
        addTopics(idmodUno,3);
        addTopics(idmodUno,4);
        addTopics(idmodUno,5);
        addTopics(idmodUno,6);

    }
    public int idModUno(int idUsuario, String nombreModulo){
        String idUsu=String.valueOf(idUsuario);
        Cursor cursor=db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME_4+" WHERE nombre LIKE ? AND  " + DBHelper.USER_ID + " = ?",
                new String[]{nombreModulo,idUsu});
        int idMod=0;
        if (cursor!=null){
            cursor.moveToFirst();
            //
                idMod=cursor.getInt(cursor.getColumnIndex(DBHelper.ID));
            return idMod;
        }
        return idMod;
    }

    private void addModulo(Modulo modulo){
        ContentValues values=new ContentValues();

        values.put(DBHelper.NAME, modulo.getNombre());
        values.put(DBHelper.USER_ID, modulo.getIdUsiario());
        values.put(DBHelper.ACTIVO, modulo.isActivo() == true ? 1 : 0);
        db.insert(DBHelper.TABLE_NAME_4, null, values);
    }

    //Hace una consulta para saber cunatos Modulos existen
    //sirve para comprobar si cuando se elimina el usuario se eliminan tambien sus modulos correspondientes
    public int totalModulos(){
        int row=0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4, null);
        row=cursor.getCount();
        return row;
    }
    //Hace una consulta para saber cunatos Temas existen
    //sirve para comprobar si cuando se elimina el usuario se eliminan tambien sus temas correspondientes
    public int totalTemas(){
        int row=0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2, null);
        row=cursor.getCount();
        return row;
    }


    ///este metod bloquea los modulos de la app
    public boolean statusModulo(int idUsuario, int numModulo){
        String idUsu=String.valueOf(idUsuario);
        String nomTem="";
        boolean activo=false;

        switch (numModulo){
            case 1:
                //basico de c++
                nomTem="Modulo 1";
                Cursor cursor=db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                if (cursor!=null){
                    cursor.moveToFirst();
                    activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 2:
                //Controles de estructura
                nomTem="Modulo 2";
                Cursor cursor2=db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                if (cursor2!=null){
                    cursor2.moveToFirst();
                    activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 3:
                //Componentes de tipos de datos
                nomTem="Modulo 3";
                Cursor cursor3=db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                if (cursor3!=null){
                    cursor3.moveToFirst();
                    activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 4:
                //programacion orientada a objetos
                nomTem="Modulo 4";
                Cursor cursor4=db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                if (cursor4!=null){
                    cursor4.moveToFirst();
                    activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 5:
                //conseptos vasicos
                nomTem="Modulo 5";
                Cursor cursor5=db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                if (cursor5!=null){
                    cursor5.moveToFirst();
                    activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 6:
                //estandar de librerias
                nomTem="Modulo 6";
                Cursor cursor6=db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                if (cursor6!=null){
                    cursor6.moveToFirst();
                    activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;

        }
        return activo;
    }

    public void startNextModulo(int nomModulo, int idUsuario){
        String nombreModulo="";
        switch (nomModulo){
            case 1:
                nombreModulo ="Modulo 2";
                break;
            case 2:
                nombreModulo ="Modulo 3";
                break;
            case 3:
                nombreModulo ="Modulo 4";
                break;
            case 4:
                nombreModulo ="Modulo 5";
                break;
            case 5:
                nombreModulo ="Modulo 6";
                break;
        }
        String id=String.valueOf(idUsuario);

        ContentValues values = new ContentValues();
        values.put(DBHelper.ACTIVO, 1);
        db.update(DBHelper.TABLE_NAME_4, values ,DBHelper.USER_ID+" = ? AND "+ DBHelper.NAME+" LIKE ?",
                new String[]{id,nombreModulo });
    }

    public  void setCalificacion (int modulo,int idModulo, int numeroTema, int calificacion){

        if(calificacion==5){calificacion=10;}else if(calificacion==4){calificacion=8;
        }else if(calificacion==3){calificacion=6;}else if (calificacion==2){calificacion=4;
        }else if (calificacion==1){calificacion=2;}else {calificacion=0;}

        String nombre="";

        switch (modulo) {
            case 1://basico C++
                switch (numeroTema){
                    case 1:
                        nombre="Mod_1_Tem_6";
                        break;
                }
                break;
            case 2://controles estr
                idModulo ++;
                switch (numeroTema){
                    case 1:
                        nombre="Mod_2_Tem_3";
                        break;
                }
                break;
            case 3:
                idModulo = idModulo + 2;
                switch (numeroTema){
                    case 1:
                        nombre="Mod_3_Tem_6";
                        break;
                }
                break;
            case 4:
                idModulo = idModulo + 3;
                switch (numeroTema){
                    case 1:
                        nombre="Mod_4_Tem_4";
                        break;
                }
                break;
            case 5:
                idModulo = idModulo + 4;
                switch (numeroTema){
                    case 1:
                        nombre="Mod_5_Tem_5";
                        break;
                }
                break;
            case 6:
                idModulo = idModulo + 5;
                switch (numeroTema){
                    case 1:
                        nombre="Mod_6_Tem_5";
                        break;
                }
                break;
        }
        String idMod = String.valueOf(idModulo);
        ContentValues values = new ContentValues();
        values.put(DBHelper.CALIFICACION, calificacion);
        db.update(DBHelper.TABLE_NAME_2, values,DBHelper.MOD_ID+" = ? AND "+ DBHelper.NAME +" LIKE ?",
                new String[]{idMod,nombre});

    }
///
    public int traerCalifTema(int numTema,int idMod,int modulo) {
        int calif = 0;
        String nombre = "";
        String idUsu = String.valueOf(idMod);

        switch (modulo) {
            case 1://basico C++
                switch (numTema){
                    case 1:
                        nombre="Mod_1_Tem_6";
                        break;
                }
                break;
            case 2://controles estr
                idMod ++;
                switch (numTema){
                    case 1:
                        nombre="Mod_2_Tem_3";
                        break;
                }
                break;
            case 3:
                idMod=idMod+2;
                switch (numTema){
                    case 1:
                        nombre="Mod_3_Tem_6";
                        break;
                }
                break;
            case 4:
                idMod=idMod+3;
                switch (numTema){
                    case 1:
                        nombre="Mod_4_Tem_4";
                        break;
                }
                break;
            case 5:
                idMod=idMod+4;
                switch (numTema){
                    case 1:
                        nombre="Mod_5_Tem_5";
                        break;
                }
                break;
            case 6:
                idMod=idMod+5;
                switch (numTema){
                    case 1:
                        nombre="Mod_6_Tem_5";
                        break;
                }
                break;
        }
        String idM=String.valueOf(idMod);

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE " + DBHelper.NAME + " LIKE ? AND  " + DBHelper.MOD_ID + " = ? ",
                new String[]{nombre, idM});
        cursor.moveToFirst();
        calif = cursor.getInt(cursor.getColumnIndex(DBHelper.CALIFICACION));

        return calif;
    }


}
