package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"d:\\1.txt", "d:\\2.txt"};
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]));
        PrintWriter printWriter = new PrintWriter(args[1]);
        String currentLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((currentLine = bufferedFileReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");
            for (String s : currentLineSplit) {
                if (s.length() > 6) {
                    stringBuilder.append(s).append(",");
                }
            }
        }
        printWriter.print(stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1));
        bufferedFileReader.close();
        printWriter.close();
    }
}
