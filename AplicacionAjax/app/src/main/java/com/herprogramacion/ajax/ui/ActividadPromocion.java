package com.herprogramacion.ajax.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.herprogramacion.ajax.R;

/**
 * Created by Rodrigo Cortes Armas on 19/04/2016.
 */
public class ActividadPromocion extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.fila_lista_material);

        WebView myWebView = (WebView) this.findViewById(R.id.webView);
        myWebView.loadUrl("http://www.utng.edu.mx/");

    }
}
