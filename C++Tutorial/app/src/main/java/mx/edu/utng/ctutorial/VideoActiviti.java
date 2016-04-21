package mx.edu.utng.ctutorial;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Enrique on 02/03/2016.
 */
public class VideoActiviti extends Activity {
    private VideoView videoView;
    private MediaController mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_activity_layout);
        mp= new MediaController(this);
        videoView = (VideoView)findViewById(R.id.video_1);
        Uri path = Uri.parse("android.resource://mx.edu.utng.ctutorial/"+R.raw.video);
        mp.setAnchorView(videoView);
        videoView.setMediaController(mp);
        videoView.setVideoURI(path);
        videoView.start();
    }
}
