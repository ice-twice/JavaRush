package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static final Map<String, Integer> resultMap = Collections.synchronizedMap(new HashMap<String, Integer>());

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int count = 0;
            HashMap<Integer, Integer> byteHashMap = new HashMap<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int byteSymbol = fileInputStream.read();
                    byteHashMap.put(byteSymbol, byteHashMap.containsKey(byteSymbol) ? byteHashMap.get(byteSymbol) + 1 : 1);
                    if (count < byteHashMap.get(byteSymbol)) {
                        count = byteHashMap.get(byteSymbol);
                    }
                }
                fileInputStream.close();
                for (Map.Entry<Integer, Integer> entry : byteHashMap.entrySet()) {
                    if (entry.getValue() == count) {
                        synchronized (resultMap) {
                            resultMap.put(fileName, entry.getKey());
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
