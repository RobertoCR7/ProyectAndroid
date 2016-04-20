package mx.edu.utng.AplicacionXML;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Roberto on 26/01/2016.
 */
public class IntroduccionActivity extends Activity{
    private Button btnMas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduccion_layout);
        btnMas=(Button) findViewById(R.id.btn_mas);
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroduccionActivity.this, LoginActivity.class));
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_menu_ayuda_sugerencia:
                startActivity(new Intent(IntroduccionActivity.this, ListaPrincipalActividad.class));
                break;
            case R.id.itm_salir:
                itmSalida();
                break;

            case R.id.itm_ayuda:
                startActivity(new Intent(IntroduccionActivity.this, AyudaActividad.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    private void itmSalida(){
        finish();
        Intent intent1=new Intent(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_HOME);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }


}
