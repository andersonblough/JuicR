package com.andersonblough.juicr.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.andersonblough.juicr.R;
import com.andersonblough.juicr.view.JuiceView;

/**
 * Created by andersonblough on 11/30/16.
 */

public class JuiceAdapter extends PagerAdapter {

    private int[] colors;
    private JuiceSelector selector;

    public interface JuiceSelector {
        void onJuiceSelected(int position);
    }

    public JuiceAdapter(Context context) {
        TypedArray ta = context.getResources().obtainTypedArray(R.array.juice_colors);
        colors = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            colors[i] = ta.getColor(i, 0);
        }
        ta.recycle();
    }

    public void setSelector(JuiceSelector selector) {
        this.selector = selector;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        JuiceView juiceView = new JuiceView(container.getContext());
        juiceView.setColor(colors[position]);
        juiceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selector != null) {
                    selector.onJuiceSelected(position);
                }
            }
        });
        container.addView(juiceView);
        return juiceView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public int getJuiceColor(int pos) {
        return colors[pos];
    }
}
