package org.polushin.snet.tg;

import org.polushin.snet.api.Message;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;
import org.polushin.snet.api.attachments.Photo;
import org.telegram.telegrambots.meta.api.objects.Chat;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TelegramChat extends AbstractTelegramChat {

    private final Chat source;

    TelegramChat(TelegramBotImpl impl, Chat source) {
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
        return CompletableFuture.completedFuture(source.getTitle());
    }

    @Override
    public Future<Collection<User>> getUsers() {
        // TODO - request
        return CompletableFuture.completedFuture(Collections.emptySet());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TelegramChat))
            return false;
        return ((TelegramChat) o).id.equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
