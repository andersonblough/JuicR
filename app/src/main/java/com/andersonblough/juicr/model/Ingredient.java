package com.andersonblough.juicr.model;

import io.realm.RealmObject;
import lombok.Builder;
import lombok.Data;

/**
 * Created by andersonblough on 11/22/16.
 */

public class Ingredient extends RealmObject {

    private String name;
    private String type;
    private String typePlural;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypePlural() {
        return typePlural;
    }

    public void setTypePlural(String typePlural) {
        this.typePlural = typePlural;
    }
}
