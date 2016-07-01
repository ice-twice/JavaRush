package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());
        int i4 = Integer.parseInt(reader.readLine());
        if (i1 > i2 && i1 > i3 && i1 > i4) {
            System.out.println(i1);
        } else if (i2 > i1 && i2 > i3 && i2 > i4) {
            System.out.println(i2);
        } else if (i3 > i1 && i3 > i2 && i3 > i4) {
            System.out.println(i3);
        } else {
            System.out.println(i4);
        }

    }
}
