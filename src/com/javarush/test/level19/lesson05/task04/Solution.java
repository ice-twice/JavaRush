package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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
            line = line.replace(".", "!");
            stringBuilder.append(line).append(System.getProperty("line.separator"));
        }
        bufferedReader1.close();
        PrintWriter printWriter = new PrintWriter(fileName2);
        printWriter.println(stringBuilder.toString());
        printWriter.close();
    }
}
