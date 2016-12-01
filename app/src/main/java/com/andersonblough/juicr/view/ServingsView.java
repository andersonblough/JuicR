package com.andersonblough.juicr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.andersonblough.juicr.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by andersonblough on 11/25/16.
 */

public class ServingsView extends LinearLayout {

    public ServingsView(Context context) {
        this(context, null);
    }

    public ServingsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ServingsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.servings_view, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.remove)
    public void remove() {

    }

    @OnClick(R.id.add)
    public void add() {

    }
}
