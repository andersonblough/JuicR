package com.andersonblough.juicr.model;

import io.realm.RealmObject;
import lombok.Builder;
import lombok.Data;

/**
 * Created by andersonblough on 11/24/16.
 */

public class RecipeItem extends RealmObject {

    private Ingredient ingredient;
    private int quantity;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
