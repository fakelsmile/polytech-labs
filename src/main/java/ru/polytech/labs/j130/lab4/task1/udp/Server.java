package ru.polytech.labs.j130.lab4.task1.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Сервер, ожидающий строковое сообщение от клиента.
 * Печатает время, сообщение и адрес клиента на экран и отправляет время приёма клиенту.
 */
public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                System.out.println("Получено от клиента: " + message);
                System.out.println("Адрес клиента: " + clientAddress + ":" + clientPort);

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                String response = "Сообщение получено в " + sdf.format(new Date());
                sendData = response.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}