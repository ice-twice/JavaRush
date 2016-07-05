package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String s = "S";
        int i = 1;
        while (i <= 100) {
            if (i % 10 != 0) {
                System.out.print(s);
            } else {
                System.out.println(s);
            }
            i++;
        }

    }
}
