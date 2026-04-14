package org.gruppe3nskeskyfullstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {

    private WishlistInputValidering validation;

    public WishlistController(WishlistInputValidering validation){
        this.validation=validation;
    }

    @GetMapping("testValideringøsnkelistenavn")
    public  String testValidering(@RequestParam String name){
        validation.validationWishlist(name);
        return "Gyldig ønskelistenavn "+name;
    }

}
