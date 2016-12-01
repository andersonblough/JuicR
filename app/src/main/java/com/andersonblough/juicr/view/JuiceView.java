package com.andersonblough.juicr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.andersonblough.juicr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andersonblough on 11/29/16.
 */

public class JuiceView extends FrameLayout {

    @BindView(R.id.color)
    ImageView fillColor;

    public JuiceView(Context context) {
        this(context, null);
    }

    public JuiceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JuiceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.juice_layout, this);
        ButterKnife.bind(this);
    }

    public void setColor(int color) {
        fillColor.setColorFilter(color);
    }
}
