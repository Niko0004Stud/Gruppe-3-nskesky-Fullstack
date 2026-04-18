package org.gruppe3nskeskyfullstack.controller.UserPContr;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.model.Wish;
import org.gruppe3nskeskyfullstack.model.WishList;
import org.gruppe3nskeskyfullstack.repository.WishListRepo;
import org.gruppe3nskeskyfullstack.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class UserPageController {
    @Autowired
    private WishListRepo wishListRepo;

    @Autowired
    private WishRepo wishRepo;

    @GetMapping("/showWishlist")
    public String showWishlist(@RequestParam("id")int id,
                               Model model){
        ArrayList<Wish> wishes = wishRepo.getAllWishesByWishlist(id);
        model.addAttribute("wishes",wishes);
        System.out.println("Du nåede til return wishlist");
        return "wishlist";
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
