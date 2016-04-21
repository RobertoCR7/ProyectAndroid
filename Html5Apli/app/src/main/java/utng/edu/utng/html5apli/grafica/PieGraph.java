package utng.edu.utng.html5apli.grafica;

/**
 * Created by kevin on 05/04/2016.
 */

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import utng.edu.utng.html5apli.LogeoActividad;
import utng.edu.utng.html5apli.util.DBAdapter;


public class PieGraph {
  Context context;
    public int getResultadoI(){
        DBAdapter adapter = new DBAdapter(context);
        adapter.open();
       int quizI;
              quizI= adapter.traerCalifTema(1, LogeoActividad.ID_USUARIO_LOGEADO);
        adapter.close();
        return quizI;
    }
    public int getResultadoII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizII = adapter.traerCalifTema(2, LogeoActividad.ID_USUARIO_LOGEADO);
        adapter.close();
        return quizII;
    }
    public int getResultadoIII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIII = adapter.traerCalifTema(3, LogeoActividad.ID_USUARIO_LOGEADO);
        adapter.close();
        return quizIII;
    }
    public int getResultadoIV(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIV = adapter.traerCalifTema(4, LogeoActividad.ID_USUARIO_LOGEADO);
        adapter.close();
        return quizIV;
    }
    public int getResultadoV(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizV = adapter.traerCalifTema(5, LogeoActividad.ID_USUARIO_LOGEADO);
        adapter.close();
        return quizV;
    }
    public int getResultadoVI(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizVI = adapter.traerCalifTema(6, LogeoActividad.ID_USUARIO_LOGEADO);
        adapter.close();
        return quizVI;
    }



    public Intent getIntent(Context context) {
        this.context = context;

        int val1= getResultadoI();
        int val2= getResultadoII();
        int val3= getResultadoIII();
        int val4= getResultadoIV();
        int val5= getResultadoV();
        int val6= getResultadoVI();


        // int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      int[] values = { val1, val2, val3, val4,val5, val6 };
        CategorySeries series = new CategorySeries("Pie Graph");
        int k = 0;
        for (int value : values) {
            series.add("Quiz " + ++k +" Calif: "+value, value);

        }

        int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN,
                Color.GRAY};

        DefaultRenderer renderer = new DefaultRenderer();
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        renderer.setChartTitle("Pie Chart Demo");
        renderer.setLabelsColor(Color.BLACK);
        renderer.setChartTitleTextSize(7);
        renderer.setZoomButtonsVisible(true);

        Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, "Pie");
        return intent;
    }
}