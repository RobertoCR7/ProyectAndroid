package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.AplicacionXML.resultquiz.DBHelperQuizUnoResultado;
import mx.edu.utng.AplicacionXML.resultquiz.Result;


/**
 * Created by Roberto on 06/02/2016.
 */

public class ResultActivity extends Activity {
	DBHelperQuizUnoResultado helper = new DBHelperQuizUnoResultado(this);
	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);


//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
//get score
		Result re = new Result();
		Bundle valoresRecibidos = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
		int score= valoresRecibidos.getInt("score");
		re.setResult(score);
		helper.insertResult(re);
		Toast resul = Toast.makeText(ResultActivity.this, "Resultado Guardado " + score, Toast.LENGTH_SHORT);
		resul.show();

//display score
		bar.setRating(score);
		switch (score)//calif estrellas
		{
			case 0:t.setText("Mal intentalo denuevo por favor");
				break;
			case 1:t.setText("Intentalo denuevo por favor");
				break;
			case 2: t.setText("Muy bien has pasado al siguiente subtema");

				switch (valoresRecibidos.getInt("modulo")){
					case 0:// solo temas pontus temas sin agragar otro switch
						switch (valoresRecibidos.getInt("tema")){
							case 0://Subtemasss-----------chekalo we  tu nadmas pon tus temas
								g.setNombre("Introduccion XML");
								g.setSigla("1");
								break;
							default:
								break;
						}
						break;//Fin modulo 1
					case 1:
						switch (valoresRecibidos.getInt("tema")){
							case 0:
								g.setNombre("XML es un metalenguage");
								g.setSigla("2");
								break;
							case 1:
								g.setNombre("XML en el mundo real");
								g.setSigla("2");

								break;
							case 2:
								g.setNombre("Términos en XML");
								g.setSigla("2");
								break;
							case 3:
								g.setNombre("Diferencias entre una BBDD y XML");
								g.setSigla("2");
								break;
							case 4:
								g.setNombre("Caracteres no permitidos");
								g.setSigla("2");
								break;
							default:
								break;
						}

						break;//Fin modulo 2
					case 2:
						switch (valoresRecibidos.getInt("tema")){
							case 0:
								g.setNombre("Tecnologías para trabajar con XMLv");
								g.setSigla("3");
								break;
							case 1:
								g.setNombre("Simple API for XML");
								g.setSigla("3");
								break;
							case 2:
								g.setNombre("Simple API for XML Inconvenientes");
								g.setSigla("3");
								break;
							case 3:
								g.setNombre("XML Binding");
								g.setSigla("3");
								break;
							case 4:
								g.setNombre("Serializadores de Binding XML - JAXB");
								g.setSigla("3");
								break;
							case 5:
								g.setNombre("eXtensible Stylesheet Language");
								g.setSigla("3");
								break;
							case 6:
								g.setNombre("XPath");
								g.setSigla("3");
								break;
							case 7:
								g.setNombre("XQuery");
								g.setSigla("3");
								break;
							default:
								break;
						}

						break; //fin modulo 3
					case 3:
						switch (valoresRecibidos.getInt("tema")){
							case 0:
								g.setNombre("Esquemas XML");
								g.setSigla("4");
								break;
							case 1:
								g.setNombre("XML Schema Lenguajes de Esquemas");
								g.setSigla("4");

								break;
							case 2:
								g.setNombre("XML Schema Objetivos de Diseño");
								g.setSigla("4");

								break;
							case 3:
								g.setNombre("Características de los XML Schemas");
								g.setSigla("4");

								break;
							case 4:
								g.setNombre("Cuerpo: Instrucciones de proceso");
								g.setSigla("4");
								break;
							case 5:
								g.setNombre("XML Schema: Definir un elemento simple");
								g.setSigla("4");
								break;
							case 6:
								g.setNombre("XML Schema: Definir un atributo");
								g.setSigla("4");
								break;
							default:
								break;
						}

						break; //FIN MODULO 4
					case 4:
						switch (valoresRecibidos.getInt("tema")){
							case 0:
								g.setNombre("1.-Practiaca de codigo");
								g.setSigla("5");

								break;
							case 1:
								g.setNombre("2.-Practiaca de codigo");
								g.setSigla("5");
								break;
							case 2:
								g.setNombre("3.-Practiaca de codigo");
								g.setSigla("5");

								break;
							case 3:
								g.setNombre("4.-Practiaca de codigo");
								g.setSigla("5");
								break;
							case 4:
								g.setNombre("5.-Practiaca de codigo");
								g.setSigla("5");
								break;
							case 5:
								g.setNombre("6.-Examen Final");
								g.setSigla("5");
								break;
							default:
								break;
						}
						break; //fin modulo 5
					default:
						break;
				}


				g.setVotos(10);
				db.insertResult(g);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
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
