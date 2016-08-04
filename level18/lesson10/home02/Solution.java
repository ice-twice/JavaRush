package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSymbols = 0, countSpaces = 0;
        // args = new String[]{"C:\\test.txt"};
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();
            if (symbol == 32) {
                countSpaces++;
            }
            countSymbols++;
        }
        System.out.println(String.format("%.2f", (float) countSpaces / countSymbols * 100));
        fileInputStream.close();
        //DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //System.out.println(decimalFormat.format((float) countSpaces / countSymbols * 100));
    }
}
