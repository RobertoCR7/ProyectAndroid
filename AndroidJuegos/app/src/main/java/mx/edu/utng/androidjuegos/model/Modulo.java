package mx.edu.utng.androidjuegos.model;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */

//Es la clase de modulo que contiene sus atributos declarados
public class Modulo {

    private int idModulo;
    private int idUsiario;
    private boolean activo;
    private String nombre;

    public Modulo(int idUsiario, String nombre, boolean activo) {
        this.idUsiario = idUsiario;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Modulo() {   //Se inicializan todos los datos en cero y vacio
        idModulo = 0;
        idUsiario = 0;
        activo = false;
        nombre = "";

    }

    //Se ponen sus setters y getters

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdUsiario() {
        return idUsiario;
    }

    public void setIdUsiario(int idUsiario) {
        this.idUsiario = idUsiario;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "idModulo=" + idModulo +
                ", idUsiario=" + idUsiario +
                ", activo=" + activo +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
