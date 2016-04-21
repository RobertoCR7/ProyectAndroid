package mx.edu.utng.androidjuegos;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class DatosActividad { // se declaran los datos que se utilizaran como es el nombre, correo, usuario y contrasenia

    String name, email,uname,pass;

//Metodos setters y getters de cada uno
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return  this.name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return  this.email;
    }

    public void setUname(String uname){
        this.uname=uname;
    }
    public String getUname(){
        return  this.uname;
    }
    public void setPass(String pass){
        this.pass=pass;
    }
    public String getPass(){
        return  this.pass;
    }

}
