package org.polushin.snet.tg;

import org.polushin.snet.api.AbstractChat;
import org.polushin.snet.api.Message;
import org.polushin.snet.api.SendMessage;
import org.polushin.snet.api.User;
import org.polushin.snet.api.attachments.Photo;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TelegramUser extends AbstractChat<TelegramSocialNetwork> implements User {

    private final org.telegram.telegrambots.meta.api.objects.User source;

    TelegramUser(TelegramSocialNetwork impl, org.telegram.telegrambots.meta.api.objects.User source) {
        super(impl);
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
        String firstName = source.getFirstName();
        String lastName = source.getLastName();
        String name;
        if (firstName == null && lastName == null)
            name = source.getUserName();
        else if (firstName == null)
            name = lastName;
        else if (lastName == null)
            name = firstName;
        else
            name = firstName + " " + lastName;
        return CompletableFuture.completedFuture(name);
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

    @Override
    public long getUserId() {
        return source.getId();
    }

    @Override
    public Future<String> getFirstName() {
        return CompletableFuture.completedFuture(source.getFirstName());
    }

    @Override
    public Future<String> getLastName() {
        return CompletableFuture.completedFuture(source.getLastName());
    }
}
