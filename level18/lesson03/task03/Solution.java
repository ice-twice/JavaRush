package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        final Map<Integer, Integer> byteMap = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int temp = fileInputStream.read();
            byteMap.put(temp, byteMap.get(temp) == null ? 1 : byteMap.get(temp) + 1);
        }
        List<Integer> byteList = new ArrayList<>(byteMap.keySet());
        Collections.sort(byteList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = byteMap.get(o1);
                int count2 = byteMap.get(o2);
                if (count1 > count2) {
                    return -1;
                } else if (count1 < count2) {
                    return 1;
                }
                return 0;
            }
        });
        for (Integer i : byteList) {
            if (!byteMap.get(byteList.get(0)).equals(byteMap.get(i))) {
                break;
            }
            System.out.print(i + " ");
        }
        reader.close();
        fileInputStream.close();
    }
}
