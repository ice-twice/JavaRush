package com.javarush.test.level09.lesson11.home04;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sDate = reader.readLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = simpleDateFormat.parse(sDate);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(simpleDateFormat1.format(date).toUpperCase());
    }
}

