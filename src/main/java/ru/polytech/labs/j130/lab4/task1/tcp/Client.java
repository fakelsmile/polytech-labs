package ru.polytech.labs.j130.lab4.task1.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Клиент, отправляющий строковое сообщение серверу и получающий ответ.
 */
public class Client {
    public static void main(String[] args) {
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 9876;

            Socket socket = new Socket(serverAddress, serverPort);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                System.out.print("Введите сообщение (для выхода введите 'exit'): ");
                String message = userInput.readLine();

                if (message.equals("exit")) {
                    break;
                }

                out.println(message);

                String receivedMessage = in.readLine();
                System.out.println("Получено от сервера: " + receivedMessage);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}