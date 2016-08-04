package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        //args = new String[]{"C:\\test.txt"};
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();
            if (symbol >= 65 && symbol <= 90 || symbol >= 97 && symbol <= 122) {
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}
