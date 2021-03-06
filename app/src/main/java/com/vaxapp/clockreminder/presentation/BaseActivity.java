package com.vaxapp.clockreminder.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.vaxapp.clockreminder.App;
import com.vaxapp.clockreminder.injector.component.ApplicationComponent;
import com.vaxapp.clockreminder.injector.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }


    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}

