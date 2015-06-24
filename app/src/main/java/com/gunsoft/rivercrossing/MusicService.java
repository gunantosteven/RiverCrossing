package com.gunsoft.rivercrossing;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by gunanto on 24/06/15.
 */
public class MusicService extends Service{

    private static MediaPlayer mp;

    public static void setMp(MediaPlayer mp) {
        MusicService.mp = mp;
    }

    public static MediaPlayer getMp() {
        return mp;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    public void onCreate()
    {
        try
        {
            mp = MediaPlayer.create(this, R.raw.groovy);
            mp.setLooping(true);
        }
        catch(Exception ex)
        {

        }
    }
    public void onDestroy()
    {
        mp.stop();
    }

    public int onStartCommand(Intent intent, int flags, int startId){

        Log.d("Start Music", "On start");
        mp.start();

        return 1;
    }

    public void onStop(){
        mp.stop();
        mp.release();
    }

    public void onPause(){
        mp.stop();
        mp.release();
    }
}
