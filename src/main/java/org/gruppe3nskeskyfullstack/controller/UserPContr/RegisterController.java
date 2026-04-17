package org.gruppe3nskeskyfullstack.controller.UserPContr;

import org.gruppe3nskeskyfullstack.service.Validation.UserInputValidation;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
@Controller
public class RegisterController {
        private final UserInputValidation userInputValidation;
        ArrayList<User> users = new ArrayList<>();

        public RegisterController(UserInputValidation userInputValidation) {
            this.userInputValidation = userInputValidation;
        }
        @Autowired
        private UserRepo userRepo;

        @PostMapping("/submit")
        public String register(User user){

            userInputValidation.validateUser(user);
            userRepo.saveUser(user);
            users.add(user);

            return "/userPage";
        }
    }
