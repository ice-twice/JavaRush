package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(byte m, byte n, String value) {

    }

    public static void printMatrix(short m, short n, String value) {

    }

    public static void printMatrix(float m, float n, String value) {

    }

    public static void printMatrix(double m, double n, String value) {

    }

    public static void printMatrix(Byte m, Byte n, String value) {

    }

    public static void printMatrix(Short m, Short n, String value) {

    }

    public static void printMatrix(Integer m, Integer n, String value) {

    }

    public static void printMatrix(Float m, Float n, String value) {

    }

}
