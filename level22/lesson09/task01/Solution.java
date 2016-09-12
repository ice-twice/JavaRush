package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = fileReader.readLine()) != null) {
            stringBuilder.append(temp).append(" ");
        }
        fileReader.close();
        List<String> stringsList = new LinkedList<>(Arrays.asList(stringBuilder.toString().split(" ")));
        for (int i = 0; i < stringsList.size(); i++) {
            String firstWord = stringsList.get(i);
            for (int j = i; j < stringsList.size(); j++) {
                if (i == j) {
                    continue;
                }
                stringBuilder.delete(0, stringBuilder.length());
                String secondWord = stringsList.get(j);
                if (firstWord.equals(stringBuilder.append(secondWord).reverse().toString())) {
                    result.add(new Pair(firstWord, secondWord));
                    stringsList.remove(i);
                    stringsList.remove(j - 1);
                    i--;
                    break;
                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
