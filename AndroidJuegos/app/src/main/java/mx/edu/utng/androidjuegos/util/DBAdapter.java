package mx.edu.utng.androidjuegos.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.androidjuegos.LogeoActividad;
import mx.edu.utng.androidjuegos.dao.DBHelper;
import mx.edu.utng.androidjuegos.model.Modulo;
import mx.edu.utng.androidjuegos.model.Question;
import mx.edu.utng.androidjuegos.model.Tema;


/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */

//Esta es la clase donde se controla todo lo que se tiene que ver con la base de datos.

public class DBAdapter {
    SQLiteDatabase db;   //Se crea la base de datos.
    DBHelper dbHelper;   //se manda el dhHelper
    Context context;

    public DBAdapter(Context c) {
        this.context = c;
    }

    //Se abre la base de daos se declara cual sera el nombre la version de la base de datos

    public DBAdapter open() throws SQLException {
        dbHelper = new DBHelper(context, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    //metodo cerrar

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

    // se agragan todas las preg=untas ala base una mediate el metodo addCuestion
    private void addQuestions() {

        //================Introduccion============================================
        Question q1;
        //PAK Cero  -->Introducción --1(Intro)
        //Se crean las preguntas con sus posibles resultado y su resultado correcto
        q1 = new Question("¿Que es Android Games", "Un juego", "Programa de computo", "Desarrollador de juegos", "Desarrollador de juegos");
        this.addQuestion(q1);
        q1 = new Question("Cual es el objetivo de este curso", "Interacuar", "Aprender en la creacion de un juego", "Ninguna", "Aprender en la creacion de un juego");
        this.addQuestion(q1);
        //================Introduccion============================================

        //////////================Bienvenido a android=============================
        //PAK uno -->Bienvenido a Android Games (Instalación del equipo)
        q1 = new Question("Hay algunos pasos que deben completarse antes de que podamos conseguir a la materia esencial cuantos pasos son. ", "5", "10", "6", "6");
        this.addQuestion(q1);
        q1 = new Question("Este es un paso opcional que le ayudará con las pruebas de su juegos en muchas versiones de la API y tamaños de pantalla.", "Descargar sdk", "openGL", "Crear un emulador.", "Crear un emulador.");
        this.addQuestion(q1);

        //PAK dos  -->Bienvenido a Android Games (Descargar e instalar el SDK)
        q1 = new Question("Antes de empezar que se tiene que hacer primero de acuerdo a lo leído.", "Abrir el proyecto para empezar a trabajar.", "Descargar aplicaciones.", "Instalar el SDK", "Instalar el SDK");
        this.addQuestion(q1);
        q1 = new Question("¿Que es sdk?", "Herramienta de cómputo", "Programa informático.", "Herramienta que sirve para la creación de nuestro proyecto.", "Herramienta que sirve para la creación de nuestro proyecto.");
        this.addQuestion(q1);

        //PAK tres -->Bienvenido a Android Games (Configurar el Eclipse)
        q1 = new Question("Por qué es importante configurar tu eclipse ", "Es esencial para la creación del juego.", "Para trabajar más rápido.", "Para así poder usarlo para la creación de juegos.", "Para así poder usarlo para la creación de juegos.");
        this.addQuestion(q1);
        q1 = new Question("En cualquier ide se puede crear un juego.", "Si solo basta con tener un SDK", "Si en cualquiera que se desee.", "Se tiene que tener un configurado el IDE para poder crear un juego.", "Se tiene que tener un configurado el IDE para poder crear un juego.");
        this.addQuestion(q1);

        //PAK cuatro--> Bienvenido a Android Games (Creación de un emulador de Android)
        q1 = new Question("Para qué sirve el emulador de Android en el desarrollo de un juego.", "Hace más rápido el proceso de la creación del juego.", "Es una librería importante en la aplicación.", "Para correr nuestra aplicación.", "Para correr nuestra aplicación.");
        this.addQuestion(q1);
        q1 = new Question("Que parte es importante saber acerca del emulador Android.", "Nada todo queda entendido.", "Que se debe de instalar siempre después de configurar eclipse.", "Que se puede correr la aplicación en un dispositivo real o en emulador.", "Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);


        //PAK cinco--> Bienvenido a Android Games (Creación de una AVD)

        q1 = new Question("¿Que es avd?", "Un componente de eclipse.", "Una librería.", "Conjunto de atributos de configuración aplicado a una imagen emulador.", "Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1 = new Question("Que es lo que ofrece un AVD", "Un entorno más cómodo para trabajar.", "Se encarga de correr el programa.", "Crea dispositivos virtuales", "Crea dispositivos virtuales");
        this.addQuestion(q1);


        //PAK seis--> Bienvenido a Android Games (Configuración de un dispositivo real)
        q1 = new Question("Cuantos pasos se requieren para realizar la configuración de un dispositivo real.", "Solo dos", "Son 2 pasos", "Son 5 pasos", "Son 5 pasos");
        this.addQuestion(q1);
        q1 = new Question("Que te permite la configuración de un dispositivo real.", "Una mejora en la creación del juego.", "Prueba múltiples tamaños de pantalla.", "Correr de mejor manera nuestra app.", "Prueba múltiples tamaños de pantalla.");
        this.addQuestion(q1);
        //////////================Bienvenido a android=============================


        //===========================00Trucos para movil===============================0

        //PAK cuatro--> Trucos para movil(La compilación de código nativo en Android)
        q1 = new Question("Que se necesita para compilar codigo nativo en android", "Conexión a internet", "Un AVD configurado", "Una java class y un archivo C", "Una java class y un archivo C");
        this.addQuestion(q1);
        q1 = new Question("Que se requiere para la compilacion de código nativo en android", "Descargar sdk", "Cargar la libreria System.loadLibrary", "Iniciar el emulador", "Cargar la libreria System.loadLibrary");
        this.addQuestion(q1);

        //PAK cuatro--> Trucos para movil(Crear el proyecto Android con soporte nativo)
        q1 = new Question("Este es el principal punto de entrada para la aplicación.", "Correr el programa en el emulador.", "Un archivo en C", "Una actividad en android", "Una actividad en android");
        this.addQuestion(q1);
        q1 = new Question("Esta biblioteca implementa la función de registro simple de C" +
                "extrae un argumento de cadena de la actividad de Java e imprime el mensaje" +
                "a la consola de registro de Android.", "un archivo", "Biblioteca nativa", "actividad", "Biblioteca nativa");
        this.addQuestion(q1);

        //PAK cuatro--> Trucos para movil(Arquitectura de la aplicación)
        q1 = new Question("A que se refiere la arquitectura de nuestra aplicacion", "A la forma de trabajar que se tendra en el desarrollo de la aplicacion.", "A la construccion del programa", "A la creacion de una carpeta que contenga ordenado las clases y archivos", "A la creacion de una carpeta que contenga ordenado las clases y archivos");
        this.addQuestion(q1);
        q1 = new Question(" Estos dos trabajan juntos" +
                "con la biblioteca nativa.", "SuSe y Bios", "Actividad principal de Java y su interfaz nativa de compañía.", "La libreria y el sdk", "Actividad principal de Java y su interfaz nativa de compañía.");
        this.addQuestion(q1);

        ///AQUI VOY....
        //PAK cuatro--> Trucos para movil(Actividad principal)
        q1 = new Question("Completa el codigo, public class MainActivity extends Activity {\n" +
                "{\n" +
                "System.loadLibrary(\"ch02\");\n" +
                "}\n" +
                "@Override\n" +
                "public void _______________________________ {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "setContentView(R.layout.main);\n" +
                "try {\n" +
                "// Run native method\n" +
                "String[] argv = { \"MyLib\", \"arg1\", \"arg2\" };\n" +
                "Natives.LibMain(argv);\n" +
                "} catch (Exception e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "}\n", "Para correr el programa", "Es la que le da e diseño a nuestra aplicacion", "onCreate(Bundle savedInstanceState)", "onCreate(Bundle savedInstanceState)");
        this.addQuestion(q1);
        q1 = new Question("Contiene el método onCreate (Bundle" +
                "savedInstanceState) el cual será invocado por Android. ", "El archivo principal de la Interfaz", "La actividad principal", "archivo sdk", "La actividad principal");
        this.addQuestion(q1);


        //PAK cuatro--> Trucos para movil(Interface Nativa)
        q1 = new Question("Contiene dos métodos importantes que tienen que ver" +
                "con la biblioteca C", "El programa eclipse", "La actividad principal", "La interfaz nativa", "La interfaz nativa");
        this.addQuestion(q1);
        q1 = new Question("Este" +
                "método está destinado a ser llamado desde la biblioteca C", "onCreate", " privado static void OnMessage", "Metodo main", " privado static void OnMessage");
        this.addQuestion(q1);


        //PAK cuatro--> Trucos para movil(Biblioteca nativa)
        q1 = new Question("Este archivo de cabecera tiene los prototipos para todo el sistema de llamadas JNI para ser utilizado por la biblioteca.", "onCreate", "System.libary", "La biblioteca nativa", "La biblioteca nativa");
        this.addQuestion(q1);
        q1 = new Question("Es generada por máquina y no debe ser editado por el usuario", "La biblioteca nativa", "jni.Natives clase", "metodo onCreate", "jni.Natives clase");
        this.addQuestion(q1);


        //PAK cuatro--> Trucos para movil(La conversión de una matriz de cadenas de Java)
        q1 = new Question("Es una herramienta muy útil para enviar argumentos" +
                "a una biblioteca nativa.", "Convertir el elemento recuperado", "Asignar espacio para la matriz ", "La conversión de una matriz de cadenas de Java a una matriz C ", "La conversión de una matriz de cadenas de Java a una matriz C ");
        this.addQuestion(q1);
        q1 = new Question("Metodo que te envia el arreglo", "GetStringUTFChars", "GetObjectArrayElement ", "jobjectArray", "GetObjectArrayElement ");
        this.addQuestion(q1);


        //PAK cuatro--> Trucos para movil(La compilación de la biblioteca compartida)
        q1 = new Question("Que es lo que se debe hacer antes de poder ejecutar nuestra aplicación ", "Debugear la aplicación", "Checar si esta encendido el emulador", "La compilación de la biblioteca compartida", "La compilación de la biblioteca compartida");
        this.addQuestion(q1);
        q1 = new Question("Este archivo describe el nombre del módulo y los archivos de origen de la biblioteca", "jni.Natives ", "Android.mk ", "jobjectArray", "Android.mk ");
        this.addQuestion(q1);


        //PAK cuatro--> Trucos para movil(Los controladores Bluetooth (Zeemote))
        q1 = new Question("Control muy popular en los teléfonos Nokia.", "HP", "IBM", "Zeemote", "Zeemote");
        this.addQuestion(q1);
        q1 = new Question("consiste en un joystick y cuatro botones (A, B," +
                "C, y D", "sdk", "El zemote", "android", "El zemote");
        this.addQuestion(q1);


        //===========================00Trucos para movil===============================0

        //===========================

        //oPN GL Y JN===================================================================

        //OpenGL y JNI -->7(La energía de los dispositivos móviles)
        q1 = new Question("Proporciona la API de software para hacer de alto rendimiento," +
                "juegos acelerados por hardware posible", "256 KB de RAM", "rocesador ARM", "OpenGL", "OpenGL");
        this.addQuestion(q1);
        q1 = new Question("Si lo desea, puede importar el proyecto en su espacio de trabajo que se tiene que hacer", "Abrir el emulador", "Archivo despues a importación y seleccionar proyecto", "Ir a las carpetas", "Archivo despues a importación y seleccionar proyecto");
        this.addQuestion(q1);

        //OpenGL y JNI -->7(OpenGL el Camino de Java)
        q1 = new Question("¿Que es lo que se vera en este capitulo?", "La configuración de nuestro emulador", "La configuracion de eclipse", "La creacion de un proyecto en si con openGL", "La creacion de un proyecto en si con openGL");
        this.addQuestion(q1);
        q1 = new Question("¿Cual es el objetivo de este modulo?", "Hacer la importacion de un proyecto", "Crear un cubo con todos los componentes.", "Crear archivos compartidos", "Crear un cubo con todos los componentes.");
        this.addQuestion(q1);


        //OpenGL y JNI -->7(Creación de un proyecto)
        q1 = new Question("Que nos dice el paso 3 en la creación de un proyecto", "Haga clic en Finalizar.", "Haga clic en el botón Nuevo proyecto Android.", "Especificar el destino de generación", "Especificar el destino de generación");
        this.addQuestion(q1);
        q1 = new Question("Que nos dice el paso 4 en la creación de un proyecto", "Haga clic en Finalizar.", "Introduzca un nombre de aplicación, tales como Ch03.OpenGL.", "Especificar el destino de generación", "Introduzca un nombre de aplicación, tales como Ch03.OpenGL.");
        this.addQuestion(q1);

        //OpenGL y JNI -->7(Java Actividad Principal)
        q1 = new Question("public class JavaGLActivity extends Activity\n" +
                "{\n" +
                "private GLSurfaceView mGLSurfaceView;\n" +
                "\n" +
                "@Override\n" +
                "public void onCreate(Bundle savedInstanceState) {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "mGLSurfaceView = ____________\n" +
                "try {\n" +
                "mGLSurfaceView.setRenderer(new CubeRenderer(true));\n" +
                "setContentView(mGLSurfaceView);\n" +
                "} catch (Exception e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "}\n", "GLSurfaceView mGLSurfaceView;", "e.printStackTrace();", "new GLSurfaceView(this);", "new GLSurfaceView(this);");
        this.addQuestion(q1);
        q1 = new Question("Estos métodos concedidos a la vista de la superficie (GLSurfaceView) a" +
                "tomar las medidas apropiadas, tales como el ahorro de estado de la aplicación o suspensión / reanudación", "onCreate y JavaGLActivity", "onPause () o onResume ()", "ninguno de los mencionados", "onPause () o onResume ()");
        this.addQuestion(q1);

        //OpenGL y JNI -->7(superficie Vista)
        q1 = new Question("define la superficie donde en el ejemplo los cubos que caen" +
                "en la animación", "GLThread.surfaceCreated ().", "mHolder = getHolder ();", "GLSurfaceView clase", "GLSurfaceView clase");
        this.addQuestion(q1);
        q1 = new Question("Este método se llama" +
                "inmediatamente antes de una superficie está siendo destruido.", "surfaceChanged(SurfaceHolder holder, int format, int w, int h):", "surfaceDestroyed(SurfaceHolder holder):", "surfaceCreated(SurfaceHolder holder):", "surfaceDestroyed(SurfaceHolder holder):");
        this.addQuestion(q1);

        //OpenGL y JNI -->7(Tema GL)
        q1 = new Question("Es un objeto de uso frecuente para restringir el número de hilos que pueden acceder al" +
                "Contexto OpenGL", "GL API.", "OpenGL", "Un semáforo", "Un semáforo");
        this.addQuestion(q1);
        q1 = new Question("Completa el siguiente codigo:" +
                "public class GLThread extends Thread\n" +
                "{\n" +
                "public GLThread(Renderer renderer, SurfaceHolder holder) {\n" +
                "super();\n" +
                "mDone = false;\n" +
                "mWidth = 0;\n" +
                "mHeight = 0;\n" +
                "mRenderer = renderer;\n" +
                "mHolder = holder;\n" +
                "_______(\"GLThread\");\n" +
                "}", "SurfaceHolder", "setName", "mEglHelper.finish();", "setName");
        this.addQuestion(q1);

        //OpenGL y JNI -->7(OpenGL nativo del Camino)
        q1 = new Question("es un sistema de un solo subproceso que requiere un ser GLContext" +
                "inicializado.", "lenguaje c", "Java", "OpenGL", "OpenGL");
        this.addQuestion(q1);
        q1 = new Question("Obtiene una instancia EGL. En Android, esto se puede hacer mediante el", "mEglDisplay", "EGLContext ", "OpenGL", "EGLContext ");
        this.addQuestion(q1);
        //oPN GL Y JN===================================================================


        //===========================Graficos con openGL===============================0

        //(OpenGL ES 2.0 y Android)
        q1 = new Question("Una gama más amplia de opciones de precisión para su uso en dispositivos embebidos utilizando", "shaders y GLSL.", "FBO", "OpenGL ES 2.0 y Android", "OpenGL ES 2.0 y Android");
        this.addQuestion(q1);
        q1 = new Question("¿Que es OpenGL ES 2.0?", "Un juego de android", "es un conjunto de mejoras para OpenGL ES 1.0", "Una actualizació de la primer versión", "es un conjunto de mejoras para OpenGL ES 1.0");
        this.addQuestion(q1);

        //(shaders)
        q1 = new Question("es un sencillo programa que describe el estrecho de OCTOPIZZO un vértice o un píxel", "Java", "jdk", "Un shaders", "Un shaders");
        this.addQuestion(q1);
        q1 = new Question("Ventajas de Shaders", "Multiplataforma es mejorado", "un mayor grado de flexibilidad simplicidad, y más alto grado de reutilización", "Es mas grande, se trabaja mejor.", "un mayor grado de flexibilidad simplicidad, y más alto grado de reutilización");
        this.addQuestion(q1);

        //GLSL)
        q1 = new Question("es el lenguaje OpenGL ES 2.0 para el sombreado de vértices y el fragmento de programación" +
                "shaders que ha sido adaptado para plataformas integradas.", "FBO", "Shaders", "GSLS", "GSLS");
        this.addQuestion(q1);
        q1 = new Question("Tiene el propósito de trabajar juntos" +
                "con OpenGL ES 1.1 para minimizar el consumo de energía y costo de los dispositivos ", "SuSe", "GSLS", "Shaders", "GSLS");
        this.addQuestion(q1);

        //Fragmento Lenguaje de sombreado (FSL)
        q1 = new Question("se usa para cambiar los atributos de color (RGBA) del píxel actual.", "HP", "IBM", "FSL", "FSL");
        this.addQuestion(q1);
        q1 = new Question("Determina cuando la declaración es invisible; este" +
                "incluye variables globales y locales, espacios de nombres, además de re-declaraciones", "variables y constantes locales", "Matrices de flotador", "vinculación entre un shader", "Matrices de flotador");
        this.addQuestion(q1);


        //Anatomía de un Shader
        q1 = new Question("¿Que palabra define el 2 paso de la anatomia de sombreado?", "Opcional validación", "Enlace", "Cargar el sombreado", "Cargar el sombreado");
        this.addQuestion(q1);
        q1 = new Question("¿Que palabra define el 6 paso de la anatomia de sombreado?", "Opcional validación", "Activar y usar.", "Crear un programa.", "Activar y usar.");
        this.addQuestion(q1);


        //Crear el programa de sombreado
        q1 = new Question("Completa el siguiente codigo:" +
                "int _____\n" +
                "Shader[0] = glCreateShader(GL_VERTEX_SHADER);\n" +
                "Shader[1] = glCreateShader(GL_FRAGMENT_SHADER);\n" +
                "LoadShader((char *)VertexShader, Shader[0]);\n" +
                "LoadShader((char *)FragmentShaderBlue, Shader[1]);\n" +
                "int Program = glCreateProgram();\n", "GL_FRAGMENT_SHADER", "OCTOPIZZO GL_VERTEX_SHADER", "Shader[2]", "Shader[2]");
        this.addQuestion(q1);
        q1 = new Question("Que es lo que crea un objeto de programa vacío" +
                "y devuelve un valor distinto de cero por la que se puede hacer referencia. ", "OCTOPIZZO GL_VERTEX_SHADER", "la API de glCreateProgram", "glCreateShader", "la API de glCreateProgram");
        this.addQuestion(q1);


        //Carga del Shader
        q1 = new Question("se utiliza para mantener las cadenas de código fuente que definen un shader.", "glShaderSource", "glCompileShader", "Un objeto de sombreado", "Un objeto de sombreado");
        this.addQuestion(q1);
        q1 = new Question("Completa el siguiente codigo:" +
                "void LoadShader(char *Code, int ID)\n" +
                "{\n" +
                "glShaderSource (ID, 1, (const char **)&Code, NULL);\n" +
                "glCompileShader (ID);\n" +
                "int ShaderStatus;\n" +
                "glGetShaderiv(ID, GL_COMPILE_STATUS, &ShaderStatus);\n" +
                "if (ShaderStatus != _______) {\n" +
                "printf(\"Error: Failed to compile GLSL program\\n\");\n" +
                "int Len = 1024;\n" +
                "char Error[1024];\n" +
                "glGetShaderInfoLog(ID, 1024, &Len, Error);\n" +
                "printf(“%s\\n”, Error);\n" +
                "exit (-1);\n" +
                "}\n" +
                "}\n", "Un objeto de sombreado", "GL_TRUE", "GL_COMPILE_STATUS", "GL_TRUE");
        this.addQuestion(q1);


        //Opcional: Programa de Validación y Estado
        q1 = new Question("Ayuda a ver si tiene errores de sintaxis en" +
                "su código de sombreado. ", "la API llamada glGetShaderiv", "Un objeto de sombreado", "Programa de Validación y Estado", "Programa de Validación y Estado");
        this.addQuestion(q1);
        q1 = new Question("Checa el siguiente codigo y corrige:" +
                "glValidateProgram(Program);\n" +
                "glGetProgramiv(Program, GL_VALIDATE_STATUS, &___________);\n" +
                "if (__________ != GL_TRUE) {\n" +
                "printf(\"Error: Failed to validate GLSL program\\n\");\n" +
                "exit(-1);\n" +
                "}\n" +
                "Finally, enable and use the program.", "OCTOPIZZO GL_VERTEX_SHADER", "ShaderStatus", "error:", "ShaderStatus");
        this.addQuestion(q1);


        //Manifest
        q1 = new Question("Completa el siguiente codigo:" +
                "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "package=\"com.opengl.shader\"\n" +
                "android:versionCode=\"1\"\n" +
                "android:versionName=\"1.0\" >\n" +
                "<uses-sdk\n" +
                "android:minSdkVersion=\"14\"\n" +
                "android:targetSdkVersion=\"14\" />\n" +
                "<uses-feature\n" +
                "android:glEsVersion=\"2\"\n" +
                "android:required=\"true\" />\n" +
                "<application\n" +
                "android:icon=\"@drawable/ic_launcher\"\n" +
                "android:label=\"@string/app_name\" >\n" +
                "<activity\n" +
                "android:label=\"@string/app_name\"\n" +
                "android:name=\".ShadersActivity\" >\n" +
                "<intent-filter >\n" +
                "<action android:name=\"android.intent.action.MAIN\" />\n" +
                "<category android:name=\"android.intent.category.LAUNCHER\" />\n" +
                "</intent-filter>\n" +
                "</activity>\n" +
                "</application>\n" +
                "__________\n", "archivo xml", "activity main", "</manifest>", "</manifest>");
        this.addQuestion(q1);
        q1 = new Question("Se pueden declarar diferentes permisos para la aplicacion", "XML", "Manifest", "En la interface", "Manifest");
        this.addQuestion(q1);


        //===========================00Trucos para movil===============================0


//64  164







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
                tema = new Tema("mod_2_tem_6", idModulo, false, 0);
                this.addTopic(tema);
                break;
            case 3:
                idModulo += 2;
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
                tema = new Tema("mod_3_tem_9", idModulo, false, 0);
                this.addTopic(tema);

                break;
            case 4:
                idModulo += 3;
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
                idModulo += 4;
                tema = new Tema("mod_5_tem_1", idModulo, true, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_2", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_3", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_4", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_5", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_6", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_7", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_8", idModulo, false, 0);
                this.addTopic(tema);
                tema = new Tema("mod_5_tem_9", idModulo, false, 0);
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
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre LIKE ? AND " + DBHelper.USER_ID + " " +
                "=? ", new String[]{nombreModulo, idUsu});

        int idModulo = 1;
        if (cursor != null) {
            cursor.moveToFirst();
            idModulo = cursor.getInt(cursor.getColumnIndex(DBHelper.ID));
            return idModulo;
        }
        return idModulo;
    }

    public void addModulos(int idUsuario) {
        //String idUsu=String.valueOf(idUsuario);

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


    //Este metodo

    public boolean statusModulo(int idUsuario, int numModulo) {
        String idUsu = String.valueOf(idUsuario);
        String nomMod = "";
        boolean activo = false;


        switch (numModulo) {
            case 1:
                nomMod = "Modulo_1";
                Cursor cursor = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre=? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor != null) {
                    cursor.moveToFirst();
                    activo = cursor.getInt(cursor.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 2:
                nomMod = "Modulo_2";
                Cursor cursor1 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre=? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor1 != null) {
                    cursor1.moveToFirst();
                    activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 3:
                nomMod = "Modulo_3";
                Cursor cursor2 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre=? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor2 != null) {
                    cursor2.moveToFirst();
                    activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 4:
                nomMod = "Modulo_4";
                Cursor cursor3 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre=? AND id_usuario=?", new String[]{nomMod, idUsu});

                if (cursor3 != null) {
                    cursor3.moveToFirst();
                    activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                    return activo;
                }
                return activo;
            case 5:
                nomMod = "Modulo_5";
                Cursor cursor4 = db.rawQuery(
                        "SELECT * FROM " + DBHelper.TABLE_NAME_4 + " WHERE nombre=? AND id_usuario=?", new String[]{nomMod, idUsu});

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

        String nomTema;
        String idMod = String.valueOf(idModulo);
        boolean activo = false;
        switch (numMod) {
            case 1:
                switch (numeroCap) {
                    case 1://SUBTEMAS
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
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    case 1://SUBTEMAS
                        nomTema = "mod_2_tem_1";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2://SUBTEMAS
                        nomTema = "mod_2_tem_2";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3://SUBTEMAS
                        nomTema = "mod_2_tem_3";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4://SUBTEMAS
                        nomTema = "mod_2_tem_4";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5://SUBTEMAS
                        nomTema = "mod_2_tem_5";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6://SUBTEMAS
                        nomTema = "mod_2_tem_6";
                        Cursor cursor6 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor6.moveToFirst();
                        activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                return activo;
            case 3:
                idModulo = idModulo + 2;
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    case 1://SUBTEMAS
                        nomTema = "mod_3_tem_1";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2://SUBTEMAS
                        nomTema = "mod_3_tem_2";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3://SUBTEMAS
                        nomTema = "mod_3_tem_3";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4://SUBTEMAS
                        nomTema = "mod_3_tem_4";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5://SUBTEMAS
                        nomTema = "mod_3_tem_5";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6://SUBTEMAS
                        nomTema = "mod_3_tem_6";
                        Cursor cursor6 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor6.moveToFirst();
                        activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 7://SUBTEMAS
                        nomTema = "mod_3_tem_7";
                        Cursor cursor7 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor7.moveToFirst();
                        activo = cursor7.getInt(cursor7.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 8://SUBTEMAS
                        nomTema = "mod_3_tem_8";
                        Cursor cursor8 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor8.moveToFirst();
                        activo = cursor8.getInt(cursor8.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 9://SUBTEMAS
                        nomTema = "mod_3_tem_9";
                        Cursor cursor9 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor9.moveToFirst();
                        activo = cursor9.getInt(cursor9.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }
                return activo;
            case 4:
                idModulo = idModulo +3;
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    case 1://SUBTEMAS
                        nomTema = "mod_4_tem_1";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2://SUBTEMAS
                        nomTema = "mod_4_tem_2";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3://SUBTEMAS
                        nomTema = "mod_4_tem_3";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4://SUBTEMAS
                        nomTema = "mod_4_tem_4";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5://SUBTEMAS
                        nomTema = "mod_4_tem_5";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6://SUBTEMAS
                        nomTema = "mod_4_tem_6";
                        Cursor cursor6 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor6.moveToFirst();
                        activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 7://SUBTEMAS
                        nomTema = "mod_4_tem_7";
                        Cursor cursor7 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor7.moveToFirst();
                        activo = cursor7.getInt(cursor7.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;

                }
                return activo;
            case 5:
                idModulo = idModulo +4;
                idMod = String.valueOf(idModulo);
                switch (numeroCap) {
                    case 1://SUBTEMAS
                        nomTema = "mod_5_tem_1";
                        Cursor cursor1 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor1.moveToFirst();
                        activo = cursor1.getInt(cursor1.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 2://SUBTEMAS
                        nomTema = "mod_5_tem_2";
                        Cursor cursor2 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor2.moveToFirst();
                        activo = cursor2.getInt(cursor2.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 3://SUBTEMAS
                        nomTema = "mod_5_tem_3";
                        Cursor cursor3 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor3.moveToFirst();
                        activo = cursor3.getInt(cursor3.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 4://SUBTEMAS
                        nomTema = "mod_5_tem_4";
                        Cursor cursor4 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor4.moveToFirst();
                        activo = cursor4.getInt(cursor4.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 5://SUBTEMAS
                        nomTema = "mod_5_tem_5";
                        Cursor cursor5 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor5.moveToFirst();
                        activo = cursor5.getInt(cursor5.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 6://SUBTEMAS
                        nomTema = "mod_5_tem_6";
                        Cursor cursor6 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor6.moveToFirst();
                        activo = cursor6.getInt(cursor6.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 7://SUBTEMAS
                        nomTema = "mod_5_tem_7";
                        Cursor cursor7 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor7.moveToFirst();
                        activo = cursor7.getInt(cursor7.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 8://SUBTEMAS
                        nomTema = "mod_5_tem_8";
                        Cursor cursor8 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor8.moveToFirst();
                        activo = cursor8.getInt(cursor8.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                    case 9://SUBTEMAS
                        nomTema = "mod_5_tem_9";
                        Cursor cursor9 = db.rawQuery(
                                "SELECT * FROM " + DBHelper.TABLE_NAME_2 + " WHERE nombre LIKE ? AND " + DBHelper.MOD_ID + " = ?", new String[]{nomTema, idMod});
                        cursor9.moveToFirst();
                        activo = cursor9.getInt(cursor9.getColumnIndex(DBHelper.ACTIVO)) == 1 ? true : false;
                        return activo;
                }

                return activo;
        }
        return activo;

    }

    //Solo se activa y guarda la calificación de los temas

    public void addCalifTemas(int idModulo, int numModulo, int numTema, int calificacion) {

        String nombreSubtema = "";
        ContentValues values = new ContentValues();
        String idUsu=String.valueOf(LogeoActividad.ID_USUARIO);
        int calif = 0;

        int totalCal = 0;
        if (calificacion==2){
            totalCal = 10;
        }else if (calificacion==1){
            totalCal=5;

        }else{
            totalCal=0;
        }
        boolean isTopic=true;


            switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entero");
                        addCalifModulo(idUsu, 1);
                        isTopic=false;
                        break;
                }
                break;
            case 2:
                idModulo++;
                //Aqui falta algo
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_2_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_2_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_2_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_2_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_2_tem_6";
                        break;
                    case 6:
                        Log.e("Pepa :", "addCalifTemas: " + "Si entero");
                        addCalifModulo(idUsu, 2);
                        isTopic=false;
                        break;

                }
                break;
            case 3:
                idModulo = idModulo + 2;
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_3_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_3_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_3_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_3_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_3_tem_6";
                        break;
                    case 6:
                        nombreSubtema = "mod_3_tem_7";
                        break;
                    case 7:
                        nombreSubtema = "mod_3_tem_8";
                        break;
                    case 8:
                        nombreSubtema = "mod_3_tem_9";
                        break;
                    case 9:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entero");
                        addCalifModulo(idUsu, 3);
                        isTopic=false;
                        break;
                }
                break;
            case 4:
                idModulo = idModulo + 3;
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_4_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_4_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_4_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_4_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_4_tem_6";
                        break;
                    case 6:
                        nombreSubtema = "mod_4_tem_7";
                        break;
                    case 7:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entero");
                        addCalifModulo(idUsu, 4);
                        isTopic=false;
                        break;


                }
                break;
            case 5:
                idModulo=idModulo+4;
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_5_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_5_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_5_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_5_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_5_tem_6";
                        break;
                    case 6:
                        nombreSubtema = "mod_5_tem_7";
                        break;
                    case 7:
                        nombreSubtema = "mod_5_tem_8";
                        break;
                    case 8:
                        nombreSubtema = "mod_5_tem_9";
                        break;
                    case 9:
                        nombreSubtema = "mod_5_tem_9";
                        break;

                }
                break;
        }

        if (isTopic){
            if (totalCal==10){
                values.put(DBHelper.ACTIVO, true);
            }else {

                values.put(DBHelper.ACTIVO, false);
            }

            String idMos = String.valueOf(idModulo);
            db.update(DBHelper.TABLE_NAME_2, values , DBHelper.MOD_ID + " = ? AND " + DBHelper.NAME + " LIKE ? ", new String[]{idMos, nombreSubtema});

        }

    }

    //============================= ESTE EL EL NUEVO METODO========================================================================================================0
    //=============================================================================================================================================================

    public void insertaCalif(int idModulo, int numModulo, int numTema) {
        String nombreSubtema = "";
        ContentValues values = new ContentValues();
      /*  int calif = 0;
        String nombreSubtema="";
        boolean isActivoT= true;
        ContentValues values = new ContentValues();
        int totalCal = 0;
        if (calificacion==2){
            totalCal = 10;
        }else if (calificacion==1){
            totalCal=5;

        }else{
            totalCal=0;
        }*/


        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:
                        Log.e("Pepa:", "addCalifTemas: " + "Si entero");
                        nombreSubtema = "mod_1_tem_1";
                        break;
                }
                break;
            case 2:
                idModulo++;
                //Aqui falta algo
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_2_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_2_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_2_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_2_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_2_tem_6";
                        break;
                    case 6:
                        //nombreSubtema="mod_2_tem_7";
                        break;

                }
                break;
            case 3:
                idModulo = idModulo + 2;
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_3_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_3_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_3_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_3_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_3_tem_6";
                        break;
                    case 6:
                        nombreSubtema = "mod_3_tem_7";
                        break;
                    case 7:
                        nombreSubtema = "mod_3_tem_8";
                        break;
                    case 8:
                        nombreSubtema = "mod_3_tem_9";
                        break;
                    case 9:
                        nombreSubtema = "mod_3_tem_9";
                        break;
                }
                break;
            case 4:
                idModulo = idModulo + 3;
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_4_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_4_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_4_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_4_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_4_tem_6";
                        break;
                    case 6:
                        nombreSubtema = "mod_4_tem_7";
                        break;
                    case 7:
                        nombreSubtema = "mod_4_tem_7";
                        break;


                }
                break;
            case 5:
                switch (numTema) {
                    case 1:
                        nombreSubtema = "mod_5_tem_2";
                        break;
                    case 2:
                        nombreSubtema = "mod_5_tem_3";
                        break;
                    case 3:
                        nombreSubtema = "mod_5_tem_4";
                        break;
                    case 4:
                        nombreSubtema = "mod_5_tem_5";
                        break;
                    case 5:
                        nombreSubtema = "mod_5_tem_6";
                        break;
                    case 6:
                        nombreSubtema = "mod_5_tem_7";
                        break;
                    case 7:
                        nombreSubtema = "mod_5_tem_8";
                        break;
                    case 8:
                        nombreSubtema = "mod_5_tem_9";
                        break;
                    case 9:
                        nombreSubtema = "mod_5_tem_9";
                        break;

                }
                break;
        }


        values.put(DBHelper.ACTIVO, true);

        String idMos = String.valueOf(idModulo);
        db.update(DBHelper.TABLE_NAME_2, values, DBHelper.MOD_ID + " = ? AND " + DBHelper.NAME + " LIKE ?", new String[]{idMos, nombreSubtema});


        //  return calif;
    }




    public List<mx.edu.utng.androidjuegos.Question> getAllQuestions( int dd) {

        List<mx.edu.utng.androidjuegos.Question> quesList = new ArrayList<mx.edu.utng.androidjuegos.Question>();
        String selectQuery="";
        Cursor cursor;
        switch (dd){
            case 0:
                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" <3 ";// se crea la query 1,2
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >2 OR "+DBHelper.KEY_ID+" <5 ";// se crea la query 3, 4
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >4 OR "+DBHelper.KEY_ID+" <7 ";// se crea la query 5,6
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >6 OR "+DBHelper.KEY_ID+" <9 ";// se crea la query 7,8
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >8 OR "+DBHelper.KEY_ID+" <11 ";// se crea la query 9,10
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >10 OR "+DBHelper.KEY_ID+" <13 ";// se crea la query 11,12
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >12 OR "+DBHelper.KEY_ID+" <15 ";// se crea la query 13,14
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >14 OR "+DBHelper.KEY_ID+" <17 "; //15, 16 1
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >16 OR "+DBHelper.KEY_ID+" <19 "; //17, 18 2
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >18 OR "+DBHelper.KEY_ID+" <21 "; //19, 20 empiezan 3
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >20 OR "+DBHelper.KEY_ID+" <23 "; //21, 22 empiezan 4
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >22 OR "+DBHelper.KEY_ID+" <25 "; //23, 24 empiezan 5
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >24 OR "+DBHelper.KEY_ID+" <27 "; //25, 26 empiezan 6
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
            case 13:

                selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME_3+" where "+DBHelper.KEY_ID+" >26 OR "+DBHelper.KEY_ID+" <29 "; //27, 28 empiezan 7
                cursor = db.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
                        mx.edu.utng.androidjuegos.Question quest = new mx.edu.utng.androidjuegos.Question();
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
    //=============================================================================================================================================================

///Agrega la calificaion al modulo

    public void addCalifModulo(String idUsuario, int numModulo){
        String nombreModulo="";
        switch (numModulo){
            case 1:
                nombreModulo="Modulo_2";
                break;
            case 2:
                nombreModulo="Modulo_3";
                break;
            case 3:
                nombreModulo="Modulo_4";
                break;
            case 4:
                nombreModulo="Modulo_5";
                break;
            case 5:
                Log.e("default de sw", "addCalifModulo: No entro a ninguno" );
                break;
        }

        ContentValues values = new ContentValues();
        values.put(DBHelper.ACTIVO, 1);
        db.update(DBHelper.TABLE_NAME_4, values,DBHelper.USER_ID +" = ? AND "+DBHelper.NAME +" LIKE ?",
                new  String[]{idUsuario,nombreModulo});
    }

    public void setCalif(int idModulo, int numTema, int numModulo, int calificacion){
        int calif = 0;

        int totalCal = 0;
        if (calificacion==2){
            totalCal = 10;
        }else if (calificacion==1){
            totalCal=5;

        }else{
            totalCal=0;
        }
        String nombre= "";
        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:
                        nombre = "mod_1_tem1";
                        break;
                }
                break;
            case 2:

                idModulo++;
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
                    case 6:
                        nombre = "mod_2_tem_6";
                        break;

                }
                break;
            case 3:
                idModulo = idModulo + 2;
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
                    case 9:
                        nombre = "mod_3_tem_9";
                        break;
                }
                break;
            case 4:
               idModulo = idModulo + 3;
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
                        nombre = "mod_4_tem_7";
                        break;


                }
                break;
            case 5:
              idModulo=idModulo+4;
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
                    case 7:
                        nombre = "mod_5_tem_7";
                        break;
                    case 8:
                        nombre = "mod_5_tem_8";
                        break;
                    case 9:
                        nombre = "mod_5_tem_9";
                        break;
                }
                break;
        }

        if (totalCal==10) {
            String idMod = String.valueOf(idModulo);

            ContentValues values = new ContentValues();
            values.put(DBHelper.CALIFICACION, totalCal);
            db.update(DBHelper.TABLE_NAME_2, values, DBHelper.MOD_ID + " = ? AND " + DBHelper.NAME + " LIKE ? ", new String[]{idMod, nombre});
        }
    }

    public int traerCalificacion(int idModulo, int numTema, int numModulo){
        int calif=0;

        String nombre = "";
        switch (numModulo) {
            case 1:
                switch (numTema) {
                    case 1:
                        nombre = "mod_1_tem1";
                        break;
                }
                break;
            case 2:

                idModulo++;
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
                    case 6:
                        nombre = "mod_2_tem_6";
                        break;

                }
                break;
            case 3:
                idModulo = idModulo + 2;
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
                    case 9:
                        nombre = "mod_3_tem_9";
                        break;
                }
                break;
            case 4:
                idModulo = idModulo + 3;
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
                        nombre = "mod_4_tem_7";
                        break;


                }
                break;
            case 5:
                idModulo=idModulo+4;
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
                    case 7:
                        nombre = "mod_5_tem_7";
                        break;
                    case 8:
                        nombre = "mod_5_tem_8";
                        break;
                    case 9:
                        nombre = "mod_5_tem_9";
                        break;
                }
                break;
        }

        String idMod= String.valueOf(idModulo);
        Cursor cursor8=db.rawQuery(
                "SELECT * FROM "+DBHelper.TABLE_NAME_2+" WHERE nombre LIKE ? AND  "+DBHelper.MOD_ID+" = ?",new String[]{nombre,idMod});
        cursor8.moveToFirst();
        calif=cursor8.getInt(cursor8.getColumnIndex(DBHelper.CALIFICACION));
        return calif;
    }


    public int getProgresoModulos (String idUsuario){
        int row=0;
        Cursor cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.USER_ID+" = ?",
                new String[]{"1",idUsuario});
        row=cursor.getCount();
        //Cuenta de los temas
        int id=Integer.valueOf(idUsuario);
        int idMod=idModulo1(id, "Modulo 1");
        int idUsuar=Integer.valueOf(idUsuario);
        //Progreso del modulo 1
        int row2=getProgresoTemas(idUsuar, idMod, 1);
        //Progreso del modulo 2
        idMod++;
        int row3=getProgresoTemas(idUsuar,idMod,2);
        //Progreso del modulo 3
        idMod++;
        int row4=getProgresoTemas(idUsuar,idMod,3);
        //Progreso del modulo 4
        idMod++;
        int row5=getProgresoTemas(idUsuar,idMod,4);
        //Progreso del modulo 4
        idMod++;
        int row6=getProgresoTemas(idUsuar,idMod,5);

        return row;//+row2+row3+row4+row5;
    }
    public int getProgresoTemas (int idUsuario,int idModulo,int numeroMod){
        String idMod=String.valueOf(idModulo);
        boolean activoo=false;
        int row40=0;
        Cursor cursor;
        switch (numeroMod){
            case 1:
                cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.MOD_ID+" = ?",
                        new String[]{"1",idMod});
                row40=cursor.getCount();
                return row40;
            case 2:
                cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.MOD_ID+" = ?",
                        new String[]{"1",idMod});
                row40=cursor.getCount();
                activoo= statusModulo(2, idUsuario);
                if (activoo){
                    return row40;
                }else{
                    return row40-1;
                }
            case 3:
                cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4 + " where " + DBHelper.ACTIVO + " = ? and " + DBHelper.MOD_ID + " = ?",
                        new String[]{"1", idMod});
                row40=cursor.getCount();
                activoo= statusModulo(3, idUsuario);
                if (activoo){
                    return row40;
                }else{
                    return row40-1;
                }
            case 4:
                cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_4+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.MOD_ID+" = ?",
                        new String[]{"1",idMod});
                row40=cursor.getCount();
                activoo= statusModulo(2, idUsuario);
                if (activoo){
                    return row40;
                }else{
                    return row40-1;
                }
            case 5:
                cursor = db.rawQuery("SELECT  * FROM " + DBHelper.TABLE_NAME_2+" where "+DBHelper.ACTIVO+" = ? and "+DBHelper.MOD_ID+" = ?",
                        new String[]{"1",idMod});
                row40=cursor.getCount();
                activoo= statusModulo(2,idUsuario);
                if (activoo){
                    return row40;
                }else{
                    return row40-1;
                }
            default:
                break;
        }
        return row40;
    }



}
