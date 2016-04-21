package mx.edu.utng.ctutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Enrique on 02/03/2016.
 */

public class ResultActivity extends Activity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
		TextView t=(TextView)findViewById(R.id.textResult);
		Bundle b = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
		int score= b.getInt("score");
		bar.setRating(score);
		switch (score)//calif estrellas
		{
			case 1:
			case 2: t.setText("Lo siento mojor suerte para la proxima");
				break;
			case 3:
			case 4:t.setText("creo que si pucuste atencion durante el curso");
				break;
			case 5:t.setText("felicidades Obtuviste el amllor mensaje");

				break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}


	protected void onPause(){
		super.onPause();
		finish(); //termina la actividad
	}
}
