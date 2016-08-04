package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
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

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes0) {
            stringBuilder.append((char) b);
        }

        String[] strings = stringBuilder.toString().split(" ");
        stringBuilder.delete(0, stringBuilder.length());
        for (String s : strings) {
            stringBuilder.append(Math.round(Double.parseDouble(s))).append(" ");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName[1]);
        fileOutputStream.write(stringBuilder.toString().getBytes());
        fileOutputStream.close();
    }
}
