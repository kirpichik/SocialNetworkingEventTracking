package org.polushin.snet.api;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SocialNetwork {

    protected final SnetState snetState;

    private final Map<Chat, ChatLocker> lockedChats = new ConcurrentHashMap<>();

    public SocialNetwork(SnetState state) {
        Objects.requireNonNull(state, "State cannot be null!");

        this.snetState = state;
    }

    /**
     * Destroys this social network.
     */
    public abstract void destroy();

    /**
     * Searches locker for locked chat.
     *
     * @param chat Chat.
     *
     * @return Locker of chat or {@code null} if chat is not locked.
     */
    protected ChatLocker getLocker(Chat chat) {
        return lockedChats.get(chat);
    }

    /**
     * Store chat as locked by locker.
     *
     * @param chat Chat.
     * @param locker Locker.
     */
    void lockChat(Chat chat, ChatLocker locker) {
        lockedChats.put(chat, locker);
    }

    /**
     * Removes chat from locked storage.
     *
     * @param chat Chat.
     */
    void unlockChat(Chat chat) {
        lockedChats.remove(chat);
    }

}
