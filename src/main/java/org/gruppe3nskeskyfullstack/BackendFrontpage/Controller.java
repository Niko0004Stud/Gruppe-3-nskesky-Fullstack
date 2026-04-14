package org.gruppe3nskeskyfullstack.BackendFrontpage;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

public class Controller {
    ArrayList<CreateUser> users = new ArrayList<>();

    @PostMapping("/register")
    public String register(CreateUser user){
        users.add(user);

        return "User account is created ";
    }
}

