package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int indexMinLength = 0;
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
            if (strings.get(indexMinLength).length() > strings.get(i).length()) {
                indexMinLength = i;
            }
        }
        System.out.println(strings.get(indexMinLength));
        for (int i = indexMinLength; i < strings.size(); i++) {
            if (strings.get(indexMinLength).length() == strings.get(i).length() && i != indexMinLength) {
                System.out.println(strings.get(i));
            }
        }

    }
}
