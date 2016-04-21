package mx.edu.utng.jasperreport.grafica;

/**
 * Created by Erick on 05/04/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.jasperreport.R;

public class GraphAChartEngineActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica_layout);
    }

    public void lineGraphHandler(View view) {
        LineGraph line = new LineGraph();
        Intent lineIntent = line.getIntent(this);
        startActivity(lineIntent);
    }

    public void barGraphHandler(View view) {
        BarGraph bar = new BarGraph();
        Intent lineIntent = bar.getIntent(this);
        startActivity(lineIntent);
    }

    public void pieGraphHandler(View view) {
        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);

    }

    public void scatterGraphHandler(View view) {
        ScatterGraph scatter = new ScatterGraph();
        Intent lineIntent = scatter.getIntent(this);
        startActivity(lineIntent);
    }

}
