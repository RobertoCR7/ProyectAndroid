package mx.edu.utng.AplicacionXML.model;

/**
 * Created by Roberto on 29/02/2016.
 */
public class ContactActivity {

    String name, email,uname,pass;


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
