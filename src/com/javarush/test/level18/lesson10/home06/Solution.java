package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        // args = new String[]{"c:\\test.txt"};
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();

        HashMap<Byte, Integer> symbolsCountMap = new HashMap<>();
        for (byte b : bytes) {
            symbolsCountMap.put(b, symbolsCountMap.containsKey(b) ? symbolsCountMap.get(b) + 1 : 1);
        }
        ArrayList<Byte> bytesSymbol = new ArrayList<>(symbolsCountMap.keySet());

        Collections.sort(bytesSymbol);

        for (byte b : bytesSymbol) {
            System.out.println((char) b + " " + symbolsCountMap.get(b));
        }
    }
}
