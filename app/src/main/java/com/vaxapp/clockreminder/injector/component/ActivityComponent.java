package com.vaxapp.clockreminder.injector.component;

import android.app.Activity;
import com.vaxapp.clockreminder.injector.PerActivity;
import com.vaxapp.clockreminder.injector.module.ActivityModule;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    //Exposed to sub-graphs.
    Activity activity();
}
