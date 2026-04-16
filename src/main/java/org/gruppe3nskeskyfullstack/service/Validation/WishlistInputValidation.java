package org.gruppe3nskeskyfullstack.service.Validation;

import  org.springframework.stereotype.Component;

@Component
public class WishlistInputValidation {

    //name VARCHAR(20) NOT NULL
    public  void validationWishlist(String name){

        String trimmed=name.trim();
        if (trimmed.length()<3 || trimmed.length()>20|| !trimmed.matches("^[\\p{L}0-9.-_]+$")){
            throw new IllegalArgumentException("Wishlist name must be between 3 and 20 characters");
        }

    }
}
