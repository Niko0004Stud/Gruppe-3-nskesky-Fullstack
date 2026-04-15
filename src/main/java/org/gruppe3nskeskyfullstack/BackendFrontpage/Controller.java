package org.gruppe3nskeskyfullstack.BackendFrontpage;

import org.gruppe3nskeskyfullstack.controller.UserInputValidering;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class Controller {
    private final UserInputValidering userInputValidering;
    ArrayList<CreateUser> users = new ArrayList<>();

    public Controller(UserInputValidering userInputValidering) {
        this.userInputValidering = userInputValidering;
    }

    @PostMapping("/register")
    public String register(@RequestBody CreateUser user){
        userInputValidering.validateName(user.getName);
        users.add(user);

        return "User account is created ";
    }
}

