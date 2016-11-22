package com.javarush.test.level31.lesson15.big01;

import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        Util.printInConsole("Enter the path to create a new archive:");
        try {
            String pathArchive = Util.readLine();
            ZipFileManager manager = new ZipFileManager(Paths.get(pathArchive));
            Util.printInConsole("Enter the path to the file to be archived:");
            String pathFile = Util.readLine();
            manager.createZip(Paths.get(pathFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
