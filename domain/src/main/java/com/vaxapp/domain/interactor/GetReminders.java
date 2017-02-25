package com.vaxapp.domain.interactor;

import com.vaxapp.domain.executor.PostExecutionThread;
import com.vaxapp.domain.executor.ThreadExecutor;
import com.vaxapp.domain.repository.UserRepository;
import java.util.Map;
import javax.inject.Inject;
import rx.Observable;

public class GetReminders extends UseCase {

    private final UserRepository photoRepository;

    @Inject
    public GetReminders(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                        UserRepository photoRepository) {
        super(threadExecutor, postExecutionThread);
        this.photoRepository = photoRepository;
    }

    @Override
    protected <T> Observable buildUseCaseObservable(Map<String, T> parameters) {
        return photoRepository.getUserPreference();
    }
}
