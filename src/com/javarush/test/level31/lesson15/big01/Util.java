package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() throws IOException {
        return reader.readLine();
    }

    public static void printInConsole(String s) {
        System.out.println(s);
    }
}
