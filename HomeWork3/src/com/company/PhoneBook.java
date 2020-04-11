package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    static HashMap<String, Person> record; //в массиве 0 элемент - телефон, 1 элемент емайл

    public PhoneBook() {
        record = new HashMap<>();
    }

    static void addRecord(String surname, String phone, String email) {
        if(record.containsKey(surname)) {
            record.get(surname).addRecord(phone, email);
        } else {
            record.put(surname, new Person(phone, email));
        };
    }

    public ArrayList<String> findPhone(String surname) {
        if(record.containsKey(surname)) {
            return record.get(surname).getPhone();
        } else {
            throw new RuntimeException("Не найдена запись с фамилией " + surname);
        }
    }

    public ArrayList<String> findEmail(String surname) {

        if(record.containsKey(surname)) {
            return record.get(surname).getEmail();
        } else {
            throw new RuntimeException("Не найдена запись с фамилией " + surname);
        }

    }

}
