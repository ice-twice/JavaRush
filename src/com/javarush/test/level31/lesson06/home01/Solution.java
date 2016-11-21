package com.javarush.test.level31.lesson06.home01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // args = new String[]{"d:\\result.txt", "d:\\1\\d.zip"};
        Map<ZipEntry, List<Integer>> zipEntriesMap = new HashMap<>();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            List<Integer> bytesForStore = new ArrayList<>();

            Path path = Paths.get(args[0]);
            Path filePath = path.getFileName();
            String fileName = filePath.toString();
            if (fileName.equals(zipEntry.getName())) {
                zipEntry = new ZipEntry("new\\" + fileName);
                byte[] bytes = Files.readAllBytes(path);
                for (Byte b : bytes) {
                    bytesForStore.add(Integer.valueOf(b));
                }
            } else {
                while (zipInputStream.available() == 1) {
                    int aByte = zipInputStream.read();
                    if (aByte == -1)
                        break;
                    bytesForStore.add(aByte);
                }
            }
            zipEntriesMap.put(zipEntry, bytesForStore);
        }
        zipInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        for (Map.Entry<ZipEntry, List<Integer>> entry : zipEntriesMap.entrySet()) {
            zipOutputStream.putNextEntry(entry.getKey());
            List<Integer> bytes = entry.getValue();
            for (Integer aByte : bytes) {
                zipOutputStream.write(aByte);
            }
        }
        zipOutputStream.close();
    }
}
