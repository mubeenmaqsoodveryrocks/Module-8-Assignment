package org.example.clientsevermsgexample;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServerView {
    protected static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket);
            new Thread(new ClientHandler(clientSocket)).start();
        }

    }
}