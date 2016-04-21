package mx.edu.utng.androidjuegos.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class DBHelper extends SQLiteOpenHelper {

//  Este es el DB HELPER principal de toda la base de datos contiene las tablas que se ocupan en la aplicación.
    public  static final String DATABASE_NAME = "utng.db";       //Uno por uno se deben declarar los datos.
    public  static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_tema";
    public static final String TABLE_NAME_3 = "tbl_quis";
    public static final String TABLE_NAME_4 = "tbl_modulos";
    public static final String NAME = "nombre";
    public static final String PASSWORD = "contrasena";
    public static final String MAIL = "correo";
    public static final String USER_ID = "id_usuario";
    public static final String  MOD_ID = "id_modulo";
    public static final String ID = "_id";
    public static final String ACTIVO = "_activo";
    public static final String CALIFICACION = "_calificacion";
    //Staticas del quis
    public static final String KEY_ID = "id";
    public static final String KEY_QUES = "question";
    public static final String KEY_ANSWER = "answer"; //correct option
    public static final String KEY_OPTA= "opta"; //option a
    public static final String KEY_OPTB= "optb"; //option b
    public static final String KEY_OPTC= "optc"; //option c

    private static final String CREATE_TABLE_1 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_1
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +MAIL+" TEXT, "
                    +PASSWORD+" TEXT);";

    //temas

    private static final String CREATE_TABLE_2 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_2
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +ACTIVO+" INTEGER, "
                    +CALIFICACION+" INTEGER, "
                    +MOD_ID+" INTEGER, FOREIGN KEY("+MOD_ID+") REFERENCES "+TABLE_NAME_4+" ("+ID+"));";

//quiz
    private static final String CREATE_TABLE_3 =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_3 + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";

//modulos
    private static final String CREATE_TABLE_4 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_4
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +ACTIVO+" INTEGER, "
                    +USER_ID+" INTEGER, FOREIGN KEY("+USER_ID+") REFERENCES "+TABLE_NAME_1+" ("+ID+"));";



    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);
        db.execSQL(CREATE_TABLE_4);
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
