package fr.facebook.hackathon.cookifyme.model;


import java.io.Serializable;

public class Ingredient implements Serializable {

    private String name;
    private String category;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Ingredient(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public Ingredient() { }

    @Override
    public String toString() {
        return  name + ", " + quantity;
    }
}
