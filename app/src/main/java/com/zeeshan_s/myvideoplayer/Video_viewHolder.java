package com.zeeshan_s.myvideoplayer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Video_viewHolder  extends RecyclerView.ViewHolder {
    ImageView thumbnail_img;
    TextView videoName;
    public Video_viewHolder(@NonNull View itemView) {
        super(itemView);
        thumbnail_img = itemView.findViewById(R.id.thumbnailImg);
        videoName = itemView.findViewById(R.id.videoName);
    }
}
