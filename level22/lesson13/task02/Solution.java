package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //args = new String[]{"d:\\1.txt", "d:\\2.txt"};
        String fileNameIn = args[0];
        String fileNameOut = args[1];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileNameIn));
        byte[] bytes = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(bytes);
        bufferedInputStream.close();
        String s = new String(bytes);
        bytes = s.getBytes("Windows-1251");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileNameOut));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

    }
}
