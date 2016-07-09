package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int max(int i, int i1) {
        return i > i1 ? i : i1;
    }

    public static long max(long l, long l1) {
        return l > l1 ? l : l1;
    }

    public static double max(double v, double v1) {
        return v > v1 ? v : v1;
    }
}
