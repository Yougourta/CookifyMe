package fr.facebook.hackathon.cookifyme.model;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    String name;
    String image;
    String method;
    List<String> ingredients;

    public Recipe(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Recipe() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
