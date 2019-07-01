package com.project.models;


import java.security.PublicKey;

public class Item {
    private String id;
    private String name;
    private double price;
    private String imageURL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item(){

    }
    public Item(String id, String name, double price, String imageURL){
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public String getPriceStr() {
        return String.valueOf(price);
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}

