package utng.edu.mx.java.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import utng.edu.mx.java.ExampleIndiceActivity;
import utng.edu.mx.java.Grafica;
import utng.edu.mx.java.GraficaHelperDos;
import utng.edu.mx.java.MainActivity;
import utng.edu.mx.java.R;
import utng.edu.mx.java.SignUp;
import utng.edu.mx.java.Util.DBAdapter;

/**
 * Created by Gustavo on 26/03/2016.
 */

public class ResultActivity extends Activity {

	GraficaHelperDos db= new GraficaHelperDos(this);
	private Button btnMenu;
	Grafica graph= new Grafica();


	private DBAdapter dbAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		btnMenu=(Button)findViewById(R.id.Btn_sig_tema);
		btnMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle bundle=new Bundle();
				bundle.putBoolean("logeo",true);
				startActivity(new Intent(ResultActivity.this, ExampleIndiceActivity.class).putExtras(bundle));
				finish();
			}
		});
//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);

//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
//get score
		Bundle b = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
		int score= b.getInt("score");
//display score
		bar.setRating(score);
		dbAdapter=new DBAdapter(this);
		dbAdapter.open();


		int calificacion=dbAdapter.getCalificaciòn(b.getInt("posicion"),  MainActivity.ID_USUARIO);

		switch (score)//calif estrellas
		{
			case 1:
			case 2: t.setText("Te recomiendo que realices de nuevo el Examen de esté capitulo \n Calificación : "+calificacion);
				break;
			case 3:
			case 4:t.setText("No muy buena tu calificacion realices de nuevo el Examen de esté capitulo \n Calificación : "+calificacion);
				break;
			case 5:t.setText("Correcto pasas al siguiente nivel\n Calificación : "+calificacion);
				graph.setNombre("Temas");
				graph.setSigla("JAVA");
				graph.setVotos(20);
				db.insertResult(graph);
				break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}


}
