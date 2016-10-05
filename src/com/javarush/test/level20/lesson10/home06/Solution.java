package com.javarush.test.level20.lesson10.home06;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }
}
