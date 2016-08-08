package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        //args = new String[]{"d:\\1.txt"};
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");
            StringBuilder stringBuilderName = new StringBuilder();
            StringBuilder stringBuilderBirthday = new StringBuilder();
            for (String s : currentLineSplit) {
                try {
                    Integer.parseInt(s);
                    stringBuilderBirthday.append(s).append(" ");
                } catch (NumberFormatException e) {
                    stringBuilderName.append(s).append(" ");
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            PEOPLE.add(new Person(stringBuilderName.toString().trim(), simpleDateFormat.parse(stringBuilderBirthday.toString().trim())));
        }
        bufferedReader.close();
    }
}
