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

import java.util.List;
import java.util.UUID;

@Controller
public class WishlistController {

    @Autowired
    WishListRepo wishListRepo;
    @Autowired
    WishRepo wishRepo;
    @Autowired
    ReservationRepo reservationRepo;

    @GetMapping("/wishlist/rename/{id}")
    public String showRenamePage(@PathVariable int id, Model model) {

        WishList wl = wishListRepo.getWLById(id);

        model.addAttribute("wishlist", wl);

        return "renameWishlist";
    }

    @PostMapping("/wishlist/rename")
    public String renameWishlist(@RequestParam int id,
                                 @RequestParam String name) {
        System.out.println("rename hit");

        WishList wl = new WishList();
        wl.setId(id);
        wl.setName(name);

        wishListRepo.updateWL(wl);

        return "redirect:/userPage";
    }

    @GetMapping("/wishlist/share/{token}")
    public String showSharedWishlist(@PathVariable String token,
                                     Model model,
                                     HttpSession session) {

        // hent wishlist via token
        WishList wl = wishListRepo.findByToken(token);

        // hent wishes (DET HER MANGLER HOS DIG)
        List<Wish> wishes = wishRepo.getAllWishesByWishlist(wl.getId());

        // tilføj til view
        model.addAttribute("wishlist", wl);
        model.addAttribute("wishes", wishes);

        // gæst = ikke ejer
        model.addAttribute("isOwner", false);

        return "wishlist";
    }

    @PostMapping("/saveCreateWishList")
    public String postCreateWishList(
            @RequestParam("name") String name, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        int userId = user.getId();
        WishList wishList = new WishList(name,userId);
        wishList.setShareToken(UUID.randomUUID().toString());
        wishListRepo.saveWL(wishList);

        return "redirect:/userPage";
    }

    @PostMapping("/deleteWishList")
    public String deleteWishList(@RequestParam("id") int id){
        wishListRepo.deleteWL(id);

        return"redirect:/userPage";
    }

    @PostMapping("/wishlist/action")
    public String handleWishlistAction(
            @RequestParam int wishlistId,
            @RequestParam String action,
            HttpSession session) {

        User user = (User) session.getAttribute("user");

        WishList wishList = wishListRepo.getWLById(wishlistId);

        if (wishList == null) {
            return "redirect:/userPage";
        }

        if (user == null) {
            return "redirect:/login";
        }
        if (wishList.getUserId() != user.getId()){
            return "redirect:/userPage";
        }

        if ("delete".equals(action)) {
            wishListRepo.deleteWL(wishlistId);
        }

        if ("rename".equals(action)) {
            return "redirect:/wishlist/rename/" + wishlistId;
        }
        if ("share".equals(action)) {
            return "redirect:/wishlist/share/" + wishList.getShareToken();
        }

        return "redirect:/userPage";
    }
    @GetMapping("/showWishlist")
    public String showWishlist(@RequestParam int id, Model model,
                               HttpSession session) {

        User user = (User) session.getAttribute("user");

        WishList wl = wishListRepo.getWLById(id);
        List<Wish> wishes = wishRepo.getAllWishesByWishlist(id);

        boolean isOwner = false;
        if (user != null) {
            isOwner = (user.getId() == wl.getUserId());
        }

        for (Wish wish : wishes) {
            boolean reserved = reservationRepo.isWishReserved(wish.getId());
            wish.setReserved(reserved);
        }

        model.addAttribute("wishlist", wl);
        model.addAttribute("wishes", wishes);
        model.addAttribute("isOwner", isOwner);

        return "wishlist";
    }

    @PostMapping("/wish/reserve")
    public String reserveWish(@RequestParam int wishId,
                              @RequestParam int wishlistId,
                              HttpSession session) {

        User user = (User) session.getAttribute("user");

        WishList wl = wishListRepo.getWLById(wishlistId);


        if (user.getId() == wl.getUserId()) {
            return "redirect:/showWishlist?id=" + wishlistId;
        }


        if (!reservationRepo.isWishReserved(wishId)) {
            reservationRepo.reserveWish(wishId, user.getId());
        }

        return "redirect:/showWishlist?id=" + wishlistId;
    }

    @PostMapping("/wish/delete")
    public String deleteWish(@RequestParam int wishId,
                             @RequestParam int wishlistId,
                             HttpSession session) {

        User user = (User) session.getAttribute("user");
        WishList wl = wishListRepo.getWLById(wishlistId);

        if (user.getId() == wl.getUserId()) {
            wishRepo.deleteWish(wishId);
        }

        return "redirect:/showWishlist?id=" + wishlistId;
    }
}
