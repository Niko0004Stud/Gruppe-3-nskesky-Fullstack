package org.gruppe3nskeskyfullstack.controller.UserPContr;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.model.WishList;
import org.gruppe3nskeskyfullstack.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class WishlistController {

    @Autowired
    WishListRepo wishListRepo;

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
    public String viewSharedWishlist(@PathVariable String token, Model model) {

        System.out.println("TOKEN: " + token);

        WishList wishList = wishListRepo.findByToken(token);
        System.out.println("WL: " + wishList);

        if (wishList == null) {
            return "redirect:/userPage";
        }

        model.addAttribute("wishlist", wishList);

        return "sharedWishlist";
    }

    @PostMapping("/saveCreateWishList")
    public String postCreateWishList(
            @RequestParam("name") String name, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        int userId = user.getId();
        WishList wishList = new WishList(name,userId); // userID skal findes på en anden måde
        wishList.setShareToken(UUID.randomUUID().toString());
        wishListRepo.saveWL(wishList);


        return "redirect:/userPage";
    }

    @PostMapping("/deleteWishList")
    public String deleteWishList(@RequestParam("id") int id){
        wishListRepo.deleteWL(id);

        return"redirect:/userPage"; // Skal nok være til userpage eller noget andet
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
        if (wishList.getUserid() != user.getId()){
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

}
