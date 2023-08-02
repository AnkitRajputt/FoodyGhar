package com.example.foodyghar.Model;

import de.hdodenhof.circleimageview.CircleImageView;

public class Review_model
{

    int imageUrl;
    String username;
    String  rating;
    String userrev;



    public Review_model(int imageUrl, String username,String rating, String userrev) {
        this.imageUrl = imageUrl;
        this.username = username;
        this.rating = rating;
        this.userrev = userrev;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUserrev() {
        return userrev;
    }

    public void setUserrev(String userrev) {
        this.userrev = userrev;
    }


}
