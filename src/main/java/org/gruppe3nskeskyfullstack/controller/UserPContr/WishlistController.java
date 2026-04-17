package org.gruppe3nskeskyfullstack.controller.UserPContr;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
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
            @RequestParam("name") String name, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        int userId = user.getId();
        WishList wishList = new WishList(name,userId); // userID skal findes på en anden måde
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

    @PostMapping("/wishlist/action")
    public String handleWishlistAction(
            @RequestParam int wishlistId,
            @RequestParam String action,
            HttpSession session) {

        User user = (User) session.getAttribute("user");

        WishList wl = wishListRepo.getWLById(wishlistId);

        if (wl == null) {
            return "redirect:/userPage";
        }

        if (user == null) {
            return "redirect:/login";
        }
        if (wl.getUserid() != user.getId()){
            return "redirect:/userPage";
        }

        if ("delete".equals(action)) {
            wishListRepo.deleteWL(wishlistId);
        }

        if ("rename".equals(action)) {
            return "redirect:/renameWishlist" + wishlistId;
        }

        return "redirect:/userPage";
    }
}
