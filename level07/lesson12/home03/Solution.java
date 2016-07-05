package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = 0;
        int minimum = 0;

        //напишите тут ваш код
        int[] ints = new int[20];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
            if (i == 0) {
                maximum = ints[i];
                minimum = ints[i];
            }
            if (maximum < ints[i]) {
                maximum = ints[i];
            }
            if (minimum > ints[i]) {
                minimum = ints[i];

            }
        }

        System.out.print(maximum + " " + minimum);
    }
}
