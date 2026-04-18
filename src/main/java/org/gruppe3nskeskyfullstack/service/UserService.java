package org.gruppe3nskeskyfullstack.service;

import org.gruppe3nskeskyfullstack.model.User;
import org.gruppe3nskeskyfullstack.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String email, String password) {
        return userRepo.verifyLogin(email, password);
    }

    // At bruge denne ville nok være smartere
    public boolean signUp(String email, String password){
        return userRepo.verifySignUp(email, password);
    }
}
