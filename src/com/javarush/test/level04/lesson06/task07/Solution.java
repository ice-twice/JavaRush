package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());

        if (i1 != i2 && i1 != i3 && i2 == i3) {
            System.out.println(1);
        } else if (i2 != i1 && i2 != i3 && i1 == i3) {
            System.out.println(2);
        } else if (i3 != i1 && i3 != i2 && i1 == i2) {
            System.out.println(3);
        }


    }
}
