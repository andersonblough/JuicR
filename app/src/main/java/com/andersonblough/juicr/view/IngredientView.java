package com.andersonblough.juicr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andersonblough.juicr.R;
import com.andersonblough.juicr.model.RecipeItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andersonblough on 11/28/16.
 */

public class IngredientView extends LinearLayout {

    @BindView(R.id.ingredient)
    TextView title;

    @BindView(R.id.quantity)
    TextView quantity;

    public IngredientView(Context context) {
        this(context, null);
    }

    public IngredientView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public IngredientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.ingredient_view, this);
        ButterKnife.bind(this);
    }

    public void setRecipeItem(RecipeItem recipeItem) {
        title.setText(recipeItem.getIngredient().getName());
        String builder = String.valueOf(recipeItem.getQuantity()) + " " +
                (recipeItem.getQuantity() > 1 ? recipeItem.getIngredient().getTypePlural() : recipeItem.getIngredient().getType());
        quantity.setText(builder);
    }
}
