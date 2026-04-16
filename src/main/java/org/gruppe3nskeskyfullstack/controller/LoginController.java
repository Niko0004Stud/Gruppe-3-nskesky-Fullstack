package org.gruppe3nskeskyfullstack.controller;

import jakarta.servlet.http.HttpSession;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

 private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/logins")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("test")
    public void testSOUT(){
        System.out.println("testen virkede");
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password/*,
                        HttpSession session*/){
        System.out.println("Du kom ind i login()");
        User user = userService.login(email, password);

        if(user!=null){
            //session.setAttribute("user", user);
            System.out.println("Det virkede!");
            return "redirect:/userPage";
        }

        return "login"; //ved fejlet login

    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
