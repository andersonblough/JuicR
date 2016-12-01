package com.andersonblough.juicr.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by andersonblough on 11/22/16.
 */
public class Juice extends RealmObject {

    private String name;
    private RealmList<RecipeItem> recipe;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<RecipeItem> getRecipe() {
        return recipe;
    }

    public void setRecipe(RealmList<RecipeItem> recipe) {
        this.recipe = recipe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String ingredientList() {
        StringBuilder builder = new StringBuilder();
        if (recipe != null) {
            for (int i = 0; i < recipe.size(); i++) {
                Ingredient ingredient = recipe.get(i).getIngredient();
                builder.append(ingredient);
                if (i < recipe.size() - 1) {
                    builder.append(", ");
                }
            }
        }
        return builder.toString();
    }
}
