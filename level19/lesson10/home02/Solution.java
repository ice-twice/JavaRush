package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // args = new String[]{"d:\\1.txt"};
        final Map<String, Double> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");
            Double parseValue = Double.parseDouble(currentLineSplit[1]);
            map.put(currentLineSplit[0], map.containsKey(currentLineSplit[0]) ? map.get(currentLineSplit[0]) + parseValue : parseValue);
        }
        bufferedReader.close();

        final ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) > map.get(o2)) {
                    return -1;
                } else if (map.get(o1) < map.get(o2)) {
                    return 1;
                }
                return 0;
            }
        });
        double maxValue = map.get(arrayList.get(0));
        for (String currentString : arrayList) {
            if (map.get(currentString) != maxValue) {
                break;
            }
            System.out.println(currentString);
        }
    }
}
