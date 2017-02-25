package com.vaxapp.clockreminder.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import com.vaxapp.clockreminder.R;
import com.vaxapp.clockreminder.presentation.reminders.RemindersListActivity;

public class NotificationService extends Service {

    private static final int NOTIFICATION_ID = 123;
    /**
     * Waits for 25ms, vibrate for 150 ms
     **/
    private static final long[] VIBRATION_PATTERN = {30, 150, 30, 150};

    private static final int LIGHT_ON_DURATION_MS = 250;
    private static final int LIGHT_OFF_DURATION_MS = 2500;

    @Override
    public IBinder onBind(Intent intent) {
        return null; //no binding
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this, RemindersListActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        //TODO: add free sound
        NotificationCompat.Builder notificationBuilder =
            new NotificationCompat.Builder(this).setContentTitle(getText(R.string.notification_title))
                                                .setContentText(getText(R.string.notification_message))
                                                .setSmallIcon(R.drawable.ic_notification)
                                                .setContentIntent(pendingIntent)
                                                .setTicker(getText(R.string.notification_message))
                                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                                .setVibrate(VIBRATION_PATTERN)
                                                .setLights(Color.RED, LIGHT_ON_DURATION_MS, LIGHT_OFF_DURATION_MS)
                                                .setAutoCancel(true);

        NotificationManager notificationManager =
            (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

        // If we get killed, after returning from here, restart
        return START_NOT_STICKY;
    }
}
