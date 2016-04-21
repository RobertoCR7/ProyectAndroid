package mx.edu.utng.jasperreport.Quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.jasperreport.CapitulosActivity;
import mx.edu.utng.jasperreport.MenuActivity;
import mx.edu.utng.jasperreport.R;

public class ResultActivity extends Activity implements View.OnClickListener {
	ImageButton imb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		imb=(ImageButton)findViewById(R.id.imv_back_capitulos);
		imb.setOnClickListener(this);
//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
//get score
		Bundle b = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
		int score= b.getInt("score");
//display score
		bar.setRating(score);
		switch (score)//calif estrellas
		{
			case 1: t.setText("Eres muy malo repasa el curso!");
				break;
			case 2: t.setText("Oops! Suerte para la proxima");
				break;
			case 3: t.setText("Sigue asi! Lograras la perfección!");
				break;
			case 4:t.setText("Woow! Eres muy bueno! Se nota que estudiaste bien el curso!");
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		finish();
		//startActivity(new Intent(ResultActivity.this, CapitulosActivity.class));
	}

}
