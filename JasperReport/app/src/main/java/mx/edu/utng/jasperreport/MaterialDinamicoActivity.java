package mx.edu.utng.jasperreport;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Erick on 17/04/2016.
 */
public class MaterialDinamicoActivity extends Activity {

    final String url = "http://www.jaspersoft.com/olp/using-jaspersoft-bi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_dinamico);
        WebView myWebView = (WebView) this.findViewById(R.id.wbv_material);
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl(url);//Pasamos la url
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
