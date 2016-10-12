package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger();

    public MyThread() {
        initializePriority();
    }

    public MyThread(Runnable target) {
        super(target);
        initializePriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        initializePriority();
    }

    public MyThread(String name) {
        super(name);
        initializePriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        initializePriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        initializePriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        initializePriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        initializePriority();
    }

    private void initializePriority() {
        priority.incrementAndGet();
        int maxPriority = getThreadGroup().getMaxPriority();
        if (priority.get() > 10) {
            priority.set(1);
        }
        setPriority(priority.get() > maxPriority ? maxPriority : priority.get());
    }
}
