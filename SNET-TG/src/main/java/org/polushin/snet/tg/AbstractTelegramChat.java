package org.polushin.snet.tg;

import org.polushin.snet.api.AbstractChat;
import org.polushin.snet.api.Message;
import org.polushin.snet.api.SendMessage;
import org.polushin.snet.api.SnetUID;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public abstract class AbstractTelegramChat extends AbstractChat<TelegramSocialNetwork> {

    protected final SnetUID id;
    protected final TelegramBotImpl impl;

    public AbstractTelegramChat(TelegramBotImpl impl, SnetUID id) {
        super(impl.getImpl());
        this.id = id;
        this.impl = impl;
    }

    @Override
    public SnetUID getChatId() {
        return id;
    }

    @Override
    public Future<Message> getMessage(SnetUID messageId) {
        SnetUID.checkImpl(messageId, TelegramSocialNetwork.class);
        // TODO - request
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public void forwardMessages(SendMessage message, Collection<SnetUID> messageIds) {
        messageIds.forEach(id -> SnetUID.checkImpl(id, TelegramSocialNetwork.class));
        // TODO - request
    }

    @Override
    public TelegramSendMessage sendMessage() {
        return new TelegramSendMessage(impl, this);
    }

    @Override
    public TelegramSendMessage sendMessage(String text) {
        return new TelegramSendMessage(impl, this, text);
    }

    @Override
    public boolean isEditingSupports() {
        return true;
    }

    @Override
    public boolean isDeletingSupports() {
        return true;
    }

    @Override
    public SendMessage editMessage(SnetUID messageId) throws UnsupportedOperationException, IllegalArgumentException {
        SnetUID.checkImpl(messageId, TelegramSocialNetwork.class);
        return new TelegramSendMessage(impl, this, messageId);
    }

    @Override
    public SendMessage editMessage(Message message) throws UnsupportedOperationException {
        Objects.requireNonNull(message, "Message cannot be null!");
        SnetUID.checkImpl(message.getMessageId(), TelegramSocialNetwork.class);
        return new TelegramSendMessage(impl, this, message.getMessageId()).setText(message.getText())
                .setReplayTo(message.getReplayToId()).appendAttachments(message.getAttachments());
    }

    @Override
    public boolean deleteMessage(SnetUID messageId) throws UnsupportedOperationException, IllegalArgumentException {
        SnetUID.checkImpl(messageId, TelegramSocialNetwork.class);
        // TODO
        return false;
    }

}
