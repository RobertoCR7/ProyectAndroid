package mx.edu.utng.ctutorial.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mx.edu.utng.ctutorial.model.Question;
import mx.edu.utng.ctutorial.model.Tema;

/**
 * Created by Enrique on 02/03/2016.
 */
public class DBHelper extends SQLiteOpenHelper {


    public  static final String DATABASE_NAME = "utng.db";
    public  static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_tema";
    public static final String TABLE_NAME_3 = "tbl_quiz";
    public static final String TABLE_NAME_4 = "tbl_modulo";
    public static final String NAME = "nombre";
    public static final String PASSWORD = "contrasena";
    public static final String MAIL = "correo";
    public static final String USER_ID = "id_usuario";
    public static final String MOD_ID = "id_modulo";
    public static final String ID = "_id";
    public static final String ACTIVO = "activo";
    public static final String CALIFICACION = "calificacion";
    //Stativcas del cuiz
    public static final String KEY_ID = "id";
    public static final String KEY_QUES = "question";
    public static final String KEY_ANSWER = "answer"; //correct option
    public static final String KEY_OPTA= "opta"; //option a
    public static final String KEY_OPTB= "optb"; //option b
    public static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase sqlite;


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
                    +MOD_ID+" INTEGER, FOREIGN KEY("+MOD_ID+") REFERENCES "+TABLE_NAME_4+" ("+ID+"));";

    private static final String CREATE_TABLE_3 =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_3 + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";

    private static final String CREATE_TABLE_4 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_4
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +ACTIVO+" INTEGER, "
                    +USER_ID+" INTEGER, FOREIGN KEY("+USER_ID+") REFERENCES "+TABLE_NAME_1+" ("+ID+"));";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Se agegan todas las preguntas a las base, una x una mediante el metodo de addQuestion();
    private void addQuestions()
    {
        //================Bacico de c++============================================
        Question q1;
        //Se crean las preguntas con sus posibles resultado y su resultado correcto
        q1=new Question("De acuerdo a la estructura del programa que palabra falta en la linea de codigo \"int ____ ()\"","std", "main", "count", "main");
        this.addQuestion(q1);
        q1=new Question("¿Cuantos bytes ocupa el tipo de dato \"int\"", "2bytes", "8bytes", "4bytes", "4bytes");
        this.addQuestion(q1);
        q1=new Question("Cual es la principal caracteristica de una constante", "Tiene un valor fijo", "expresa valores diferentes dentro del codigo", "Ninguna", "Tiene un valor fijo");
        this.addQuestion(q1);
        q1=new Question("para que sirven los operadores en C++", "es mas corto", "es mas internacional", "ambos", "ambos");
        this.addQuestion(q1);
        q1=new Question("Para que nos sirven la entrada y salida de datos", "para realizar operaciones", "extraer caracteres", "Ninguna", "para realizar operaciones");
        this.addQuestion(q1);


        //================Controles de estructura============================================

        q1=new Question("C++ es lo mismo que C","si","no","es una evolucion","es una evolucion");
        this.addQuestion(q1);
        q1=new Question("Completa la linea de codigo ( count _____ \"x is 100\"","<<",">>","==","<<");
        this.addQuestion(q1);
        q1=new Question("conjunto de instruciones que se ejecutan cuando se llama desde algun punto del programa","funcion","operador","metodo","funcion");
        this.addQuestion(q1);
        q1=new Question("espesifica los datos devueltos por la funcion","tipo de dato","formato","funcion","tipo de dato");
        this.addQuestion(q1);
        q1=new Question("Completa la linea de codigo (Z = addition( x , __ ) )","z","x","y","y");
        this.addQuestion(q1);

        //================Componentes de tipos de datos============================================

        q1=new Question("Antes de empezar que se tiene que hacer primero de acuerdo a lo leído.","Abrir el proyecto para empezar a trabajar.","Descargar aplicaciones.","Instalar el SDK","Instalar el SDK");
        this.addQuestion(q1);
        q1=new Question("¿Que es sdk?","Herramienta de cómputo","Programa informático.","Herramienta que sirve para la creación de nuestro proyecto.","Herramienta que sirve para la creación de nuestro proyecto.");
        this.addQuestion(q1);
        q1=new Question("¿Que es sdk?","Herramienta de cómputo","Programa informático.","Herramienta que sirve para la creación de nuestro proyecto.","Herramienta que sirve para la creación de nuestro proyecto.");
        this.addQuestion(q1);
        q1=new Question("¿Que es sdk?","Herramienta de cómputo","Programa informático.","Herramienta que sirve para la creación de nuestro proyecto.","Herramienta que sirve para la creación de nuestro proyecto.");
        this.addQuestion(q1);
        q1=new Question("¿Que es sdk?","Herramienta de cómputo","Programa informático.","Herramienta que sirve para la creación de nuestro proyecto.","Herramienta que sirve para la creación de nuestro proyecto.");
        this.addQuestion(q1);


        //================Programacion orientada a objetos============================================

        q1=new Question("Por qué es importante configurar tu eclipse ","Es esencial para la creación del juego.","Para trabajar más rápido.","Para así poder usarlo para la creación de juegos.","Para así poder usarlo para la creación de juegos.");
        this.addQuestion(q1);
        q1=new Question("En cualquier ide se puede crear un juego.","Si solo basta con tener un SDK","Si en cualquiera que se desee.","Se tiene que tener un configurado el IDE para poder crear un juego.","Se tiene que tener un configurado el IDE para poder crear un juego.");
        this.addQuestion(q1);
        q1=new Question("En cualquier ide se puede crear un juego.","Si solo basta con tener un SDK","Si en cualquiera que se desee.","Se tiene que tener un configurado el IDE para poder crear un juego.","Se tiene que tener un configurado el IDE para poder crear un juego.");
        this.addQuestion(q1);
        q1=new Question("En cualquier ide se puede crear un juego.","Si solo basta con tener un SDK","Si en cualquiera que se desee.","Se tiene que tener un configurado el IDE para poder crear un juego.","Se tiene que tener un configurado el IDE para poder crear un juego.");
        this.addQuestion(q1);
        q1=new Question("En cualquier ide se puede crear un juego.","Si solo basta con tener un SDK","Si en cualquiera que se desee.","Se tiene que tener un configurado el IDE para poder crear un juego.","Se tiene que tener un configurado el IDE para poder crear un juego.");
        this.addQuestion(q1);


        //================Conceptos avanzados============================================

        q1=new Question("Para qué sirve el emulador de Android en el desarrollo de un juego.","Hace más rápido el proceso de la creación del juego.","Es una librería importante en la aplicación.","Para correr nuestra aplicación.","Para correr nuestra aplicación.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);



        //================Estandar de librerias============================================

        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);

    }

    // Este es el metodo que inserta los valores de objeto cuestion a la base mediante la utilizacion del petodo put,
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


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE_1);
    db.execSQL(CREATE_TABLE_2);
    db.execSQL(CREATE_TABLE_3);
    db.execSQL(CREATE_TABLE_4);
        sqlite=db;
        addQuestions();
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_3);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_4);
        onCreate(db);
    }


}
