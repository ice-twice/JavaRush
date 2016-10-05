package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader readerFile1 = new BufferedReader(new FileReader(readerConsole.readLine()));
            BufferedReader readerFile2 = new BufferedReader(new FileReader(readerConsole.readLine()));
            readerConsole.close();

            String s1, s2;
            while ((s1 = readerFile1.readLine()) != null) {
                allLines.add(s1);
            }
            while ((s2 = readerFile2.readLine()) != null) {
                forRemoveLines.add(s2);
            }
            readerFile1.close();
            readerFile2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        System.out.println(allLines);
        System.out.println(forRemoveLines);

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            /*for (String forRemoveLine : forRemoveLines) {
                if (allLines.contains(forRemoveLine)) {
                    return;
                }
            }*/
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
