package utng.edu.utng.html5apli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by kevin on 17/04/2016.
 */
public class AprendiendoActivity  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.aprendiendo_layout);

        WebView myWebView = (WebView) this.findViewById(R.id.wbv_material);
        myWebView.loadUrl("https://www.codecademy.com/es/tracks/html-css-traduccion-al-espanol-america-latina-clone");

    }

}
