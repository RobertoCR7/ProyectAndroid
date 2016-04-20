package mx.edu.utng.AplicacionXML.model;

/**
 * Created by Roberto on 23/02/2016.
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
        idModulo =0;
        calificacion = 0;
        activo=false;
    }

    public Tema( String nombre, int modulo, boolean activo,int calificacion) {
        this.nombre = nombre;
        this.idModulo = modulo;
        this.activo = activo;
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
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

    @Override
    public String toString() {
        return "Tema{" +
                "idTema=" + idTema +
                ", nombre='" + nombre + '\'' +
                ", usuario=" + idModulo +
                ", activo=" + activo +
                '}';
    }
}
