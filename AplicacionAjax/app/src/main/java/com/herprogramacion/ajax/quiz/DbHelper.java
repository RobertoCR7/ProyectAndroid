package com.herprogramacion.ajax.quiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rodrigo Cortes Armas on 23/03/2016.
 */
public class DbHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    //Nombre de la base de dato
    public static final String DATABASE_NAME = "triviaQuiz";
    // Nombre de la tabla
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_tema";
    public static final String NAME = "nombre";
    public static final String PASSWORD = "contrasena";
    public static final String USER_ID = "id_usuario";
    public static final String ACTIVO = "activo";
    public static final String CALIFICACION = "calificacion";
    public static final String ID = "_id";

    // Nombre de la tabla
    private static final String TABLE_QUEST = "quest";
    // nombre de cada una de las columnas
    public static final String KEY_ID = "id";
    public static final String KEY_QUES = "question";
    public static final String KEY_ANSWER = "answer"; //Opcion correcta
    public static final String KEY_OPTA= "opta"; //opcion a
    public static final String KEY_OPTB= "optb"; //opcion b
    public static final String KEY_OPTC= "optc"; //opcion c
    private static SQLiteDatabase dbase;



    private static final String CREATE_TABLE_1 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_1
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +PASSWORD+" TEXT);";


    private static final String CREATE_TABLE_2 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_2
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +ACTIVO+" INTEGER, "
                    +CALIFICACION+" INTEGER, "
                    +USER_ID+" INTEGER, FOREIGN KEY("+USER_ID+") REFERENCES "+TABLE_NAME_1+" ("+ID+"));";


    private static final String CREATE_TABLE_QUIZ =
            "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";

    //Solo utilizamos el context, nombre de la base y la version.
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Crear la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_QUIZ);
        dbase=db;
        addQuestions();
        dbase=db;
    }

    public DbHelper open()throws SQLException{
        getWritableDatabase();
        return this;
    }

    //Agregar las preguntas, las separa de 5 por cada capitulo.
    private void addQuestions(){
        Pregunta q1;

        q1 = new Pregunta("¿Quien presento por primera vez el articulo ajax?",
                "Jesse James Garret", "EL Komander", "Rodrigo Armas", "Jesse James Garret");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuando se presento?","1 de Enero del 2002 ", "19 de Septiembre del 2018", "18 de Febrero del 2005","18 de Febrero del 2005");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que seignifica realmente ajax?",
                "Es un detergente", "es un acrónimo de Asynchronous JavaScript + XML",
                "Es algo bonito", "es un acrónimo de Asynchronous JavaScript + XML");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Tecnologias que conforman ajax?",
                "XHTML, CSS, DOM, JSON,HttpRequest,Javascript", "Javascript y XHTML",
                "HTML Y CSS", "XHTML, CSS, DOM, JSON,HttpRequest,Javascript");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Se requieren conocimientos avanzados para operar ajax?",
                "Si", "No", "Depende", "Si");
        this.addQuestion(q1);

        //CAPITULO 2//
        q1 = new Pregunta("¿Que navegadores siguen los estandares de XMLHttpRequest?",
                "Firefox, Safari", "Safari", "Firefox, Safari, Opera, Internet Explorer 7 y 8",
                "Firefox, Safari, Opera, Internet Explorer 7 y 8");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Funcion que se encarga de procesar la respuesta del servidor es: ?",
                "onreadystatechange", "XMLHttpRequest", "Http", "onreadystatechange");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Menciona una propiedad del objeto XMLHttpRequest?", "Http",
                "readyState", "XMLHttp", "readyState");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Tecnicas basicas de ajax?", "Desplegables", "Autocompletar",
                "Desplegables, Autocompletar", "Desplegables, Autocompletar");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Las tecnicas basicas requieren de un nivel de conocimiento alto?",
                "Si", "NO", "Claro que no", "Si");
        this.addQuestion(q1);

        //CAPITULO 3//
        q1 = new Pregunta("¿Ajax brinda soporte a aplicaciones mutilenguaje?", "No", "Si",
                "Jamas", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cual es la solucion para brindar soporte a paginas multilenguaje?",
                "Autoacompletar", "Teclado Virtual", "Corregir", "Teclado Virtual");
        this.addQuestion(q1);

        q1 = new Pregunta("¿El auto completar es la solucion para minimizar la busqueda?",
                "Si", "Pudiera ser", "Jamas", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Existen restricciones a las aplicaciones de javascript?", "No",
                "Si", "Jamas", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Las aplicaciones de javascript pueden acceder a los recursos locales  como archivos y directorios?",
                "Depende de los permisos", "Si", "No", "No");
        this.addQuestion(q1);

        //CAPITULO 4//
        q1 = new Pregunta("¿Los protocolos RSS y Atom permiten que sus noticias se compartan facilmente?",
                "Si", "No", "Depende", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿RSS es ideal para aplicaciones AJAX que trate con sus contenidos?",
                "Si", "No", "Depende", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que sitios utilizan RSS", "Articulos, Blogs", "Articulos?",
                "Blogs", "Articulos, Blogs");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que definen la las reglas de un lenguaje de programacion?",
                "El programador", "El plugin","La sintaxis", "La sintaxis");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que lenguajes de programacion son similares a javascript?",
                "Java Y C", "HTML5","CSS", "Java Y C");
        this.addQuestion(q1);

        //CAPITULO 5//
        q1 = new Pregunta("¿Normas basicas en javascript?","Variables", "Espacios",
                "Espacios en blanco, Mayusculas y minusculas", "Espacios en blanco, Mayusculas y minusculas");
        this.addQuestion(q1);

        q1 = new Pregunta("¿javascript puede almacenar diferentes tipos de datos durante la ejecucuin del programa?",
                "No", "Si","Jamas", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Si en javascript se intercambian las mayusculas y las minusculas que les sucede a las aplicaciones?",
                "Funcionan", "Dejan de funcionar","Se deienen", "Dejan de funcionar");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Si en javascript se intercambian las mayusculas y las minusculas que les sucede a las aplicaciones?",
                "Funcionan", "Dejan de funcionar","Se deienen", "Dejan de funcionar");
        this.addQuestion(q1);

        q1 = new Pregunta("¿La siguiente sentencia para que sirve? alert(mensaje de prueba);",
                "Proyectar en consola", "Mostrar un mensaje", "Nada", "Mostrar un mensaje");
        this.addQuestion(q1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Borra la tabla si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_2);
        // Crea la tabla nuevamente
        onCreate(db);
        dbase=db;
    }
    public void addQuestion(Pregunta quest){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserta nueva fila
        dbase.insert(TABLE_QUEST, null, values);
    }

    //Lista de pregunta con el metodo getAllQuestion, sirve para mostrar 5 preguntas por cada
    // elemento del listView, caso 0 muestra las primeras 5 preguntas y asi sucesivamente.
    //
    public List<Pregunta> getAllQuestion(int dd){

        List<Pregunta> quesList = new ArrayList<Pregunta>();
        String selectQuery="";
        dbase=this.getReadableDatabase();//se abre la base a lectura
        Cursor cursor;
        switch (dd) {
            //en la opcion 0 del listView mostrara las primeras 5 preguntas
            case 0:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " <6 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
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
            //En la opcion 0 del listView mostrara las preguntas de la 6 a la 10 pregunta
            case 1:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >5 OR " + KEY_ID + " <11 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
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
            //En la opcion 0 del listView mostrara las preguntas de la 10 a la 15
            case 2:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >10 OR " + KEY_ID + " <16 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
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
            //En la opcion 0 del listView mostrara las preguntas de la 15 a la 20
            case 3:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >15 OR " + KEY_ID + " <21 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
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
            //En la opcion 0 del listView mostrara las preguntas de la 20 a la 25
            case 4:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >20 OR " + KEY_ID + " <26 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
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
        return quesList;
    }
    public int rowcount(){
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public void addTopics(int idUsuario){
        Tema tema;
        dbase=this.getReadableDatabase();
        //Comienza la insercion de los temas
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
/*
        String idUsu = String.valueOf(idUsuario);
        int idTemaUno = idTema1(idUsu, "tem_1");
        Log.e("Id del primer tema", "addTopics: " + idTemaUno);
*/

    }

    private void addTopic(Tema tema){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, tema.getNombre());
        values.put(ACTIVO, tema.isActivo() == true?1:0);
        values.put(CALIFICACION, tema.getCalificacion());
        values.put(USER_ID, tema.getIdUsuario());
        // Inserting Row
        dbase.insert(TABLE_NAME_2, null, values);
    }

    public int[] loginInternoDb(String nomUsu,String contrUsu){
        dbase=this.getReadableDatabase();
        Cursor cursor=dbase.rawQuery(
                "SELECT * FROM " + TABLE_NAME_1 + " WHERE "+NAME+" LIKE ? AND "+PASSWORD+" = ? ", new String[]{nomUsu, contrUsu});
        int[] datosLogeo=new int[2];
        datosLogeo[0]=0;//si esta loeagado
        datosLogeo[1]=0;//id usu
        if (cursor!=null){
            if (cursor.getCount()>0){
                datosLogeo[0]=1;
                cursor.moveToFirst();
                datosLogeo[1]=cursor.getInt(cursor.getColumnIndex(ID));
                return datosLogeo;
            }
        }
        return datosLogeo;
    }
    public int idTema1(int idUsuario, String nombreTema){
        String idUsu=String.valueOf(idUsuario);
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery("SELECT * FROM " +TABLE_NAME_2 + " WHERE nombre LIKE ? AND " +USER_ID + " = ?", new String[]{nombreTema, idUsu});
        int idTem = 0;
        if (cursor != null){
            cursor.moveToFirst();
            idTem = cursor.getInt(cursor.getColumnIndex(USER_ID));
            return idTem;
        } else {
            return idTem;
        }
    }


    public boolean statusTema(int idUsuario, int numTema){
        dbase=this.getReadableDatabase();
        String idUsu=String.valueOf(idUsuario);
        String nomTem="";
        boolean activo=false;
        switch (numTema){
            case 1:
                Log.e("1", "statusTema: TwT" );
                nomTem="tem_1";
                Cursor cursor=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                Log.e("2", "statusTema: TwT" );

                if (cursor!=null){
                    cursor.moveToFirst();
                    activo = cursor.getInt(cursor.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 2:
                nomTem="tem_2";
                Cursor cursor1=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor1!=null){
                    cursor1.moveToFirst();
                    activo = cursor1.getInt(cursor1.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 3:
                nomTem="tem_3";
                Cursor cursor2=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor2!=null){
                    cursor2.moveToFirst();
                    activo = cursor2.getInt(cursor2.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 4:
                nomTem="tem_4";
                Cursor cursor3=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor3!=null){
                    cursor3.moveToFirst();
                    activo = cursor3.getInt(cursor3.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 5:
                nomTem="tem_5";
                Cursor cursor4=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor4!=null){
                    cursor4.moveToFirst();
                    activo = cursor4.getInt(cursor4.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
           }
        return false;
    }

    public void insertaCalifTemas(int calificacion, int idUsuario, int numTema){
        dbase=this.getReadableDatabase();
        int calif = 0;
        String nombreTema = "";
        ContentValues values = new ContentValues();

        int totalCal = 0;
        if (calificacion == 5){
            totalCal = 10;
        }else if (calificacion == 4){
            totalCal = 8;
        }

        switch (numTema){
            case 1:
                nombreTema = "tem_2";
                break;
            case 2:
                nombreTema = "tem_3";
                break;
            case 3:
                nombreTema = "tem_4";
                break;
            case 4:
                nombreTema = "tem_5";
                break;
            case 5:
                nombreTema = "tem_6";
                break;
            case 6:
                //Mensaje de exito
                break;
        }

        //Falta agregar calificacion!

        if (totalCal >= 8){
            values.put(ACTIVO, true);
        } else {
            values.put(ACTIVO, false);
        }

        //values.put(CALIFICACION, totalCal);
        String idUsu=String.valueOf(idUsuario);
        Log.e("1 de update", "insertaCalifTemas: " );

        dbase.update(TABLE_NAME_2, values, USER_ID + " = ? AND " + NAME + " LIKE ? ", new String[]{idUsu, nombreTema});

        Log.e("2 de update", "insertaCalifTemas: ");
    }

}