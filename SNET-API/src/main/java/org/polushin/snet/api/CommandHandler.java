package org.polushin.snet.api;

import org.polushin.snet.api.actions.CommandAction;

@FunctionalInterface
public interface CommandHandler {

    /**
     * Handle input command action.
     *
     * @param command Command action.
     */
    void onCommand(CommandAction command);

}
