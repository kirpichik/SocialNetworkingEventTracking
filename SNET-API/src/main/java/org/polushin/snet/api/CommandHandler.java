package org.polushin.snet.api;

import org.polushin.snet.api.actions.CommandAction;

public interface CommandHandler {

    void onCommand(CommandAction command);

}
