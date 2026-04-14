package org.gruppe3nskeskyfullstack.controller;

public class UserInputValidering {

    public void validateusername(String name) {

        if (name == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        String trimmed = name.trim();

        if (trimmed.length() < 3 || trimmed.length() > 20) {
            throw new IllegalArgumentException("Username must be between 3 and 20 characters");
        }

        if (!trimmed.matches("[\\p{L}0-9]")) {
            throw new IllegalArgumentException("Username can only contain these charachers: a-z A-Z 0-9");
        }

    }

}
