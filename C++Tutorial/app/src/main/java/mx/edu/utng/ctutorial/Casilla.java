package mx.edu.utng.ctutorial;

/**
 * Created by Enrique on 21/04/2016.
 */
public class Casilla {
    public int x;
    public int y;
    public int ancho;
    public int contenido;
    public boolean destapado = false;
    public void fijarxy(int x, int y, int ancho){
        this.x =x;
        this.y =y;
        this.ancho=ancho;
    }
    public boolean dentro(int xx, int yy){
        if(xx>=this.x && xx<=this.x+ancho && yy>=this.y && yy<=this.y+ancho){
            return true;
        }else {
            return false;
        }
    }
}
