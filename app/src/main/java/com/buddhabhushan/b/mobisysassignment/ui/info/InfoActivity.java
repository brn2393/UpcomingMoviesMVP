package com.buddhabhushan.b.mobisysassignment.ui.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.buddhabhushan.b.mobisysassignment.R;
import com.buddhabhushan.b.mobisysassignment.ui.base.BaseActivity;

/**
 * Created by B on 18-09-2017.
 */

public class InfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_info;
    }

    @Override
    protected void init() {
        setToolbarTitle(R.string.title_activity_info);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
