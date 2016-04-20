package com.herprogramacion.ajax.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.herprogramacion.ajax.R;

/**
 * Created by Rodrigo Cortes Armas on 17/04/2016.
 */
public class ActividadMaterial extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.fila_lista_material);

        WebView myWebView = (WebView) this.findViewById(R.id.webView);
        myWebView.loadUrl("http://www.um.es/docencia/barzana/DAWEB/Desarrollo-de-aplicaciones-web-AJAX.html");

    }
}
