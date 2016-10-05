package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String[] person = scanner.nextLine().split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = null;
            try {
                date = simpleDateFormat.parse(person[3] + " " + person[4] + " " + person[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(person[1], person[2], person[0], date);
        }

        @Override
        public void close() throws IOException {
            scanner.close();

        }
    }
}
