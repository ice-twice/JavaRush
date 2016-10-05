package com.javarush.test.level26.lesson15.big01;

public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        Operation[] operations = values();
        if (i < 2 || i > operations.length) {
            throw new IllegalArgumentException();
        }
        return operations[i - 1];
    }
}