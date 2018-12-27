package org.polushin.snet.tg;

import org.polushin.snet.api.Message;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;
import org.polushin.snet.api.attachments.Photo;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TelegramUser extends AbstractTelegramChat implements User {

    private final org.telegram.telegrambots.meta.api.objects.User source;

    TelegramUser(TelegramBotImpl impl, org.telegram.telegrambots.meta.api.objects.User source) {
        super(impl, SnetUID.getId(source.getId(), TelegramSocialNetwork.class));
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
        return CompletableFuture.completedFuture(Collections.singleton(this));
    }

    @Override
    public SnetUID getUserId() {
        return id;
    }

    @Override
    public Future<String> getFirstName() {
        return CompletableFuture.completedFuture(source.getFirstName());
    }

    @Override
    public Future<String> getLastName() {
        return CompletableFuture.completedFuture(source.getLastName());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TelegramUser))
            return false;
        return ((TelegramUser) o).id.equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
