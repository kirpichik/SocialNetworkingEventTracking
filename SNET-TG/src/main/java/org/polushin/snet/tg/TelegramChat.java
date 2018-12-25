package org.polushin.snet.tg;

import org.polushin.snet.api.AbstractChat;
import org.polushin.snet.api.Message;
import org.polushin.snet.api.SendMessage;
import org.polushin.snet.api.User;
import org.polushin.snet.api.attachments.Photo;
import org.telegram.telegrambots.meta.api.objects.Chat;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TelegramChat extends AbstractChat<TelegramSocialNetwork> {

    private final Chat source;

    TelegramChat(TelegramSocialNetwork implementation, Chat source) {
        super(implementation);
        this.source = source;
    }

    @Override
    public Future<Message> getPinnedMessage() {
        // TODO - request
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public Future<Photo> getPhoto() {
        // TODO - request
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public Future<String> getTitle() {
        return CompletableFuture.completedFuture(source.getTitle());
    }

    @Override
    public Future<Collection<User>> getUsers() {
        // TODO - request
        return CompletableFuture.completedFuture(Collections.emptySet());
    }

    @Override
    public long getChatId() {
        return source.getId();
    }

    @Override
    public Future<Message> getMessage(long messageId) {
        // TODO - request
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public void forwardMessages(SendMessage message, long... messageIds) {
        // TODO - request
    }

    @Override
    public TelegramSendMessage sendMessage() {
        return new TelegramSendMessage(implementation);
    }

    @Override
    public TelegramSendMessage sendMessage(String text) {
        return new TelegramSendMessage(implementation, text);
    }
}
