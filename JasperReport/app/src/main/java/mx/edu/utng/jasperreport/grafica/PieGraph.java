package mx.edu.utng.jasperreport.grafica;

/**
 * Created by Erick on 05/04/2016.
 */

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import mx.edu.utng.jasperreport.Login.MainActivity;
import mx.edu.utng.jasperreport.Util.DBAdapter;

public class PieGraph {

    //Traemos los resultados de los temas de la bd
  Context context;
    public int getResultadoI(){
        DBAdapter adapter = new DBAdapter(context);
        adapter.open();
       int quizI;
              quizI= adapter.traerCalifTema(1, MainActivity.ID_USUARIO);
        adapter.close();
        return quizI;
    }
    public int getResultadoII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizII = adapter.traerCalifTema(2, MainActivity.ID_USUARIO);
        adapter.close();
        return quizII;
    }
    public int getResultadoIII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIII = adapter.traerCalifTema(3, MainActivity.ID_USUARIO);
        adapter.close();
        return quizIII;
    }
    public int getResultadoIV(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIV = adapter.traerCalifTema(4, MainActivity.ID_USUARIO);
        adapter.close();
        return quizIV;
    }
    public int getResultadoV(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizV = adapter.traerCalifTema(5, MainActivity.ID_USUARIO);
        adapter.close();
        return quizV;
    }
    public int getResultadoVI(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizVI = adapter.traerCalifTema(6, MainActivity.ID_USUARIO);
        adapter.close();
        return quizVI;
    }

    public int getResultadoVII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizVII = adapter.traerCalifTema(7, MainActivity.ID_USUARIO);
        adapter.close();
        return quizVII;
    }

    public int getResultadoVIII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizVIII = adapter.traerCalifTema(8, MainActivity.ID_USUARIO);
        adapter.close();
        return quizVIII;
    }

    public int getResultadoIX(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIX = adapter.traerCalifTema(9, MainActivity.ID_USUARIO);
        adapter.close();
        return quizIX;
    }

    public int getResultadoX(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizX = adapter.traerCalifTema(10, MainActivity.ID_USUARIO);
        adapter.close();
        return quizX;
    }

    public Intent getIntent(Context context) {
        this.context = context;

        int val1= getResultadoI();
        int val2= getResultadoII();
        int val3= getResultadoIII();
        int val4= getResultadoIV();
        int val5= getResultadoV();
        int val6= getResultadoVI();
        int val7= getResultadoVII();
        int val8= getResultadoVIII();
        int val9= getResultadoIX();
        int val10 = getResultadoX();

        // int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //Pasamos los resultados para dibujar la grafica
      int[] values = { val1, val2, val3, val4,val5, val6, val7, val8, val9, val10};
        CategorySeries series = new CategorySeries("Pie Graph");
        int k = 0;
        for (int value : values) {
            series.add("Quiz " + ++k +" Calif: "+value, value);

        }

        int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN,
                Color.GRAY, Color.RED, Color.DKGRAY, Color.BLACK, Color.LTGRAY };

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