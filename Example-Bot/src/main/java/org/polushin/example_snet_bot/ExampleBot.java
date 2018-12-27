package org.polushin.example_snet_bot;

import org.polushin.snet.api.EventTracker;
import org.polushin.snet.api.Message;
import org.polushin.snet.api.SnetState;
import org.polushin.snet.api.actions.CommandAction;

public class ExampleBot extends EventTracker {

    public ExampleBot(SnetState snetState) {
        super(snetState);
        snetState.setCommandHandler("start", this);
    }

    @Override
    public void onCommand(CommandAction command) {
        if (command.getCommandName().equals("start"))
            command.getChat().sendMessage("Давай сыграем в \"Купи слона\"? А кто тебя спрашивает, игра уже началась!")
                    .send();
    }

    @Override
    public void onMessage(Message message) {
        if (message.getText() == null)
            return;
        message.getChat().sendMessage("Все говорят \"" + message.getText() + "\", а ты купи слона!")
                .setReplayTo(message.getMessageId()).send();
    }

    @Override
    protected void onDisable() {

    }
}
