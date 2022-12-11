package com.zeeshan_s.myvideoplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;

public class VideoAdapterView extends RecyclerView.Adapter<Video_viewHolder> {
    Context context;
    List<Video> videoList;

    public VideoAdapterView(Context context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public Video_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_recycler, parent, false);
        return new Video_viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Video_viewHolder holder, int position) {
        Video video = videoList.get(position);

//       --------------------------;
//        holder.thumbnail_img.setImageBitmap(getThumbVideo(context, video.getVideoUri()));
//        holder.thumbnail_img.setImageBitmap(video.getThumbBitmap());
        holder.videoName.setText(video.getVideoName());

//        _____________--- New approach 2---________________
        Glide.with(context).asBitmap().load(videoList.get(position).getVideoUri()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_launcher_foreground).centerCrop())
                .into(holder.thumbnail_img);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, VideoThumbnailClicked.class);
            String uri = video.getVideoUri().toString();
            intent.putExtra("uri", uri);
//            intent.putSerializeable("serial", video);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

//------------ Taking Video thumbnail -------------
    public Bitmap getThumbVideo(Context context, Uri videoUri) {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, videoUri);
            bitmap = mediaMetadataRetriever.getFrameAtTime(1000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }
}
