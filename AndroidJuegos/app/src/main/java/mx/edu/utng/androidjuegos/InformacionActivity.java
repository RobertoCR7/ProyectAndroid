package mx.edu.utng.androidjuegos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */
public class InformacionActivity extends Activity {
    private Button btnRef1;
    private Button btnRef2;
    private Button btnRef3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mas_info);
        btnRef1=(Button)findViewById(R.id.ref1);
        btnRef2=(Button)findViewById(R.id.ref2);
        btnRef3=(Button)findViewById(R.id.ref3);


        btnRef1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String url = "https://it-ebooks24.com/ebook/beginning-android-4-games-development";
                Intent i = new Intent(InformacionActivity.this, Gato.class);
              //  i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btnRef2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String url="http://www.kilobolt.com/game-development-tutorial.html";
                Intent i = new Intent(InformacionActivity.this, MainMenuActivity.class);
               // i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btnRef3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.suntimebox.com/android-game-programming-tutorials/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
    }

