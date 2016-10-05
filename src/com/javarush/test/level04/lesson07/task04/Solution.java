package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int numNegative = 0, numPositive = 0;

        if (i1 < 0) {
            numNegative += 1;

        } else {
            numPositive += 1;
        }
        if (i2 < 0) {
            numNegative += 1;

        } else {
            numPositive += 1;
        }
        if (i3 < 0) {
            numNegative += 1;

        } else {
            numPositive += 1;
        }
        System.out.println("количество отрицательных чисел: " + numNegative);
        System.out.println("количество положительных чисел: " + numPositive);
    }
}
