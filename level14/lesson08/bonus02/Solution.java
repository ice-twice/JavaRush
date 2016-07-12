package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.valueOf(reader.readLine());
        int i2 = Integer.valueOf(reader.readLine());

        // bad way
        /*for (int i = i1 < i2 ? i1 : i2; i > 0; i--) {
            if (i1 % i == 0 && i2 % i == 0) {
                System.out.println(i);
                break;
            }
        }*/

        // good way
        while (true) {
            if (i2 == 0) {
                System.out.println(i1);
                break;
            }
            int temp = i2;
            i2 = i1 % i2;
            i1 = temp;
        }
    }
}
