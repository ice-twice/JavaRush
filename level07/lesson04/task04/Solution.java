package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] ints = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }
        int temp;
        for (int i = 0; i < ints.length; i++) {
            if (i < ints.length - 1 - i) {
                temp = ints[i];
                ints[i] = ints[ints.length - 1 - i];
                ints[ints.length - 1 - i] = temp;
            } else {
                break;
            }

        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
