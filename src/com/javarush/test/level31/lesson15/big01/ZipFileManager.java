package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        if (Files.notExists(zipFile.getParent())) {
            Files.createDirectories(zipFile.getParent());
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path fileName : fileNames) {
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath,
                                Path fileName) throws Exception {
        ZipEntry zipEntry = new ZipEntry(fileName.toString());
        zipOutputStream.putNextEntry(zipEntry);
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            copyData(inputStream, zipOutputStream);
        }
        zipOutputStream.closeEntry();
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        int count;
        byte[] bytes = new byte[1024];
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
    }
}

