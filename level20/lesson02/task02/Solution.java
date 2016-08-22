package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            //System.out.println(your_file_name.getAbsolutePath());
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("firstName");
            user.setLastName("lastName");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users) {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(user.getBirthDate());
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String firstName;
            while ((firstName = bufferedReader.readLine()) != null) {
                String lastName = bufferedReader.readLine();
                String birthDayS = bufferedReader.readLine();
                String maleS = bufferedReader.readLine();
                String countryS = bufferedReader.readLine();
                Date birthDay = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH).parse(birthDayS);
                Boolean male = Boolean.parseBoolean(maleS);
                User.Country country = null;
                for (User.Country countryItem : User.Country.values()) {
                    if (countryS.equals(countryItem.toString())) {
                        country = countryItem;
                        break;
                    }
                }
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(birthDay);
                user.setMale(male);
                user.setCountry(country);
                users.add(user);
            }
            bufferedReader.close();
            for (User user : users) {
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.getBirthDate());
                System.out.println(user.isMale());
                System.out.println(user.getCountry());
            }
        }
    }
}
