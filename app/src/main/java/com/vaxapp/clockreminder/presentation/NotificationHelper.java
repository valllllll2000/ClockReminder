package com.vaxapp.clockreminder.presentation;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.vaxapp.clockreminder.service.NotificationService;
import java.util.Calendar;
import javax.inject.Inject;

import static android.content.Context.ALARM_SERVICE;

public class NotificationHelper {

    private final Context context;

    @Inject
    public NotificationHelper(Context context) {
        this.context = context;
    }

    public void cancelAllNotifications() {
        Intent intent = new Intent(context, NotificationService.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent =
            PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
    }

    public void scheduleNotification(int hour, int minute) {
        Intent intent = new Intent(context, NotificationService.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent =
            PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 00);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,
                                  pendingIntent);
    }
}
