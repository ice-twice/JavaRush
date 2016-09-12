package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = fileReader.readLine()) != null) {
            stringBuilder.append(temp);
        }
        fileReader.close();
        if (stringBuilder.length() != 0) {
            String[] strings = stringBuilder.toString().split(" ");
            StringBuilder result = getLine(strings);
            System.out.println(result.toString());
        }
    }

    public static StringBuilder getLine(String... words) {
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(words));
        LinkedList<String> strings1 = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            String word1 = strings.get(i);
            char lChar = word1.toLowerCase().charAt(word1.length() - 1);
            char fChar;
            strings.remove(i);
            strings1.add(word1);
            for (int j = 0; j < strings.size(); j++) {
                String word2 = strings.get(j);
                fChar = word2.toLowerCase().charAt(0);
                if (lChar == fChar) {
                    lChar = word2.toLowerCase().charAt(word2.length() - 1);
                    strings.remove(j);
                    strings1.add(word2);
                    j = -1;
                }
            }
            if (strings1.size() != words.length) {
                for (String s : strings1) {
                    strings.add(s);
                }
                strings1.clear();
                i--;
            } else {
                for (String s : strings1) {
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append(s);
                    } else {
                        stringBuilder.append(" ").append(s);
                    }
                }
                break;
            }
        }
        return stringBuilder;
    }
}