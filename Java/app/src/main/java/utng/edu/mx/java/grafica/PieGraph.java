package utng.edu.mx.java.grafica;

/**
 * Created by Gustavo on 05/04/2016.
 */

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

import utng.edu.mx.java.MainActivity;
import utng.edu.mx.java.Util.DBAdapter;

public class PieGraph {
  Context context;
    public int getResultadoI(){
        DBAdapter adapter = new DBAdapter(context);
        adapter.open();
       int quizI;
              quizI= adapter.getCalificaciòn(1, MainActivity.ID_USUARIO);
        adapter.close();
        return quizI;
    }
    public int getResultadoII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizII = adapter.getCalificaciòn(2, MainActivity.ID_USUARIO);
        adapter.close();
        return quizII;
    }
    public int getResultadoIII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIII = adapter.getCalificaciòn(3, MainActivity.ID_USUARIO);
        adapter.close();
        return quizIII;
    }
    public int getResultadoIV(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizIV = adapter.getCalificaciòn(4, MainActivity.ID_USUARIO);
        adapter.close();
        return quizIV;
    }
    public int getResultadoV(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizV = adapter.getCalificaciòn(5, MainActivity.ID_USUARIO);
        adapter.close();
        return quizV;
    }
    public int getResultadoVI(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizVI = adapter.getCalificaciòn(6, MainActivity.ID_USUARIO);
        adapter.close();
        return quizVI;
    }

    public int getResultadoVII(){
        DBAdapter adapter= new DBAdapter(context);
        adapter.open();
        int quizVII = adapter.getCalificaciòn(7, MainActivity.ID_USUARIO);
        adapter.close();
        return quizVII;
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

        Log.e("CAL 1", "getIntent: "+val1 );
        Log.e("CAL 2", "getIntent: "+val2 );
        Log.e("CAL 3", "getIntent: "+val3 );
        Log.e("CAL 4", "getIntent: "+val4 );
        Log.e("CAL 5", "getIntent: "+val5 );
        Log.e("CAL 6", "getIntent: "+val6 );
        Log.e("CAL 7", "getIntent: "+val7 );
        // int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      int[] values = { val1, val2, val3, val4,val5, val6, val7};
        CategorySeries series = new CategorySeries("Pie Graph");
        int k = 0;
        for (int value : values) {
            series.add("Quiz " + ++k +" Calif: "+value, value);

        }

        int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN,
                Color.GRAY, Color.RED};

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