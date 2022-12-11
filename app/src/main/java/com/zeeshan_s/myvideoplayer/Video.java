package com.zeeshan_s.myvideoplayer;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;

public class Video implements Serializable {
    String videoName;
    Uri videoUri;
    Bitmap thumbBitmap;

    public Video(String videoName, Uri videoUri, Bitmap thumbBitmap) {
        this.videoName = videoName;
        this.videoUri = videoUri;
        this.thumbBitmap = thumbBitmap;
    }

    public Video(String videoName, Uri videoUri) {
        this.videoName = videoName;
        this.videoUri = videoUri;
    }

    public String getVideoName() {
        return videoName;
    }

    public Uri getVideoUri() {
        return videoUri;
    }

    public Bitmap getThumbBitmap() {
        return thumbBitmap;
    }
}
