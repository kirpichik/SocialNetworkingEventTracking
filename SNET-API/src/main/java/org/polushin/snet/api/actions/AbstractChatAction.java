package org.polushin.snet.api.actions;

import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;

import java.util.Objects;

public abstract class AbstractChatAction implements ChatAction {

    protected final Type type;
    protected final SnetUID messageId;
    protected final User from;
    protected final Chat chat;
    protected final long date;
    protected final String text;

    protected AbstractChatAction(Type type, SnetUID messageId, User from, Chat chat, long date, String
            text) {
        Objects.requireNonNull(type, "Type cannot be null!");
        Objects.requireNonNull(chat, "Chat cannot be null!");
        this.type = type;
        this.messageId = messageId;
        this.from = from;
        this.chat = chat;
        this.date = date;
        this.text = text;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public SnetUID getMessageId() {
        return messageId;
    }

    @Override
    public User getFrom() {
        return from;
    }

    @Override
    public Chat getChat() {
        return chat;
    }

    @Override
    public long getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }
}
