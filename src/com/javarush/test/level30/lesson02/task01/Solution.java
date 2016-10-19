package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int result = 0;
        if (s != null) {
            if (s.contains("x")) {
                result = Integer.decode(s);
            } else if (s.contains("b")) {
                result = Integer.parseInt(s.substring(2), 2);
            } else if (s.charAt(0) == '0') {
                result = Integer.parseInt(s, 8);
            } else {
                result = Integer.parseInt(s);
            }
        }
        return String.valueOf(result);
    }
}
