package org.polushin.snet.tg;

import org.polushin.snet.api.SnetState;
import org.polushin.snet.api.SocialNetwork;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class TelegramSocialNetwork extends SocialNetwork {

    public TelegramSocialNetwork(SnetState state) {
        super(state);

        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new TelegramBotImpl(state));
        } catch (TelegramApiRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        // TODO
    }
}
