package mx.edu.utng.ctutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by Enrique on 21/04/2016.
 */
public class Tablero extends View {
    Casilla[][] casillas;

    public Tablero(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(0,0,0);
        int ancho =0;
        if(canvas.getWidth()<canvas.getHeight()){
            ancho = this.getWidth();
        }else {
            ancho = this.getHeight();
        }
        int anchocua = ancho/8;
        Paint pincel = new Paint();
        pincel.setTextSize(20);
        Paint pincel2 = new Paint();
        pincel2.setTextSize(20);
        pincel2.setTypeface(Typeface.DEFAULT_BOLD);
        pincel2.setARGB(255, 0, 0, 255);
        Paint pincelLienal = new Paint();
        pincelLienal.setARGB(255, 255, 255, 255);
        int filaact = 0;
        for (int f=0; f<8;f++){
            for (int c = 0; c < 8; c++){
                casillas[f][c].fijarxy(c * anchocua, filaact, anchocua);
                if (casillas[f][c].destapado==false){
                    pincel.setARGB(153, 204, 204, 204);
                }else {
                    pincel.setARGB(255, 153, 153, 153 );
                }
                canvas.drawRect(c*anchocua,filaact, c*anchocua+anchocua-2,
                        filaact + anchocua - 2, pincel);
                canvas.drawLine(c*anchocua, filaact, c*anchocua+anchocua, filaact, pincelLienal);
                canvas.drawLine(c*anchocua+anchocua-1, filaact, c*anchocua+anchocua-1, filaact+anchocua, pincelLienal);
                if (casillas[f][c].contenido>=1 &&  casillas[f][c].contenido<=8 && casillas[f][c].destapado){
                    canvas.drawText(String.valueOf(casillas[f][c].contenido),c*anchocua+(anchocua/2)-8, filaact+anchocua/2, pincel2);

                }
                if (casillas[f][c].contenido == 80 && casillas[f][c].destapado) {
                    Paint bomba = new Paint();
                    bomba.setARGB(255, 255, 0, 0);
                    canvas.drawCircle(c * anchocua + (anchocua / 2), filaact
                    +(anchocua / 2), 8, bomba);
                }
            }
            filaact = filaact + anchocua;
        }
    }
}
