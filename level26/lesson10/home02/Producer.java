package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            System.out.println("Some text for " + i);
            i++;
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("[" + Thread.currentThread().getName() + "] thread was terminated");
                break;
            }
        }
    }
}
