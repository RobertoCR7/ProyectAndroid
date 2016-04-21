package utng.edu.utng.html5apli.grafica;

/**
 * Created by Kevin on 05/04/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import utng.edu.utng.html5apli.R;


public class GraphAChartEngineActivity extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.grafica_layout);

        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);
    }



   public void lineGraphHandler (View view)
    {
        LineGraph line = new LineGraph();
        Intent lineIntent = line.getIntent(this);
        startActivity(lineIntent);
    }

    public void barGraphHandler (View view)
    {
        BarGraph bar = new BarGraph();
        Intent lineIntent = bar.getIntent(this);
        startActivity(lineIntent);
    }

    public void pieGraphHandler (View view)
    {
        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);

    }

    public void scatterGraphHandler (View view)
    {
        ScatterGraph scatter = new ScatterGraph();
        Intent lineIntent = scatter.getIntent(this);
        startActivity(lineIntent);
    }

}