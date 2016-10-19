package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask {
    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected Object compute() {
        int x = i;
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b == 0) {
            return result;
        }
        BinaryRepresentationTask task = new BinaryRepresentationTask(b);
        task.fork();
        return task.join() + result;
    }
}
