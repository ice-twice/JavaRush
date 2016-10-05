package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
