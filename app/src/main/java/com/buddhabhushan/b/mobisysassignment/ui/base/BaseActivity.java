package com.buddhabhushan.b.mobisysassignment.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buddhabhushan.b.mobisysassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Buddhabhushan on 16-Sep-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.base_activity_container)
    RelativeLayout baseActivityContainer;
    @BindView(R.id.base_activity_content)
    FrameLayout baseActivityContent;
    @BindView(R.id.toolbar_activity_base)
    Toolbar toolbarActivityBase;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        init();
    }

    @LayoutRes
    protected abstract int getLayout();

    protected abstract void init();

    @Override
    public void setContentView(int layoutResID) {
        baseActivityContainer = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        baseActivityContent = (FrameLayout) baseActivityContainer.findViewById(R.id.base_activity_content);
        getLayoutInflater().inflate(layoutResID, baseActivityContent, true);
        super.setContentView(baseActivityContainer);
        ButterKnife.bind(this);

        setSupportActionBar(toolbarActivityBase);

        getSupportActionBar().setHomeButtonEnabled(true);
    }

    protected void setToolbarTitle(String title) {
        toolbarTitle.setText(title);
    }

    protected void setToolbarTitle(@StringRes int title) {
        toolbarTitle.setText(getText(title));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getLayout() == R.layout.activity_main) {
            getMenuInflater().inflate(R.menu.menu, menu);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
