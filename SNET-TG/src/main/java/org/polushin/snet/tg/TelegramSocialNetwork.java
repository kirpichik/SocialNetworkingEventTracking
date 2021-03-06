package org.polushin.snet.tg;

import org.polushin.snet.api.SnetState;
import org.polushin.snet.api.SocialNetwork;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class TelegramSocialNetwork extends SocialNetwork {

    public TelegramSocialNetwork(SnetState state, String username, String token) {
        super(state);

        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new TelegramBotImpl(this, username, token));
        } catch (TelegramApiRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        // TODO
    }

    SnetState getState() {
        return snetState;
    }
}
