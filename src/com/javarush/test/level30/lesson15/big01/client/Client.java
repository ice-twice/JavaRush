package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter the server address: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter the server port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter the user name: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        Message messageText = new Message(MessageType.TEXT, text);
        try {
            connection.send(messageText);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error while sending message.");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error. The program will be closed.");
                return;
            }
        }
        if (!clientConnected) {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }
        ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        String text;
        while (clientConnected && !(text = ConsoleHelper.readString()).equals("exit")) {
            if (shouldSentTextFromConsole()) {
                sendTextMessage(text);
            }
        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " joined the chat");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " left the chat.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage != null) {
                    MessageType messageType = receiveMessage.getType();
                    if (messageType != null) {
                        if (messageType == MessageType.NAME_REQUEST) {
                            String userName = getUserName();
                            Message message = new Message(MessageType.USER_NAME, userName);
                            connection.send(message);
                        } else if (messageType == MessageType.NAME_ACCEPTED) {
                            notifyConnectionStatusChanged(true);
                            return;
                        } else {
                            throw new IOException("Unexpected MessageType");
                        }
                    }
                }
            }
        }


        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage != null) {
                    MessageType messageType = receiveMessage.getType();
                    if (messageType != null) {
                        if (messageType == MessageType.TEXT) {
                            processIncomingMessage(receiveMessage.getData());
                        } else if (messageType == MessageType.USER_ADDED) {
                            informAboutAddingNewUser(receiveMessage.getData());
                        } else if (messageType == MessageType.USER_REMOVED) {
                            informAboutDeletingNewUser(receiveMessage.getData());
                        } else {
                            throw new IOException("Unexpected MessageType");
                        }
                    }
                }
            }
        }
    }
}
