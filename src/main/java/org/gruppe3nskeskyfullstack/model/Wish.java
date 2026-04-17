package org.gruppe3nskeskyfullstack.model;

public class Wish {
    // int id, int wishlistID, string name, double price, string url

    private int id;
    private  int wishlistID;
    private  String name;
    private double price;
    private String url;

    public Wish(int id, int wishlistID, String name, double price, String url) {
        this.id = id;
        this.wishlistID = wishlistID;
        this.name = name;
        this.price = price;
        this.url = url;
    }
    public Wish( int wishlistID, String name, double price, String url) {
        this.wishlistID = wishlistID;
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public Wish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




}
