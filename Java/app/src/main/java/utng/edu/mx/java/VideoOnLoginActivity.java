package utng.edu.mx.java;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Gustavo on 02/04/2016.
 */
public class VideoOnLoginActivity extends AppCompatActivity {
    private Bundle valoresResividosV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_on_login_layout);
       // setRequestedOrientation();
        initComponents();
    }

    private void initComponents() {
        valoresResividosV=getIntent().getExtras();
        final VideoView vivVideo =(VideoView)findViewById(R.id.viv_video);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vivVideo);
        String strUrl="";
        switch (valoresResividosV.getInt("posicion")){
            case 2:
                strUrl="rtsp://r6---sn-a5m7ln7k.googlevideo.com/Cj0LENy73wIaNAlrlYcXb6yW_xMYDSANFC28TwBXMOCoAUIASARgstvF-bWSh_NWigELTWpsa0ZKcHExRTgM/D6DC46293FB870D801EB8FCFBADEC2126515C0F2.A25A166EFA338EB0D80E7BD4A9637A79D6A0AB91/yt6/1/video.3gp";
                break;
            case 3:
                strUrl="rtsp://r9---sn-a5m7zne6.googlevideo.com/Cj0LENy73wIaNAm6jsIz2sAG_BMYDSANFC25ZQBXMOCoAUIASARgstvF-bWSh_NWigELTWpsa0ZKcHExRTgM/D67BD2A31903A73FE92E07A3E15323FC080008C9.D6C900008D97E7D0D334676DC6F30988D815A799/yt6/1/video.3gp";
                break;
            case 4:
                strUrl="rtsp://r9---sn-a5m7lnez.googlevideo.com/Cj0LENy73wIaNAn2i9xOUnsbcxMYDSANFC2bdwBXMOCoAUIASARgstvF-bWSh_NWigELTWpsa0ZKcHExRTgM/6347A3897A71DC9FF9A835D6DD26D9BE1DC0591F.BFAE1C1D965C46B72AD3020C28D588C586D275A3/yt6/1/video.3gp";
                break;
            case 5:
                strUrl="rtsp://r13---sn-a5m7lnel.googlevideo.com/Cj0LENy73wIaNAmZTaMIE8SB5hMYDSANFC3oegBXMOCoAUIASARgstvF-bWSh_NWigELTWpsa0ZKcHExRTgM/0C85EF1A7E58C7AB979BDA6E5011FF7BBD6176E6.46DDA477A1043579E926F70522AFFCA9A22AE68F/yt6/1/video.3gp";
                break;
            case 6:
                strUrl="rtsp://r18---sn-a5m7zne6.googlevideo.com/Cj0LENy73wIaNAm_kyXmwsVUhhMYDSANFC2WewBXMOCoAUIASARgstvF-bWSh_NWigELTWpsa0ZKcHExRTgM/3C5AC054A5A2CBD7892B2FDBF081C44AA58989DB.18A52CFCE3F090F163108585488F26B51F388633/yt6/1/video.3gp";
                break;
            default:
                break;
        }
        Uri uri=Uri.parse(strUrl);
        vivVideo.setMediaController(mediaController);
        vivVideo.setVideoURI(uri);
        vivVideo.requestFocus();
        vivVideo.start();

    }
}
