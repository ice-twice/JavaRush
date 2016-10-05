package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fileName = new String[3];
        for (int i = 0; i < fileName.length; i++) {
            fileName[i] = reader.readLine();
        }
        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName[1]);
        byte[] bytes = new byte[fileInputStream1.available()];

        FileOutputStream fileOutputStream = new FileOutputStream(fileName[0]);
        fileOutputStream.write(bytes, 0, fileInputStream1.read(bytes));
        fileInputStream1.close();

        FileInputStream fileInputStream2 = new FileInputStream(fileName[2]);
        bytes = new byte[fileInputStream2.available()];

        fileOutputStream.write(bytes, 0, fileInputStream2.read(bytes));
        fileOutputStream.close();
        fileInputStream2.close();


    }
}
