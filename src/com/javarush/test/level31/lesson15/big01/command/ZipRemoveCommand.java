package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Введите путь к файлу");
        Path pathToFile = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(pathToFile);
        ConsoleHelper.writeMessage("Файл успешно удален");
    }
}