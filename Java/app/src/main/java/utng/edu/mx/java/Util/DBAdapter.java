package utng.edu.mx.java.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import utng.edu.mx.java.dao.DBHelper;
import utng.edu.mx.java.model.Question;
import utng.edu.mx.java.model.Tema;


/**
 * Created by Gustavo on 26/03/2016.
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


    public String[] informacionUsuario(String idUsu){

        Cursor cursor=db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME_1 + " WHERE _id=? ", new String[]{idUsu});

        String[] infoUsu=new String[2];
        cursor.moveToFirst();
        infoUsu[0]=cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
        infoUsu[1]=cursor.getString(cursor.getColumnIndex(DBHelper.MAIL));
        return infoUsu;
    }


      // se agregan todas las preguntas mediante el metodo addQueztion


    private void addQuestions()
    {
        Question q1;
        //PAK Cero
        //Se crean las preguntas con sus posibles resultado y su resultado correcto
        //Pak JAVA
        q1=new Question("¿Java es un lenguaje orientado a?","Eclipse", "Objetos", "Android", "Objetos");
        this.addQuestion(q1);
        q1=new Question("¿Las aplicaciones desarrolladas en java se puede ejecutar en?", "Donde se desarrollo","No se ejecutan", "En cualquier dispositivo","En cualquier dispositivo");
        this.addQuestion(q1);
        q1=new Question("¿Java es idependiente a?","objetos", "Plataforma","dispositivos","Plataforma");
        this.addQuestion(q1);
        q1=new Question("JAVA se considera un lenguaje", "Robusto","Obsoleto", "Ninguno de los dos","Robusto");
        this.addQuestion(q1);
        q1=new Question("¿El lenguaje JAVA permite el uso de técnicas de programación inadecuadas?","Si", "No","ninguna de las dos","No");
        this.addQuestion(q1);
        // 5 preguntas más --Ejemplo

        //////////----------------------
        //PAK objeto
        q1=new Question("¿Qué es un objeto en JAVA?","Pieza de software","Herencia","Vista ","Pieza de software");
        this.addQuestion(q1);
        q1=new Question("¿Qué conforma un objeto?","Encapsulamiento","Herencia","Ambas","Ambas");
        this.addQuestion(q1);
        q1=new Question("¿Cuáles son los atributos de un objeto?","Métodos","Identidades","Ambos","Ambos");
        this.addQuestion(q1);
        q1=new Question("¿En los métodos de un objeto se caracterizan por sus acciones denominadas?","Operaciones","Identidades","Funciones","Operaciones");
        this.addQuestion(q1);
        q1=new Question("¿Cómo se distingue un objeto de otro?","Tamaño","Identidad","Estado","Identidad");
        this.addQuestion(q1);

        //PAK clase
        q1=new Question("¿Una clase puede representar?","Entidades","Conceptos","Ambos","Ambos");
        this.addQuestion(q1);
        q1=new Question("¿Una clase pude definir un conjunto de?","Interfaces, operaciones","Variable, métodos","Atributos, identificadores","Variable, métodos");
        this.addQuestion(q1);
        q1=new Question(" ¿Las clases pueden ser pública o privada?","Si ","No","Nunca","Si ");
        this.addQuestion(q1);
        q1=new Question("¿Qué palabra reservada se utiliza para que puedas utilizar atributos de otra clase?","Implement","Extends","Import","Extends");
        this.addQuestion(q1);
        q1=new Question("¿Palabra reservada para declarar una clase  ______ class HolaMundo{?","public","Implementar","Hacer ","public");
        this.addQuestion(q1);

        //PAK Metodo
        q1=new Question(" ¿Los métodos se denominan como una función dentro de?","Objeto","Clase","Instancia","Clase");
        this.addQuestion(q1);
        q1=new Question("¿Un método puede ser declarado?","Public,package","Private,protected","ambos","ambos");
        this.addQuestion(q1);
        q1=new Question("¿Cualquier método se puede ser declarado como abstract?","Si","No","Ninguno","Si");
        this.addQuestion(q1);
        q1=new Question("¿Si un método es abstract sus clases también lo pueden ser?","No","Si","Ninguna","Si");
        this.addQuestion(q1);
        q1=new Question("¿Las clases de un método no pueden hacerse referencia una a otra?","Si","No","Ninguna","Si");
        this.addQuestion(q1);

        //PAK Estructura de control
        q1=new Question("¿Qué estructura de control ejecuta varias operaciones?","If..[else]","Switch..case..break..default","while","Switch..case..break..default");
        this.addQuestion(q1);
        q1=new Question("¿Qué estructura de control ejecuta una sola operación?","If..[else]","Switch..case..break..default","Do while","If..[else]");
        this.addQuestion(q1);
        q1=new Question("¿Qué estructura de control realiza la evolución de ejecución al final de proceso?","While ","If..[else]","Do while ","Do while ");
        this.addQuestion(q1);
        q1=new Question("¿Qué instrucción te permite saltar al final de una ejecución repetitiva?","break","Case","Default","break");
        this.addQuestion(q1);
        q1=new Question("¿Qué otra instrucción existe?","Catch","Try","Todas las anteriores","Todas las anteriores");
        this.addQuestion(q1);

        //PAK examen final
        q1=new Question("¿Las aplicaciones desarrolladas en java se puede ejecutar en?", "Donde se desarrollo","No se ejecutan", "En cualquier dispositivo","En cualquier dispositivo");
        this.addQuestion(q1);
        q1=new Question("¿Un método puede ser declarado?","Public,package","Private,protected","ambos","ambos");
        this.addQuestion(q1);
        q1=new Question("¿Qué estructura de control ejecuta una sola operación?","If..[else]","Switch..case..break..default","Do while","If..[else]");
        this.addQuestion(q1);
        q1=new Question("¿Una clase pude definir un conjunto de?","Interfaces, operaciones","Variable, métodos","Atributos, identificadores","Variable, métodos");
        this.addQuestion(q1);
        q1=new Question("¿Cómo se distingue un objeto de otro?","Tamaño","Identidad","Estado","Identidad");
        this.addQuestion(q1);

    }

    //aqui se inicializa el metodo que inserta los valores del objeto mediante la utilizacion del metoo put

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

    public void addTopics(int idUsuario){
        Tema tema;
        //Inicio de la incercion de los temas

        tema = new Tema("tem_1", idUsuario, true, 0);
        this.addTopic(tema);
        tema = new Tema("tem_2", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_3", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_4", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_5", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_6", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_7", idUsuario, false, 0);
        this.addTopic(tema);

        String idUsu = String.valueOf(idUsuario);
        int idTemaUno= idTemaUno(idUsu, "tem_1");
        Log.e("id del primer tema", "addTopics:" + idTemaUno);

        addQuestions(); //Agregamos las preguntas en la base

    }
    private void  addTopic(Tema tema){
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, tema.getNombre());
        values.put(DBHelper.ACTIVO, tema.isActivo() == true?1:0);
        values.put(DBHelper.CALIFICACION, tema.getCalificacion());
        values.put(DBHelper.USER_ID, tema.getIdUsuario());
        // Inserting Row
        db.insert(DBHelper.TABLE_NAME_2, null, values);

    }
    private int idTemaUno(String idUsuario, String nomTema){
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.USER_ID + " = ? " , new String[]{nomTema,idUsuario});
        int idTem= 0;
        if(cursor!=null){
            cursor.moveToFirst();
            idTem=cursor.getInt(cursor.getColumnIndex(DBHelper.USER_ID));
            return idTem;
        }else{
            return idTem;
        }
    }
    public List<Question> getAllQuestions( int dd) {

        List<Question> quesList = new ArrayList<Question>();
        String selectQuery="";
        Cursor cursor;
        switch (dd){
            case 0:
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 +" where "+ DBHelper.KEY_ID +" <6 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 +" where "+ DBHelper.KEY_ID +" >5 OR "+ DBHelper.KEY_ID +" <11 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 +" where "+ DBHelper.KEY_ID +" >10 OR "+ DBHelper.KEY_ID +" <16 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 +" where "+ DBHelper.KEY_ID +" >15 OR "+ DBHelper.KEY_ID +" <21 ";// se crea la query
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 +" where "+ DBHelper.KEY_ID +" >20 OR "+ DBHelper.KEY_ID +" <26 ";// se crea la query
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
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3 +" where "+ DBHelper.KEY_ID +" >25 OR "+DBHelper.KEY_ID +" <=30 ";// se crea la query
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

    public int totalTemas(){
        int row=0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2, null);
        row=cursor.getCount();
        return row;
    }

    public boolean statusTema(int idUsuario, int numTema){
        String idUsu = String.valueOf(idUsuario);
        String nomTema="";
        boolean activo = false;

        switch (numTema){
            case 1:
                nomTema="tem_1";
                Cursor cursor=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor!=null) {
                    cursor.moveToFirst();
                    activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 2:
                nomTema="tem_2";
                Cursor cursor1=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor1!=null) {
                    cursor1.moveToFirst();
                    activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 3:
                nomTema="tem_3";
                Cursor cursor2=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor2!=null) {
                    cursor2.moveToFirst();
                    activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 4:
                nomTema="tem_4";
                Cursor cursor3=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor3!=null) {
                    cursor3.moveToFirst();
                    activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 5:
                nomTema="tem_5";
                Cursor cursor4=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor4!=null) {
                    cursor4.moveToFirst();
                    activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 6:
                nomTema="tem_6";
                Cursor cursor5=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor5!=null) {
                    cursor5.moveToFirst();
                    activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 7:
                nomTema="tem_7";
                Cursor cursor6=db.rawQuery(
                        "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTema,idUsu});
                if (cursor6!=null) {
                    cursor6.moveToFirst();
                    activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
        }
        return false;
    }
    public void desbloquearTemas(int numeroTema, int idUsuario,int calificacion){
        if (calificacion>=4) {
            String nombre = "";
            switch (numeroTema) {
                case 1:
                    nombre = "tem_2";
                    break;
                case 2:
                    nombre = "tem_3";
                    break;
                case 3:
                    nombre = "tem_4";
                    break;
                case 4:
                    nombre = "tem_5";
                    break;
                case 5:
                    nombre = "tem_6";
                    break;
            }
            String idUsu = String.valueOf(idUsuario);
            ContentValues values = new ContentValues();
            values.put(DBHelper.ACTIVO, 1);
            db.update(DBHelper.TABLE_NAME_2, values, DBHelper.USER_ID + " = ? AND " + DBHelper.NAME + " LIKE ?", new String[]{idUsu, nombre});
        }
    }

    public void ingresarCalificacion(int calificacion, int numeroTema, int idUsuario){
        String nombre="";
        String idUsu=String.valueOf(idUsuario);
        int totalCalif=0;

        if (calificacion==5){
            totalCalif=10;

        }else if (calificacion==4){
            totalCalif=8;

        }else if (calificacion==3){
            totalCalif=6;
        }else if (calificacion==2){
            totalCalif=4;
        }else if (calificacion==1){
            totalCalif=2;
        }else {
            totalCalif=0;
        }

        switch (numeroTema){
            case 1:
                nombre="tem_1";
                break;
            case 2:
                nombre="tem_2";

                break;
            case 3:
                nombre="tem_3";

                break;
            case 4:
                nombre="tem_4";

                break;
            case 5:
                nombre="tem_5";

                break;
            case 6:
                nombre="tem_6";

                break;
        }
        ContentValues values= new ContentValues();
        values.put(DBHelper.CALIFICACION,totalCalif);

        db.update(DBHelper.TABLE_NAME_2,values,
                DBHelper.USER_ID+" = ? AND "+DBHelper.NAME+" like ? ",new String[]{idUsu,nombre});

    }

    public int getCalificaciòn(int numeroTema,int IdUsuario){
        String nombre="";
        String idUsu=String.valueOf(IdUsuario);

        switch (numeroTema){
            case 1:
                nombre="tem_1";
                break;
            case 2:
                nombre="tem_2";
                break;
            case 3:
                nombre="tem_3";
                break;
            case 4:
                nombre="tem_4";
                break;
            case 5:
                nombre="tem_5";
                break;
            case 6:
                nombre="tem_6";
                break;
            case 7:
                nombre="tem_7";
                break;
        }
        int califi=1;
        Cursor cursor=db.rawQuery(
                "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre like ? AND "+DBHelper.USER_ID+" =?",new String[]{nombre,idUsu});
        if (cursor!=null){
            if (cursor.getCount()>0){
                cursor.moveToFirst();
                califi=cursor.getInt(cursor.getColumnIndex(DBHelper.CALIFICACION));
                return califi;
            }

        }
        return califi;
    }

    public int getProgreso(int idUsuario){
        int row=0;
        String idUsu=String.valueOf(idUsuario);
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.USER_ID+" = ?",
                new String[]{"1",idUsu});
        row=cursor.getCount();
        return row;

    }
}