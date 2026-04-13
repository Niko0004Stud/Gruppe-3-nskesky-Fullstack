package org.gruppe3nskeskyfullstack.controller;

import  org.springframework.stereotype.Component;

@Component
public class ØnskelisteInputValidering {

    public  void valideringøsnkelistenavn(String name){

        if (name==null){
            throw new IllegalArgumentException("ønskelistenavn må ikke være null");
        }
        String trimmed=name.trim();

        if (trimmed.length()<3 || trimmed.length()>20){
            throw new IllegalArgumentException("øsnkelistenavn skal være mellem 3 og 20 tegn");
        }

        if (!trimmed.matches("^[\\p{L}0-9.-_]+$")){
            throw new IllegalArgumentException("øsnkelistenavn gyldige tegn er kun a-zA-Z0-9._-");
        }

    }
}

