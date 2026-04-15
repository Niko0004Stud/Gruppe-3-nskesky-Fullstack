package org.gruppe3nskeskyfullstack.controller;

import  org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        if (!trimmed.matches("[\\p{L}]")) {
            throw new IllegalArgumentException("Username can only contain these charachers: a-z A-Z");
        }
    }

    // password VARCHAR(50) NOT NULL - Natasha
    public void validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        String trimmed = password.trim();
        if (trimmed.length() < 3 || trimmed.length() > 50) {
            throw new IllegalArgumentException("password must be between 5 and 50 characters");
        }
        if (!trimmed.matches("[\\p{L}0-9]")) {
            throw new IllegalArgumentException("password can only contain these charachers: a-z A-Z 0-9");
        }

    }

    // email VARCHAR(100) NOT NULL -Natsaha
    public void validateEmail(String Email) {
        if (Email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        String trimmed = Email.trim();
        if (trimmed.length() < 3 || trimmed.length() > 100) {
            throw new IllegalArgumentException("password must be between 3 and 100 characters");
        }
        if (!trimmed.matches("[\\p{L}0-9]")) {
            throw new IllegalArgumentException("password can only contain these charachers: a-z A-Z 0-9 ");
        }
        if (!Email.contains("@")) {
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

    //birthDate DATE NOT NULL-estera
    public void validateBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birthdate cannot be null");
        }

        if(!birthDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Birhdate can only be in the past");
        }

    }
}
