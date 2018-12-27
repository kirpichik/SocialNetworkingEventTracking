package org.polushin.snet.tg;

import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.actions.CommandAction;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBotImpl extends TelegramLongPollingBot {

    private final TelegramSocialNetwork impl;
    private final String username, token;

    TelegramBotImpl(TelegramSocialNetwork impl, String username, String token) {
        this.impl = impl;
        this.username = username;
        this.token = token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message msg = update.getMessage();
            if (msg.hasText() && msg.getText().startsWith("/"))
                impl.getState().performUpdate(buildCommandAction(msg));
            else
                impl.getState().performUpdate(new TelegramMessage(this, update.getMessage()));
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    TelegramSocialNetwork getImpl() {
        return impl;
    }

    private CommandAction buildCommandAction(Message msg) {
        SnetUID id = SnetUID.getId(msg.getMessageId(), TelegramSocialNetwork.class);
        TelegramUser user = new TelegramUser(this, msg.getFrom());
        TelegramChat chat = new TelegramChat(this, msg.getChat());
        return new CommandAction(id, user, chat, msg.getDate(), msg.getText());
    }
}
