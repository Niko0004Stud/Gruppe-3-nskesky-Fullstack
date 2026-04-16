package org.gruppe3nskeskyfullstack.controller.UserPContr;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.model.WishList;
import org.gruppe3nskeskyfullstack.repository.WishListRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class UserPageController {
    private WishListRepo wishListRepo;
    @GetMapping("/userpage")
    public String userPage(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        List<WishList> wishlists;
        wishlists = wishListRepo.getAllWLsByUser(user.getId());

        model.addAttribute("wishlists", wishlists);

        return "userpage";
    }
}
