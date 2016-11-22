package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

public class Archiver {
    public static void main(String[] args) throws Exception {
        /*try {
            ConsoleHelper.writeMessage("Enter the path to create a new archive:");
            String pathArchive = ConsoleHelper.readString();
            ZipFileManager manager = new ZipFileManager(Paths.get(pathArchive));
            ConsoleHelper.writeMessage("Enter the path to the file to be archived:");
            String pathFile = ConsoleHelper.readString();
            manager.createZip(Paths.get(pathFile));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        ExitCommand command = new ExitCommand();
        command.execute();
    }
}
