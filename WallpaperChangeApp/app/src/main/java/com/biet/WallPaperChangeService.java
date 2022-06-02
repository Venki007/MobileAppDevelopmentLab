package com.biet;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class WallPaperChangeService extends Service {
    Timer timer;
    int intervalInSec = 10;
    int numberOfImages = 3;
    int interval= 1000 * intervalInSec;
    Drawable drawable;
    List<Integer> imageIdList;
    WallpaperManager wpm;

    public WallPaperChangeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer =new Timer();
        wpm=WallpaperManager.getInstance(WallPaperChangeService.this);
        imageIdList = new ArrayList<>();
        imageIdList.add(R.drawable.one);
        imageIdList.add(R.drawable.two);
        imageIdList.add(R.drawable.three);
    }

    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                drawable = getResources().getDrawable(imageIdList.get(getRandomNumber(1,numberOfImages)-1));
                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0, interval);

        return super.onStartCommand(intent, flags, startId);
    }
}