package org.polushin.snet.tg;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBotImpl extends TelegramLongPollingBot {

    private final TelegramSocialNetwork impl;

    TelegramBotImpl(TelegramSocialNetwork impl) {
        this.impl = impl;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage())
            impl.getState().performUpdate(new TelegramMessage(this, update.getMessage()));
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    TelegramSocialNetwork getImpl() {
        return impl;
    }
}
