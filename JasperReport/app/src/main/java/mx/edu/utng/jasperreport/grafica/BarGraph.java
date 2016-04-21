package mx.edu.utng.jasperreport.grafica;

/**
 * Created by Erick on 05/04/2016.
 */
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class BarGraph{

    Context context;


    public Intent getIntent(Context context)
    {
        // Bar 1
        int[] y = {0,1 };
        CategorySeries series = new CategorySeries("Quiz 1");
        for (int i = 0; i < y.length; i++) {
            series.add("Bar " + (i+1), y[i]);
        }

        // Bar 2
        int[] y2 = {2,0};
        CategorySeries series2 = new CategorySeries("Quiz 2");
        for (int i = 0; i < y.length; i++) {
            series2.add("Bar " + (i+1), y2[i]);
        }

        // Bar 3
        int[] y3 = { 0,3};
        CategorySeries series3 = new CategorySeries("Quiz 3");
        for (int i = 0; i < y.length; i++) {
            series3.add("Bar " + (i+1), y3[i]);
        }

        // Bar 4
        int[] y4 = { 4,0};
        CategorySeries series4 = new CategorySeries("Quiz 4");
        for (int i = 0; i < y.length; i++) {
            series4.add("Bar " + (i+1), y4[i]);
        }

        // Bar 5
        int[] y5 = { 0,5};
        CategorySeries series5 = new CategorySeries("Quiz 5");
        for (int i = 0; i < y.length; i++) {
            series5.add("Bar " + (i+1), y5[i]);
        }

        // Bar 6
        int[] y6 = {6,0};
        CategorySeries series6 = new CategorySeries("Quiz 6");
        for (int i = 0; i < y.length; i++) {
            series6.add("Bar " + (i+1), y6[i]);
        }

        // Bar 7
        int[] y7 = {0,7};
        CategorySeries series7 = new CategorySeries("Quiz 7");
        for (int i = 0; i < y.length; i++) {
            series7.add("Bar " + (i+1), y7[i]);
        }

        // Bar 8
        int[] y8 = {8,0};
        CategorySeries series8 = new CategorySeries("Quiz 8");
        for (int i = 0; i < y.length; i++) {
            series8.add("Bar " + (i+1), y8[i]);
        }

        // Bar 9
        int[] y9 = {0,9};
        CategorySeries series9 = new CategorySeries("Quiz 9");
        for (int i = 0; i < y.length; i++) {
            series9.add("Bar " + (i+1), y9[i]);
        }

        // Bar 10
        int[] y10 = {10,0};
        CategorySeries series10 = new CategorySeries("Quiz 10");
        for (int i = 0; i < y.length; i++) {
            series10.add("Bar " + (i+1), y10[i]);
        }

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

        dataset.addSeries(series.toXYSeries());
        dataset.addSeries(series2.toXYSeries());
        dataset.addSeries(series3.toXYSeries());
        dataset.addSeries(series4.toXYSeries());
        dataset.addSeries(series5.toXYSeries());
        dataset.addSeries(series6.toXYSeries());
        dataset.addSeries(series7.toXYSeries());
        dataset.addSeries(series8.toXYSeries());
        dataset.addSeries(series9.toXYSeries());
        dataset.addSeries(series10.toXYSeries());



        // This is how the "Graph" itself will look like
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        mRenderer.setChartTitle("Resultados de los Custionarios");
        mRenderer.setXTitle("X VALUES");
        mRenderer.setYTitle("Y VALUES");
        mRenderer.setAxesColor(Color.WHITE);///////////////////////
        mRenderer.setLabelsColor(Color.YELLOW);

        // Customize bar 1
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setColor(Color.BLUE);
        renderer.setDisplayChartValues(true);
        renderer.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer);

        // Customize bar 2
        XYSeriesRenderer renderer2 = new XYSeriesRenderer();
        renderer2.setColor(Color.GREEN);
        renderer2.setDisplayChartValues(true);
        renderer2.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer2);


        // Customize bar 3
        XYSeriesRenderer renderer3 = new XYSeriesRenderer();
        renderer3.setColor(Color.MAGENTA);
        renderer3.setDisplayChartValues(true);
        renderer3.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer3);

        // Customize bar 4
        XYSeriesRenderer renderer4 = new XYSeriesRenderer();
        renderer4.setColor(Color.YELLOW);
        renderer4.setDisplayChartValues(true);
        renderer4.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer4);


        // Customize bar 5
        XYSeriesRenderer renderer5 = new XYSeriesRenderer();
        renderer5.setColor(Color.CYAN);
        renderer5.setDisplayChartValues(true);
        renderer5.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer5);

        // Customize bar 6
        XYSeriesRenderer renderer6 = new XYSeriesRenderer();
       renderer6.setColor(Color.GRAY);
        renderer6.setDisplayChartValues(true);
        renderer6.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer6);

        // Customize bar 7
        XYSeriesRenderer renderer7 = new XYSeriesRenderer();
        renderer7.setColor(Color.RED);
        renderer7.setDisplayChartValues(true);
        renderer7.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer7);

        // Customize bar 8
        XYSeriesRenderer renderer8 = new XYSeriesRenderer();
        renderer8.setColor(Color.DKGRAY);
        renderer8.setDisplayChartValues(true);
        renderer8.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer8);

        // Customize bar 9
        XYSeriesRenderer renderer9 = new XYSeriesRenderer();
        renderer9.setColor(Color.BLACK);
        renderer9.setDisplayChartValues(true);
        renderer9.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer9);

        // Customize bar 10
        XYSeriesRenderer renderer10 = new XYSeriesRenderer();
        renderer10.setColor(Color.LTGRAY);
        renderer10.setDisplayChartValues(true);
        renderer10.setChartValuesSpacing((float) 1);
        mRenderer.addSeriesRenderer(renderer10);



        Intent intent = ChartFactory.getBarChartIntent(context, dataset,mRenderer, Type.DEFAULT);
        return intent;
    }

}
