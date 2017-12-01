package com.fredericboisguerin.insa.network.core.service;

import com.fredericboisguerin.insa.network.core.ui.Message;

public interface MessageSenderService {

    void sendMessageOn(String ipAddress, int port, Message message) throws Exception;
}
