package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fileName = new String[2];
        for (int i = 0; i < fileName.length; i++) {
            fileName[i] = reader.readLine();
        }
        reader.close();

        FileInputStream fileInputStream0 = new FileInputStream(fileName[0]);
        byte[] bytes0 = new byte[fileInputStream0.available()];
        fileInputStream0.read(bytes0);
        fileInputStream0.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName[1]);
        byte[] bytes1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(bytes1);
        fileInputStream1.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName[0]);
        fileOutputStream.write(bytes1);
        fileOutputStream.write(bytes0);
        fileOutputStream.close();
    }
}
