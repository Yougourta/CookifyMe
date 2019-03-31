package fr.facebook.hackathon.cookifyme.model;


import java.io.Serializable;

public class Ingredient implements Serializable {

    private String name;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String category) {
        this.image = category;
    }

    public Ingredient() {}
}
