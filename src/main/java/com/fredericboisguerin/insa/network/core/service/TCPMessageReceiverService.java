package com.fredericboisguerin.insa.network.core.service;

import com.fredericboisguerin.insa.network.core.ui.Entete;
import com.fredericboisguerin.insa.network.core.ui.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


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
                String messageRecue = reader.readLine();
                if( messageRecue != null) {
                    int char$ = messageRecue.indexOf('$');

                    String[] tableauDeString = messageRecue.split("[$]", 2);
                    System.out.println(tableauDeString[0]);
                    monIncomingMessageListener.onNewIncomingMessage(tableauDeString[1]);
                }








            }catch (IOException e){
                e.printStackTrace();
            }


        }




    }
}
