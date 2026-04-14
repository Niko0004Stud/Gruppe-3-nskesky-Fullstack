package org.gruppe3nskeskyfullstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ØnskelisteController {

    private ØnskelisteInputValidering validering;
    public ØnskelisteController(ØnskelisteInputValidering validering){
        this.validering=validering;
    }

    @GetMapping("testValideringøsnkelistenavn")
    public  String testValidering(@RequestParam String navn){
        validering.valideringøsnkelistenavn(navn);
        return "Gyldig ønskelistenavn "+navn;
    }

}
