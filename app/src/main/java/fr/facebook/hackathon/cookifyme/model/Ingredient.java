package fr.facebook.hackathon.cookifyme.model;


public class Ingredient {

    private String name;
    private Category category;
    private int quantity;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Ingredient(String name, Category category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  name + ", " + quantity;
    }
}
