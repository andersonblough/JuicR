package com.andersonblough.juicr.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;

import com.andersonblough.juicr.R;
import com.andersonblough.juicr.adapter.JuiceAdapter;

import butterknife.BindView;

/**
 * Created by andersonblough on 11/30/16.
 */

public class EditActivity extends BaseActivity {

    private static final float MIN_SCALE = 0.75f;
    public static final String JUICE_ID = "juice_id";

    @BindView(R.id.juice_picker)
    ViewPager juicePicker;

    private JuiceAdapter juiceAdapter;
    private long juiceId;

    @Override
    int layoutResId() {
        return R.layout.activity_edit;
    }

    @Override
    int menuResId() {
        return R.menu.edit;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() != null) {
            juiceId = getIntent().getLongExtra(JUICE_ID, 0);
        }
        init();
        int padding = (getResources().getDisplayMetrics().widthPixels - getResources().getDimensionPixelOffset(R.dimen.juice_icon_size)) / 2;
        juiceAdapter = new JuiceAdapter(this);
        juiceAdapter.setSelector(new JuiceAdapter.JuiceSelector() {
            @Override
            public void onJuiceSelected(int position) {
                juicePicker.setCurrentItem(position, true);
            }
        });
        juicePicker.setAdapter(juiceAdapter);
        juicePicker.setPaddingRelative(padding, 0, padding, 0);
        juicePicker.setOffscreenPageLimit(juiceAdapter.getCount() / 2);
        juicePicker.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                position -= (juicePicker.getPaddingRight() / (float) page.getWidth());
                if (position >= -3 && position <= 3) {
                    page.setScaleX(Math.max(1f - Math.abs(position / 3f), MIN_SCALE));
                    page.setScaleY(Math.max(1f - Math.abs(position / 3f), MIN_SCALE));
                } else {
                    page.setScaleX(MIN_SCALE);
                    page.setScaleY(MIN_SCALE);
                }
            }
        });
        juicePicker.setCurrentItem(juiceAdapter.getCount() / 2);
    }

    private void init() {
        setTitle(juiceId == 0 ? "ADD JUICE" : "EDIT JUICE");
    }
}
