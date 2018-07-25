package org.polushin.snet.api.input;

import com.sun.istack.internal.NotNull;

public interface Chat {

    /**
     * @return Unique ID of this chat.
     */
    long getChatId();

    /**
     * Sends message to this chat.
     *
     * @param message Message.
     */
    void sendMessage(@NotNull Message message);

}
