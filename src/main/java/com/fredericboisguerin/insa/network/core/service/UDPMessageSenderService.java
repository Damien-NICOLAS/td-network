package com.fredericboisguerin.insa.network.core.service;

import com.fredericboisguerin.insa.network.core.ui.Message;

import java.net.*;


public class UDPMessageSenderService implements MessageSenderService {




    @Override
    public void sendMessageOn(String ipAddress, int port, Message message) throws Exception {

        byte[] data;

        //data = Message.getBytes();

        DatagramSocket datagramSocket = new DatagramSocket();

        //DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        //datagramPacket.setAddress(InetAddress.getByName(ipAddress));
        //datagramPacket.setPort(port);
        //datagramSocket.send(datagramPacket);
        datagramSocket.close();



    }
}
