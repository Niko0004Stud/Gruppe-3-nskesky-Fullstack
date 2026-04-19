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
    private WishRepo wishRepo;

    @PostMapping("/reserve")
    public String reserveWish(@RequestParam int wishId,
                              HttpSession session) {

        User user = (User) session.getAttribute("user");


        if (user == null) {
            return "redirect:/login";
        }

        Wish wish = wishRepo.getWishByID(wishId);
        WishList wishlist = wishListRepo.getWLById(wish.getWishlistID());


        if (wishlist.getUserId() == user.getId()) {
            return "redirect:/userPage";
        }

        reservationRepo.reserveWish(wishId, user.getId());

        return "redirect:/wishlist/share/" + wishlist.getShareToken();
    }

    @PostMapping("/wishlist/{wishlistId}/createWish")
    public String createwish(
            @PathVariable("wishlistId") int wishlistId,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam(value = "url", required = false) String url) {

        System.out.println("Du kom ind i createWish()");
        if(url==null || url.isEmpty()){
            url="noURL";
        }
        Wish wish = new Wish(wishlistId, name, price, url);
        wishRepo.saveWish(wish);

        return "redirect:/showWishlist?id=" + wishlistId;
    }

    @GetMapping("/showWishes")
    public String showWishes(@RequestParam("id")int id, Model model){
        WishList wl = wishListRepo.getWLById(id);
        ArrayList<Wish> wishes = wishRepo.getAllWishesByWishlist(id);

        model.addAttribute("wishlist", wl);
        model.addAttribute("wishes",wishes);
        model.addAttribute("wishlistId", id);

        return "wishlist";
    }

    @PostMapping("/wish/action")
    public String handleAction(@RequestParam int wishId,
                               @RequestParam int wishlistId,
                               @RequestParam String action,
                               HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (action.equals("delete")) {
            wishRepo.deleteWish(wishId);
        }

        else if (action.equals("reserve")) {
            if (user != null) {
                reservationRepo.reserveWish(wishId, user.getId());
            }
        }
        return "redirect:/showWishlist?id=" + wishlistId;
    }
}



