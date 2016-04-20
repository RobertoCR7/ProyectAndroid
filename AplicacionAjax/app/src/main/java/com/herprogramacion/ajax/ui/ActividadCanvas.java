package com.herprogramacion.ajax.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Rodrigo Cortes Armas on 19/04/2016.
 */
public class ActividadCanvas extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraficosView(this));

    }

    public class GraficosView extends View{
        public GraficosView(Context context) {
            super(context);
        }
         @Override
        protected void onDraw(Canvas canvas){
             canvas.drawRGB(20, 50, 255);
             Paint pincel1 = new Paint();
             pincel1.setARGB(255, 255, 100, 100);
             pincel1.setTextSize(350);
             pincel1.setTypeface(Typeface.SERIF);
             canvas.drawText("UTNG", 100, 270, pincel1);

         }
    }
}
