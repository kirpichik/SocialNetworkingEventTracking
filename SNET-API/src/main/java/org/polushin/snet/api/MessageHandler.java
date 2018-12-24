package org.polushin.snet.api;

@FunctionalInterface
public interface MessageHandler {

    void onMessage(Message message);

}
