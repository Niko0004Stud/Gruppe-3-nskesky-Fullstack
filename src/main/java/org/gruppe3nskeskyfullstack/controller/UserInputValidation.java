package org.gruppe3nskeskyfullstack.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserInputValidering {

@Component
public class UserInputValidation {

    // name VARCHAR(50) NOT NULL - Natasha
    public void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");

        }

        String trimmed = name.trim();
        if (trimmed.length() < 3 || trimmed.length() > 50) {
            throw new IllegalArgumentException("Name must be between 3 and 50 characters");
        }

        if (!trimmed.matches("[\\p{L}]+")) {
            throw new IllegalArgumentException("Username can only contain these letters: a-z A-Z");
        }
    }

    // password VARCHAR(50) NOT NULL - Natasha
    public void validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        String trimmed = password.trim();
        if (trimmed.length() < 5 || trimmed.length() > 50) {
            throw new IllegalArgumentException("password must be between 5 and 50 characters");
        }
        if (!trimmed.matches("[\\p{L}0-9]+")) {
            throw new IllegalArgumentException("password can only contain these charachers: a-z A-Z 0-9");
        }

    }

    // email VARCHAR(100) NOT NULL
    public void validateEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        String trimmed = email.trim();
        if (trimmed.length() < 3 || trimmed.length() > 100) {
            throw new IllegalArgumentException("Email must be between 3 and 100 characters");
        }
        if (!trimmed.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid input ");
        }
        if (!email.contains("@")) {
            System.out.println("The mail must contain @");
        }
    }

    // gender VARCHAR(20) NOT NULL-estera
    public void validateGender(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }

        String trimmed = name.trim();
        if (trimmed.length() < 3 || trimmed.length() > 20) {
            throw new IllegalArgumentException("Gender must be between 3 and 20 characters");
        }

        if (!trimmed.matches("^\\p{L}+$")) {
            throw new IllegalArgumentException("Gender can only contain letters");
        }
    }

    //tlfNumber VARCHAR(20) NOT NULL-estera
    public void validateTlfNr(String number) {
        if (number == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        String trimmed=number.trim();
        if ( trimmed.length()==0 || trimmed.length()>20) {
            throw new IllegalArgumentException("The phone number must be between 1-20 characters");
        }

        if (!trimmed.matches("^[0-9]+$")){
            throw new IllegalArgumentException("Phone number can only contain numbers");
        }
    }
    }

    //birthDate DATE NOT NULL
    public void birthDate(String bithDate) {
        if (bithDate == null) {
            throw new IllegalArgumentException(" Birth Date cannot be null");
        }

    //birthDate DATE NOT NULL-estera
    public void validateBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birthdate cannot be null");
        String trimmed = bithDate.trim();
        if (trimmed.length() < 4 || trimmed.length() > 10) {
            throw new IllegalArgumentException("Gender cannot contain more than 10 characters");
        }

        if(!birthDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Birhdate can only be in the past");
        }
    }

}
