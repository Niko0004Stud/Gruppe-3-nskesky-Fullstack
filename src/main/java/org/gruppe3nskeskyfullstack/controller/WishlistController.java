package org.gruppe3nskeskyfullstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {

    private WishlistInputValidation validation;

    public WishlistController(WishlistInputValidation validation){
        this.validation=validation;
    }

    @GetMapping("testWishlistName")
    public  String testWishlistValidation(@RequestParam String name){
        validation.validationWishlist(name);
        return "Wishlist name acceptet: "+name;
    }

}
