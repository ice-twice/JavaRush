package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        if (array.length > 1) {
            Arrays.sort(array);
            final float median;
            if (array.length % 2 == 0) {
                int lengthHalf = array.length / 2;
                median = (array[lengthHalf] + array[lengthHalf - 1]) / 2;
            } else {
                median = array[array.length / 2];
            }
            Arrays.sort(array, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int distance1 = (int) Math.abs(o1 - median);
                    int distance2 = (int) Math.abs(o2 - median);
                    int result = Integer.compare(distance1, distance2);
                    System.out.println(result);
                    if (result == 0) {
                        return o1.compareTo(o2);
                    } else {
                        return result;
                    }
                }
            });
        }
        return array;
    }
}
