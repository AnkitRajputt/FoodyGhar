package com.example.foodyghar.Model;

public class Tab_menu_AsiaFood {

    String name;
    String id;
    String price;
    Integer imageUrl;
    String rating;
    String restorantname;

    public Tab_menu_AsiaFood(String id,String name, String price, Integer imageUrl, String rating, String restorantname) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.restorantname = restorantname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRestorantname() {
        return restorantname;
    }

    public void setRestorantname(String restorantname) {
        this.restorantname = restorantname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
