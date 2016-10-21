package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter the server port: ");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Server was started.");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new Handler(socket).start();
                } catch (Exception e) {
                    serverSocket.close();
                    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {

        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
