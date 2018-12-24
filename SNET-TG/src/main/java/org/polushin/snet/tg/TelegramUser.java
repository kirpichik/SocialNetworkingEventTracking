package org.polushin.snet.tg;

import org.polushin.snet.api.AbstractChat;
import org.polushin.snet.api.SendMessage;
import org.polushin.snet.api.User;
import org.polushin.snet.api.attachments.Photo;

import java.util.Collection;

public class TelegramUser extends AbstractChat<TelegramSocialNetwork> implements User {

    public TelegramUser(TelegramSocialNetwork implementation) {
        super(implementation);
    }

    @Override
    public TelegramMessage getPinnedMessage() {
        return null;
    }

    @Override
    public Photo getPhoto() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public long getChatId() {
        return 0;
    }

    @Override
    public TelegramMessage getMessage(long messageId) {
        return null;
    }

    @Override
    public void forwardMessages(SendMessage message, long... messageIds) {

    }

    @Override
    public TelegramSendMessage sendMessage() {
        return null;
    }

    @Override
    public TelegramSendMessage sendMessage(String text) {
        return null;
    }

    @Override
    public long getUserId() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }
}
