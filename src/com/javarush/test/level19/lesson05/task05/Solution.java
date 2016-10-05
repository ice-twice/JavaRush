package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
            line = line.replaceAll("\\pP", "");
            stringBuilder.append(line);
        }
        bufferedReader1.close();
        PrintWriter printWriter = new PrintWriter(fileName2);
        printWriter.println(stringBuilder.toString());
        printWriter.close();
    }
}
