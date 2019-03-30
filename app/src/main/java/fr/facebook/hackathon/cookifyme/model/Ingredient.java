package fr.facebook.hackathon.cookifyme.model;


public class Ingredient {

    private String name;
    private String category;

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


    public Ingredient(String name, String category) {
        this.name = name;
        this.category = category;

    }

    @Override
    public String toString() {
        return  name;
    }
}
