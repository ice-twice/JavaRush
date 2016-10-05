package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        if (i > 0) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int i1 = Integer.parseInt(reader.readLine());
                if (j == 0) {
                    max = i1;
                } else if (i1 > max) {
                    max = i1;
                }

            }
            System.out.println(max);

        }

        //напишите тут ваш код

    }
}
