package com.vaxapp.domain.interactor;

import com.vaxapp.domain.entity.Reminder;
import com.vaxapp.domain.executor.PostExecutionThread;
import com.vaxapp.domain.executor.ThreadExecutor;
import com.vaxapp.domain.repository.UserRepository;
import java.util.Map;
import javax.inject.Inject;
import rx.Observable;

public class SaveReminder extends UseCase {

    public static final String REMINDER_KEY = "notification_enabled_key";
    private final UserRepository photoRepository;

    @Inject
    public SaveReminder(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                        UserRepository photoRepository) {
        super(threadExecutor, postExecutionThread);
        this.photoRepository = photoRepository;
    }

    @Override
    protected <T> Observable buildUseCaseObservable(Map<String, T> parameters) {
        if (parameters == null || parameters.get(REMINDER_KEY) == null) {
            return Observable.error(new IllegalArgumentException("Missing params"));
        }
        return photoRepository.saveUserPreference((Reminder) parameters.get(REMINDER_KEY));
    }
}
