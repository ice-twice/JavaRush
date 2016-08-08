package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        // args = new String[]{"d:\\1.txt"};
        Map<String, Double> map = new TreeMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");
            Double parseValue = Double.parseDouble(currentLineSplit[1]);
            map.put(currentLineSplit[0], map.containsKey(currentLineSplit[0]) ? map.get(currentLineSplit[0]) + parseValue : parseValue);
        }
        bufferedReader.close();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
