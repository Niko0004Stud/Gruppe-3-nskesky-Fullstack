package org.gruppe3nskeskyfullstack.controller.UserPContr;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.model.Wish;
import org.gruppe3nskeskyfullstack.model.WishList;
import org.gruppe3nskeskyfullstack.repository.ReservationRepo;
import org.gruppe3nskeskyfullstack.repository.WishListRepo;
import org.gruppe3nskeskyfullstack.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class WishController {

    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    private WishListRepo wishListRepo;
    @Autowired
   private WishRepo wishRepo;// Autowire så vi får adgang til vores wishesrepo, da autowire gør at vi kan connecte vores klasser sammen
    //wishesrepo skal bruges

    /*@GetMapping("/getWishes")//Hvis man får en hhtp request, så sender den  tilbage til createWishes siden.
    public String FrontPage() { // den side den ligger på - createwishes- dette er bare et eksempel den ligger ikke i frontpage.
        return "CreateWishes";
    }*/




    @PostMapping("/reserve")
    public String reserveWish(@RequestParam int wishId,
                              HttpSession session) {

        User user = (User) session.getAttribute("user");

        // ikke logget ind
        if (user == null) {
            return "redirect:/login";
        }

        Wish wish = wishRepo.getWishByID(wishId);
        WishList wishlist = wishListRepo.getWLById(wish.getWishlistID());

        // ejer sin egen liste
        if (wishlist.getUserid() == user.getId()) {
            return "redirect:/userPage";
        }

        reservationRepo.reserveWish(wishId, user.getId());

        return "redirect:/wishlist/share/" + wishlist.getShareToken();
    }

    @PostMapping("/savewishes")
    public String postCreatewishes(
    @PostMapping("/wishlist/{wishlistId}/createWish")
    public String createwish(
            @PathVariable("wishlistId") int wishlistId,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam(value = "url", required = false) String url) {

        System.out.println("Du kom ind i createWish()");
        /*WishList wishList = (WishList) httpSession.getAttribute("wishList");
        int wishlistId = wishList.getId();*/
        if(url==null || url.isEmpty()){
            url="noURL";
        }
        Wish wish = new Wish(wishlistId, name, price, url);
        wishRepo.saveWish(wish);

        return "redirect:/showWishes?id="+wishlistId;

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
        ArrayList<Wish> wishes = wishRepo.getAllWishesByWishlist(id);
        model.addAttribute("wishes",wishes);
        model.addAttribute("wishlistId", id);

        return "wishlist";
    }

    @PostMapping("/deleteWish")
    public String deleteWishList(@RequestParam("id") int id){
        wishRepo.deleteWish(id);

        return"redirect:/"; // Skal nok være til userpage eller noget andet
    }

    }



