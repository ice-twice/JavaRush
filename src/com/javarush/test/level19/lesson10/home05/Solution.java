package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"d:\\1.txt", "d:\\2.txt"};
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        PrintWriter printWriter = new PrintWriter(args[1]);
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");
            for (String aCurrentLineSplit : currentLineSplit) {
                for (int j = 0; j < aCurrentLineSplit.length(); j++) {
                    if (Character.isDigit(aCurrentLineSplit.charAt(j))) {
                        printWriter.print(aCurrentLineSplit + " ");
                        break;
                    }
                }
            }
        }
        bufferedReader.close();
        printWriter.close();
    }
}
