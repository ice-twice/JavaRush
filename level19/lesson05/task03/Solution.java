package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader1.readLine()) != null) {
            String[] splitS = line.split(" ");
            for (String split : splitS) {
                try {
                    stringBuilder.append(Integer.parseInt(split)).append(" ");
                } catch (NumberFormatException e) {
                }
            }
        }
        bufferedReader1.close();
        PrintWriter printWriter = new PrintWriter(fileName2);
        printWriter.println(stringBuilder.toString());
        printWriter.close();
    }
}
