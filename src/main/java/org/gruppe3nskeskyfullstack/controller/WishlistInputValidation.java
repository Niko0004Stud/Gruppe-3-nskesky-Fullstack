package org.gruppe3nskeskyfullstack.controller;

import  org.springframework.stereotype.Component;

@Component
public class WishlistInputValidation {

    //name VARCHAR(20) NOT NULL
    public  void validationWishlist(String name){

        if (name==null){
            throw new IllegalArgumentException("Wishlist name cannot be null");
        }

        String trimmed=name.trim();
        if (trimmed.length()<3 || trimmed.length()>20){
            throw new IllegalArgumentException("Wishlist name must be between 3 and 20 characters");
        }

        if (!trimmed.matches("^[\\p{L}0-9.-_]+$")){
            throw new IllegalArgumentException("Wishlist name ca only contain these characters: a-z A-Z 0-9 . _ -");
        }

    }
}
