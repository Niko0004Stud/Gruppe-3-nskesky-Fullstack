package org.gruppe3nskeskyfullstack.model;

public class WishList {

    private String name;
    private int id;
    private int userid;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserid() {
        return userid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
