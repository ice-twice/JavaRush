package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) throws Exception {
        Operation operation = null;
        while (true) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
            if (operation == Operation.EXIT) {
                break;
            }
        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Select operations:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - " + Operation.CREATE.name());
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - " + Operation.ADD.name());
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - " + Operation.REMOVE.name());
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - " + Operation.EXTRACT.name());
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - " + Operation.CONTENT.name());
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - " + Operation.EXIT.name());
        int operation = ConsoleHelper.readInt();
        return Operation.values()[operation];
    }
}
