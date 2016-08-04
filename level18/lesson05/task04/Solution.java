package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
        byte[] bytes = new byte[fileInputStream.available()];
        int count = fileInputStream.read(bytes);
        for (int i = 1; i <= count; i++) {
            fileOutputStream1.write(bytes[count - i]);
        }
        fileInputStream.close();
        fileOutputStream1.close();
    }
}
