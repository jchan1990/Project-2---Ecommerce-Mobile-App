package com.example.qube.project2simpleshop.easteregg;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qube.project2simpleshop.R;

import java.io.IOException;

/**
 * Created by Qube on 8/23/16.
 */
public class ChocoboMediaPlayer {
    //My easter egg class that I'll be using throughout the all the activities

    private static ChocoboMediaPlayer instance;

    public ChocoboMediaPlayer(Context applicationContext) {
    }

    // getInstance helper method
    public static ChocoboMediaPlayer getInstance(Context context) {
        if (instance == null) {
            instance = new ChocoboMediaPlayer(context.getApplicationContext());
        }
        return instance;
    }

    //This should play a sound :D LET'S CROSS OUR FINGERS :D
    public void ChocoboCaller(final Context context, View view) {
        final MediaPlayer mp = new MediaPlayer();
        ImageView imageViewChocobo = (ImageView) view.findViewById(R.id.iv_chocobo_caller);

        imageViewChocobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Hmmm... I hear a chocobo nearby", Toast.LENGTH_SHORT).show();
                if (mp.isPlaying()) {
                    mp.stop();
                }
                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = context.getAssets().openFd("ChocoboCall.mp3");
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
