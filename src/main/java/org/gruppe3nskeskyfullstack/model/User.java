package org.gruppe3nskeskyfullstack.model;

import java.time.LocalDate;

public class User {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String tlf_number;
    private String gender;
    private LocalDate birth_date;
    private String password;


    public User(int id, String first_name, String last_name, String email, String tlf_number,
                String gender, LocalDate birth_date, String password){
        this.id=id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.tlf_number=tlf_number;
        this.gender=gender;
        this.birth_date=birth_date;
        this.password=password;
    }

    public User(String first_name, String last_name, String email, String tlf_number,
                String gender, LocalDate birth_date, String password){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.tlf_number=tlf_number;
        this.gender=gender;
        this.birth_date=birth_date;
        this.password=password;
    }
    public User(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTlf_number() {
        return tlf_number;
    }

    public void setTlf_number(String tlf_number) {
        this.tlf_number = tlf_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
