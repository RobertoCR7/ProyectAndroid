package mx.edu.utng.ctutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Enrique on 09/02/2016.
 */
public class Seleccion extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView txvListaTituloD;
    private ListView lsvContenidoListaD;
    private String[] contenidoLista;
    private Bundle valoresResividosSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu_activity_layout);
        initComponents();
    }
    private void initComponents(){
        txvListaTituloD= (TextView) findViewById(R.id.txv_titulo_lista_d);
        lsvContenidoListaD= (ListView) findViewById(R.id.lsv_contenido_lista_d);

        valoresResividosSel=getIntent().getExtras();


        txvListaTituloD.setText(valoresResividosSel.getString("elegido"));

        switch (valoresResividosSel.getInt("posicion")){
            case 0:

                contenidoLista=getResources().getStringArray(R.array.introduction);

                break;
            case 1:

                contenidoLista=getResources().getStringArray(R.array.number1);

                break;
            case 2:
                contenidoLista=getResources().getStringArray(R.array.number2);

                break;
            case 3:
                contenidoLista=getResources().getStringArray(R.array.number3);

                break;
            case 4:
                contenidoLista=getResources().getStringArray(R.array.number4);

                break;
            case 5:
                contenidoLista=getResources().getStringArray(R.array.number5);

                break;
            case 6:
                contenidoLista=getResources().getStringArray(R.array.number6);
                break;
            default:
                break;
        }

        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.item_submenu_layout,R.id.txv_item_menu_d,contenidoLista);
        lsvContenidoListaD.setAdapter(adapter);
        lsvContenidoListaD.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle valoresEnviadosS=new Bundle();
        valoresEnviadosS.putString("moduloElegidoNombre", valoresResividosSel.getString("elegido"));
        valoresEnviadosS.putInt("moduloElegidoPosision", valoresResividosSel.getInt("posicion"));
        valoresEnviadosS.putString("nombreTema", contenidoLista[position]);
        valoresEnviadosS.putInt("posisionTema", position);

        switch (valoresResividosSel.getInt("posicion")){
            case 0:
                switch (position){
                    case 0:
                        break;
                    default:
                        startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            case 1:
                switch (position){
                    case 5:
                        valoresEnviadosS.putInt("idQuiz", 20);
                        startActivity(new Intent(this, QuizActivity.class).putExtras(valoresEnviadosS));
                        break;
                    default:
                        startActivity(new Intent(this, ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            case 2:
                switch (position){
                    case 3:
                        valoresEnviadosS.putInt("idQuiz",21);
                        startActivity(new Intent(this,QuizActivity.class).putExtras(valoresEnviadosS));
                        break;
                    default:
                        startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            case 3:
                switch (position){
                    case 6:
                        valoresEnviadosS.putInt("idQuiz",22);
                        startActivity(new Intent(this,QuizActivity.class).putExtras(valoresEnviadosS));
                        break;
                    default:
                        startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            case 4:
                switch (position){
                    case 4:
                        valoresEnviadosS.putInt("idQuiz",23);
                        startActivity(new Intent(this,QuizActivity.class).putExtras(valoresEnviadosS));
                        break;
                    default:
                        startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            case 5:
                switch (position){
                    case 5:
                        valoresEnviadosS.putInt("idQuiz",24);
                        startActivity(new Intent(this,QuizActivity.class).putExtras(valoresEnviadosS));
                        break;
                    default:
                        startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            case 6:
                switch (position){
                    case 5:
                        valoresEnviadosS.putInt("idQuiz",25);
                        startActivity(new Intent(this,QuizActivity.class).putExtras(valoresEnviadosS));
                        break;
                    default:
                        startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                        break;
                }
                break;
            default:
                startActivity(new Intent(this,ContenidoTema.class).putExtras(valoresEnviadosS));
                break;
        }
    }
}
