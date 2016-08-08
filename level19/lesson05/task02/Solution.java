package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        String s;
        int count = 0;
        while ((s = bufferedReader1.readLine()) != null) {
            String[] wordsArray = s.replaceAll("\\pP", " ").split(" ");
            for (String word : wordsArray) {
                if (word.equals("world")) {
                    count++;
                }
            }
        }
        bufferedReader1.close();
        System.out.println(count);
    }
}
