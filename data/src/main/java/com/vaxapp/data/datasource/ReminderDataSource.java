package com.vaxapp.data.datasource;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import com.vaxapp.data.entity.GsonMapper;
import com.vaxapp.domain.entity.Reminder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class ReminderDataSource {

    private static final String PREFERENCE = "reminder";
    private SharedPreferences sharedPrefs;
    private final GsonMapper gsonMapper;

    @Inject
    public ReminderDataSource(SharedPreferences preferences, GsonMapper gsonMapper) {
        this.sharedPrefs = preferences;
        this.gsonMapper = gsonMapper;
    }

    public Observable<List<Reminder>> getUserPreference() {
        List<Reminder> reminders = new ArrayList<>();
        Reminder reminder = getReminder();
        if (reminder != null) {
            reminders.add(reminder);
        }
        return Observable.just(reminders);
    }

    @Nullable
    private Reminder getReminder() {
        return gsonMapper.read(sharedPrefs.getString(PREFERENCE, null), Reminder.class);
    }

    public Observable<Boolean> saveUserPreference(Reminder reminder) {
        sharedPrefs.edit().putString(PREFERENCE, gsonMapper.write(reminder, Reminder.class)).apply();
        return Observable.just(true);
    }
}
