package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution {
    public static void main(String[] args) {
    }

    //Напишите тут ваши методы
    public static int min(int i, int i1) {
        return i < i1 ? i : i1;
    }

    public static long min(long l, long l1) {
        return l < l1 ? l : l1;
    }

    public static double min(double v, double v1) {
        return v < v1 ? v : v1;
    }
}
