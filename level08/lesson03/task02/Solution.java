package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("арбуз", "ягода");
        stringHashMap.put("банан", "трава");
        stringHashMap.put("вишня", "ягода");
        stringHashMap.put("груша", "фрукт");
        stringHashMap.put("дыня", "овощ");
        stringHashMap.put("ежевика", "куст");
        stringHashMap.put("жень-шень", "корень");
        stringHashMap.put("земляника", "ягода");
        stringHashMap.put("ирис", "цветок");
        stringHashMap.put("картофель", "клубень");
        for (Map.Entry<String, String> entry : stringHashMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());

        }

    }
}
