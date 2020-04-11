package com.company;

import java.util.ArrayList;

public class Person {
    ArrayList<String> phone;
    ArrayList<String> email;

    public ArrayList<String> getPhone() {
        return phone;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public Person(String phone, String email) {
        this.phone = new ArrayList<>();
        this.phone.add(phone);

        this.email = new ArrayList<>();
        this.email.add(email);
    }

    public void addRecord(String phone, String email){
        this.phone.add(phone);
        this.email.add(email);
    }


}
