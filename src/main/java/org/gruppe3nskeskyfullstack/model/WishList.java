package org.gruppe3nskeskyfullstack.model;

public class WishList {

    private String name;
    private int id;
    private int userId;

    public WishList(String name, int userId, int id){
        this.name=name;
        this.id=id;
        this.userId=userId;
    }

    public WishList(String name, int userId){
        this.name=name;
        this.userId=userId;
    }

    public WishList(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserid() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }
}
