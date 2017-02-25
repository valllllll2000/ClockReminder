package com.vaxapp.clockreminder.presentation.reminders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.vaxapp.clockreminder.R;
import com.vaxapp.clockreminder.presentation.BaseActivity;
import com.vaxapp.clockreminder.presentation.add.AddReminderActivity;

public class RemindersListActivity extends BaseActivity implements RemindersListView {

    @Bind(R.id.reminder_rv)
    RecyclerView reminderRv;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpToolBar();
    }

    private void setUpToolBar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_item_add) {
            startActivity(new Intent(this, AddReminderActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
