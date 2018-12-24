package org.polushin.snet.tg;

import org.polushin.snet.api.SnetState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBotImpl extends TelegramLongPollingBot {

    private final SnetState snetState;

    TelegramBotImpl(SnetState state) {
        snetState = state;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage())
            handleMessage(update.getMessage());
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    private void handleMessage(Message message) {

    }
}
