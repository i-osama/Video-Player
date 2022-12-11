package com.zeeshan_s.myvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import com.halilibo.bvpkotlin.BetterVideoPlayer;

import java.util.ArrayList;
import java.util.List;

public class VideoThumbnailClicked extends AppCompatActivity {

    Intent intent;
    Uri uri;
//    VideoView videoView;
    BetterVideoPlayer videoView;
    List<Video> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_thumbnail_clicked);

        intent = getIntent();
        uri = Uri.parse(intent.getStringExtra("uri"));
//        videoList = new ArrayList<>();
//        videoList = (ArrayList<Video>) intent.getSerializableExtra("serial");
//        Log.i("All", "onCreate: "+ videoList);

        videoView = findViewById(R.id.selectedVideo);
        if (uri != null){
//            videoView.setVideoURI(uri);
//            videoView.start();
            videoView.setSource(uri);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }
}