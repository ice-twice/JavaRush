package com.javarush.test.level27.lesson09.home01;

public class ConsumerTask implements Runnable {
    protected volatile boolean stopped;
    private TransferObject transferObject;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        while (!stopped) {
            transferObject.get();
        }
    }

    public void stop() {
        stopped = true;
    }
}