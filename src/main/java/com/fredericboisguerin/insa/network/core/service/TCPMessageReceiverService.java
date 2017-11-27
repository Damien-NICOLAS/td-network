package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class TCPMessageReceiverService implements MessageReceiverService, Runnable {
    private ServerSocket serverSocket;
    private Socket chatSocket;
    private InputStreamReader streamInput;
    private BufferedReader reader;
    private IncomingMessageListener monIncomingMessageListener;


    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {

        serverSocket = new ServerSocket(port);
        monIncomingMessageListener = incomingMessageListener;
        chatSocket = serverSocket.accept();
        streamInput = new InputStreamReader(chatSocket.getInputStream());
        reader = new BufferedReader(streamInput);
        new Thread(() -> run()).start();

    }

    @Override
    public void run() {
        boolean varTrue = true;
        while (varTrue){
            try{
                String message = reader.readLine();

                if(message != null) {
                    monIncomingMessageListener.onNewIncomingMessage(message);
                }

            }catch (IOException e){
                e.printStackTrace();
            }


        }




    }
}
