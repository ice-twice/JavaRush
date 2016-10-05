package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        final Map<Integer, Integer> byteMap = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int temp = fileInputStream.read();
            byteMap.put(temp, byteMap.get(temp) == null ? 1 : byteMap.get(temp) + 1);
        }
        fileInputStream.close();
        int min = 0;
        boolean minInitialize = false;
        for (Map.Entry<Integer, Integer> entry : byteMap.entrySet()) {
            if (!minInitialize) {
                min = entry.getValue();
                minInitialize = true;
            }
            if (min > entry.getValue()) {
                min = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : byteMap.entrySet()) {
            if (min == entry.getValue()) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
