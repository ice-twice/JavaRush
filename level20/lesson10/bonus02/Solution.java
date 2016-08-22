package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        StringBuilder coordinatesBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            outerLoop:
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    if (coordinatesBuilder.length() > 0) {
                        String[] coordinates = coordinatesBuilder.toString().split(",");
                        for (int k = 0; k < coordinates.length; k += 4) {
                            if (Integer.parseInt(coordinates[k]) <= i && Integer.parseInt(coordinates[k + 1]) <= j && Integer.parseInt(coordinates[k + 2]) >= i && Integer.parseInt(coordinates[k + 3]) >= j) {
                                continue outerLoop;
                            }
                        }
                    }
                    int iStart = i;
                    coordinatesBuilder.append(i).append(",").append(j).append(",");
                    while (j + 1 < a[i].length && a[i][j + 1] == 1) {
                        j++;
                    }
                    while (i + 1 < a.length && a[i + 1][j] == 1) {
                        i++;
                    }
                    coordinatesBuilder.append(i).append(",").append(j).append(",");
                    i = iStart;
                    count++;
                }
            }
        }
        return count;
    }
}
