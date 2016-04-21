package mx.edu.utng.ctutorial.model;

/**
 * Created by Enrique on 05/04/2016.
 */
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

    public Modulo() {
        idModulo = 0;
        idUsiario = 0;
        activo = false;
        nombre = "";

    }

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
