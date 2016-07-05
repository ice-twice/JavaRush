package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> stringHashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            stringHashMap.put("lastName" + i, "firstName" + i);
        }
        return stringHashMap;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int i = 0;
        for (String s : map.values()) {
            if (s.equals(name)) {
                i++;
            }
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int i = 0;
        for (String s : map.keySet()) {
            if (s.equals(lastName)) {
                i++;
            }
        }
        return i;

    }
}
