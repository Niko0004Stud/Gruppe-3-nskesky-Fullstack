package org.gruppe3nskeskyfullstack.service;

import org.gruppe3nskeskyfullstack.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User login(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }
}
