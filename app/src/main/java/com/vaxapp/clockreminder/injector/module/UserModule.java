package com.vaxapp.clockreminder.injector.module;

import com.vaxapp.clockreminder.injector.PerActivity;
import com.vaxapp.domain.interactor.GetReminders;
import com.vaxapp.domain.interactor.SaveReminder;
import com.vaxapp.domain.interactor.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class UserModule {

    @Provides
    @PerActivity
    @Named("getReminders")
    UseCase provideGetPhotosUseCase(GetReminders getReminders) {
        return getReminders;
    }

    @Provides
    @PerActivity
    @Named("saveReminder")
    UseCase provideSetPhotosUseCase(SaveReminder saveReminder) {
        return saveReminder;
    }


}
