package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws
            Exception {
        ConsoleHelper.writeMessage("Enter the path to the archive");
        String path = ConsoleHelper.readString();
        return new ZipFileManager(Paths.get(path));
    }
}