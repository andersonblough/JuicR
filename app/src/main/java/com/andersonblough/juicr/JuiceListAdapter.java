package com.andersonblough.juicr;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andersonblough.juicr.model.Juice;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andersonblough on 11/22/16.
 */

public class JuiceListAdapter extends RecyclerView.Adapter<JuiceListAdapter.JuiceHolder> {

    private List<Juice> items;

    public void setItems(List<Juice> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public JuiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JuiceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.juice_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(JuiceHolder holder, int position) {
        Juice juice = items.get(position);
        holder.name.setText(juice.getName());
        holder.ingredients.setText(juice.ingredientList());
        holder.juiceColor.setColorFilter(Color.parseColor(juice.getColor()), PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    class JuiceHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.ingredients)
        TextView ingredients;

        @BindView(R.id.juice_color)
        ImageView juiceColor;

        JuiceHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
