package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int countT = string.length() - string.replace("\t", "").length();
        if (countT < 2) {
            throw new TooShortStringException();
        }
        int firstTIndex = string.indexOf('\t') + 1;
        int secondTIndex = string.indexOf('\t', firstTIndex);
        return string.substring(firstTIndex, secondTIndex);
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }

    public static class TooShortStringException extends Exception {
    }
}
