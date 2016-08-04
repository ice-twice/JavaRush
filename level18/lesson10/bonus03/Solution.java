package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String UPDATE_DATA = "-u";
        String DELETE_DATA = "-d";

        //String parameter = "-u 198478 productName1 999.01 11";
        // parameter = "-d 198478";
        //args = parameter.split(" ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            String id = line.substring(0, 8).trim();
            if (id.equals(args[1])) {
                if (args[0].equals(UPDATE_DATA)) {
                    stringBuilder.append(handleLength(id, 8)).append(handleLength(args[2], 30)).append(handleLength(args[3], 8)).append(handleLength(args[4], 4)).append(System.getProperty("line.separator"));
                } else if (args[0].equals(DELETE_DATA)) {
                    // empty
                }
            } else {
                stringBuilder.append(line).append(System.getProperty("line.separator"));
            }
        }
        bufferedReader.close();

        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.write(stringBuilder.toString());
        printWriter.close();
    }

    private static String handleLength(String s, int count) {
        if (s.length() < count) {
            StringBuilder stringBuilder = new StringBuilder(s);
            while (stringBuilder.length() < count) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        } else if (s.length() > count) {
            return s.substring(0, count);
        }
        return s;
    }
}
