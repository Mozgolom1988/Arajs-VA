package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //ЗАДАНИЕ 1:
        //Массив строк из 30 слов:
        String [] inbox = {"ведро", "вода", "мыло","вода","мыло","уборка","еда","вода","самоизоляция","улица",
                            "магазин", "собаки", "кошки", "люди", "маски", "люди", "маски", "маски", "люди", "трава",
                            "шаг", "движение", "дом", "комьютер", "замок", "дом", "дом", "дом", "дом", "свобода"};

        //Найдем список слов из которых состоит текст:
        Set<String> setWord = new HashSet(Arrays.asList(inbox));
        System.out.println("Уникальные слова: " + setWord);
        System.out.println();

        //Посчитать сколько раз встречается каждое слово (использовать HashMap)
        countRepeatWord(inbox);

        //ЗАДАНИЕ 2:
        PhoneBook phoneBook = new PhoneBook();

        //добавление записей в книгу:
        phoneBook.addRecord("Иванов", "434647","ivanov111@mail.ru");
        phoneBook.addRecord("Петров", "123453","petrov111@mail.ru");
        phoneBook.addRecord("Иванов", "554433","ivanov222@mail.ru");

        //Вывод телефоно и емайлов для проверки и отработка ошибки записи которая не найдена
        System.out.println();
        try {
            System.out.println(phoneBook.findPhone("Иванов"));
            System.out.println(phoneBook.findEmail("Сидоров"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }


    static void countRepeatWord(String[] inbox) {

        HashMap<String, Integer> countRepeatWord = new HashMap<>();

        for(int i=0 ; i < inbox.length; i++) {
            if(countRepeatWord.containsKey(inbox[i])) {
                countRepeatWord.put(inbox[i], (int)countRepeatWord.get(inbox[i])+1);
            } else {
                countRepeatWord.put(inbox[i],1);
            };

        }

        System.out.println("Слово и сколько раз оно встречается: ");
        System.out.println(countRepeatWord);

    }
}
