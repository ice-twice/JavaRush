package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter the server port: ");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server was started.");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message messageNameRequest = new Message(MessageType.NAME_REQUEST);
            while (true) {
                connection.send(messageNameRequest);
                Message receiveMessage = connection.receive();
                if (receiveMessage != null && receiveMessage.getType() == MessageType.USER_NAME) {
                    String userName = receiveMessage.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        Message messageNameAccepted = new Message(MessageType.NAME_ACCEPTED);
                        connection.send(messageNameAccepted);
                        return userName;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    Message messageUserAdded = new Message(MessageType.USER_ADDED, name);
                    connection.send(messageUserAdded);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage != null) {
                    if (receiveMessage.getType() != MessageType.TEXT) {
                        ConsoleHelper.writeMessage("Error. This message is not a text.");
                        continue;
                    }
                    String text = receiveMessage.getData();
                    if (text != null) {
                        String sendText = userName + ": " + text;
                        Message messageText = new Message(MessageType.TEXT, sendText);
                        sendBroadcastMessage(messageText);
                    }
                }
            }
        }
    }
}
