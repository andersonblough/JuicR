package com.andersonblough.juicr.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.andersonblough.juicr.JuiceListAdapter;
import com.andersonblough.juicr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andersonblough on 11/22/16.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.juice_list)
    RecyclerView juiceList;

    private JuiceListAdapter juiceListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        juiceListAdapter = new JuiceListAdapter();
        juiceList.setAdapter(juiceListAdapter);
    }

    @Override
    int layoutResId() {
        return R.layout.activity_main;
    }

    @Override
    int menuResId() {
        return R.menu.main;
    }
}
