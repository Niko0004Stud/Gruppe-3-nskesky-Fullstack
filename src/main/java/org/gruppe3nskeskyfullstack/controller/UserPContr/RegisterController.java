package org.gruppe3nskeskyfullstack.controller.UserPContr;

import org.gruppe3nskeskyfullstack.service.Validation.UserInputValidation;
import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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

        @PostMapping("/trySignUp")
        public String register(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("tlfNumber") String tlfNumber,
                               @RequestParam("gender") String gender,
                               @RequestParam("birthDate") LocalDate date,
                               @RequestParam("password") String password){

            User user = new User(firstName, lastName, email, tlfNumber, gender, date, password);
            userInputValidation.validateUser(user);
            if(userRepo.verifySignUp(email, password)){
                System.out.println("Du oprettede en bruger");
                userRepo.saveUser(user);
                users.add(user);

                return "/userPage";
            }else {
                System.out.println("Bruger med samme email eller password eksisterer allerede.");
                return "/signUp";
            }
        }
    }
