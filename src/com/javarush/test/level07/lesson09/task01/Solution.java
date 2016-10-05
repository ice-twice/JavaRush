package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        ArrayList<Integer> integers2 = new ArrayList<>();
        ArrayList<Integer> integers3 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            int i1 = Integer.parseInt(reader.readLine());
            integers.add(i1);
            if (i1 % 3 == 0 && i1 % 2 == 0) {
                integers1.add(i1);
                integers2.add(i1);
            } else if (i1 % 3 == 0) {
                integers1.add(i1);

            } else if (i1 % 2 == 0) {
                integers2.add(i1);

            } else {
                integers3.add(i1);
            }
        }
        printList(integers1);
        printList(integers2);
        printList(integers3);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
