package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = bufferedReader.readLine();
            if (s.equalsIgnoreCase(res.getString("operation.EXIT"))) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
        }

        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String line = "";
        while (line.length() != 3) {
            line = readString();
            if (line.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            }
        }
        return line.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String sTwoDigits;
        String[] twoDigits;
        while (true) {
            sTwoDigits = readString();
            twoDigits = sTwoDigits.split(" ");
            try {
                if (twoDigits.length == 2) {
                    int denomination = Integer.parseInt(twoDigits[0]);
                    int count = Integer.parseInt(twoDigits[1]);
                    if (denomination > 0 && count > 0) {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
            }
            writeMessage(res.getString("invalid.data"));
        }
        return twoDigits;
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        while (true) {
            String line = readString();
            try {
                int number = Integer.parseInt(line);
                return Operation.getAllowableOperationByOrdinal(number);
            } catch (Exception e) {

            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}