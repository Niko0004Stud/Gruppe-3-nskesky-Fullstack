package org.gruppe3nskeskyfullstack.controller;

import org.springframework.stereotype.Component;

public class BrugerInputValidering {

    public void valideringbrugernavn(String name) {

        if (name == null) {
            throw new IllegalArgumentException("bruger navn må ikke være null");
        }

        String trimmed = name.trim();

        if (trimmed.length() < 3 || trimmed.length() > 20) {
            throw new IllegalArgumentException("Brugernavn skal være mellem 3 og 20 tegn");
        }

        if (!trimmed.matches("[\\p{L}0-9]")) {
            throw new IllegalArgumentException("brugernavn gyldige tegn er kun a-z A-Z 0-9");
        }

    }

}
