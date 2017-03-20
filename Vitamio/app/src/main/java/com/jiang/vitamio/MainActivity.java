package com.jiang.vitamio;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private String path="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);
        videoView= (VideoView) findViewById(R.id.vitamio);
        if (path==""){
            Toast.makeText(this, "网址不正确", Toast.LENGTH_SHORT).show();
        }else {
            videoView.setVideoURI(Uri.parse(path));
            videoView.setMediaController(new MediaController(this));
        }
    }
}
