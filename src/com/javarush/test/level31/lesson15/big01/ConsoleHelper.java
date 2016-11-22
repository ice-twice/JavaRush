package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String line;
        while (true) {
            try {
                line = reader.readLine();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return line;
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static int readInt() {
        int i;
        while (true) {
            try {
                i = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                writeMessage("Error when entering the number. Enter the number again.");
            }
        }
        return i;
    }

}
