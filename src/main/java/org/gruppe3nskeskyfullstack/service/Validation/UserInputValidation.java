package org.gruppe3nskeskyfullstack.service.Validation;

import org.gruppe3nskeskyfullstack.model.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserInputValidation {



    public void validateUser(User user) {
        validateName(user.getFirstName());
        validateEmail(user.getEmail());
        validateTlfNr(user.getTlfNumber());
        validateGender(user.getGender());
        validateBirthDate(user.getBirthDate().toString());
        validatePassword(user.getPassword());
    }
    // name VARCHAR(50) NOT NULL
    public void validateName(String name) {
        String trimmed = name.trim();
        if ((trimmed.length() < 3 || trimmed.length() > 50)|| !trimmed.matches("[\\p{L}]+")){
            throw new IllegalArgumentException("Name must be between 3-50 characters");
        }
    }

    // password VARCHAR(50) NOT NULL
    public void validatePassword(String password) {
        String trimmed = password.trim();
        if (!trimmed.matches("[\\p{L}0-9]+")||(trimmed.length() < 5 || trimmed.length() > 50)) {
            throw new IllegalArgumentException("password must be between 5 and 50 characters");
        }
    }
        // email VARCHAR(100) NOT NULL
    public void validateEmail(String email) {
        String trimmed = email.trim();
        if (trimmed.length() < 3 || trimmed.length() > 100 ||!trimmed.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email must be between 3 and 100 characters");
        }
    }

    // gender VARCHAR(20) NOT NULL
    public void validateGender(String name) {
        String trimmed = name.trim();
        if (trimmed.length() < 4 || trimmed.length() > 10||!trimmed.matches("[\\p{L}]")) {
            throw new IllegalArgumentException("Gender cannot contain more than 10 characters");
        }
    }

    //tlfNumber VARCHAR(20) NOT NULL
    public void validateTlfNr(String number) {
        if (number.length() >20) {
            throw new IllegalArgumentException("The phone number can contain max 20 characters");
        }
    }

    //birthDate DATE NOT NULL
    public void validateBirthDate(String birthDate) {
        String trimmed = birthDate.trim();
        if (trimmed.length() < 4 || trimmed.length() > 10|| !trimmed.matches("[\\p{L}]")) {
            throw new IllegalArgumentException("Gender cannot contain more than 10 characters");
        }

    }

}
