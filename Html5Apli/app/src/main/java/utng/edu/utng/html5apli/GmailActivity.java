package utng.edu.utng.html5apli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;

/**
 * Created by kevin on 20/04/2016.
 */
public class GmailActivity extends Activity implements View.OnClickListener{
    private ImageButton imgGmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.example_email_layout);
        initComponets();
    }

    private void initComponets() {

        imgGmail=(ImageButton)findViewById(R.id.imv_gmail);
        imgGmail.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.imv_gmail:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/certificado.png")));
                email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.send_enviar));
                email.putExtra(Intent.EXTRA_TEXT , getString(R.string.agradecimiento));
                email.setType("plain/text");

                startActivity(Intent.createChooser(email, ""));


        }
    }
}
