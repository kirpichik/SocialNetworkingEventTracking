package org.polushin.example_snet_bot;

import org.polushin.snet.api.SnetState;
import org.polushin.snet.tg.TelegramSocialNetwork;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String username, token;
        try (Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("config.conf"))) {
            username = scanner.next();
            token = scanner.next();
        }

        SnetState state = new SnetState();
        state.registerTracker(new ExampleBot(state));
        state.registerSocialNetwork(TelegramSocialNetwork.class, new TelegramSocialNetwork(state, username, token));
    }

}
