package org.gruppe3nskeskyfullstack.controller;

public class UserInputValidering {

    // name VARCHAR(50) NOT NULL
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

    // password VARCHAR(50) NOT NULL
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

    // email VARCHAR(100) NOT NULL
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

    // gender VARCHAR(20) NOT NULL
    public void validateGender(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }

        String trimmed = name.trim();
        if (trimmed.length() < 4 || trimmed.length() > 10) {
            throw new IllegalArgumentException("Gender cannot contain more than 10 characters");
        }

        if (!trimmed.matches("[\\p{L}]")) {
            throw new IllegalArgumentException("Username can only contain these charachers: a-z A-Z");
        }
    }

    //tlfNumber VARCHAR(20) NOT NULL
    public void validateTlfNr(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Phone number cannot be 0");
        }


        if (number >20) {
            throw new IllegalArgumentException("The phone number can contain max 20 characters");
        }

    }

    //birthDate DATE NOT NULL
    public void birthDate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }

        String trimmed = name.trim();
        if (trimmed.length() < 4 || trimmed.length() > 10) {
            throw new IllegalArgumentException("Gender cannot contain more than 10 characters");
        }

        if (!trimmed.matches("[\\p{L}]")) {
            throw new IllegalArgumentException("Username can only contain these charachers: a-z A-Z");
        }
    }

}
