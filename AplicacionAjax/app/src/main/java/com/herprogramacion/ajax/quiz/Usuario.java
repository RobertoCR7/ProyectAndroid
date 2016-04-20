package com.herprogramacion.ajax.quiz;

/**
 * Created by griselda on 23/02/2016.
 * Faltan comentarios en la clase y los metodos
 */
public class Usuario {

    private int  idUsuario;
    private String nombre;
    private String contrasena;

    public Usuario(int idUsuario, String nombre, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(){
        this(0,"","");

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
