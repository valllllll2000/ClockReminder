package com.vaxapp.clockreminder.injector.component;

import com.vaxapp.clockreminder.presentation.reminders.RemindersListActivity;
import com.vaxapp.clockreminder.injector.PerActivity;
import com.vaxapp.clockreminder.injector.module.ActivityModule;
import com.vaxapp.clockreminder.injector.module.UserModule;
import com.vaxapp.clockreminder.presentation.add.AddReminderActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent {

    void inject(RemindersListActivity remindersListActivity);

    void inject(AddReminderActivity addReminderActivity);
}
