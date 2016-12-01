package com.andersonblough.juicr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andersonblough.juicr.R;
import com.andersonblough.juicr.model.RecipeItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andersonblough on 11/28/16.
 */

public class RecipeView extends LinearLayout {

    @BindView(R.id.add_ingredient)
    TextView addIngredient;

    public RecipeView(Context context) {
        this(context, null);
    }

    public RecipeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecipeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.recipe_view, this);
        ButterKnife.bind(this);
        addIngredient.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setRecipe(List<RecipeItem> recipe) {
        removeAllViews();
        for (int i = 0; i < recipe.size(); i++) {
            IngredientView ingredientView = new IngredientView(getContext());
            ingredientView.setRecipeItem(recipe.get(0));
            addView(ingredientView);
        }
    }

    public void setEditable(boolean editable) {
        addIngredient.setVisibility(editable ? VISIBLE : GONE);
    }
}
