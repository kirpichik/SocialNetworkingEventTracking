package org.polushin.snet.api;

import com.sun.istack.internal.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SocialNetwork {

    protected SnetState snetState;

    private final Map<Chat, ChatLocker> lockedChats = new ConcurrentHashMap<>();

    public SocialNetwork(@NotNull SnetState state) {
        Objects.requireNonNull(state, "State cannot be null!");

        this.snetState = state;
    }

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

    void lockChat(Chat chat, ChatLocker locker) {
        lockedChats.put(chat, locker);
    }

    void unlockChat(Chat chat) {
        lockedChats.remove(chat);
    }

}
