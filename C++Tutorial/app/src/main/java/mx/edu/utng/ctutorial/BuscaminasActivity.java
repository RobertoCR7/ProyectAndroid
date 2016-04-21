package mx.edu.utng.ctutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Enrique on 21/04/2016.
 */
public class BuscaminasActivity extends Activity implements View.OnTouchListener {
    private Tablero fondo;
    int x;
    int y;
    private boolean activo = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bucaminas_activity);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linear_layout1);
        fondo = new Tablero(this);
        fondo.setOnTouchListener(this);
        linearLayout1.addView(fondo);
        fondo.casillas=new Casilla[8][8];
        for (int f=0; f<8;f++) {
            for (int c = 0; c < 8; c++) {
                fondo.casillas[f][c] = new Casilla();
            }
        }
        this.disponerBombas();
        this.contarBombasPerimetro();
    }
    public void presionado(View v){
        fondo.casillas=new Casilla[8][8];
        for (int f=0; f<8;f++) {
            for (int c = 0; c < 8; c++) {
                fondo.casillas[f][c] = new Casilla();
            }
        }
        this.disponerBombas();
        this.contarBombasPerimetro();
        activo = true;
        fondo.invalidate();
    }

    private void disponerBombas() {
        int cantidad = 8;
        do {
            int fila = (int) (Math.random()*8);
            int columna = (int) (Math.random()*8);
            if (fondo.casillas[fila][columna].contenido==0){
                fondo.casillas[fila][columna].contenido =80;
                cantidad--;
            }
        }while (cantidad!=0);
    }

    private void contarBombasPerimetro() {
        for (int f=0; f<8;f++) {
            for (int c = 0; c < 8; c++) {
                if (fondo.casillas[f][c].contenido==0){
                    int cant = contarCoordenadas(f,c);
                    fondo.casillas[f][c].contenido=cant;
                }
            }
        }
    }

    private int contarCoordenadas(int f, int c) {
        int total = 0;
        if (f -1>=0 && c-1>=0){
            if (fondo.casillas[f-1][c-1].contenido==80){
                total++;
            }
        }
        if (f-1>=0){
            if (fondo.casillas[f-1][c].contenido==80){
                total++;
            }
        }
        if (f-1>=0 && c+1<8){
            if (fondo.casillas[f-1][c+1].contenido==80){
                total++;
            }
        }
        if (c+1<8){
            if (fondo.casillas[f][c+1].contenido==80){
                total++;
            }
        }
        if (f+1<8 && c+1<8){
            if (fondo.casillas[f+1][c+1].contenido==80){
                total++;
            }
        }
        if (f+1<8){
            if (fondo.casillas[f+1][c].contenido==80){
                total++;
            }
        }
        if (f+1<8 && c-1>0){
            if (fondo.casillas[f+1][c-1].contenido==80){
                total++;
            }
        }
        if (c-1>=0){
            if (fondo.casillas[f][c-1].contenido==80){
                total++;
            }
        }
        return 0;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (activo){
            for (int f=0; f<8;f++) {
                for (int c = 0; c < 8; c++) {
                    if(fondo.casillas[f][c].dentro((int)event.getX(),
                            (int) event.getY())){
                        fondo.casillas[f][c].destapado = true;
                        if (fondo.casillas[f][c].contenido==80){
                            Toast.makeText(this,"Booooommm",Toast.LENGTH_SHORT).show();
                            activo = false;
                        }else if (fondo.casillas[f][c].contenido==0){
                            recorrer(f,c);
                        }
                        fondo.invalidate();
                    }
                }
            }
        }
        if (gano()&& activo){
            Toast.makeText(this,"Ganaste",Toast.LENGTH_LONG).show();
            activo=false;
        }
        return false;
    }

    private boolean gano() {
        int cant =0;
        for (int f=0; f<8; f++){
            for (int c=0;c <8;c++){
                if (fondo.casillas[f][c].destapado){
                    cant++;
                }
            }
        }
        if (cant==56){
            return true;
        }else
        return false;
    }


    private void recorrer(int f, int c) {
        if (f>=0 && f<8 && c>=0 && c<8){
            if (fondo.casillas[f][c].contenido==0){
                fondo.casillas[f][c].destapado = true;
                fondo.casillas[f][c].contenido = 50;
                recorrer(f,c+1);
                recorrer(f,c-1);
                recorrer(f+1,c);
                recorrer(f-1,c);
                recorrer(f-1,c-1);
                recorrer(f-1,c+1);
                recorrer(f+1,c+1);
                recorrer(f+1,c-1);
            }else if (fondo.casillas[f][c].contenido>=1 && fondo.casillas[f][c].contenido<=8){
                fondo.casillas[f][c].destapado=true;
            }
        }
    }
}
