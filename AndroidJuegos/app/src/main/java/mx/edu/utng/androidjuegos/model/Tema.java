package mx.edu.utng.androidjuegos.model;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class Tema {  //Se declaran los datos de la tabla tema.

    private int  idTema;
    private String nombre;
    private int idModulo;
    private boolean activo;
    private int calificacion;

    public Tema() {   //Se inicializan en cero los que son de tipo entero y las cadenas vacias
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

    //Se ponen sus respectivos setters y getters

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
