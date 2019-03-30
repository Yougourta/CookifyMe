package fr.facebook.hackathon.cookifyme.model;


public class Ingredient {

    private String name;
    private Category category;

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



    public Ingredient(String name, Category category) {
        this.name = name;
        this.category = category;

    }

    @Override
    public String toString() {
        return  name;
    }
}
