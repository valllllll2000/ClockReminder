package com.vaxapp.data.repository;

import com.vaxapp.data.datasource.ReminderDataSource;
import com.vaxapp.domain.entity.Reminder;
import com.vaxapp.domain.repository.UserRepository;
import javax.inject.Inject;
import rx.Observable;

public class UserDataRepository implements UserRepository {

    private final ReminderDataSource reminderDataSource;

    @Inject
    public UserDataRepository(ReminderDataSource reminderDataSource) {
        this.reminderDataSource = reminderDataSource;
    }

    @Override
    public Observable<Reminder> getUserPreference() {
        return reminderDataSource.getUserPreference();
    }

    @Override
    public Observable<Boolean> saveUserPreference(Reminder reminder) {
        return reminderDataSource.saveUserPreference(reminder);
    }
}
