package com.javarush.test.level31.lesson15.big01;

import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter the path to create a new archive:");
        String pathArchive = ConsoleHelper.readString();
        ZipFileManager manager = new ZipFileManager(Paths.get(pathArchive));
        ConsoleHelper.writeMessage("Enter the path to the file to be archived:");
        String pathFile = ConsoleHelper.readString();
        try {
            manager.createZip(Paths.get(pathFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
