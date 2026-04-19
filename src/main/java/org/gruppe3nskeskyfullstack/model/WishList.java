package org.gruppe3nskeskyfullstack.model;

public class WishList {

    private String name;
    private int id;
    private int userId;
    private String shareToken;

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

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setShareToken(String shareToken){
        this.shareToken=shareToken;
    }
    public String getShareToken(){
        return shareToken;
    }
}
