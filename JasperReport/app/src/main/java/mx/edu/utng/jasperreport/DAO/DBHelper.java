package mx.edu.utng.jasperreport.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mx.edu.utng.jasperreport.Model.Question;
import mx.edu.utng.jasperreport.Util.DBAdapter;

/**
 * Created by Erick on 23/02/2016.
 * Faltan comentarios en la clase y los metodos
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
    //Estaticas de Quiz
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
                    +USER_ID+" INTEGER, FOREIGN KEY("+USER_ID+") REFERENCES "+TABLE_NAME_1+" ("+ID+"));";

    private static final String CREATE_TABLE_3 =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_3 + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_QUES+ " TEXT, "
                    + KEY_ANSWER+ " TEXT, "
                    +KEY_OPTA +" TEXT, "
                    +KEY_OPTB +" TEXT, "
                    +KEY_OPTC+" TEXT);";

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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_3);
        sqlite=db;
        onCreate(db);
    }


    //Se agrega todas las preguntas a la base, una por una mediante el metodo addQuestion
    private void addQuestions() {
        Question q1;
        //PAK Cero
        //Se crean las preguntas con sus posibles resultado y su resultado correcto
        q1 = new Question("¿En que esta escrito JasperReports?", "C#", "Java", "PHP", "Java");
        this.addQuestion(q1);
        q1 = new Question("¿Es una biblioteca que puede ser embebida en cualquier aplicacion Java?", "Si", "No", "Tal vez", "Si");
        this.addQuestion(q1);
        q1 = new Question("¿Que funciones incluye JasperReports?", "Scriplets y Subreportes", "Reportes y Scriplets", "No incluye funciones", "Scriplets y Subreportes");
        this.addQuestion(q1);
        q1 = new Question("¿Como se llama el servidor de JasperReports?", "JasperServer", "Linux", "Ninguno de los dos", "JasperServer");
        this.addQuestion(q1);

        // 5 preguntas más --

        //////////----------------------
        //PAK uno
        q1 = new Question("¿Los reportes se generan basados en un diseño xml?", "Cierto", "Falso", "Ninguna de las dos", "Cierto");
        this.addQuestion(q1);
        q1 = new Question("¿A traves de que se hace la conexio a base de datos?", "JDBC", "MySQL", "Ninguna de las dos", "JDBC");
        this.addQuestion(q1);
        q1 = new Question("¿Cual es el nombre del tema?", "No tiene", "Ciclo vital de JasperReport", "Introduccion a JasperReport", "Ciclo vital de JasperReport");
        this.addQuestion(q1);
        q1 = new Question("Completa la siguiente clase de JasperReport net.sf.jasperreports. ? .JasperManager", "engine", "view", "Esa parte de omite", "engine");
        this.addQuestion(q1);


        //PAK dos
        q1 = new Question("¿A traves de que metodo se compila?", "compileReport()", "onCompile()", "compileReport()", "compileReport()");
        this.addQuestion(q1);
        q1 = new Question("¿En donde se encuentra el compilador reportes?", "net.sf.jasperreports.engine.JasperManager", "net.sf.jasperreports.engines.JasperManager", "net.sf.jasperReports.engine.JasperManager", "net.sf.jasperreports.engine.JasperManager");
        this.addQuestion(q1);
        q1 = new Question("¿El diseño no es transformado en un objeto serializable del tipo net.sf.jasperreports.engine.JasperReport?", "Cierto", "Falso", "Ninguna", "Falso");
        this.addQuestion(q1);
        q1 = new Question("¿Que clase se utiliza para previsualizar el diseño?", "net.sf.jasperreports.engine.view.JasperReport", "net.sf.jasperreports.engine.view.JasperManager", "net.sf.jasperreports.engine.view.JasperDesignViewer", "net.sf.jasperreports.engine.view.JasperDesignViewer");
        this.addQuestion(q1);

        //PAK tres
        q1 = new Question("¿Cuantos métodos son utilizados para exportar los reportes?", "No se necesita ningun metodo", "Aproximadamente 15", "Aproximadamente 8", "Aproximadamente 15");
        this.addQuestion(q1);
        q1 = new Question("¿Cual línea de código es necesaria para exportar los reportes con cualquiera de los 3 metodos?", "Ambas", "js = JasperManager.compileReport(rutaRep + '/' + narchivo);", "jp = JasperManager.fillReport()js, param, Motor.getConexion());", "Ambas");
        this.addQuestion(q1);
        q1 = new Question("¿Completa la siguiente linea jp = JasperManager. ?? (js, param, Motor.getConexion());", "fillReport", "compileReport()", "param", "fillReport");
        this.addQuestion(q1);
        q1 = new Question("¿Cual es la funcion de esta línea de codigo js = JasperManager.compileReport(rutaRep + '/' + narchivo);?", "Marcaria error", "El metodo invocado recibe tres parametros: el primero de ellos es una referencia al reporte a llenar; el segundo contiene los parametros necesario para llenar el reporte (si no son necesarios se pasa null); y el tercero es una referencia a la conexion con la base de datos, en mi caso utilizo una clase llamada Motor", "Solo referencia el reporte a llenar", "El metodo invocado recibe tres parametros: el primero de ellos es una referencia al reporte a llenar; el segundo contiene los parametros necesario para llenar el reporte (si no son necesarios se pasa null); y el tercero es una referencia a la conexion con la base de datos, en mi caso utilizo una clase llamada Motor");
        this.addQuestion(q1);

        //PAK cuatro
        q1 = new Question("¿Cómo se declara una variable?", "$P{parametro}", "${parametro}", "V{parametro}", "$V{parametro}");
        this.addQuestion(q1);
        q1 = new Question("¿De qué subtipo es el Map que se debe de crear cuando se esta preparando el reporte?", "<Object.String>", "String.Object<>", "No se necesita de ningun Map", "String.Object<>");
        this.addQuestion(q1);
        q1 = new Question("¿El Map String.Object<> es en especifico un HashMap?", "No existen esos terminos", "Falso", "Cierto", "Cierto");
        this.addQuestion(q1);
        q1 = new Question("¿Qué parametro se le pasa a compileReport() para iniciar el reporte?", "reportStream", "jrprint", "Exception e", "reportStream");
        this.addQuestion(q1);

        //PAK cinco
        q1 = new Question("¿Cómo se declara una variable?", "$V{variable}", "${variable}", "V{variable}", "$V{variable}");
        this.addQuestion(q1);
        q1 = new Question("¿Se puede declarar una variable en cualquier parte del documento?", "No", "Si", "A veces", "Si");
        this.addQuestion(q1);
        q1 = new Question("¿Son aquellas variables que como su nombre lo indica estan relacionadas con sus características exteriores?", "Variables de Entorno", "Variables Cualitativas", "Variables Estaticas", "Variables Cualitativas");
        this.addQuestion(q1);
        q1 = new Question("¿Completa la siguiente linea de codigo class=/'java.util.Date/'><![CDATA[   {FECHA}]]?", "$P", "$V", "Param", "$P");
        this.addQuestion(q1);

        //PAK Seis
        q1 = new Question("¿Que hay que hacer para añadir un nuevo estilo?", "Damos click derecho directamente sobre el estilo y añadimos el nuevo", "Vamos a la pestaña 'Template Inspector' damos click derecho sobre 'Styles' y los vamos añadiendo", "Es imposible crear nuevos estilo ya que son protegidos", "Vamos a la pestaña 'Template Inspector' damos click derecho sobre 'Styles' y los vamos añadiendo");
        this.addQuestion(q1);
        q1 = new Question("¿Podemos insertar una plantilla dando solo click derecho sobre la pestaña 'Report inspector'?", "Cierto", "Falso", "No existe dicha pestaña", "Falso");
        this.addQuestion(q1);
        q1 = new Question("¿En qué pestaña podemos cambiar ya sea el tipo de fuente, tamaño etc.?", "Report Inspector", "Styles", "Propiedades", "Propiedades");
        this.addQuestion(q1);
        q1 = new Question("¿Cualquiera puede dar estilo a un reporte en JasperReport?", "Por supuesto", "No, es complicado", "Ninguna de las dos", "Por supuesto");
        this.addQuestion(q1);

        //PAK Siete
        q1 = new Question("¿Un Scriptlet es una clase Java que debe extender de otras clases?", "Si", "No", "A veces", "Si");
        this.addQuestion(q1);
        q1 = new Question("¿Cuales son las clases de las que puede extender un Scriptlet?", "net.sf.jasperreports.engine.JRAbstractScriptlet", "De ambas", "net.sf.jasperreports.engine.JRDefaultScriptlet", "De ambas");
        this.addQuestion(q1);
        q1 = new Question("Completa la clase: net.sf.jasperreports.engine.JRA....Scriptlet", ".rchive", ".bstract", ".llow", ".bstract");
        this.addQuestion(q1);
        q1 = new Question("¿Que contiene la clase JRAbstract?", "Las implementaciones vacías por defecto de cada método en el JRAbstractScriptlet", "Esta clase no contiene nada", "Una serie de métodos abstractos que deben suprimirse en cada aplicación", "Una serie de métodos abstractos que deben suprimirse en cada aplicación");
        this.addQuestion(q1);

        //PAK Ocho
        q1 = new Question("Completa la siguiente consulta:  SELECT codigo, nombre, curso, horario FROM matricula INNER JOIN materia '??' idmateria = codigo '??' dni = $P{dni}", "ON y WHERE", "IN y WHERE", "IN y AS", "ON y WHERE");
        this.addQuestion(q1);
        q1 = new Question("¿Podemos ayudarnos del wizard de iReport para crear un subinforme y insertarlo en el informe padre?", "Nunca", "No siempre", "Si", "Si");
        this.addQuestion(q1);
        q1 = new Question("¿El subreporte no extiende del reporte padre?", "Cierto", "Nunca", "Falso", "Falso");
        this.addQuestion(q1);
        q1 = new Question("¿Como se llama el tema?", "Creacion de subreportes", "Introduccion a JasperReport", "Creacion de Gráficos", "Creacion de subreportes");
        this.addQuestion(q1);

        //PAK Nueve
        q1 = new Question("¿Crees que es un curso muy entrentenido?", "Si", "No", "Le falta algo", "Si");
        this.addQuestion(q1);
        q1 = new Question("¿Piensas que podemos mejorar en algo?", "Claro", "No", "Tal vez", "Claro");
        this.addQuestion(q1);
        q1 = new Question("¿Estarias dispuesto a pagar por una version premium?", "Si", "No", "Depende", "Depende");
        this.addQuestion(q1);
        q1 = new Question("¿Que opinas del desarrollador?", "Le falta algo a su app", "Es muy buena su app", "Debería esforzarse mas por mejorarla", "Debería esforzarse mas por mejorarla");
        this.addQuestion(q1);

    }


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
