package com.vaxapp.clockreminder;

import android.app.Application;
import com.vaxapp.clockreminder.injector.component.ApplicationComponent;
import com.vaxapp.clockreminder.injector.component.DaggerApplicationComponent;
import com.vaxapp.clockreminder.injector.module.ApplicationModule;

public class App extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent =
            DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        this.applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
