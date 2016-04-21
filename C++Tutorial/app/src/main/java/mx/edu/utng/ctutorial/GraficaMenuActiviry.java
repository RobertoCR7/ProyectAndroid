package mx.edu.utng.ctutorial;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.androidplot.Plot;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.StepFormatter;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.text.DecimalFormat;
import java.util.Arrays;

import mx.edu.utng.ctutorial.util.DBAdapter;

/**
 * Created by Enrique on 02/03/2016.
 */
public class GraficaMenuActiviry extends ActionBarActivity {
    private XYPlot myxyPlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_menu_layout);
        initComponents();
    }



    private void initComponents() {
        DBAdapter
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();

        int idmodI= dbAdapter.idModUno(Login.ID_USUARIO,"Modulo 1");

        int cal1=dbAdapter.traerCalifTema(1, idmodI, 1);
        int cal2=dbAdapter.traerCalifTema(1, idmodI, 2);
        int cal3=dbAdapter.traerCalifTema(1, idmodI, 3);
        int cal4=dbAdapter.traerCalifTema(1, idmodI, 4);
        int cal5=dbAdapter.traerCalifTema(1, idmodI, 5);
        int cal6=dbAdapter.traerCalifTema(1,idmodI,6);

        Log.e("Cal 1", "initComponents: "+cal1);
        Log.e("Cal 2", "initComponents: "+cal2);
        Log.e("Cal 3", "initComponents: "+cal3);
        Log.e("Cal 4", "initComponents: "+cal4);
        Log.e("Cal 5", "initComponents: "+cal5);
        Log.e("Cal 6", "initComponents: "+cal6);

        myxyPlot=(XYPlot)findViewById(R.id.xyp_grafica);

        Number[] series1Numbers = {cal1,cal2, cal3, cal4, cal5, cal6,0};

        XYSeries series2 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
                "Calificacion");

        myxyPlot.getGraphWidget().getDomainOriginLinePaint().setColor(Color.BLACK);//Borde interior
        myxyPlot.getGraphWidget().getRangeOriginLinePaint().setColor(Color.BLACK);//Borde interior

        myxyPlot.setBorderStyle(Plot.BorderStyle.SQUARE, null, null);//grafiac de barras
        myxyPlot.getBorderPaint().setStrokeWidth(1);
        myxyPlot.getBorderPaint().setAntiAlias(false);
        myxyPlot.getBorderPaint().setColor(Color.BLACK);//Borde de toda la grafica

        Paint lineFill = new Paint();
        lineFill.setAlpha(153);
        lineFill.setShader(new LinearGradient(250, 10, 0, 100, Color.WHITE, Color.BLUE, Shader.TileMode.MIRROR));

        StepFormatter stepFormatter  = new StepFormatter(Color.rgb(0, 0,0), Color.YELLOW);
        stepFormatter.getLinePaint().setStrokeWidth(1);//Grosor del borde de las lineas de las barras

        stepFormatter.getLinePaint().setAntiAlias(false);
        stepFormatter.setFillPaint(lineFill);
        myxyPlot.addSeries(series2, stepFormatter);
        //Numeraciones
        myxyPlot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);
        myxyPlot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
        myxyPlot.setTicksPerRangeLabel(1);
        myxyPlot.setTicksPerDomainLabel(1);

        myxyPlot.setDomainLabel("Examenes");
        myxyPlot.setRangeLabel("Calificaciónes");

        myxyPlot.setDomainValueFormat(new DecimalFormat("0"));//Para que solo aparescan numeros enteros


        myxyPlot.setTitle("Grafica de examnes");

    }
}
