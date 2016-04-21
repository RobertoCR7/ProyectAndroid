package mx.edu.utng.ctutorial.model;

/**
 * Created by Enrique on 02/03/2016.
 */
public class Tema {

    private int  idTema;
    private String nombre;
    private int idModulo;
    private boolean activo;
    private int calificacion;

    public Tema() {
        idTema=0;
        nombre="";
        idModulo=0;
        activo=false;
        calificacion=0;
    }

    public Tema(String nombre, int idModulo, boolean activo, int calificacion) {
        this.nombre = nombre;
        this.idModulo = idModulo;
        this.activo = activo;
        this.calificacion = calificacion;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public int setCalificacion(int calificacion) {
        this.calificacion = calificacion;
        return calificacion;//
    }

    @Override
    public String toString() {
        return "Tema{" +
                "idTema=" + idTema +
                ", nombre='" + nombre + '\'' +
                ", idModulo=" + idModulo +
                ", activo=" + activo +
                ", calificacion=" + calificacion +
                '}';
    }
}
