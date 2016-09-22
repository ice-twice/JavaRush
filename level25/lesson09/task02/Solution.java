package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected final Thread.UncaughtExceptionHandler handler;
    protected TimerTask original;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String threadName = t.getName();
                String[] strings = e.getMessage().split(threadName);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(strings[0]);
                for (int i = 0; i < threadName.length(); i++) {
                    stringBuilder.append("*");
                }
                stringBuilder.append(strings[1]);
                System.out.println(stringBuilder);
            }
        }; // init handler here
        // for test
        this.run();
    }

    // for test
    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {

            }
        });
    }

    public void run() {
        try {
            original.run();
            throw new Throwable();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}