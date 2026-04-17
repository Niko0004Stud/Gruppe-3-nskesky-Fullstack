package org.gruppe3nskeskyfullstack.controller.UserPContr;

import org.gruppe3nskeskyfullstack.model.WishList;
import org.gruppe3nskeskyfullstack.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistController {

    @Autowired
    WishListRepo wishListRepo;

    @GetMapping("/getCreateWishlist")
    public String createWishList(){
        return "createWishList";
    }

    @PostMapping("/saveCreateWishList")
    public String postCreateWishList(
            @RequestParam("name") String name,
            @RequestParam("userID") String userID){

        WishList wishList = new WishList(/*name, userID*/); // userID skal findes på en anden måde
        wishListRepo.saveWL(wishList);
        return "redirect:/userPage";
    }

    @PostMapping("/getUpdateWishList")
    public String upDateWishList(@RequestParam("id") int id, Model model){
        WishList wishList = wishListRepo.getWLById(id);
        model.addAttribute(wishList);
        return "updateWishList";
    }


    @PostMapping("/deleteWishList")
    public String deleteWishList(@RequestParam("id") int id){
        wishListRepo.deleteWL(id);

        return"redirect:/userPage"; // Skal nok være til userpage eller noget andet
    }
}
