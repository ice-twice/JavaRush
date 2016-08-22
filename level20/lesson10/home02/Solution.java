package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        Object o = objectStream.readObject();
        return o instanceof B ? (B) o : (A) o;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

   /* public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        A a = solution.new A();
        B b = solution.new B();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:\\1.txt"));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\1.txt"));
        solution.getOriginalObject(objectInputStream);
        objectInputStream.close();
    }*/
}
