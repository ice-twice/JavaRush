package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {

        /*String parameter = "-c productName 999.00 10";
        args = parameter.split(" ");*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        /*FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        StringBuilder stringBuilder = new StringBuilder();

        int countSymbolsLine = 50;
        // find max id
        int maxId = 1;
        if (bytes.length != 0) {
            int countLines = (bytes.length) / countSymbolsLine;
            for (int i = 0; i < countLines; i++) {
                int temp = bytes.length - (countLines - i) * countSymbolsLine;
                for (int j = temp; j < temp + 8; j++) {
                    if (bytes[j] >= 48 && bytes[j] <= 57) {
                        stringBuilder.append((char) bytes[j]);
                    }
                }
                int currentId = Integer.parseInt(stringBuilder.toString());
                if (maxId < currentId) {
                    maxId = currentId;
                }
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        // code testing is not likely to pass because String.format...
        // but with the method handleLength all is well

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        printWriter.println(String.format("%n%-8.8s%-30.30s%-8.8s%-4.4s", ++maxId, args[1], args[2], args[3]));
        printWriter.close();*/


        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String currentLine;
        int maxId = 1;
        while ((currentLine = bufferedReader.readLine()) != null) {
            int currentId = Integer.parseInt(currentLine.substring(0, 8).trim());
            maxId = maxId < currentId ? currentId : maxId;
        }
        bufferedReader.close();

        String maxIdS = handleLength(String.valueOf(++maxId), 8);
        String productName = handleLength(args[1], 30);
        String price = handleLength(args[2], 8);
        String quantity = handleLength(args[3], 4);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(maxIdS).append(productName).append(price).append(quantity);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        printWriter.println(stringBuilder.toString());
        printWriter.close();
    }

    static String handleLength(String s, int count) {
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

