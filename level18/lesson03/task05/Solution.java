package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        List<Integer> byteList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int temp = fileInputStream.read();
            if (!byteList.contains(temp)) {
                byteList.add(temp);
            }
        }
        fileInputStream.close();
        Collections.sort(byteList);
        for (Integer i : byteList) {
            System.out.print(i + " ");
        }
    }
}