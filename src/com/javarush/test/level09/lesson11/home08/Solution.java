package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] ints = {5, 2, 4, 7, 0};
        ArrayList<int[]> integers = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            int[] ints1 = new int[ints[i]];
            for (int j = 0; j < ints[i]; j++) {
                ints1[j] = j;
            }
            integers.add(ints1);
        }

        return integers;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
