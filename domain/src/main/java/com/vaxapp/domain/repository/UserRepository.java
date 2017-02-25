package com.vaxapp.domain.repository;

import com.vaxapp.domain.entity.Reminder;
import rx.Observable;

public interface UserRepository {

    Observable<Reminder> getUserPreference();

    Observable<Boolean> saveUserPreference(Reminder reminder);
}
