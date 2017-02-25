package com.vaxapp.clockreminder.presentation.add;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.vaxapp.clockreminder.R;
import com.vaxapp.clockreminder.injector.component.DaggerUserComponent;
import com.vaxapp.clockreminder.injector.component.UserComponent;
import com.vaxapp.clockreminder.presentation.BaseActivity;
import com.vaxapp.clockreminder.presentation.NotificationHelper;
import javax.inject.Inject;

public class AddReminderActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.prefUrlEdit)
    EditText editText;

    @Bind(R.id.prefTimePicker)
    TimePicker timePicker;

    @Bind(R.id.checkBox)
    CheckBox checkBox;

    @Inject
    NotificationHelper notificationHelper;

    @Inject
    AddReminderPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        setupActionBar();
        initializeInjector();
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initializeInjector() {
        UserComponent userComponent = DaggerUserComponent.builder()
                                                         .applicationComponent(getApplicationComponent())
                                                         .activityModule(getActivityModule())
                                                         .build();
        userComponent.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.menu_item_save) {
            //TODO: save prefs
            int hour = timePicker.getCurrentHour();
            int minute = timePicker.getCurrentMinute();
            String url = editText.getText().toString();
            boolean notify = checkBox.isChecked();
            presenter.saveSettings(hour, minute, url, notify);
            if (notify) {
                notificationHelper.scheduleNotification(hour, minute);
            } else {
                notificationHelper.cancelAllNotifications();
            }
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
