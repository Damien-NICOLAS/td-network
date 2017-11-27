package com.fredericboisguerin.insa.network.core.service;

import java.io.IOException;
import java.net.*;

public class UDPMessageReceiverService implements MessageReceiverService, Runnable {
    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;
    private IncomingMessageListener monIncomingMessageListener;


    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {

        datagramSocket = new DatagramSocket(port);
        datagramPacket = new DatagramPacket(new byte[100], 100);
        monIncomingMessageListener = incomingMessageListener;

        new Thread(() -> run()).start();



    }

    @Override
    public void run() {
        boolean uneVariablaAtrue = true;
        while (uneVariablaAtrue) {
            try {
                datagramSocket.receive(datagramPacket);

                String message = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());

                monIncomingMessageListener.onNewIncomingMessage(message);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}

