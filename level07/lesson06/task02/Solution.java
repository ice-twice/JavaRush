package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int indexMaxLength = 0;
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
            if (strings.get(indexMaxLength).length() < strings.get(i).length()) {
                indexMaxLength = i;
            }
        }
        System.out.println(strings.get(indexMaxLength));
        for (int i = indexMaxLength; i < strings.size(); i++) {
            if (strings.get(indexMaxLength).length() == strings.get(i).length() && i != indexMaxLength) {
                System.out.println(strings.get(i));
            }
        }
    }
}
