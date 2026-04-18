package org.gruppe3nskeskyfullstack.model;

public class Reservation {

    private int id;
    private int wishId;
    private int userId;

    public Reservation() {}

    public Reservation(int wishId, int userId) {
        this.wishId = wishId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}