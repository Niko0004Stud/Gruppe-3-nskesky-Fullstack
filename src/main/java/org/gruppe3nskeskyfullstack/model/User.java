package org.gruppe3nskeskyfullstack.model;

import java.time.LocalDate;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String tlfNumber;
    private String gender;
    private LocalDate birthDate;
    private String password;


    public User(int id, String firstName, String lastName, String email, String tlfNumber,
                String gender, LocalDate birthDate, String password){
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.tlfNumber = tlfNumber;
        this.gender=gender;
        this.birthDate = birthDate;
        this.password=password;
    }

    public User(String firstName, String lastName, String email, String tlfNumber,
                String gender, LocalDate birthDate, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.tlfNumber = tlfNumber;
        this.gender=gender;
        this.birthDate = birthDate;
        this.password=password;
    }
    public User(){}

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTlfNumber() {
        return tlfNumber;
    }

    public void setTlfNumber(String tlfNumber) {
        this.tlfNumber = tlfNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
