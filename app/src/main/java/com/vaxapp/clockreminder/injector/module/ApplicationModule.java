package com.vaxapp.clockreminder.injector.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.GsonBuilder;
import com.vaxapp.clockreminder.App;
import com.vaxapp.clockreminder.thread.UIThread;
import com.vaxapp.data.entity.GsonMapper;
import com.vaxapp.data.executor.JobExecutor;
import com.vaxapp.data.repository.UserDataRepository;
import com.vaxapp.domain.executor.PostExecutionThread;
import com.vaxapp.domain.executor.ThreadExecutor;
import com.vaxapp.domain.repository.UserRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private static final String PREF_FILENAME = "preferences";

    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    UserRepository providePhotoRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(PREF_FILENAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    GsonMapper provideMapper() {
        return new GsonMapper(new GsonBuilder().create());
    }

}
