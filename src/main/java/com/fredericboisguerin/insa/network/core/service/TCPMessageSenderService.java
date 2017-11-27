package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class TCPMessageSenderService implements MessageSenderService {
    private Socket chatSocket;
    private InputStreamReader stream;
    private BufferedReader reader;
    private PrintWriter writer;


    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {

        chatSocket = new Socket(InetAddress.getByName(ipAddress), port);
        writer = new PrintWriter(chatSocket.getOutputStream());

        writer.println(message);




        writer.close();








    }
}
