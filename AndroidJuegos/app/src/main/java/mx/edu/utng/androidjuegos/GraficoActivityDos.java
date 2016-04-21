package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by a on 30/03/2016.
 */
public class GraficoActivityDos extends Activity {



    private GraficaHelperDos sqlite;
    private PieChart pieChart;
    private TableLayout table_layout;
    private Button btnEnviarCorreo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica_implementada);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        table_layout = (TableLayout) findViewById(R.id.tableLayout1);
        btnEnviarCorreo = (Button)findViewById(R.id.btn_enviar_correo);
        sqlite = new GraficaHelperDos(this);
        setDataChart();//grafico
        createDataTable();//tabla
        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GraficoActivityDos.this, EnviarCorreoActivity.class);
                startActivity(intent);
            }
        });
    }


    public void setDataChart() {
        //obtiene registro de la base de datos
        sqlite.openConnection();
        ArrayList<Grafica> candidatos = sqlite.getCandidatos();
        sqlite.closeConnection();

        //propiedades de grafico
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1000, 1000);
        pieChart.setHoleRadius(36f);
        pieChart.setDescription("");

        //valores
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        ArrayList<String> xVals = new ArrayList<String>();
        //colores de la torta
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);

        sqlite.openConnection();
        float total_votos = sqlite.getTotalVotos();
        sqlite.closeConnection();

        //ingresa datos a grafico
        for (int index = 0; index < candidatos.size(); index++) {
            float votos = (candidatos.get(index).getVotos() / total_votos) * 100f;
            yVals.add(new Entry(votos, index));
            xVals.add(candidatos.get(index).getSigla());
        }

        PieDataSet dataSet = new PieDataSet(yVals, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }

    //Para crear la tabla de votación:

    private void createDataTable() {
        sqlite.openConnection();
        ArrayList<Grafica> candidatos = sqlite.getCandidatos();
        sqlite.closeConnection();

        //
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(5, 3, 5, 3);
        tableRowParams.weight = 1;
        //encabezado
        TableRow rowHead = new TableRow(this);
        rowHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        //col 1
        TextView col1 = new TextView(this);
        col1.setBackgroundResource(R.drawable.tv_bg);
        col1.setGravity(Gravity.CENTER);
        col1.setTypeface(null, Typeface.BOLD);
        col1.setTextSize(12);
        col1.setPadding(6, 10, 6, 10);
        col1.setText("SIGLA");
        //col 2
        TextView col2 = new TextView(this);
        col2.setBackgroundResource(R.drawable.tv_bg);
        col2.setGravity(Gravity.CENTER);
        col2.setTypeface(null, Typeface.BOLD);
        col2.setTextSize(12);
        col2.setPadding(6, 10, 6, 10);
        col2.setText("LECCIÓN");
        //col 3
        TextView col3 = new TextView(this);
        col3.setBackgroundResource(R.drawable.tv_bg);
        col3.setGravity(Gravity.CENTER);
        col3.setTypeface(null, Typeface.BOLD);
        col3.setTextSize(12);
        col3.setPadding(6, 10, 6, 10);
        col3.setText("TOTAL");
        //añade columnas
        rowHead.addView(col1, tableRowParams);
        rowHead.addView(col2, tableRowParams);
        rowHead.addView(col3, tableRowParams);
        //añade fila
        table_layout.addView(rowHead);
        for (Grafica c : candidatos) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            //col 1
            TextView tv1 = new TextView(this);
            tv1.setBackgroundResource(R.drawable.tv_bg);
            tv1.setGravity(Gravity.CENTER);
            tv1.setTypeface(null, Typeface.BOLD);
            tv1.setTextSize(12);
            tv1.setPadding(6, 10, 6, 10);
            tv1.setText(c.getSigla());
            //col 2
            TextView tv2 = new TextView(this);
            tv2.setBackgroundResource(R.drawable.tv_bg);
            tv2.setGravity(Gravity.CENTER);
            tv2.setTextSize(12);
            tv2.setPadding(6, 10, 6, 10);
            tv2.setText(c.getNombre());
            //col 3
            TextView tv3 = new TextView(this);
            tv3.setBackgroundResource(R.drawable.tv_bg);
            tv3.setGravity(Gravity.CENTER);
            tv3.setTextSize(12);
            tv3.setPadding(6, 10, 6, 10);
            tv3.setText(String.valueOf(c.getVotos()));
            //añade columnas
            row.addView(tv1, tableRowParams);
            row.addView(tv2, tableRowParams);
            row.addView(tv3, tableRowParams);
            //añade fila
            table_layout.addView(row);
        }
    }

  /*  @Override
    public void onClick(View v) {
        startActivity(new Intent(GraficoActivityDos.this, LoginInterno.class));
    }*/
}
