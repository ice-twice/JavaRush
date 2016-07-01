package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(String.valueOf(i));
        }
        System.out.println(strings.size());
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

    }
}
