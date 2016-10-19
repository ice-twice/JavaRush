package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            String nameElement = "ShareItem-" + i;
            System.out.println("Элемент '" + nameElement + "' добавлен");
            ShareItem item = new ShareItem(nameElement, i);
            queue.offer(item);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
            if (queue.hasWaitingConsumer()) {
                System.out.println("Consumer в ожидании!");
            }

        }
    }
}
