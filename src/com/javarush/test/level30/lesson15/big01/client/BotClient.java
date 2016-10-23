package com.javarush.test.level30.lesson15.big01.client;

public class BotClient extends Client {
    public static void main(String[] args) {
        Client botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int botNumber = (int) (Math.random() * 99);
        return "date_bot_" + botNumber;
    }

    public class BotSocketThread extends SocketThread {

    }
}
