package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class ResultActivity extends Activity {

	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();

	//private ImageView imvRetornar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		/*imvRetornar = (ImageView)findViewById(R.id.imv_retornar);

		imvRetornar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, ListaDosActivity.class);
				startActivity(intent);
			}
		});*/
//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
//get score
		Bundle valoresRecibidos = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
		int score= valoresRecibidos.getInt("score");
//display score
		bar.setRating(score);
		switch (score)//calif estrellas
		{
			//case 1:
			case 1: t.setText("Intentalo de nuevo");
				break;
			//case 3:
			case 2:t.setText("Muy BIEN continua el curso");

				switch (valoresRecibidos.getInt("moduloT")){
					case 0:
						switch (valoresRecibidos.getInt("temaT")){
							case 0:
								g.setNombre("Introducción");
								break;
							default:
								break;
						}
						break;//Fin modulo 1
					case 1:
						switch (valoresRecibidos.getInt("temaT")){
							case 0:
								g.setNombre("Instalación");
								break;
							case 1:
								g.setNombre("Instalar SDK");
								break;
							case 2:
								g.setNombre("Configurar Eclipse");
								break;
							case 3:
								g.setNombre("Crear un emulador");
								break;
							case 4:
								g.setNombre("Crear un AVD");
								break;
							case 5:
								g.setNombre("Configurar dispositivo real");
								break;
							default:
								break;
						}

						break;//Fin modulo 2
					case 2:
						switch (valoresRecibidos.getInt("temaT")){
							case 0:
								g.setNombre("Compilación de codigo");
								break;
							case 1:
								g.setNombre("Crear proyecto");
								break;
							case 2:
								g.setNombre("Arquitectura de la App");
								break;
							case 3:
								g.setNombre("Actividad Principal");
								break;
							case 4:
								g.setNombre("Interface Nativa");
								break;
							case 5:
								g.setNombre("Biblioteca Nativa");
								break;
							case 6:
								g.setNombre("Conversión de matriz");
								break;
							case 7:
								g.setNombre("Compilación de Biblioteca");
								break;
							case 8:
								g.setNombre("Controladores");
								break;
							default:
								break;
						}

						break; //fin modulo 3
					case 3:
						switch (valoresRecibidos.getInt("temaT")){
							case 0:
								g.setNombre("Dispositivos moviles");
								break;
							case 1:
								g.setNombre("Open GL");
								break;
							case 2:
								g.setNombre("Crear el proyecto");
								break;
							case 3:
								g.setNombre("Actividad Principal java");
								break;
							case 4:
								g.setNombre("Superficie vista");
								break;
							case 5:
								g.setNombre("Tema GL");
								break;
							case 6:
								g.setNombre("Open GL nativo");
								break;
							default:
								break;
						}

						break; //FIN MODULO 4
					case 4:
						switch (valoresRecibidos.getInt("temaT")){
							case 0:
								g.setNombre("Open GL 2.0");
								break;
							case 1:
								g.setNombre("Shaders");
								break;
							case 2:
								g.setNombre("GSLS");
								break;
							case 3:
								g.setNombre("Fragmento sombreado");
								break;
							case 4:
								g.setNombre("Anatomia de un shader");
								break;
							case 5:
								g.setNombre("Crear programa sombreado");
								break;
							case 6:
								g.setNombre("Carga del sahder");
								break;
							case 7:
								g.setNombre("Programa de validacion");
								break;
							case 8:
								g.setNombre("Manifest");

								break;
							default:
								break;
						}

						break; //fin modulo 5
					default:
						break;
				}

				g.setSigla("Android Games");
				g.setVotos(10);
				db.insertResult(g);

				break;
			//case 3:t.setText("Muy bien asi continua");
				//break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
}
