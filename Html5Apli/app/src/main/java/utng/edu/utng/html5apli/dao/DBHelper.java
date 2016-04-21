package utng.edu.utng.html5apli.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utng.edu.utng.html5apli.model.Question;
import utng.edu.utng.html5apli.util.DBAdapter;

/**
 * Created by kevin Castillo  on 09/04/2016.
 */
public class DBHelper extends SQLiteOpenHelper {


    public  static final String DATABASE_NAME = "utng.db";
    public  static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_tema";
    public static final String TABLE_NAME_3 = "tbl_quiz";
    public static final String NAME = "nombre";
    public static final String PASSWORD = "contrasena";
    public static final String MAIL = "correo";
    public static final String USER_ID = "id_usuario";
    public static final String ACTIVO = "activo";
    public static final String CALIFICACION = "calificacion";
    public static final String ID = "_id";

    //Estaticas del Quiz

    public static final String KEY_ID = "id";
    public static final String KEY_QUES = "question";
    public static final String KEY_ANSWER = "answer"; //correct option
    public static final String KEY_OPTA= "opta"; //option a
    public static final String KEY_OPTB= "optb"; //option b
    public static final String KEY_OPTC= "optc"; //option c
    public SQLiteDatabase sqlite;

    private static final String CREATE_TABLE_1 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_1
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +MAIL+" TEXT, "
                    +PASSWORD+" TEXT);";


    private static final String CREATE_TABLE_2 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_2
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +ACTIVO+" INTEGER, "
                    +CALIFICACION+" INTEGER, "
                    +USER_ID+" INTEGER, FOREIGN KEY ("+USER_ID+") REFERENCES "+TABLE_NAME_1+" ("+ID+"));";

    private static final String CREATE_TABLE_3 =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_3 + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_QUES+ " TEXT, "
                    + KEY_ANSWER+ " TEXT, "
                    +KEY_OPTA +" TEXT, "
                    +KEY_OPTB +" TEXT, "
                    +KEY_OPTC+" TEXT)";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);
        sqlite=db;
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_3);
        sqlite=db;
        onCreate(db);

    }

    private void addQuestions()
    {
        Question q1;

        q1=new Question("¿Con cuantas características provee HTML5?","Uno", "Dos", "Tres", "Tres");
        this.addQuestion(q1);
        q1=new Question("¿Cuáles son las tres características?", "Organización, estructura y funcionalidad",
                "Estructura, estilo y funcionalidad", "Estilo, estructura y organización",
                "Estructura, estilo y funcionalidad");
        this.addQuestion(q1);
        q1=new Question("Un documento HTML es un archivo de:","Texto", "Diseño","Estilo","Texto");
        this.addQuestion(q1);
        q1=new Question("4.¿Qué quiere decir APIs?", "Interfaz de Programación de Aplicaciones",
                "Programación de Aplicaciones con Interfaz", "Interfaz  de Aplicaciones",
                "Interfaz de Programación de Aplicaciones");
        this.addQuestion(q1);
        q1=new Question("¿Con que lenguajes de programación esta combinado Html5?","PHP, HTML y CSS",
                "HTML, CSS y Javascript","Java, C# Y HTML","HTML, CSS y Javascript");
        this.addQuestion(q1);

        //PAK uno
        q1=new Question("¿Cuál etiqueta define  la raíz del documento HTML?","<!DOCTYPE>",
                "<head>","<html>","<html>");
        this.addQuestion(q1);
        q1=new Question("¿Qué especifica la etiqueta <ol> ?","Una lista desordenada.",
                "Una lista ordenada.","Una lista simple.","Una lista ordenada.");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiqueta especifica el contenido principal del documento?",
                "<head>","<!DOCTYPE>","<main>","<main>");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiqueta representa un superíndice?","<sub>","<sup>","<span>","<sub>");
        this.addQuestion(q1);
        q1=new Question("¿Qué  etiqueta nos especifica el resultado de un cálculo?",
                "<pre>","<calculation>","<output>","<output>");
        this.addQuestion(q1);

        //PAK dos
        q1=new Question("¿Con que etiqueta se indica el tipo de documento que se va a crear?",
                "<!DOCTYPE>","<head>","<html>","<!DOCTYPE>");
        this.addQuestion(q1);
        q1=new Question("¿Qué código está bien organizado?",
                "<!DOCTYPE html>\n" +
                        "<html lang=”es”>\n" +
                        "<head>\n" +
                        "\n" +
                        "<body>\n" +
                        "\n" +
                        "</body>\n" +
                        "</head>\n" +
                        "</html>\n",
                "<html lang=”es”>\n" +
                        "<!DOCTYPE html>\n" +
                        "\n" +
                        "<head>\n" +
                        "\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>\n",
                "<!DOCTYPE html>\n" +
                        "<html lang=”es”>\n" +
                        "<head>\n" +
                        "\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>\n",
                "<!DOCTYPE html>\n" +
                        "<html lang=”es”>\n" +
                        "<head>\n" +
                        "\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>\n");
        this.addQuestion(q1);
        q1=new Question("¿Qué elemento es usado para incorporar estilos, códigos Javascrip, imágenes o iconos de archivos externos?",
                "<meta name=””>","<link>","<table>","<link>");
        this.addQuestion(q1);
        q1=new Question("¿Entre que etiquetas se representa la parte visible de todo el documento?","<head>",
                "<body>","<htmal>","<body>");
        this.addQuestion(q1);
        q1=new Question("¿Que etiqueta nos sirve para poner el titulo al documento?\n","<subtitle>","<title>","<titulo>","<title>");
        this.addQuestion(q1);

        //Estructura global
        q1=new Question("¿Qué etiqueta comenzó a dominar la escena con el surgimiento de las webs interactivas?",
                "<body>","<div>","<table>","<div>");
        this.addQuestion(q1);
        q1=new Question("¿Qué barra nos permite navegar por el sitio web?","Barra de Navegación",
                "Barra de Institucional","Barra Lateral","Barra de Navegación");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiqueta permitía a los diseñadores acomodar datos, textos, imágenes, etc.?",
                "<body>","<table>","<organization>","<table>");
        this.addQuestion(q1);
        q1=new Question("¿En qué apartado se ubica usualmente el logo, el títulos, etc.?",
                "Información Principal","Barra Institucional","Cabecera","Cabecera");
        this.addQuestion(q1);
        q1=new Question("¿Qué podemos encontrar en la Barra Institucional?",
                "Información general del sitio web, el autor o la compañía entre otras cosas.",
                "Una lista de links apuntando a cada uno de los Items.",
                "Una lista de artículos, descripciones de productos o cualquier otra información importante",
                "Información general del sitio web, el autor o la compañía entre otras cosas.");
        this.addQuestion(q1);

        //Estructura deL Cuerpo
        q1=new Question("¿Qué etiqueta declara el cuerpo o la parte visible del documento?",
                "<section>","<aside>","<body>","<body>");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiquetas nos ofrecen información adicional de cada sección del mismo documento?",
                "<section> y <aside>","<footer> y <aside>","<body> y <footer>","<footer> y <aside>");
        this.addQuestion(q1);
        q1=new Question("¿Para qué nos han servido los elementos HTML5 estudiados?",
                "Para identificar cada sección de diseño.","Para saber su funcionalidad.",
                "Para saber hacer un sitio web.","Para identificar cada sección de diseño.");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiqueta nos permite navegar por el sitio web?","<navegation>",
                "<nav>","<section>","<nav>");
        this.addQuestion(q1);
        q1=new Question("¿Por qué es importante la etiqueta <section>?",
                "Con tiene la información más relevante de sitio web.",
                "Nos permite declarar la el cuerpo.","Nos ofrece información adicional de cada sección.",
                "Con tiene la información más relevante de sitio web.");
        this.addQuestion(q1);

        //Dentro del Cuerpo
        //PAK Seis
        q1=new Question("¿Para qué sirve la etiqueta <time>?","Nos permite llevar un control de tiempo",
                "Nos muestra hora en un formato comprensible.",
                "Nos muestra la  fecha y hora en formatos comprensibles por los usuarios y el navegador.",
                "Nos muestra la  fecha y hora en formatos comprensibles por los usuarios y el navegador.");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiqueta es utilizada para construir varios bloques de contenido?","<section>",
                "<var>","<aside>","<section>");
        this.addQuestion(q1);
        q1=new Question("¿Este elemento es usado para mostrar el título de un trabajo (libro, película, poema, etc…).?",
                "<article>","<cite>","<citar>","<cite>");
        this.addQuestion(q1);
        q1=new Question("¿Qué etiqueta permite resaltar el texto?","<small>","<hgr oup>","<marck>","<marck>");
        this.addQuestion(q1);
        q1=new Question("¿Esta etiqueta nos brinda  una porción independiente de contenido (por ejemplo," +
                " imágenes, diagramas o videos)?","<address>","<figure>","<hgr oup>","<figure>");
        this.addQuestion(q1);

    }

    //Este metodo que inserta los valores del objeto Quiestion a la Base Mediate la Utilización del
    //Metodo Put

    private void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_QUES, quest.getQUESTION());
        values.put(DBHelper.KEY_ANSWER, quest.getANSWER());
        values.put(DBHelper.KEY_OPTA, quest.getOPTA());
        values.put(DBHelper.KEY_OPTB, quest.getOPTB());
        values.put(DBHelper.KEY_OPTC, quest.getOPTC());
        // Inserting Row
        sqlite.insert(DBHelper.TABLE_NAME_3, null, values);
    }
}
