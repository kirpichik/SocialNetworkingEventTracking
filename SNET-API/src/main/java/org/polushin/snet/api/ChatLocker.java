package org.polushin.snet.api;

public interface ChatLocker extends MessageHandler, ChatActionHandler, CommandHandler {

    /**
     * Lock on chat handler.
     *
     * @param chat Locked chat.
     */
    default void onLock(Chat chat) {

    }

    /**
     * Unlock chat handler.
     */
    default void onUnlock(Chat chat) {

    }

}
