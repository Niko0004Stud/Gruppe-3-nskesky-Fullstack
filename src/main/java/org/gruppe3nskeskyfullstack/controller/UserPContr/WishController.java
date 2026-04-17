package org.gruppe3nskeskyfullstack.controller.UserPContr;

import org.gruppe3nskeskyfullstack.model.Wish;
import org.gruppe3nskeskyfullstack.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishController {


    @Autowired
    WishRepo wishRepo;// Autowire så vi får adgang til vores wishesrepo, da autowire gør at vi kan connecte vores klasser sammen
    //wishesrepo skal bruges

    @GetMapping("/getWishes")//Hvis man får en hhtp request, så sender den  tilbage til createWishes siden.
    public String FrontPage() { // den side den ligger på - createwishes- dette er bare et eksempel den ligger ikke i frontpage.
        return "CreateWishes";



    }

    @PostMapping("/savewishes")
    public String postCreatewishes(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("url") String url) {
return "redirect:/";

    }

   /* @PostMapping("/getUpdateWish")
    public String upDateWish(@RequestParam("id") int id, Model model){
       Wish wish
        model.addAttribute(Wish);
        return "updateWishList";
    }
    */


    @GetMapping("/showWishes")
    public String showWishes(@RequestParam("id")int id, Model model){
        Wish wish = wishRepo.getWishByID(id);
        model.addAttribute(wish);

        return "showWishes";
    }

    @PostMapping("/deleteWishList")
    public String deleteWishList(@RequestParam("id") int id){
        wishRepo.deleteWish(id);

        return"redirect:/"; // Skal nok være til userpage eller noget andet
    }

    }



