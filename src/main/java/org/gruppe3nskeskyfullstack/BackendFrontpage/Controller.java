package org.gruppe3nskeskyfullstack.BackendFrontpage;

import org.gruppe3nskeskyfullstack.controller.UserInputValidering;
import org.gruppe3nskeskyfullstack.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;



//public class Controller {
//    private final UserInputValidering userInputValidering;
//    ArrayList<User> users = new ArrayList<>();
//
//    public Controller(UserInputValidering userInputValidering) {
//        this.userInputValidering = userInputValidering;
//    }
//
//    @PostMapping("/register")
//    public String register(@RequestBody User user){
//        userInputValidering.validateName(user.getFirstName());
//        users.add(user);
//
//        return "User account is created ";
//    }
//}

