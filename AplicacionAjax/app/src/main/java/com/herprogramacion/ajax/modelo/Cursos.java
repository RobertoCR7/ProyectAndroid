package com.herprogramacion.ajax.modelo;

import android.support.v7.app.AppCompatActivity;

import com.herprogramacion.ajax.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de datos estático para alimentar la aplicación
 */

/**
 * Created by Rodrigo Cortes Armas on 17/02/2016.
 */
public class Cursos extends AppCompatActivity{
    //declaracion de las variables que llenaran nuestra vista
    private String curso;
    private String eslogan;
    private int idDrawable;

    //el cursor se encarga de posicionar cada elemento es su lugar
    public Cursos(String curso, String eslogan, int idDrawable) {
        this.curso = curso;
        this.eslogan = eslogan;
        this.idDrawable = idDrawable;
    }
    //Lista de cursos, imagenes que se muestran el inicio de la aplicacion
    public static  final List<Cursos> CURSOS = new ArrayList<Cursos>();

    public static final List<Cursos> CAPITULOS = new ArrayList<>();
    public static final List<Cursos> VIDEOS = new ArrayList<>();
    public static final List<Cursos> MATERIAL = new ArrayList<>();

    /**
     * Nombre y descripcion de otros cursos en inicio de la aplicacion se podran descargar
     */
    static{
        CURSOS.add(new Cursos("HTML","¡Crea tus propias paginas!", R.drawable.ht));
        CURSOS.add(new Cursos("JAVA","¡El lenguaje mas famoso!", R.drawable.java));
        CURSOS.add(new Cursos("Javascript","¡Valida tus formularios!", R.drawable.script));
        CURSOS.add(new Cursos("PHP","¡Aprende php facilmente!", R.drawable.php));
        CURSOS.add(new Cursos("RUBY","¿Crees que es dificil?", R.drawable.ruby));

    }

    //Getters y Setters
    public String getCurso() {
        return curso;
    }

    public String getEslogan() {
        return eslogan;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}


