package org.gruppe3nskeskyfullstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController

public class UserController {

    private UserInputValidation validation;
    public UserController(UserInputValidation validation){
        this.validation=validation;
    }

    @GetMapping("testUserGender")
    public String testGenderValidation(@RequestParam String gender){
        validation.validateGender(gender);
        return "Gender acceptet: "+ gender;
    }

    @GetMapping("testUserTlf")
    public String testTlfValidation(@RequestParam String telefon){
        validation.validateTlfNr(telefon);
        return "Phone nr acceptet: "+ telefon;
    }

    @GetMapping("testUserBirthdate")
    public String testBirthdateValidation(@RequestParam String birtdDate){
        LocalDate date=LocalDate.parse(birtdDate);
        validation.validateBirthDate(date);
        return "Birthday accepted: "+ date;
    }

}
