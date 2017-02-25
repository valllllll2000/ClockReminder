package com.vaxapp.clockreminder.presentation.add;

import com.vaxapp.domain.entity.Reminder;
import com.vaxapp.domain.interactor.SaveReminder;
import com.vaxapp.domain.interactor.UseCase;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import rx.Subscriber;

public class AddReminderPresenter {

    private final UseCase saveUserPreferences;

    @Inject
    public AddReminderPresenter(@Named("saveUserPref") UseCase saveUserPreferences) {
        this.saveUserPreferences = saveUserPreferences;
    }

    public void saveSettings(int hour, int minute, String url, boolean notify) {
        Map<String, Object> params = new HashMap<>(2);
        params.put(SaveReminder.REMINDER_KEY, new Reminder(hour, minute, url, notify));
        saveUserPreferences.execute(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        }, params);
    }
}
