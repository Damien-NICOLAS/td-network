package com.fredericboisguerin.insa.network.core.service;

import com.fredericboisguerin.insa.network.core.ui.Message;

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
    public void sendMessageOn(String ipAddress, int port, Message message) throws Exception {

        chatSocket = new Socket(InetAddress.getByName(ipAddress), port);
        writer = new PrintWriter(chatSocket.getOutputStream());
        System.out.println(message);
        writer.println(message);




        writer.close();








    }
}
