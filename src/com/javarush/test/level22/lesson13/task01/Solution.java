package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] strings = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strings[i] = stringTokenizer.nextToken();
            i++;
        }
        return strings;
    }

    /*public static void main(String[] args) {
        String[] strings = getTokens("getTokens(\"level22.lesson13.task01\", \".\") == {\"level22\", \"lesson13\", \"task01\"}", "delimiter");
        for (String s : strings) {
            System.out.println(s);
        }
    }*/
}
