package org.gruppe3nskeskyfullstack.controller.UserPContr;

import org.gruppe3nskeskyfullstack.service.Validation.UserInputValidering;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
@Controller
public class RegisterController {
        private final UserInputValidering userInputValidering;
        ArrayList<User> users = new ArrayList<>();

        public RegisterController(UserInputValidering userInputValidering) {
            this.userInputValidering = userInputValidering;
        }
        @Autowired
        private UserRepo userRepo;

        @PostMapping("/submit")
        public String register(User user){

            userInputValidering.validateUser(user);
            userRepo.saveUser(user);

            return "/userPage";
        }
    }
