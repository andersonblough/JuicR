package com.andersonblough.juicr.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andersonblough.juicr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andersonblough on 11/24/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.title)
    TextView title;

    @Nullable
    @BindView(R.id.icon)
    ImageView icon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId());
        ButterKnife.bind(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuResId() != 0) {
            getMenuInflater().inflate(menuResId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    abstract int layoutResId();

    abstract int menuResId();

    public void setTitle(String title) {
        this.title.setVisibility(View.VISIBLE);
        this.title.setText(title);
        this.icon.setVisibility(View.GONE);
    }

    public void setIcon(int resId) {
        this.title.setVisibility(View.GONE);
        this.icon.setImageResource(resId);
        this.icon.setVisibility(View.VISIBLE);
    }

}
