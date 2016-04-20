package mx.edu.utng.AplicacionXML.resultquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import mx.edu.utng.AplicacionXML.resultquiz.Result;

/**
 * Created by Roberto on 01/04/2016.
 */
public class DBHelperQuizUnoResultado extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "resultado.db";
    private static final String TABLE_NAME = "resultado";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RESULT = "score";

    private static final String TABLE_NAME_QUIZII = "resultadoii";
    private static final String COLUMN_ID_QUIZII = "id";
    private static final String COLUMN_RESULT_QUIZII = "score";


    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table resultado (id integer primary key not null , " +
            "score integer not null);";

    private static final String TABLE_CREATE_QUIZII= "create table "+TABLE_NAME_QUIZII+" (id integer primary key not null , " +
            "score integer not null);";

    public DBHelperQuizUnoResultado(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_QUIZII);
        this.db = db;
    }

    public void insertResult(Result re){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();



        String query = "select * from resultado";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_RESULT, re.getResult());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public void insertResultQuizII(Result re){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();



        String query = "select * from "+TABLE_NAME_QUIZII;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID_QUIZII, count);
        values.put(COLUMN_RESULT_QUIZII, re.getResult());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public  int traerResult() {
        int trerscore=0;
        db = this.getReadableDatabase();
        String query = "select id, score from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                   int id= cursor.getInt(0);
                  int  score = cursor.getInt(1);
                    // db.close();
                    trerscore=score;
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            Log.e("Base de datos", "Error al leer la base de datos");
        }

       return trerscore;
    }

    public  int traerResultQuizII() {
        int trerscore=0;
        db = this.getReadableDatabase();
        String query = "select id, score from " + TABLE_NAME_QUIZII;
        Cursor cursor = db.rawQuery(query, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    int id= cursor.getInt(0);
                    int  score = cursor.getInt(1);
                    // db.close();
                    trerscore=score;
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            Log.e("Base de datos", "Error al leer la base de datos");
        }

        return trerscore;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME+", "+TABLE_NAME_QUIZII;
        db.execSQL(query);
        this.onCreate(db);

    }


}
