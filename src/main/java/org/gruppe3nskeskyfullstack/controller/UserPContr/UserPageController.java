package org.gruppe3nskeskyfullstack.controller.UserPContr;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.model.WishList;
import org.gruppe3nskeskyfullstack.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class UserPageController {
    @Autowired
    private WishListRepo wishListRepo;

    @GetMapping("/showWishList")
    public String showWishlist(@RequestParam("id")int id, Model model){
        WishList wishList = wishListRepo.getWLById(id);
        model.addAttribute(wishList);

        return "showWishList";
    }

    @GetMapping("/userPage")
    public String userPage(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/";
        }

        List<WishList> wishlists;
        wishlists = wishListRepo.getAllWLsByUser(user.getId());

        model.addAttribute("wishlists", wishlists);
        System.out.println(wishlists);
        System.out.println(wishlists.size());

        return "userPage";
    }
}
