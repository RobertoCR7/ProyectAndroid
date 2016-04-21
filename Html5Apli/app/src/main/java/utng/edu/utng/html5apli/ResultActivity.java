package utng.edu.utng.html5apli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener {
	private Button btnVolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btnVolver =(Button)findViewById(R.id.btn_vover);
		setContentView(R.layout.activity_result);
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
			case 1:
			case 2:
			case 3:t.setText("Para poder pasar al siguiente modulo necesita sacar más de tres estrellas  : (");
				break;
			case 4:
			case 5:t.setText("Felicidades se a desbloqueado el siguiente Modulo ; )");
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

	public void onButtonClick(View view) {
		Intent intent = new Intent(ResultActivity.this, MenuActivity.class);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {

	}
}

