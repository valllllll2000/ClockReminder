package com.vaxapp.clockreminder.injector.component;

import android.content.Context;
import com.vaxapp.clockreminder.App;
import com.vaxapp.clockreminder.injector.module.ApplicationModule;
import com.vaxapp.clockreminder.presentation.BaseActivity;
import com.vaxapp.domain.executor.PostExecutionThread;
import com.vaxapp.domain.executor.ThreadExecutor;
import com.vaxapp.domain.repository.UserRepository;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    ApplicationModule.class
})
public interface ApplicationComponent {

    void inject(App app);

    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

    UserRepository userRepository();
}
